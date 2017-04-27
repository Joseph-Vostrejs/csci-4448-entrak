
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception 
	{
	createTable();
	post();
	
	}
	
	public static Connection getConnection() throws Exception{
		try{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/OOTest";
			String username = "Nathan@localhost";
			String password = "4448";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return conn;
			
		}catch(Exception e){System.out.println(e);}
		
		
		return null;
	}

	public static void post() throws Exception{
		final String var1 = "John";
		final String var2 = "Miller";
		try
		{
		Connection con = getConnection();
		PreparedStatement posted = con.prepareStatement("INSERT INTO table1 (first,last) VALUES ('"+var1+"','"+var2+"')");
		posted.executeUpdate();
		}catch(Exception e){System.out.println(e);}
	finally{
		System.out.println("Insert Completed.");
	}
	
	
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
