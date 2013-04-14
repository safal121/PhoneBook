package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionFactory {
    
        Statement stmt=null;
       // Connection con=null;
        final String USERNAME="root";
        final String PASSWORD="";
        String url="jdbc:mysql://localhost:3306/";
        String dbName="login";
     //   String password=null;
        String driverClassName="com.mysql.jdbc.Driver";
        
        private static ConnectionFactory connectionFactory = null;
        
        
        public ConnectionFactory(){
        try{
            Class.forName(driverClassName);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() throws SQLException{
         Connection con=null;
         con=DriverManager.getConnection(url+dbName,USERNAME,PASSWORD);
        // con.close();
         return con;
    }
    

   
    
}