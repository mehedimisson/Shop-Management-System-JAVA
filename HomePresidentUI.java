import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JFrame;
class HomePresidentUI extends JFrame implements WindowListener, ActionListener{
	private Register register;
	public Button logOutButton;
	public Button productButton;
	
	public Button ProductAddButton;
	public Button ORDERAddButton;
	public Button EmployeeAddButton;
	
	public Button StockUpdateButton;
	public Button EditEmployeeButton;
	
	
	public Button viewCustomerButton;
	public Button viewEmployeeButton;
	
	public Button deleteCustomerButton;
	public Button deleteEmployeeButton;
	public Button deleteOrderButton;
	public Button deleteProductButton;
	
	private JLabel messageBox;
	
	
	
	public HomePresidentUI(Register r){
		super("Welcome BOSS! ");
		this.register=r;
		
		messageBox=new JLabel("Data to show");
		
		logOutButton=new Button("LogOut");
		productButton=new Button("Product");
		EmployeeAddButton=new Button("Add Employee");
		
		StockUpdateButton=new Button("Update Stock");
		EditEmployeeButton=new Button("Edit Employee Info");
		
		ProductAddButton=new Button("Add Product");
		ORDERAddButton=new Button("Add Order");
		viewCustomerButton = new Button("View Customer");
		viewEmployeeButton = new Button("View Employee");
		
		deleteCustomerButton = new Button("Delete a Customer");
		deleteEmployeeButton = new Button("Delete a Employee");
		deleteOrderButton = new Button("Delete a Order");
		deleteProductButton=new Button("Delete a product");
		
		deleteCustomerButton.setBounds(240,100,130,30);
		deleteEmployeeButton.setBounds(240,140,130,30);
		deleteOrderButton.setBounds(240,180,100,30);
		deleteProductButton.setBounds(240,220,100,30);
		
		StockUpdateButton.setBounds(240,180,80,30);
		EditEmployeeButton.setBounds(200,60,140,30);
		
		logOutButton.setBounds(60,200,80,30);
		productButton.setBounds(380,100,80,30);
		ProductAddButton.setBounds(380,140,80,30);
		ORDERAddButton.setBounds(380,180,80,30);
		EmployeeAddButton.setBounds(380,60,80,30);
		viewEmployeeButton.setBounds(350,30,100,30);
		viewCustomerButton.setBounds(380,220,90,30);
		messageBox.setBounds(480,10,200,300);
		
		add(logOutButton);
		add(productButton);
		add(messageBox);
		add(viewCustomerButton);
		add(viewEmployeeButton);
		
		add(ProductAddButton);
		add(EditEmployeeButton);
		add(ORDERAddButton);
		add(EmployeeAddButton);
		
		add(deleteCustomerButton);
		add(deleteEmployeeButton);
		add(deleteOrderButton);
		add(deleteProductButton);
		
		add(StockUpdateButton);
		
		
		logOutButton.addActionListener(this);
		productButton.addActionListener(this);
		
		EditEmployeeButton.addActionListener(this);
				
		viewCustomerButton.addActionListener(this);
		viewEmployeeButton.addActionListener(this);
		
		ORDERAddButton.addActionListener(this);
		ProductAddButton.addActionListener(this);
		EmployeeAddButton.addActionListener(this);
		
		deleteCustomerButton.addActionListener(this);
		deleteEmployeeButton.addActionListener(this);
		deleteOrderButton.addActionListener(this);
		deleteProductButton.addActionListener(this);
		
		StockUpdateButton.addActionListener(this);
		
		addWindowListener(this);
		
		setSize(800,400);
		setLocation(100,100);
		
		setLayout(null);
	}
	public void paint(Graphics g){
		g.drawString("Welcome Mr.President !",40,100);
	}
	public void windowClosing(WindowEvent we){
        System.out.println("Window is closing");
		System.exit(0);
	}
	
	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
		if(s.equals("LogOut")){
			register.hpu.setVisible(false);
			register.loginWindow.setVisible(true);
		}
		else if(s.equals("Product")){
			register.buf.loadContacts("select * from product");
			register.buf.showAllContact(messageBox);
		}
		else if(s.equals("View Employee")){
			register.bufE.loademployee("select * from employee");
			register.bufE.showAllemployee(messageBox);
		}
		else if(s.equals("Add Product")){
			register.hpu.setVisible(false);
			register.pa.setVisible(true);
		}
		else if(s.equals("View Customer")){
			register.bufC.loadcustomer("select * from customer");
			register.bufC.showAllcustomer(messageBox);			
		}
		else if(s.equals("Add Order")){
			register.hpu.setVisible(false);
			register.oa.setVisible(true);
		}
		else if(s.equals("Add Employee")){
			register.hpu.setVisible(false);
			register.ea.setVisible(true);
		}
		else if(s.equals("Delete a Customer")){
			register.hpu.setVisible(false);
			register.dltc.setVisible(true);
		}
		else if(s.equals("Delete a Employee")){
			register.hpu.setVisible(false);
			register.dlte.setVisible(true);
		}
		else if(s.equals("Delete a Order")){
			register.hpu.setVisible(false);
			register.dlto.setVisible(true);
		}
		else if(s.equals("Delete a product")){
			register.hpu.setVisible(false);
			register.dltp.setVisible(true);
		}
		else if(s.equals("Update Stock")){
			register.hpu.setVisible(false);
			register.su.setVisible(true);
		}
		else if(s.equals("Edit Employee Info")){
			register.hpu.setVisible(false);
			register.iee.setVisible(true);
		}
}	
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}

}