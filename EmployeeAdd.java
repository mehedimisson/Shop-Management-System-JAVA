import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class EmployeeAdd extends Frame implements WindowListener,ActionListener{
	private Register register;
	public TextField uName;
	public TextField pass;
	public TextField ename;
	public TextField jb;
	public TextField phn;
	public TextField sal;
	public Button signUpButton;
	public Button backButton;
	public EmployeeAdd(Register r){
		super("Add Employee");
		this.register=r;
		//SpaceField 
		
		uName=new TextField(10);
		pass=new TextField(10);
		ename=new TextField(10);
		jb=new TextField(10);
		phn=new TextField(11);
		sal=new TextField(10);
		
       // Labels
		Label lID=new Label("Log ID");
		Label pwd=new Label("Password:");
		Label eName=new Label("Employee Name:");
		Label cJob=new Label("Job :");
		Label cPhn=new Label("Phone No. :");
		Label Sal=new Label("Salary");
		
		//Button Adding
		
		signUpButton=new Button("Signup");
		signUpButton.setBackground(Color.blue);
		backButton=new Button("Back");
		backButton.setBackground(Color.red);
		
		//Finally all adding to UI
		
		add(lID);
		add(uName);
		
		add(pwd);
		add(pass);
	
	   add(eName);
	   add(ename);
	   
	   add(cJob);
	   add(jb);
	   
	   add(cPhn);
	   add(phn);
	   
	   add(Sal);
	   add(sal);
	   
	   add(signUpButton);
	   add(backButton);
		
		signUpButton.addActionListener(this);
		backButton.addActionListener(this);
		addWindowListener(this);
		setLocation(250,150);
		setSize(800,400);
		setLayout(new FlowLayout());
		setBackground(Color.lightGray);
	}
	public void windowClosing(WindowEvent we){
        System.out.println("Window is closing");
		System.exit(0);
	}
	public void actionPerformed(ActionEvent e){
		DataAccess da=new DataAccess();
		String st=e.getActionCommand();
		if(st.equals("Signup")){
			if(uName.getText().equals("") || pass.getText().equals("") || ename.getText().equals("") || jb.getText().equals("") || phn.getText().equals("") || sal.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please provide all valid Informations"); 
			}
			else{
			int status=2;
			String sql="insert into login (log_id,password,status) values('"+uName.getText()+"','"+pass.getText()+"','"+status+"')";
			da.updateDB(sql);
			System.out.println(sql);
			String sql1="INSERT INTO employee (e_name,job,phone,Salary,log_id) VALUES ('"+ename.getText()+"','"+jb.getText()+"','"+phn.getText()+"','"+sal.getText()+"','"+uName.getText()+"')";
			da.updateDB(sql1);
			System.out.println(sql1);
			JOptionPane.showMessageDialog(this,"Employee add successfully!");
			
			register.ea.setVisible(false);
			register.hpu.setVisible(true);
			}
		}
		else if(st.equals("Back")){
			register.ea.setVisible(false);
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