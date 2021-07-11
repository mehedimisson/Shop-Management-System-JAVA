import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class SignUpWindow extends Frame implements WindowListener,ActionListener{
	private Register register;
	public TextField uName;
	public TextField pass;
	public TextField cname;
	public TextField cadd;
	public TextField phn;
	public Button signUpButton;
	public Button backButton;
	public SignUpWindow(Register r){
		super("User Sign Up Window");
		this.register=r;
		uName=new TextField(10);
		pass=new TextField(10);
		cname=new TextField(10);
		cadd=new TextField(10);
		phn=new TextField(11);
		/*Checkbox checkbox1 = new Checkbox("C++");  
        checkbox1.setBounds(100,100, 50,50);  
        Checkbox checkbox2 = new Checkbox("Java", true);  
        checkbox2.setBounds(100,150, 50,50);
*/		
       
		Label ul=new Label("User Name:");
		Label el=new Label("Password:");
		Label cName=new Label("Customer Name:");
		Label cAdd=new Label("Address :");
		Label cPhn=new Label("Phone No. :");
		
		
		
		signUpButton=new Button("Signup");
		signUpButton.setBackground(Color.blue);
		backButton=new Button("Back");
		backButton.setBackground(Color.red);
		
		add(ul);
		add(uName);
		add(el);
		add(pass);
	// add(checkbox1);  
       // add(checkbox2);
	   add(cName);
	   add(cname);
	   add(cAdd);
	   add(cadd);
	   add(cPhn);
	   add(phn);
		add(signUpButton);
		add(backButton);
		
		signUpButton.addActionListener(this);
		backButton.addActionListener(this);
		addWindowListener(this);
		setLocation(150,150);
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
			if(uName.getText().equals("") || pass.getText().equals("") || uName.getText().equals("") || cadd.getText().equals("") || phn.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please provide all valid Informations"); 
			}
			else {
			int status=1;
			String sql="insert into login (log_id,password,status) values('"+uName.getText()+"','"+pass.getText()+"','"+status+"')";
			da.updateDB(sql);
			System.out.println(sql);
			String sql1="insert into customer (log_id,cus_name,cus_add,	phone) values('"+uName.getText()+"','"+cname.getText()+"','"+cadd.getText()+"','"+phn.getText()+"')";
			da.updateDB(sql1);
			System.out.println(sql1);
			JOptionPane.showMessageDialog(this,"Sign Up successful! Enjoy !");
			
			register.signUpWindow.setVisible(false);
			register.loginWindow.setVisible(true);
			}
		}
		else if(st.equals("Back")){
			register.signUpWindow.setVisible(false);
			register.loginWindow.setVisible(true);
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