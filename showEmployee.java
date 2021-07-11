//package labtask;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class showEmployee extends JFrame implements ActionListener{
    private JLabel messageBox;
	
	public BufferEmployee bufE;
	public showEmployee(){
		super("Java Keyboard Demo");
		bufE=new BufferEmployee(10);
		Button b=new Button("Show All");
        messageBox=new JLabel("Data to show");
        
		
		
		b.setBounds(20,150,80,25);
		messageBox.setBounds(130,10,300,300);
		
    
        add(b);
		add(messageBox);

		setSize(450,400);
		b.addActionListener(this);
		setLayout(null);
	}
	public void actionPerformed(ActionEvent ae){
		String st=ae.getActionCommand();
		if(st.equals("Show All")){
			bufE.loademployee("select * from employee");
			bufE.showAllemployee(messageBox);
		}
	}
	public void paint(Graphics g){
	}
}
