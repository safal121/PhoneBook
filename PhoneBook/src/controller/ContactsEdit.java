/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 *
 * @author oscar-11
 */
@WebServlet(name = "ContactsEdit", urlPatterns = {"/ContactsEdit"})
public class ContactsEdit extends HttpServlet {

        String firstname;
        String lastname;
        String contactno;
        String email;
        String address;
        String userid;
        int contactid;
    
    
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        HttpSession session=request.getSession(true);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int rowsaffected=0;
        firstname=request.getParameter("firstname");
        lastname=request.getParameter("lastname");
        contactno=request.getParameter("contactno");
        email=request.getParameter("email");
        address=request.getParameter("address");
        userid=(String) session.getAttribute("username");
        contactid=Integer.parseInt(request.getParameter("contactid"));
        Contact contact=new Contact(firstname,lastname,contactno,email,address,userid,contactid);
        ConnectionFactory connectionfactory=new ConnectionFactory(); 
        boolean check=true;
       
        DataAccess dataaccess=new DataAccess(); 
        try {
                Connection c=connectionfactory.getConnection();
                if(c==null)
                    check=false;
               dataaccess.databaseUpdate(c, contact);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        
        
    
    RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/ViewContacts");
                  dispatcher.forward(request,response);
    
    }
    
             
  
   
}