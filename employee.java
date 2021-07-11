public class employee{
	
	private int e_id;
	private String e_name;
	private String job;
	private String Salary;
	
	
	public employee(int c,String n,String p,String e){
		e_id=c;e_name=n;
		job=p;Salary=e;
	}
	public String getName(){return e_name;}
	public String getSalary(){return Salary;}
	public String getJob(){return job;}
	public int getEID(){return e_id;}
	public String toString(){
		return e_name+" : "+Salary;
	}
}