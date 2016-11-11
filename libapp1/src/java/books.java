


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class books extends HttpServlet {
   
 
    Connection con;
    Statement st;
     ResultSet rs;

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
              st=con.createStatement();
              rs = st.executeQuery("select * from addbooks");

              out.println("Currently existing books are");
              //if(rs.next())
               out.println("<html><head></head><body bgcolor=seagreen><table border=2><tr><th>BNAME</th><th>BCODE</th><th>AUTHOR</th><th>DATEOFARR</th><th>PRICE</th><th>RACKNO</th><th>NOOFBOOKS</th><th>SUBJCODE</th></tr>");
              while(rs.next())
              {
               out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td></tr>");
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






    } 

    


