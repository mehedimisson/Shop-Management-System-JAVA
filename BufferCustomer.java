import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
public class BufferCustomer{
	public customer customerList[];
	public BufferCustomer(int s){
		customerList=new customer[s];
	}
	public void addcustomer(customer c){
		for(int i=0;i<customerList.length;i++){
			if(customerList[i]==null){
				customerList[i]=c;
				break;
			}
		}
	}

	public void loadcustomer(String sql){
		//System.out.println(sql);
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql);
			customer c=null;
			while(rs.next()){
				c=new customer(rs.getInt("cus_id"),rs.getString("cus_name"),rs.getString("cus_add"),rs.getString("phone"));
				addcustomer(c);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void showAllcustomer(JLabel l){
		printAllcustomer();
		String s="<html>";
		for(customer r:customerList){
			if(r!=null){
				s=s+r.getName()+":"+r.getPhone();
				s=s+","+r.getAdd()+"<br/>";
			}
		}
		s+="</html>";
		l.setText(s);
	}
	public void printAllcustomer(){
		for(customer c:customerList){
			if(c!=null){
				System.out.println(c);
			}
		}
	}
}