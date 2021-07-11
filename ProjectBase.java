public class ProjectBase{
    public static void main(String str[]){
		Register r=new Register();
		r.loginWindow=new LoginWindow(r);
		r.signUpWindow=new SignUpWindow(r);
		
		r.hcu=new HomeCustomerUI(r);
		r.heu=new HomeEmployeeUI(r);
		r.hpu=new HomePresidentUI(r);
		r.pa=new ProductAdd(r);
		r.oa=new OrderAdd(r);
		r.ccp=new CustomerChangePassword(r);
		
		//r.buf=new Bufferp(r);
        r.loginWindow.setVisible(true);
    }
}