import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Basic1 extends JFrame implements ActionListener{
	
	private int count = 0;
	private int count2 = 0;
	private JButton myButton = new JButton("PUSH ME!");
	private JLabel label = new JLabel("Count: "+ count);
	//private JLabel label2 = new JLabel("'count2'");
	private JButton myButton2 = new JButton(""+count2);
	
	public Basic1() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		setResizable(true);
		setTitle("Entrak");
		add(myButton);
		add(myButton2);
		setSize(1000,1000);
		add(label);
		myButton.addActionListener(this);
		myButton2.addActionListener(this);
		
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e){
		count++;
		label.setText("Count: "+ count);
	}
	
	public void actionPerformed2(ActionEvent e){
		count2++;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		new Basic1();
	}

}
