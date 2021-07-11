public class customer{
	
	private int cus_id;
	private String cus_name;
	private String cus_add;
	private String phone;
	
	
	public customer(int c,String n,String p,String e){
		cus_id=c;cus_name=n;
		cus_add=p;phone=e;
	}
	public String getName(){return cus_name;}
	public String getPhone(){return phone;}
	public String getAdd(){return cus_add;}
	public int getCID(){return cus_id;}
	public String toString(){
		return cus_name+" : "+phone;
	}
}