//package labtask;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
//import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ShowContact extends JFrame implements ActionListener{
    private JLabel messageBox;
	private TextField emailText;
	public Bufferp buf;
	public ShowContact(){
		super("Java Keyboard Demo");
		buf=new Bufferp(10);
		Button b=new Button("Show All");
        messageBox=new JLabel("Data to show");
        emailText=new TextField(30);
		
		//emailText.setBounds(20,100,100,25);
		b.setBounds(20,150,80,25);
		messageBox.setBounds(50,10,300,300);
		
        //add(emailText);
        add(b);
		add(messageBox);

		setSize(50,400);
		b.addActionListener(this);
		setLayout(null);
	}
	public void actionPerformed(ActionEvent ae){
		String st=ae.getActionCommand();
		if(st.equals("Show All")){
			buf.loadContacts("select * from product");
			buf.showAllContact(messageBox);
		}
	}
	public void paint(Graphics g){
	}
}
