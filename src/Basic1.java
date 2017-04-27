import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Basic1 extends JFrame implements ActionListener{
	
	private int count = 0;
	private JButton myButton = new JButton("PUSH ME!");
	private JLabel label = new JLabel("Count: "+ count);
	
	public Basic1() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(myButton);
		setSize(400,400);
		add(label);
		
		
		myButton.addActionListener(this);
		pack();
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e){
		count++;
		label.setText("Count: "+ count);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		new Basic1();
	}

}
