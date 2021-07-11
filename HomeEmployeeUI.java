import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JFrame;
class HomeEmployeeUI extends Frame implements WindowListener, ActionListener{
	private Register register;
	public Button logOutButton;
	public Button productButton;
	public Button ProductAddButton;
	public Button ORDERAddButton;
	public Button viewCustomerButton;
	private JLabel messageBox;
	public Button changePassButton;
	
	public HomeEmployeeUI(Register r){
		super("Employee Home");
		this.register=r;
		
		messageBox=new JLabel("Data to show");
		
		logOutButton=new Button("LogOut");
		productButton=new Button("Product");
		ProductAddButton=new Button("Add Product");
		ORDERAddButton=new Button("Add Order");
		viewCustomerButton = new Button("View Customer");
		changePassButton=new Button("Change Password");
		
		
		logOutButton.setBounds(60,200,80,30);
		productButton.setBounds(380,100,80,30);
		ProductAddButton.setBounds(380,140,80,30);
		ORDERAddButton.setBounds(380,180,80,30);
		changePassButton.setBounds(380,65,120,30);
		viewCustomerButton.setBounds(380,220,90,30);
		messageBox.setBounds(480,10,200,300);
		
		add(logOutButton);
		add(changePassButton);
		add(productButton);
		add(messageBox);
		add(viewCustomerButton);
		add(ProductAddButton);
		add(ORDERAddButton);
		
		logOutButton.addActionListener(this);
		productButton.addActionListener(this);
		ORDERAddButton.addActionListener(this);
		changePassButton.addActionListener(this);
		viewCustomerButton.addActionListener(this);
		ProductAddButton.addActionListener(this);
		
		addWindowListener(this);
		
		setSize(800,400);
		setLocation(100,100);
		
		setLayout(null);
	}
	public void paint(Graphics g){
		g.drawString("Welcome Employee !",40,100);
	}
	public void windowClosing(WindowEvent we){
        System.out.println("Window is closing");
		System.exit(0);
	}
	
	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
		if(s.equals("LogOut")){
			register.heu.setVisible(false);
			register.loginWindow.setVisible(true);
		}
		else if(s.equals("Product")){
			register.buf.loadContacts("select * from product");
			register.buf.showAllContact(messageBox);
		}
		else if(s.equals("Add Product")){
			register.heu.setVisible(false);
			register.pa.setVisible(true);
		}
		else if(s.equals("View Customer")){
			register.bufC.loadcustomer("select * from customer");
			register.bufC.showAllcustomer(messageBox);
			//register.heu.setVisible(false);
			//register.AddProduct.setVisible(true);
		}
		else if(s.equals("Add Order")){
			register.heu.setVisible(false);
			register.eoa.setVisible(true);
		}
		else if(s.equals("Change Password")){
			register.hcu.setVisible(false);
			JOptionPane.showMessageDialog(this,"You are about to change password!");
			register.ccp.setVisible(true);
		}
}	
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}

}