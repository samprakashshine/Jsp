import java.io.IOException;  
    import javax.servlet.ServletException;  
    import javax.servlet.annotation.WebServlet;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
    @WebServlet("/DeleteDairy")  
    public class DeleteDairy extends HttpServlet {  
        protected void doGet(HttpServletRequest request, HttpServletResponse response)   
                 throws ServletException, IOException {  
            String date=request.getParameter("date");  
           
            DairyDao.delete(date);  
            response.sendRedirect("ViewDairy");  
        }  
    }  