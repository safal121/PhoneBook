package model;

import java.sql.*;
public class DataAccess {

	 public ResultSet databaseResult(Connection c,String query) throws SQLException{
	        Statement stmt=c.createStatement();
	        ResultSet rs=stmt.executeQuery(query);
	        return rs;
	    }

	 public void databaseDelete(Connection c,String query) throws SQLException{
		    Statement stmt=c.createStatement();
		        stmt.executeUpdate(query);
		}
		    public int databaseInsert(Connection c,Contact contact) throws SQLException{
		       int rowsaffected=0;
		        try{
		      
		           String query="INSERT INTO `contact`(`userid`, `firstname`, `lastname`, `contactnumber`, `email`, `address`) VALUES (?,?,?,?,?,?)";
		         PreparedStatement statement = c.prepareStatement(query); 
		        statement.setString(1, contact.get_userid());
		        statement.setString(2,contact.get_firstname());
		        statement.setString(3, contact.get_lastname());
		        statement.setString(4, contact.get_contactno());
		        statement.setString(5, contact.get_email());
		        statement.setString(6, contact.get_address());
		        statement.execute();
		       
		        }
		       catch(SQLException e){
		           e.printStackTrace();
		       }
		       finally{
		            c.close();
		        }
		        return rowsaffected;
		    }

		    public int databaseUpdate(Connection c,Contact contact) throws SQLException{
		        int a=0;
		         try{
		        
		          String query="UPDATE contact SET userid=?, firstname=?, lastname=?, contactnumber=?, email=?, address=? where contactid=?";
		          PreparedStatement statement = c.prepareStatement(query); 
		         statement.setString(1, contact.get_userid());
		         statement.setString(2, contact.get_firstname());
		         statement.setString(3, contact.get_lastname());
		         statement.setString(4, contact.get_contactno());
		         statement.setString(5, contact.get_email());
		         statement.setString(6, contact.get_address());
		         statement.setInt(7, contact.get_contactid());
		             a=statement.executeUpdate();
		        }
		        
		         
		        catch(SQLException e){
		            e.printStackTrace();
		           // rowsaffected=5;
		        }
		        finally{
		             c.close();
		         }
		         return a;
		     }
		    
		    
}
