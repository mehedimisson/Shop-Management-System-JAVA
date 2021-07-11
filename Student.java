public class Student{
	private int status;
	private float cgpa;
	private String uname;
	private String dept;
	private String pass;
	public Student(String un, String p,int i){
		status=i;cgpa=(float)0.0;
		uname=un;pass=p;
	}
	public String getPassword(){
		return pass;
	}
	public String getUName(){
		return uname;
	}
	public int getStatus(){
		return status;
	}
	
	public void print(){
		System.out.print(uname+" is from "+dept);
		System.out.println(" with cgpa: "+cgpa);
	}
}