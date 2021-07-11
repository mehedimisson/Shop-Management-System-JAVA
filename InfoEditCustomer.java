import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class InfoEditCustomer extends Frame implements WindowListener,ActionListener{
	
	private Register register;
		
	public TextField id;
	public TextField cname;
	public TextField cadd;
	public TextField phn;

	public Button changeButton;
	public Button backButton;
	
	public InfoEditCustomer(Register r){
		super("Change Information");
		this.register=r;
		
		id=new TextField(10);
		cname=new TextField(10);
		cadd=new TextField(10);
		phn=new TextField(10);
       
		Label logid=new Label("log ID");
		
		Label cName=new Label("Customer Name:");
		Label cAdd=new Label("Address :");
		Label cPhn=new Label("Phone No. :");
		
		
		
		changeButton=new Button("confirm");
		backButton=new Button("Back");
		
		add(logid);
		add(id);
		
	    add(cName);
	    add(cname);
		
	    add(cAdd);
	    add(cadd);
		
	    add(cPhn);
	    add(phn);
		
		add(changeButton);
		add(backButton);
		
		changeButton.addActionListener(this);
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
			if(id.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please provide changes!"); 
			}
			else{
			String user = id.getText();
			
			String newName= cname.getText();
			String newAddress= cadd.getText();
			String contactNumber=phn.getText();
			
				
			String sql1="update customer set cus_name='"+newName+"',cus_add='"+newAddress+"',phone='"+contactNumber+"' WHERE `log_id` = '"+user+"'";
			da.updateDB(sql1);
			
			JOptionPane.showMessageDialog(this,"Password Changed Successful !");
			
			register.iec.setVisible(false);
			register.hcu.setVisible(true);
			
			System.out.println(sql1);
			}
			
		}
		else if(st.equals("Back")){
			register.iec.setVisible(false);
			register.hcu.setVisible(true);
		}
	}
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}

}