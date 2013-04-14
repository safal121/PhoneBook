package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

import model.ConnectionFactory;
import model.Contact;
import model.DataAccess;

/**
 * Servlet implementation class EditContact
 */
@WebServlet("/EditContact")
public class EditContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
       int contact_id=Integer.parseInt(request.getParameter("contactid"));
       PrintWriter out=response.getWriter();
        //out.println("<html><body>Bigyan</html></body>");
        ConnectionFactory connectionfactory=new ConnectionFactory();
          try {
           Connection con=(Connection) connectionfactory.getConnection();
           DataAccess dao=new DataAccess();
           String query="Select * from contact where contactid='"+contact_id+"'";
           ResultSet rs=dao.databaseResult(con, query);
           Contact contacts=new Contact();
           String first=null,last=null,contactno=null,email=null,address=null;;
           int contactid=0;
           while(rs.next()){
               first=rs.getString(2);
               last=rs.getString(3);
               contactno=rs.getString(4);
               email=rs.getString(5);
               address=rs.getString(6);
               contactid=rs.getInt(7);
           }
           Contact contact=new Contact(first,last,contactno,email,address,contactid);
          // out.println("<html><body>"+address+"</body></html>");
           request.setAttribute("editcontact",contact);
           RequestDispatcher requestdispatcher=request.getRequestDispatcher("/editcontact.jsp");
           requestdispatcher.forward(request,response);

       } catch (SQLException ex) {
          ex.printStackTrace();	
       }    
       }

	/**}
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
