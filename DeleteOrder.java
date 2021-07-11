import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class DeleteOrder extends Frame implements WindowListener,ActionListener{
	
	private Register register;
		
	public TextField id;
	

	public Button changeButton;
	public Button backButton;
	
	public DeleteOrder(Register r){
		super("Delete Order");
		this.register=r;
		
		id=new TextField(10);

       
		Label logid=new Label("Enter the OrderID ");

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
			
			String sql1="delete from orders WHERE `o_id` = '"+user+"'";
			da.updateDB(sql1);
			
			
			JOptionPane.showMessageDialog(this,"Order Deleted !");
						
			System.out.println(sql1);
			}
			
		}
		else if(st.equals("Back")){
			register.dlto.setVisible(false);
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