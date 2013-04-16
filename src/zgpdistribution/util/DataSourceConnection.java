/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zgpdistribution.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author John
 */
public class DataSourceConnection {

    public DataSourceConnection() {
    }
    
    public static Connection initDB() {        
	String url="jdbc:mysql://localhost:3306/zgpdistribution";
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,"root","root");
            ResultSet rs = null;
        }catch(ClassNotFoundException cnf) {
            System.err.println(cnf.getMessage());
        }catch(SQLException sqle) {
            System.err.println(sqle.getMessage());
        }catch(Exception exc) {
            System.err.println(exc.getMessage());
        }
        return connection;
    }
}
