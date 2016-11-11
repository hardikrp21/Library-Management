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
public class returning extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     Connection con;
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        try
           {

            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:be1","","");
           }
           catch(Exception e){e.printStackTrace();}

   

    try
           {
            Statement st = con.createStatement();
            String st1 = req.getParameter("rin");
            String st2 = req.getParameter("bn");

            st1=st1.trim();
            st2=st2.trim();
            
           
            int j =st.executeUpdate("delete from issue where idno ='"+st1+"' and bookcode ='"+st2+"'");

            if(j>0)
             out.println("<html><body bgcolor = pink><h1>The issue is deleted</h1></body></html>");
            else
             out.println("<html><body bgcolor = pink><h1>The issue is not deleted</h1></body></html>");
           }
           catch(Exception ex)
           {
               out.println(ex.getMessage());
           }
          }
}
 