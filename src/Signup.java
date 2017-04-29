import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class Signup extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
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
	private JButton enter = new JButton("sign up");
	
	public Signup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(logo);
		add(fnlabel);
		add(firstnameField);
		add(lnlabel);
		add(lastnameField);
		add(unlabel);
		add(usernameField);
		add(pwlabel);
		add(passwordField);
		add(emlabel);
		add(emailField);
		
		add(enter);
		setSize(1000,1000);
		
		enter.addActionListener(this);
		
	    pack();
	    setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		new User(firstnameField.getText(),lastnameField.getText(),usernameField.getText(),
		passwordField.getText(),emailField.getText());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		new Signup();
	}

}