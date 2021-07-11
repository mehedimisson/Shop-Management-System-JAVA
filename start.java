public class start{
    public static void main(String str[]){
		Register r=new Register();
		
		r.loginWindow=new LoginWindow(r);
		r.signUpWindow=new SignUpWindow(r);
		
		//UI from Login
		
		r.hcu=new HomeCustomerUI(r);
		r.heu=new HomeEmployeeUI(r);
		r.hpu=new HomePresidentUI(r);
		
		// Adding
		
		r.pa=new ProductAdd(r);
		r.oa=new OrderAdd(r);
		r.ea=new EmployeeAdd(r);
		//r.ca=new CategoryAdd(r);
		r.eoa=new EmployeeOrderAdd(r);
		//r.oap=new 
		
		// Change or Edit
		
		r.ccp=new CustomerChangePassword(r);
		r.ecp=new EmployeeChangePassword(r);
		r.iec=new InfoEditCustomer(r);
		r.iee=new InfoEditEmployee(r);
		r.su=new StockUpdate(r);
		
		//Delete
		r.dltc=new DeleteCustomer(r);
		r.dlte=new DeleteEmployee(r);
		r.dltp=new DeleteProduct(r);
		r.dlto=new DeleteOrder(r);
		
        r.loginWindow.setVisible(true);
    }
}