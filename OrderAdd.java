import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class OrderAdd extends Frame implements WindowListener,ActionListener{
	
	private Register register;
		
	public TextField oid;
	public TextField pid;
	public TextField cusID;
	public TextField quantity;
	public TextField pPrice;
	public TextField date;
	public TextField eid;
	
	public Button signUpButton;
	public Button backButton;
	public OrderAdd(Register r){
		super("Add Order of Demand");
		this.register=r;
		
		oid=new TextField(10);
		pid=new TextField(10);
		cusID=new TextField(10);
		quantity=new TextField(15);
		pPrice=new TextField(10);
		date=new TextField(10);
		eid=new TextField(10);
  
       
		Label orderID=new Label("Order ID:");
		Label productID=new Label("Product ID:");
		Label customerName=new Label("Customer ID:");
		Label Quantity=new Label("Quantity:");
		Label Prices=new Label("Price");
		Label Date=new Label("Date (dd/mm/year):");
		Label employeeID=new Label("Employee ID:");
		
		
		signUpButton=new Button("confirm");
		backButton=new Button("Back");
		
		add(orderID);
		add(oid);
		
		add(productID);
		add(pid);
		
		add(customerName);
		add(cusID);
		
		add(Quantity);
		add(quantity);
		
		add(Prices);
		add(pPrice);
		
		add(Date);
		add(date);
		
		add(employeeID);
		add(eid);

		add(signUpButton);
		add(backButton);
		
		signUpButton.addActionListener(this);
		backButton.addActionListener(this);
		addWindowListener(this);
		setLocation(150,150);
		setSize(800,400);
		setLayout(new FlowLayout());
	}
	public void windowClosing(WindowEvent we){
        System.out.println("Window is closing");
		System.exit(0);
	}
	public void actionPerformed(ActionEvent e){
		DataAccess da=new DataAccess();
		String st=e.getActionCommand();
		if(st.equals("confirm")){
			if(oid.getText().equals("") || pid.getText().equals("") || cusID.getText().equals("") || quantity.getText().equals("") || pPrice.getText().equals("") || date.getText().equals("") || eid.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please provide all valid Informations"); 
			}
			else{
				//String PRICE="select price from product where p_id='"+pid.getText()+"'";
				//da.updateDB(PRICE);
				int qt=Integer.parseInt(quantity.getText());
				int pp=Integer.parseInt(pPrice.getText());
				int totalCost=pp*qt;
				String ttCOST = Integer.toString(totalCost);
				
			String sql="insert into orders (o_id,p_id,cus_id,quantity,price,date,e_id) values('"+oid.getText()+"','"+pid.getText()+"','"+cusID.getText()+"','"+quantity.getText()+"','"+ttCOST+"','"+date.getText()+"','"+eid.getText()+"')";
			da.updateDB(sql);
			
			JOptionPane.showMessageDialog(this,"Order of Demand is taken !");
			JOptionPane.showMessageDialog(this,"Wait until the product comes !");
			
			register.oa.setVisible(false);
			register.hpu.setVisible(true);
			
			System.out.println(sql);
			
			//oid.setText("");
			pid.setText("");
			cusID.setText("");
			quantity.setText("");
			//pPrice.setText("");
			date.setText("");
			eid.setText("");
			}
		}
		else if(st.equals("Back")){
			register.oa.setVisible(false);
			register.hpu.setVisible(true);
			//register.ON.setVisible(false);
		}
	}
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}

}