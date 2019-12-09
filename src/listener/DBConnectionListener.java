//This listener is used to create database connection object and carry it forward throughout application

package listener;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import databaseConnector.DatabaseConnection;

@WebListener
public class DBConnectionListener implements ServletContextListener, ServletContextAttributeListener {
	Connection con;
	
	
    public DBConnectionListener() {
    }


    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    }

    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
        
    	ServletContext dbConn = sce.getServletContext();
         
        Connection conn = (Connection)dbConn.getAttribute("conn");
         
         try {
         conn.close();
         } catch(SQLException e) {
        	 e.printStackTrace();
         }
         
         
    	
    }

    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    }

    public void contextInitialized(ServletContextEvent sce)  {
    	
    	//This variable will provide a conenction to the databae throughout the WHOLE application. It will only be
    	//and doesn't require a new connection every time a new page is openeed
         DatabaseConnection dbconn = new DatabaseConnection ("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/mercury", "root", "Aitrop31");
         
         con = dbconn.getConnection();
         
         ServletContext dbConn = sce.getServletContext();
         
         dbConn.setAttribute("conn", con);
            
    }
	
}
