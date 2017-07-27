import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditDairy")  
public class EditDairy extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Dairy</h1>");  
       // String time=request.getParameter("time");  
        
          
        Dairy d=DairyDao.getDairyByDate(request.getParameter("date"));  
          
        out.print("<form action='EditDairy2' method='post'>");  
        out.print("<table>");  
        out.print("<tr>");  
        out.println("<td>Date:</td><td><input type='text' name='date' value='"+d.getDate()+"'/></td>");
        out.println("</tr>");
        out.print("<tr>"); 
        out.println("<td>Time:</td><td><input type='text' name='time' value='"+d.getTime()+"'/></td>");
        out.println("</tr>");  
        out.print("<tr>");
        out.println("<td>Data:</td><td><input type='text' name='data' value='"+d.getData()+"'/></td>");
                out.println("</tr>");   
        out.print("<tr>");
        out.println("<td colspan='2'><input type='submit' value='Edit & Save '/></td>");
        out.println("</tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
} 