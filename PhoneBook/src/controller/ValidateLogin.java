package controller;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import model.DataAccess;
import model.ConnectionFactory;

/**
 * Servlet implementation class ValidateLogin
 */
@WebServlet("/ValidateLogin")
public class ValidateLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
        String password=request.getParameter("password");
        String remember_me=request.getParameter("remember-me"); 
       
        String temppass;
        List <String> pass=new ArrayList();
        DataAccess  dataaccess=new DataAccess();
        ResultSet  rs=null;  
        
          ConnectionFactory con=new ConnectionFactory();
         String query="Select password from userkey where username='"+username+"'";
         Connection c=null;
         try {
        	 c = con.getConnection();
        	 rs=dataaccess.databaseResult(c,query);
        	 
         } catch (SQLException ex) {
        	 ex.printStackTrace();
         }
         
         try {
        	 while(rs.next()){
        		 temppass=rs.getString("password");
        		 pass.add(temppass); 
     }
         } catch (SQLException ex) {
        	 ex.printStackTrace();
 }
    finally{
    		try {                rs.close();
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
	
         PrintWriter out=response.getWriter();  
         response.setContentType("text/html");
         
 
  if(pass.get(0).equals(password)){
	  HttpSession session=request.getSession(true);
	  session.setAttribute("username",username);
	  RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/ViewContacts");
	  dispatcher.forward(request,response);
  }
}
}