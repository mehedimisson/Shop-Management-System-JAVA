import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class ProductAdd extends Frame implements WindowListener,ActionListener{
	
	private Register register;
		
	public TextField pid;
	public TextField pName;
	public TextField mdlNO;
	public TextField pPrice;
	public TextField cid;
	public TextField sid;
	public TextField warnty;
	
	public TextField TypeName;
	

	public TextField Quantity;
	
	public Button signUpButton;
	public Button backButton;
	public ProductAdd(Register r){
		super("Add Products");
		this.register=r;
		
		pid=new TextField(10);
		pName=new TextField(10);
		mdlNO=new TextField(10);
		pPrice=new TextField(10);
		cid=new TextField(10);
		sid=new TextField(10);
		warnty=new TextField(10);
		TypeName=new TextField(10);
		Quantity=new TextField(10);
  
       
		Label productID=new Label("Product ID:");
		Label productName=new Label("Product Name:");
		Label modelNumer=new Label("Model Number:");
		Label productPrice=new Label("Product Price:");
		Label categoryID=new Label("Category ID:");
		Label stockID=new Label("Stock ID :");
		Label productWarranty=new Label("Product Warranty:");
		Label categoryType=new Label("Category Type");
		Label qnty=new Label("Quantity");
		
		
		signUpButton=new Button("confirm");
		backButton=new Button("Back");
		
		add(productID);
		add(pid);
		
		add(productName);
		add(pName);
		
		add(modelNumer);
		add(mdlNO);
		
		add(productPrice);
		add(pPrice);
		
		add(categoryID);
		add(cid);
		add(categoryType);
		add(TypeName);
		
		add(stockID);
		add(sid);
		add(qnty);
		add(Quantity);
		
		
		add(productWarranty);
		add(warnty);

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
			if(pName.getText().equals("") || pid.getText().equals("") || mdlNO.getText().equals("") || cid.getText().equals("") || pPrice.getText().equals("") || warnty.getText().equals("") || sid.getText().equals("") || warnty.getText().equals("") || sid.getText().equals("") || TypeName.getText().equals("") || Quantity.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please provide all valid Informations"); 
			}
			else{
			String sql="insert into product (p_id,pName,modelNo,price,c_id,s_id,warranty) values('"+pid.getText()+"','"+pName.getText()+"','"+mdlNO.getText()+"','"+pPrice.getText()+"','"+cid.getText()+"','"+sid.getText()+"','"+warnty.getText()+"')";
			da.updateDB(sql);
			System.out.println(sql);
			JOptionPane.showMessageDialog(this,"Product Successfully added!");
			
			String sqlC="insert into category (c_id,type) values('"+cid.getText()+"','"+TypeName.getText()+"')";
			da.updateDB(sqlC);
			
			JOptionPane.showMessageDialog(this,"Category Added Succesfully !");
			
			String sqlS="insert into stock (s_id,Quantity) values('"+sid.getText()+"','"+Quantity.getText()+"')";
			da.updateDB(sqlS);
			
			JOptionPane.showMessageDialog(this,"Added Succesfully !");
			
			pName.setText("");
			pid.setText("");
			mdlNO.setText("");
			cid.setText("");
			pPrice.setText("");
			sid.setText("");
			warnty.setText("");
			TypeName.setText("");
			Quantity.setText("");
			register.pa.setVisible(false);
			register.heu.setVisible(true);
			}
		}
		else if(st.equals("Back")){
			register.pa.setVisible(false);
			register.heu.setVisible(true);
		}
	}
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}

}