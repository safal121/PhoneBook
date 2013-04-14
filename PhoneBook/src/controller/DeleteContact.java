package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ConnectionFactory;
import model.DataAccess;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class DeleteContact
 */
@WebServlet("/DeleteContact")
public class DeleteContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int contact_id=Integer.parseInt(request.getParameter("contactid"));
        HttpSession session=request.getSession(true);
         ConnectionFactory connectionfactory=new ConnectionFactory();
           try {
            Connection con=(Connection) connectionfactory.getConnection();
            DataAccess dao=new DataAccess();
            String query="Delete from contact where contactid='"+contact_id+"'";
            dao.databaseDelete(con, query);
        

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/ViewContacts");
            rd.forward(request,response);
        }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
