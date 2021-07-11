public class Register{
	
	public LoginWindow loginWindow;
	public SignUpWindow signUpWindow;
// User Interface for loggedIn User 
	public HomeCustomerUI hcu;
	public HomeEmployeeUI heu;
	public HomePresidentUI hpu;
// Adding UI	
	public ProductAdd pa;
	public ProductAdd ppa;
	public OrderAdd oa;
	public EmployeeOrderAdd eoa;
	public EmployeeAdd ea;
	//public OrderAddP oap;

//Edit/Update	
	public CustomerChangePassword ccp;
	public EmployeeChangePassword ecp;
	public InfoEditCustomer iec;
	public InfoEditEmployee iee;
	public StockUpdate su;
//Delete
	public DeleteCustomer dltc;
	public DeleteEmployee dlte;
	public DeleteOrder dlto;
	public DeleteProduct dltp;
	
//Buffer	
	public Buffer buffer;
	public Bufferp buf;
	public BufferCustomer bufC;
	public BufferEmployee bufE;
	
	public Register(){
		loginWindow=null;
		signUpWindow=null;
//	UI USer		
		hcu=null;
		heu=null;
		hpu=null;
//	adding UI		
		
		ppa=null;
		pa=null;
		oa=null;
		eoa=null;
		ea=null;
		//oap=null;
		
//	EDIT UPDATE		
		su=null;
		ccp=null;
		ecp=null;
		iec=null;
		iee=null;
//	DELETE		
		dltc=null;
		dlte=null;
		dlto=null;
		dltp=null;
		
//	buffer
		buf=null;
		bufC=null;
		bufE=null;
		
		buffer = new Buffer(20);
		buf = new Bufferp(10);
		bufC = new BufferCustomer(10);
		bufE = new BufferEmployee(10);
	}
}