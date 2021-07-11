import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class CustomerChangePassword extends Frame implements WindowListener,ActionListener{
	
	private Register register;
		
	public TextField oid;
	public TextField oPass;
	public TextField nPass;

	
	public Button changeButton;
	public Button backButton;
	public CustomerChangePassword(Register r){
		super("Change Password");
		this.register=r;
		
		oid=new TextField(10);
		oPass=new TextField(10);
		nPass=new TextField(10);
		
  
       
		Label logid=new Label("log ID");
		Label oldPass=new Label("old password");
		Label newPass=new Label("new Password");
		
		
		
		changeButton=new Button("confirm");
		backButton=new Button("Back");
		
		add(logid);
		add(oid);
		
		add(oldPass);
		add(oPass);
		
		add(newPass);
		add(nPass);
		
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
			String newpassword = nPass.getText();
			String oldpassword = oPass.getText();
			String user = oid.getText();
			
			String sql="update login set password='"+newpassword+"' WHERE `log_id` = '"+user+"' and `password`='"+oldpassword+"'";
			da.updateDB(sql);
			JOptionPane.showMessageDialog(this,"Password Changed Successful !");
			
			register.ccp.setVisible(false);
			register.loginWindow.setVisible(true);
			
			System.out.println(sql);
			
			oid.setText("");
			oPass.setText("");
			nPass.setText("");
			
		}
		else if(st.equals("Back")){
			register.ccp.setVisible(false);
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