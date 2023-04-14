//https://www.baeldung.com/spring-data-jpa-multiple-databases#3-configuring-a-datasource

package com.geektext.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseUtility {
    private static Connection connection = null;
    
    public static Connection getConnection() throws SQLException{
        if(connection != null){//If the connection exists return the connection
            return connection;
        }else{//Provides a connection if connection IS null
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/geek_text?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String user = "root";
            String password = "Group21";
            
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url,user,password);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            
            
            
        }
        return connection;
    }
}
