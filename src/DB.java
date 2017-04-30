
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;


public class DB {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception 
	{
	//createTable();
	//post();
	
	}
	
	public static Connection getConnection() throws Exception{
		try{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/entrak";
			String username = "Nathan@localhost";
			String password = "4448";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return conn;
			
		}catch(Exception e){System.out.println(e);}
		
		
		return null;
	}

	public static void post(String query) throws Exception{
		try
		{
		Connection con = getConnection();
		PreparedStatement posted = con.prepareStatement(query);
		posted.executeUpdate();
		}catch(Exception e){System.out.println(e);}
	finally{
		System.out.println("Insert Completed.");
	}
	}
	
	public static ResultSet select(String query) throws Exception{
		try
		{
		Connection con = getConnection();
		PreparedStatement select = con.prepareStatement(query);
		ResultSet rs = select.executeQuery();
		return rs;
		}catch(Exception e){System.out.println("Unable to select: "+e);}
		finally{
			System.out.println("Selection Completed.");
		}
		return null;
	}
		
		
	

	public static void createTable() throws Exception{
		try{
			Connection conn = getConnection();
			PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS table1(id int NOT NULL AUTO_INCREMENT,first varchar(255),last varchar(255),PRIMARY KEY (id))");
			create.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		finally{System.out.println("Function complete.");}
	}
	
}
