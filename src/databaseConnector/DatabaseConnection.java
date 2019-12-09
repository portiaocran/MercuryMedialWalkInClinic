//This class is used to connect to the database

package databaseConnector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private String url;
	private String username;
	private String password;
	
	public DatabaseConnection(String driver, String url, String username, String password) {

			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
			
			this.url = url;
			this.username = username;
			this.password = password;
	
	}
	
	@SuppressWarnings("finally")
	public Connection getConnection() {
		Connection conn= null;
		
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			return conn;
		}
			
	}

}
