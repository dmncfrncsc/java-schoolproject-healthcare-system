import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.Connection;



public class dbConnection {
	static Connection con;
	private static final dbConnection INSTANCE = new dbConnection();
	public static dbConnection getInstance() {
		return INSTANCE;
	}

	public static Connection getdbConnection() {
		try{
			if(con==null) {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare", "root", "hatdog");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
