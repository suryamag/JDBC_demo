package jdbcConcepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test2 {
	
	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/mydatabase";
		String pas = "Alluser@123";
		String userName= "root";
		String query = " select * from student;";
		
		Connection con = DriverManager.getConnection(url, userName, pas);
		
		Statement stm = con.createStatement();
		
		ResultSet rs = stm.executeQuery(query);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) +"/ "+rs.getInt(2) +"/ "+rs.getInt(3) +"/ "+rs.getString(4));
		}
	}

}
