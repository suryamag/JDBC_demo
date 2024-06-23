package jdbcConcepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest1 {
	
	public static void main(String[] args) throws SQLException {
		
//		readData();
//		insertData();
//		insertByVar();
//		insertByPrepared();
		deleteMethod();
	

}


	private static void readData() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/mydatabase";
		String userName = "root";
		String password = "Alluser@123";
		String query = "select * from employee ";
			
			Connection con=DriverManager.getConnection(url,userName,password);
			
			Statement stmt=con.createStatement();  
			
			ResultSet rs=stmt.executeQuery(query);  
			
			while(rs.next()) {
			System.out.println(rs.getInt(1) +"/ "+ rs.getInt(2)+"/ "+ rs.getString(3)+"/ "+ rs.getString(4)+"/ "+ rs.getString(5));  
			}
			con.close();  
		
	}

	private static void insertData() throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/mydatabase";
		String userName = "root";
		String password = "Alluser@123";
		String query = "insert into student values (25,353,735832113,'kutty')";
			
			Connection con=DriverManager.getConnection(url,userName,password);
			
			Statement stmt=con.createStatement();  
			
			int rs=stmt.executeUpdate(query);  
			
			System.out.println(rs);
			
		
			con.close();  
		
	}
	
	private static void insertByVar() throws SQLException {
		
		
		String url = "jdbc:mysql://localhost:3306/mydatabase";
		String userName = "root";
		String password = "Alluser@123";
		int age = 25;
		int id = 354;
		int mob = 701077;
		String name = "panni";
		String query = "insert into student values ("+age+","+id+","+mob+",'"+name+"')";
			
			Connection con=DriverManager.getConnection(url,userName,password);
			
			Statement stmt=con.createStatement();  
			
			int rs=stmt.executeUpdate(query);  
			
			System.out.println("insert into student values ("+age+","+id+","+mob+",'"+name+"')");
			
			System.out.println(rs);
			
		
			con.close(); 
		
	}
	
	

	private static void insertByPrepared() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/mydatabase";
		String userName = "root";
		String password = "Alluser@123";
		int age = 26;
		int id = 355;
		int mob = 2105161;
		String name = "maraan";
		String query = "insert into student values(?,?,?,?) ";
			
			Connection con=DriverManager.getConnection(url,userName,password);
			
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1, age);
			pst.setInt(2, id);
			pst.setInt(3, mob);
			pst.setString(4, name);
			
			int row = pst.executeUpdate();
			System.out.println(pst);
			System.out.println(row);
			
		
			con.close(); 
		
	}
	
	public static void deleteMethod() throws SQLException {

		
		String url = "jdbc:mysql://localhost:3306/mydatabase";
		String userName = "root";
		String password = "Alluser@123";
		
		int id = 355;
		
		String query = "delete from student where id ="+id; 
			
			Connection con=DriverManager.getConnection(url,userName,password);
			
			Statement stmt=con.createStatement();  
			
			int rs=stmt.executeUpdate(query);  
			
			System.out.println(rs);
			
		
			con.close(); 
		
	
		
	}
	
}
