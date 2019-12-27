import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCCon {

	public static void main(String[] args) throws SQLException {

		try {
			//1.--> Register Class and load Drivers
			Class.forName("com.mysql.jdbc.Driver");
			//2.-->Establish the connection
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			//3.-->Create Statement Obj
			Statement stm =con.createStatement();
			//4.send & execute the Quries
			
			//CURD Operation   Create Update read Delete
			
			int rows;
			
			rows=stm.executeUpdate("insert into info values(4,'sanku',21)");  //insert /Create
			
			rows=stm.executeUpdate("update table info set name='balya' where id=3");  //update
			
			rows=stm.executeUpdate("delete from info where id=4");
			
			//5--> Process result from ResultSet
			
			ResultSet rs=stm.executeQuery("select * from info");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
			
			
			//6.-->close the connection
			con.close();
			
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Connection Failed");
			
			e.printStackTrace();
		}

	}

}

/*
   for create update and delete  --->  stm.executeUpdate()
   and fro select/read  --> stm.executeQuery()
   
   JDBC is a Specification defined by Java vendors & implemented by DB vendors

*/