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
            String carNO, machineNO, lon, lat, gpsTime, status,simNO, mileage, temperature ;
            int speed, direction ;
            
            
            
            result = stmt.executeQuery("select carNo, machineNO, lo, la, gpsTime, status, speed, mileage, direction, simNO, temperature  from tPosition_last, tCar where tPosition_last.carID = tCar.carID ");

            while (result.next()) {
                carNO=result.getString("carNO");
                machineNO=result.getString("machineNO");
                gpsTime=result.getString("gpsTime");
                status=result.getString("status");
                speed=result.getInt("speed");
                mileage=result.getString("mileage");
                lon=result.getString("lo");
                lat = result.getString("la");
                direction=result.getInt("direction");
                simNO=result.getString("simNO");
                temperature=result.getString("temperature");
                System.out.println(carNO+","+machineNO+","+gpsTime+","+status+","+speed+","+mileage+","+lon+","+lat+","+direction+","+simNO+","+temperature);
                
                
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        
        }
    }
    
}
