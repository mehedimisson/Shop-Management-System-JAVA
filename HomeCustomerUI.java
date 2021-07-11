import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JFrame;
class HomeCustomerUI extends Frame implements WindowListener, ActionListener{
	private Register register;
	public Button changePassButton;
	public Button changeInfoButton;
	public Button logOutButton;
	public Button productButton;
	private JLabel messageBox;
	
	public HomeCustomerUI(Register r){
		super("CustomerHome");
		this.register=r;
		messageBox=new JLabel("Data to show");
		setBackground(Color.lightGray);
		
		logOutButton=new Button("LogOut");
		productButton=new Button("Product");
		changePassButton=new Button("Change Password");
		changeInfoButton=new Button("Change Information");
		
		logOutButton.setBounds(60,200,80,30);
		logOutButton.setBackground(Color.red);
		productButton.setBounds(380,100,80,30);
		productButton.setBackground(Color.blue);
		changePassButton.setBounds(310,140,120,30);
		changeInfoButton.setBounds(310,180,120,30);
		changePassButton.setBackground(Color.blue);
		messageBox.setBounds(480,10,200,300);
		
		add(logOutButton);
		add(productButton);
		add(changePassButton);
		add(messageBox);
		add(changeInfoButton);
		
		logOutButton.addActionListener(this);
		productButton.addActionListener(this);
		changePassButton.addActionListener(this);
		changeInfoButton.addActionListener(this);
		
		addWindowListener(this);
		
		setSize(800,400);
		setLocation(100,100);
		
		setLayout(null);
		
	}
	public void paint(Graphics g){
		g.drawString("Welcome Customer !",40,100);
	}
	public void windowClosing(WindowEvent e){
        System.out.println("Window is closing");
		System.exit(0);
	}
	
	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
		if(s.equals("LogOut")){
			register.hcu.setVisible(false);
			register.loginWindow.setVisible(true);
		}
		else if(s.equals("Product")){
			register.buf.loadContacts("select * from product");
			register.buf.showAllContact(messageBox);
		}
		else if(s.equals("Change Password")){
			register.hcu.setVisible(false);
			JOptionPane.showMessageDialog(this,"You are about to change password!");
			register.ccp.setVisible(true);
		}
		else if(s.equals("Change Information")){
			register.hcu.setVisible(false);
			JOptionPane.showMessageDialog(this,"You are about to change your Information");
			register.iec.setVisible(true);
		}
}	
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}

}