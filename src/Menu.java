import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

import java.sql.*;

public class Menu implements ItemListener {
    JPanel cards;
    final static String CALENDARPANEL = "calendar";
    final static String GROUPSPANEL = "groups";
    final static String TODOPANEL = "to do list";
    

    private JTextField event = new JTextField(20);
    private JTextField start = new JTextField();
    private JTextField end = new JTextField();
    private JTextField place = new JTextField(20);
    private JLabel eventl = new JLabel("event:");
    private JLabel startl = new JLabel("start:");
    private JLabel endl = new JLabel("end: (these are facades for now)");
    private JLabel placel = new JLabel("location:");
    private JButton newEventButton = new JButton("add event");
    
    private JTextField todo = new JTextField(20);
    private JButton newToDoButton = new JButton("add to do item");
    
    public void addComponentToPane(Container pane, User current, final Calendar curcal, final ToDoList curlist) {
        JPanel comboBoxPane = new JPanel();
        String comboBoxItems[] = { CALENDARPANEL, GROUPSPANEL, TODOPANEL };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
        
        newEventButton.addActionListener(
        	new ActionListener() {
        		public void actionPerformed( ActionEvent e) {
        			new Event(curcal, event.getText(), Date.valueOf("2017-05-01"), Date.valueOf("2017-05-02"), place.getText());
        		}
        	}
        );        
        
        newToDoButton.addActionListener(
           	new ActionListener() {
           		public void actionPerformed( ActionEvent e) {
           			//query todo list
           			curlist.addItem(todo.getText());
           		}
          	}
        );
        
        JPanel calcard = new JPanel();
        calcard.add(new JLabel("Calendar"));
        calcard.add(eventl);
        calcard.add(event);
        calcard.add(startl);
        calcard.add(start);
        calcard.add(endl);
        calcard.add(end);
        calcard.add(placel);
        calcard.add(place);
        calcard.add(newEventButton);
        
		String query4 = "SELECT calendarName FROM Calendars WHERE owner = '" + current + "'";
        try{
        	//calcard.add(new JLabel("a thing"));
        	ResultSet q4rs = DB.select(query4);
        	calcard.add(new JLabel(q4rs.getString("calendarName")));
        	String query5 = "SELECT EventName, startTime, endTime, location FROM Events WHERE Cal = '" + q4rs.getString("calendarName") + "'";
        	try{
        		ResultSet q5rs = DB.select(query5);
        		while(q5rs.next()){
        			calcard.add(new JLabel(q5rs.getString("EventName")+" from "+q5rs.getDate("startTime")+" to "+q5rs.getDate("endTime")+" at "+q5rs.getString("location")));
        		}
        	}catch(Exception e){System.out.println(e);}
        }catch(Exception e){System.out.println(e);}
        
        
        JPanel groupcard = new JPanel();
        groupcard.add(new JLabel("Groups"));
        
        JPanel todocard = new JPanel();
        todocard.add(new JLabel("To Do List"));
        todocard.add(todo);
        todocard.add(newToDoButton);
        
        /*
        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement("do things");
        listModel.addElement("do more things");
        JList list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener((ListSelectionListener) this);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);
        todocard.add(listScrollPane);
        */
        
        
        
        
        cards = new JPanel(new CardLayout());
        cards.add(calcard, CALENDARPANEL);
        cards.add(groupcard, GROUPSPANEL);
        cards.add(todocard, TODOPANEL);
        
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }
    
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
    
    public static void launchMenu(User current, Calendar curcal, ToDoList curlist) {
        //Create and set up the window.
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the content pane.
        Menu menu = new Menu();
        menu.addComponentToPane(frame.getContentPane(), current, curcal, curlist);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
}
