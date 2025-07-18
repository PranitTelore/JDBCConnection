import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PractiseAgain {

	public static void main(String[] args) throws Exception {
		// 1. Import the Pkgs
		// 2. Load the Class 
		// 3. Register the Driver
		// 4 Create statmenet obj
		// 5. Send and execute the Query
		// 6. Get Result using resultset
		// 7. Close the Connection
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from emp");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDate(5));
		}
		
		con.close();

	}

}
