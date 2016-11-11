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
public class lending extends HttpServlet {
   
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
           catch(Exception e)
           {
             out.println(e.getMessage());
           }

        try
           {
            Statement st = con.createStatement();
            String st1 = req.getParameter("lin");
            
            String st2 = req.getParameter("ldoi");
            String st3 = req.getParameter("ldoe");
            String st4 = req.getParameter("mno");

            st1=st1.trim();
            st2=st2.trim();
            st3=st3.trim();
            st4=st4.trim();

            int j =st.executeUpdate("insert into issue values('"+st1+"','"+st2+"','"+st3+"','"+st4+"')");

            if(j>0)
             out.println("<html><body bgcolor = pink><h1>The data is added successfully</h1></body></html>");
            else
             out.println("<html><body bgcolor = pink><h1>The data is not added</h1></body></html>");
           }
           catch(Exception e)
           {
               out.println("same copy of book can not be issued to same meber");
           }
          }

        
    }

    

