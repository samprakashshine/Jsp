import java.io.IOException;  
    import java.io.PrintWriter;  
      
    import javax.servlet.ServletException;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
    import javax.servlet.http.HttpSession; 
    import javax.servlet.annotation.WebServlet; 
    @WebServlet("/Logout")
    public class Logout extends HttpServlet {  
            protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                                    throws ServletException, IOException {  
                response.setContentType("text/html");  
                PrintWriter out=response.getWriter();  
                  
                request.getRequestDispatcher("Diary.html").include(request, response);  
                  
                HttpSession session=request.getSession();  
                session.invalidate();  
              
                out.print("<h3>You are successfully Signed out!</h3>");  
                  
                out.close();  
        }  
    }  