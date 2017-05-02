import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
//import java.util.Date; 
//import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
//import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
//import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class Menu implements ItemListener {
    JPanel cards;
    final static String CALENDARPANEL = "calendar";
    final static String GROUPSPANEL = "groups";
    final static String TODOPANEL = "to do list";
    
    private JTextField username = new JTextField(20);
    private JTextField group = new JTextField(20);
    private JLabel usernamel = new JLabel("user to be added:");
    private JLabel groupl = new JLabel("group to add to:");
    private JButton addMemberButton = new JButton("add member");
    
    private JTextField event = new JTextField(20);
    private JTextField start = new JTextField();
    private JTextField end = new JTextField();
    private JTextField place = new JTextField(20);
    private JLabel eventl = new JLabel("event:");
    private JLabel startl = new JLabel("start:");
    private JLabel endl = new JLabel("end:");
    private JLabel placel = new JLabel("location:");
    private JButton newEventButton = new JButton("add event");
    //private UtilDateModel model = new UtilDateModel();
    //private JDatePanelImpl datePanel = new JDatePanelImpl(model);
    //private JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
    
    private JTextField todo = new JTextField(20);
    private JButton newToDoButton = new JButton("add to do item");
    private JButton completedToDoButton = new JButton("completed task");//this is a dummy button
    
    private DefaultListModel listModel = new DefaultListModel();
    private JList list = new JList(listModel);
    
    private ToDoList curlist;
    private Calendar curcal;
    
    public void addComponentToPane(Container pane, User current, Calendar incal, ToDoList inlist) {
        JPanel comboBoxPane = new JPanel();
        String comboBoxItems[] = { CALENDARPANEL, GROUPSPANEL, TODOPANEL };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
        
        curlist = inlist;
        curcal = incal;
        
        final JPanel calcard = new JPanel();
        
        newEventButton.addActionListener(
        	new ActionListener() {
        		public void actionPerformed( ActionEvent e) {
        			new Event(curcal, event.getText(), Date.valueOf("2017-05-01"), Date.valueOf("2017-05-02"), place.getText());
        			//calcard.add(new JLabel(event.getText() + " from " + Date.valueOf("2017-05-01") + " until " + Date.valueOf("2017-05-02") + " at " + place.getText()));
        			//calcard.setVisible(true);
        		}
        	}
        );        
        
        newToDoButton.addActionListener(
           	new ActionListener() {
           		public void actionPerformed( ActionEvent e) {
           			//query todo list
           			curlist.addItem(todo.getText());
           			System.out.println("Insert Completed");
           			listModel.addElement(todo.getText());
           			int index = list.getHeight();
           			todo.requestFocusInWindow();
           			todo.setText("");
           			list.ensureIndexIsVisible(index);
           		}
          	}
        );
        
        calcard.add(new JLabel("My Calendar"));
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
        //groupcard.add(new JLabel("Groups"));
        groupcard.add(usernamel);
        groupcard.add(username);
        groupcard.add(groupl);
        groupcard.add(group);
        groupcard.add(addMemberButton);
        
        JPanel todocard = new JPanel();
        todocard.add(new JLabel("To Do-"));
        todocard.add(todo);
        todocard.add(newToDoButton);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);
        todocard.add(listScrollPane, BorderLayout.CENTER);
        
        todocard.add(completedToDoButton);
        
                
        
        
        
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
        //frame.add(datePicker);
    }
    
}
