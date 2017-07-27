import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Employee</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Emp e=EmpDao.getEmployeeById(id);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr>");  
        out.println("<td>Id:</td><td><input type='text' name='id' value='"+e.getId()+"'/></td>");
        out.println("</tr>");
        out.print("<tr>"); 
        out.println("<td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td>");
        out.println("</tr>");  
        out.print("<tr>");
        out.println("<td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+"'/></td>");
                out.println("</tr>");  
        out.print("<tr>");
        out.println("<td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td>");
        out.println("</tr>");  
        out.print("<tr>");
        out.println("<td>Country:</td>");
        out.println("<td>");  
        out.print("<select name='country' style='width:150px'>");  
        out.print("<option>India</option>");  
        out.print("<option>USA</option>");  
        out.print("<option>UK</option>");  
        out.print("<option>Other</option>");  
        out.print("</select>");  
        out.print("</td>");
        out.println("</tr>");  
        out.print("<tr>");
        out.println("<td colspan='2'><input type='submit' value='Edit & Save '/></td>");
        out.println("</tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
} 