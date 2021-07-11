import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
public class BufferEmployee{
	public employee employeeList[];
	public BufferEmployee(int s){
		employeeList=new employee[s];
	}
	public void addemployee(employee c){
		for(int i=0;i<employeeList.length;i++){
			if(employeeList[i]==null){
				employeeList[i]=c;
				break;
			}
		}
	}

	public void loademployee(String sql){
		
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql);
			employee c=null;
			while(rs.next()){
				c=new employee(rs.getInt("e_id"),rs.getString("e_name"),rs.getString("job"),rs.getString("Salary"));
				addemployee(c);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void showAllemployee(JLabel l){
		printAllemployee();
		String s="<html>";
		for(employee r:employeeList){
			if(r!=null){
				s=s+r.getName()+":"+r.getSalary();
				s=s+","+r.getJob()+"<br/>";
			}
		}
		s+="</html>";
		l.setText(s);
	}
	public void printAllemployee(){
		for(employee c:employeeList){
			if(c!=null){
				System.out.println(c);
			}
		}
	}
}