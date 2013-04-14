package controller;

import model.*;
import java.sql.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccount() {
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
		 HttpSession session=request.getSession(true);
	        response.setContentType("text/html;charset=UTF-8");
	        String firstname=request.getParameter("firstname");
	        String lastname=request.getParameter("lastname");
	        String contactno=request.getParameter("contactno");
	        String email=request.getParameter("email");
	        String address=request.getParameter("address");
	        String id=(String) session.getAttribute("username");
	        Contact contact=new Contact(firstname,lastname,contactno,email,address,id);
	        ConnectionFactory connectionfactory=new ConnectionFactory(); 
	        boolean check=true;
	        //String operation="insert";
	        DataAccess dataaccess=new DataAccess(); 
	        try {
	                Connection c=connectionfactory.getConnection();
	                if(c==null)
	                    check=false;
	                dataaccess.databaseInsert(c, contact);
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	         RequestDispatcher rd=getServletContext().getRequestDispatcher("/ViewContacts");
	            rd.forward(request,response);
	}

}
