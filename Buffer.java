import java.sql.ResultSet;
import java.sql.SQLException;
public class Buffer{
	private Student studentList[];
	
	public Buffer(int size){
		studentList=new Student[size];
	}
	public void loadStudents(String sql)throws SQLException{
		DataAccess da=new DataAccess();
		ResultSet rs=da.getData(sql);
		Student s=null;
		int status;float cgpa;
		String uname,pass;
		while(rs.next()){
			//id=rs.getInt("sid");
			uname=rs.getString("log_id");
			pass=rs.getString("password");
			status=rs.getInt("status");
			//System.out.println(id+cgpa+name+dept);
			s=new Student(uname,pass,status);
			addStudent(s);
		}
	}
	public boolean checkStudentAuth(String un,String pass){
		boolean flag=false;
		for(Student s:studentList){
			if(s!=null){
				if(s.getUName().equals(un) && s.getPassword().equals(pass)){
					flag=true;
				}
			}
		}
		return flag;
	}
		public int checkStatus(String un,String pass){
		int fg=0;
		for(Student s:studentList){
			if(s!=null){
				if(s.getUName().equals(un) && s.getPassword().equals(pass)){
					fg=s.getStatus();
				}
			}
		}
		return fg;
	}
	public void addStudent(Student s){
		for(int i=0;i<studentList.length;i++){
			if(studentList[i]==null){
				studentList[i]=s;break;
			}
		}
	}
	public void printAllStudents(){
		for(Student s:studentList){
			if(s!=null){
				s.print();
			}
		}
	}
}