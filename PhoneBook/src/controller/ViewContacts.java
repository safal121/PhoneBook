package controller;

import java.util.List;
import java.util.ArrayList;
import model.ConnectionFactory;
import model.DataAccess;
import model.Contact;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewContacts
 */
@WebServlet("/ViewContacts")
public class ViewContacts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewContacts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			HttpSession session=request.getSession(true);
			String first,middle,last,contactno,email,address;
			int contactid;
			String user=(String)session.getAttribute("username");
			PrintWriter out=response.getWriter();  
	         response.setContentType("text/html");
	         //out.println("<html><body>"+user+"</body></html>");
			List<Contact>contactList=new ArrayList<Contact>();
			ConnectionFactory connectionfactory=new ConnectionFactory();
			try {
	            Connection con=connectionfactory.getConnection();
	            DataAccess dao=new DataAccess();
	            String query="Select * from contact where userid='"+user+"'";
	            ResultSet rs=dao.databaseResult(con, query);
	            while(rs.next()){
	              //  String [] information=new String[7];
	               // for(int i=1;i<=7;i++){
	                    first=rs.getString(2).toString();
	                    last=rs.getString(3).toString();
	                    contactno=rs.getString(4).toString();
	                    email=rs.getString(5).toString();
	                    address=rs.getString(6).toString();
	                    contactid=Integer.parseInt(rs.getString(7).toString());
	                    Contact contact=new Contact(first,last,contactno,email,address,contactid);
	                    contactList.add(contact);
	               //out .println("<html><body>"+first+last+contactno+email+address+contactid+"</body></html>");
	                    //}
	                
	            
	            }

	            
	           request.setAttribute("contacts",contactList);
	           RequestDispatcher requestdispatcher=request.getRequestDispatcher("/View.jsp");
	           requestdispatcher.forward(request,response);

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	     //   }
	    }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		// TODO Auto-generated method stub
	}

}
