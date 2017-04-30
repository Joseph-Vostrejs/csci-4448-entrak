import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Menu implements ItemListener {
    JPanel cards;
    final static String CALENDARPANEL = "calendar";
    final static String GROUPSPANEL = "groups";
    final static String TODOPANEL = "to do list";
    
    public void addComponentToPane(Container pane, User current) {
        JPanel comboBoxPane = new JPanel();
        String comboBoxItems[] = { CALENDARPANEL, GROUPSPANEL, TODOPANEL };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
        
        
        
        JPanel calcard = new JPanel();
        calcard.add(new JLabel("Calendar"));
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
    
    public static void launchMenu(User current) {
        //Create and set up the window.
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the content pane.
        Menu menu = new Menu();
        menu.addComponentToPane(frame.getContentPane(), current);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
}
