import java.io.IOException;  
    import java.io.PrintWriter;  
      
    import javax.servlet.ServletException;  
    import javax.servlet.annotation.WebServlet;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
    @WebServlet("/EditDairy2")  
    public class EditDairy2 extends HttpServlet {  
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
           
              
            int status=DairyDao.update(d);  
            out.println(status);
            if(status>0){  
                response.sendRedirect("ViewDairy");  
            }else{  
                out.println("Sorry! unable to update Dairy");  
            }  
              
            out.close();  
        }  
      
    }  

