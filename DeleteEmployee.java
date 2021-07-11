import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class DeleteEmployee extends Frame implements WindowListener,ActionListener{
	
	private Register register;
		
	public TextField id;
	

	public Button changeButton;
	public Button backButton;
	
	public DeleteEmployee(Register r){
		super("Delete Employee");
		this.register=r;
		
		id=new TextField(10);

       
		Label logid=new Label("Enter the LogID ");

		changeButton=new Button("confirm");
		backButton=new Button("Back");
		
		add(logid);
		add(id);
		
	    		
		add(changeButton);
		add(backButton);
		
		changeButton.addActionListener(this);
		backButton.addActionListener(this);
		addWindowListener(this);
		setLocation(350,150);
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
			
			String sql1="delete from employee WHERE `log_id` = '"+user+"'";
			da.updateDB(sql1);
			
			String sql="delete from login WHERE `log_id` = '"+user+"'";
			da.updateDB(sql);
			
			JOptionPane.showMessageDialog(this,"Employee Information Deleted !");
						
			System.out.println(sql1);
			}
			
		}
		else if(st.equals("Back")){
			register.dlte.setVisible(false);
			register.hpu.setVisible(true);
		}
	}
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}

}