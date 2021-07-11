import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class InfoEditEmployee extends Frame implements WindowListener,ActionListener{
	
	private Register register;
		
	public TextField id;
	public TextField ename;
	public TextField jb;
	public TextField phn;
	public TextField sal;

	public Button changeButton;
	public Button backButton;
	
	public InfoEditEmployee(Register r){
		super("Change Information");
		this.register=r;
		
		id=new TextField(10);
		ename=new TextField(10);
		jb=new TextField(10);
		phn=new TextField(11);
		sal=new TextField(10);
       
		Label logid=new Label("Employee ID");
		
		Label eName=new Label("Employee Name:");
		Label eJob=new Label("Job :");
		Label ePhn=new Label("Phone No. :");
		Label Sal=new Label("Salary :");
		
		
		changeButton=new Button("confirm");
		backButton=new Button("Back");
		
		add(logid);
		add(id);
		
	    add(eName);
	    add(ename);
		
	    add(eJob);
	    add(jb);
		
	    add(ePhn);
	    add(phn);
		
		add(Sal);
		add(sal);
		
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
			
			String newName= ename.getText();
			String JOB= jb.getText();
			String contactNumber=phn.getText();
			String salary=sal.getText();
			
				
			String sql1="update employee set e_name='"+newName+"',job='"+JOB+"',phone='"+contactNumber+"',Salary='"+salary+"' WHERE `log_id` = '"+user+"'";
			da.updateDB(sql1);
			
			JOptionPane.showMessageDialog(this,"Password Changed Successful !");
			
			register.iee.setVisible(false);
			register.hpu.setVisible(true);
			
			System.out.println(sql1);
			}
			
		}
		else if(st.equals("Back")){
			register.iee.setVisible(false);
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