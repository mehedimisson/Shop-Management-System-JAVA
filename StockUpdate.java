import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class StockUpdate extends Frame implements WindowListener,ActionListener{
	
	private Register register;
		
	public TextField sid;
	public TextField Quantity;
	
	public Button signUpButton;
	public Button backButton;
	
	public StockUpdate(Register r){
		super("Update Stock");
		this.register=r;
		
		sid=new TextField(10);
		Quantity=new TextField(10);
		
       
		Label stockID=new Label("Stock ID:");
		Label qnty=new Label("Quantity :");
	
		
		signUpButton=new Button("confirm");
		backButton=new Button("Back");
		
		add(stockID);
		add(sid);
		
		add(qnty);
		add(Quantity);


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
			if(sid.getText().equals("") || Quantity.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please provide all valid Informations"); 
			}
			else{
				
			String ID= sid.getText();
			String Q= Quantity.getText();
			
			String sql="update stock set Quantity='"+Q+"' WHERE `s_id` = '"+ID+"'";
			da.updateDB(sql);
			
			JOptionPane.showMessageDialog(this,"Added Succesfully !");
			
			register.su.setVisible(false);
			register.hpu.setVisible(true);
			
			System.out.println(sql);
			
			sid.setText("");
			Quantity.setText("");

			}
		}
		else if(st.equals("Back")){
			register.su.setVisible(false);
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