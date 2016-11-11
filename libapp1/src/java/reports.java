/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chetan
 */
public class reports extends HttpServlet {
   
     Connection con;
    Statement st;
     ResultSet rs;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

         try
           {

            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:be1","","");
           }
           catch(Exception e)
           {
             out.println(e.getMessage());
           }

         try
             {
              st=con.createStatement();
              rs = st.executeQuery("select book_name,name,Date_of_Issue,date_of_Return from issue a,addbooks b,member c where a.bookcode=b.bookcode and a.idno=c.idno");

              out.println("Currently existing issues are");
              //if(rs.next())
               out.println("<html><head></head><body bgcolor=seagreen><table border=2><tr><th>BNAME</th><th>MNAME</th><th>DATE OF ISSUE</th><th>DATE OF RETURN</th></tr>");
              while(rs.next())
              {
  out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");
              }
              out.println("</table></body></html>");
              st.close();
              rs.close();
             }
             catch(Exception ex)
             {
                 out.println(ex.getMessage());
             }

        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
