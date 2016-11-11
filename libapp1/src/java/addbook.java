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


public class addbook extends HttpServlet {
    Connection con;

    
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

       out.println("hello world");
         try
           {
            
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:be1","","");
           }
           catch(Exception e)
           {
               System.out.println(e.getMessage());
          }


    try
           {
            Statement st = con.createStatement();
            String str1 = req.getParameter("bn");
            String str2 = req.getParameter("bc");
            String str3 = req.getParameter("aut");
            String str4 = req.getParameter("doa");
            String str5 = req.getParameter("pr");
            String str6 = req.getParameter("rn");
            String str7 = req.getParameter("nob");
            String str8 = req.getParameter("sc");

            //String str=str2+":"+str2+":"+str1+":"+str3+":"+str5+":"+str4+":"+str6+":"+str8;

            //out.println(str);

            
            int k = st.executeUpdate("insert into addbooks values('"+str2+"','"+str1+"','"+str3+"','"+str5+"','"+str4+"','"+str6+"','"+str8+"','"+str7+"')");
            //out.println("str8");
            if(k>0)
             out.println("books are added successfully");
            else
             out.println("books are not added");
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
