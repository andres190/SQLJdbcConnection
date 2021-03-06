/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcconnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class JdbcConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
                Connection conn = null;
        
        String url = "jdbc:sqlserver://ADMINISTRATOR2;databaseName=8833test";
        Statement stmt = null;
        ResultSet result = null;
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String databaseUserName = "wservice";
        String databasePassword = "WebServices123";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, databaseUserName, databasePassword);
            stmt = conn.createStatement();
            result = null;
            String lon,lat;
            result = stmt.executeQuery("select * from tPosition_last ");

            while (result.next()) {
                lon=result.getString("lo");
                lat = result.getString("la");              
                System.out.println(lon+"  "+lat);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        
        }
    }
    
}
