import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        // request.getRequestDispatcher("SaveServlet").include(request, response);  
        out.println("<a href='index.html'>Add New Employee</a>");  
        out.println("<h1>Employees List</h1>");  
          
        List<Emp> list=EmpDao.getAllEmployees();  
          
        out.print("<table border='1' width='100%'>");  
        out.print("<tr>");  
                 out.print("<th>Id</th>");
                 out.print("<th>Name</th>");
                  out.print("<th>Password</th>");
                   out.print("<th>Email</th>");
                    out.print("<th>Country</th>");
                     out.print("<th>Edit</th>");
                      out.print("<th>Delete</th>");
        out.print(" </tr>");
        for(Emp e:list){  
         out.print("<tr>");
                 out.print("<td>"+e.getId()+"</td>"); 
                 out.print("<td>"+e.getName()+"</td>");
                 out.print("<td>"+e.getPassword()+"</td>");
                 out.print("<td>"+e.getEmail()+"</td>");
                 out.print( "<td>"+e.getCountry()+"</td>");
                 out.print("<td><a href='EditServlet?id="+e.getId()+"'>edit</a></td>");
                 out.print("<td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td>");
                 out.print("</tr>");
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}