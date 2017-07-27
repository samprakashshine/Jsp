 import java.io.IOException;  
    import java.io.PrintWriter;  
      
    import javax.servlet.ServletException;  
    import javax.servlet.annotation.WebServlet;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
    @WebServlet("/SaveDairy")  
    public class SaveDairy extends HttpServlet {  
        protected void doPost(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
             
            String date=request.getParameter("date");  
        String time=request.getParameter("time");  
            String data=request.getParameter("data");  
            
              
           Dairy d=new Dairy();
            d.setDate(date); 
            d.setTime(time);  
            d.setData(data);  
           
              
            int status=DairyDao.save(d);  
            if(status>0){  
                out.print("<p>Record saved successfully!</p>");  
             request.getRequestDispatcher("indexD.html").include(request, response);
               // request.getRequestDispatcher("ViewServlet").include(request, response);  
            }else{  
                out.println("Sorry! unable to save record");  
            }  
              
            out.close();  
        }  
      
    }  