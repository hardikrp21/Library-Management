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
public class addmember extends HttpServlet
{
   
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
              String s1 = req.getParameter("idno");
              String s2 = req.getParameter("mname");
              String s3 = req.getParameter("maddress");
              String s4 = req.getParameter("doi");
              String s5 = req.getParameter("doe");
              String s6 = req.getParameter("som");
              String s7 = req.getParameter("tom");
              String s8 = req.getParameter("amt");

              int i = st.executeUpdate("insert into member values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')");
              if(i>0)
               out.println("data is successfully added");
              else
               out.println("data is not added");
             }
              catch(Exception e)
              {
                  out.println(e.getMessage());
              }
           }





    } 




