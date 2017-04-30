import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;


public class Signup extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JLabel logo = new JLabel("entrak");
	private JTextField firstnameField = new JTextField(20);
	private JTextField lastnameField = new JTextField(20);
	private JTextField usernameField = new JTextField(20);
	private JTextField passwordField = new JTextField(20);
	private JTextField emailField = new JTextField(20);
	private JLabel fnlabel = new JLabel("first name:");
	private JLabel lnlabel = new JLabel("last name:");
	private JLabel unlabel = new JLabel("username:");
	private JLabel pwlabel = new JLabel("password:");
	private JLabel emlabel = new JLabel("email:");
	private JButton signUpButton = new JButton("sign up");
	private JButton signInButton = new JButton("sign in");
	
	public Signup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		

        signUpButton.addActionListener(
        	new ActionListener() {
        		public void actionPerformed( ActionEvent e) {
        			User current = new User(firstnameField.getText(),lastnameField.getText(),usernameField.getText(),
        					passwordField.getText(),emailField.getText());
        					
        			Calendar curcal = new Calendar(current, "basic", "");
        			
        			ToDoList curlist = new ToDoList(current);
        			
        			Menu.launchMenu(current, curcal, curlist);
        		}
        	}
        );

        signInButton.addActionListener(
        	new ActionListener() {
        		public void actionPerformed( ActionEvent e) {
        			User current = null;
        			Calendar curcal = null; //query these to pass
        			ToDoList curlist = null;
        			
        			Menu.launchMenu(current, curcal, curlist);
        		}
        	}
        );
        
		add(logo);
		add(unlabel);
		add(usernameField);
		add(pwlabel);
		add(passwordField);
		add(signInButton);
		add(fnlabel);
		add(firstnameField);
		add(lnlabel);
		add(lastnameField);
		add(emlabel);
		add(emailField);
		add(signUpButton);
		
		setSize(1000,1000);
		
		pack();
		setVisible(true);
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		new Signup();
		
	}


	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}