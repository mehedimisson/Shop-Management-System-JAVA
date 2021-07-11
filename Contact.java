public class Contact{
	
	private int p_id;
	private String pName;
	private String modelNo;
	private int price;
	private int c_id;
	private int s_id;
	private int warranty;
	
	public Contact(int c,String n,String p,int e,int cd,int sd, int w){
		p_id=c;pName=n;
		modelNo=p;price=e;c_id=cd;s_id=sd;
		warranty=w;
	}
	public String getName(){return pName;}
	public String getPhone(){return modelNo;}
	public int getEmail(){return price;}
	public int getCID(){return p_id;}
	public String toString(){
		return pName+" : "+price;
	}
}