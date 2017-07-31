import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewDiary")  
public class ViewDiary extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        // request.getRequestDispatcher("SaveServlet").include(request, response);  
        out.println("<a href='indexD.html'>Add New Day</a>"); 
       
        out.println("<h1>Diary  List</h1>");  
          
        List<Diary> list=DiaryDao.getAllDiary();  
          
        out.print("<table border='1' width='100%'>");  
        out.print("<tr>");  
                 out.print("<th>Date</th>");
                 out.print("<th>Time</th>");
                  out.print("<th>Data</th>");
                
                     out.print("<th>Edit</th>");
                      out.print("<th>Delete</th>");
        out.print(" </tr>");
        for(Diary d:list){  
         out.print("<tr>");
                 out.print("<td>"+d.getDate()+"</td>"); 
                 out.print("<td>"+d.getTime()+"</td>");
                 out.print("<td>"+d.getData()+"</td>");
                
                 out.print("<td><a href='EditDiary?date="+d.getDate()+"'>edit</a></td>");
                 out.print("<td><a href='DeleteDiary?date="+d.getDate()+"'>delete</a></td>");
                 out.print("</tr>");
        }  
        out.print("</table>");
          
          
        out.close();  
    }  
}