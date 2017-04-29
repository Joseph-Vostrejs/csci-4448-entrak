import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu implements ItemListener {
    JPanel cards; //a panel that uses CardLayout
    final static String CALENDARPANEL = "calendar";
    final static String GROUPSPANEL = "groups";
    final static String TODOPANEL = "to do list";
    
    public void addComponentToPane(Container pane) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = { CALENDARPANEL, GROUPSPANEL, TODOPANEL };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
        
        //Create the "cards".
        JPanel calcard = new JPanel();
        calcard.add(new JLabel("-Calendar Info-"));
        
        JPanel groupcard = new JPanel();
        groupcard.add(new JLabel("-groups info-"));
        
        JPanel todocard = new JPanel();
        todocard.add(new JLabel("-to do list info-"));
        
        //Create the panel that contains the "cards".
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
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    public static void launchMenu(User current) {
        //Create and set up the window.
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the content pane.
        Menu menu = new Menu();
        menu.addComponentToPane(frame.getContentPane());
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
}
