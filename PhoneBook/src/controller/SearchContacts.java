package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ConnectionFactory;
import model.Contact;
import model.DataAccess;

/**
 * Servlet implementation class SearchContacts
 */
@WebServlet("/SearchContacts")
public class SearchContacts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchContacts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String search=(String)request.getParameter("search");
	        HttpSession session=request.getSession(true);
	        String user=(String) session.getAttribute("username");
	        ConnectionFactory connectionfactory=new ConnectionFactory();
	        List<String[]> personList=new ArrayList<String[]>();   
	        PrintWriter out=response.getWriter();
//	        response.setContentType("text/html");
//	        out.println("<html><body>Bigyan</body></html>"); 
	        //out.println("<html><body><p>"+search+user+"</p></body></html>");
	       
	       String first,last,contactno,email,address;
	       int contactid;
	        Contact contact;
	        List<Contact> contactList=new ArrayList<Contact>();
	        try {
	              
	            Connection con=connectionfactory.getConnection();
	            DataAccess dao=new DataAccess();
	            String query="Select * from contact where userid='"+user+"'"+"AND(firstname='"+search+"'"+"OR lastname='"+search+"'"+"OR address='"+search+"')";
	            
	            ResultSet rs=dao.databaseResult(con, query);
	            response.setContentType("text/html");
	            while(rs.next()){
	            	first=rs.getString(2).toString();
                    last=rs.getString(3).toString();
                    contactno=rs.getString(4).toString();
                    email=rs.getString(5).toString();
                    address=rs.getString(6).toString();
                    contactid=Integer.parseInt(rs.getString(7).toString());
                    contact=new Contact(first,last,contactno,email,address,contactid);
                    contactList.add(contact);
	            
	            }
	            
	            
	            	
	            	request.setAttribute("contacts",contactList);
		           RequestDispatcher requestdispatcher=request.getRequestDispatcher("/View.jsp");
		          requestdispatcher.forward(request,response);
	           } catch (SQLException ex) {
	            ex.printStackTrace();
	        }

	         finally {            
	            out.close();
	        }
	     
	     }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
