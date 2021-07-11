import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class LoginWindow extends Frame implements WindowListener, ActionListener{
	private Register register;
	public TextField uName;
	public TextField password;
	public Button loginButton;
	public Button signUpButton;
	public LoginWindow(Register r){
		super("Login");
		this.register=r;
		uName=new TextField();
		password=new TextField();
		loginButton=new Button("Login");
		signUpButton=new Button("Signup");
		password.setEchoChar('*');
		
		uName.setBounds(120,80,150,30);
		uName.setBackground(Color.lightGray);
		password.setBounds(120,130,150,30);
		password.setBackground(Color.lightGray);
		
		loginButton.setBounds(80,200,80,30);
		loginButton.setBackground(Color.GREEN);
		signUpButton.setBounds(190,200,80,30);
		signUpButton.setBackground(Color.BLUE);
		
		Label l1=new Label("Username");
		TextField tf=new TextField(10);
		add(l1);
		add(uName);
		add(password);
		add(loginButton);
		add(signUpButton);
		setBackground(Color.WHITE);
		loginButton.addActionListener(this);
		signUpButton.addActionListener(this);
		addWindowListener(this);
		setSize(380, 420);
		setLocation(100,100);
		setLayout(null);
	
	}
	public void paint(Graphics g){
		
		g.drawString("Log ID:",40,100);
		g.drawString("Password:",40,150);
		g.drawString("Gadget & Shop ",20,50);
	}
	public void windowClosing(WindowEvent we){
        System.out.println("Window is closing");
		System.exit(0);
	}
	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
		boolean b=false;
		int q2=0;
		if(s.equals("Login")){
			try{
				register.buffer.loadStudents("select * from login");
				//register.buffer.printAllStudents();
				b=register.buffer.checkStudentAuth(uName.getText(),password.getText());
				if(b){
					q2=register.buffer.checkStatus(uName.getText(),password.getText());
					
					
					if(q2==1){
					System.out.println("Valid User");
					//register.signUpWindow.setVisible(true);
					register.hcu.setVisible(true);
					register.loginWindow.setVisible(false);
					uName.setText("");
					password.setText("");
				}
					else if(q2==2){
					System.out.println("Valid User");
					//register.signUpWindow.setVisible(true);
					register.heu.setVisible(true);
					register.loginWindow.setVisible(false);
					uName.setText("");
					password.setText("");
				}
				else if(q2==3){
					System.out.println("Valid User");
					JOptionPane.showMessageDialog(this,"Welcome Boss!");
					register.hpu.setVisible(true);
					register.loginWindow.setVisible(false);
					uName.setText("");
					password.setText("");
				}
				}
				else{
					JOptionPane.showMessageDialog(this,"Invalid ID or Password");
					System.out.println("Invalid User");
				}
			}
			catch(Exception ex){ex.printStackTrace();}
			//System.out.println(uName.getText());
			//System.out.println(password.getText());
		}
		else if(s.equals("Signup")){
			register.loginWindow.setVisible(false);
			register.signUpWindow.setVisible(true);
		}
	}
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}

}