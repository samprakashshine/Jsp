# My dairy app
-----------------
## pojo class

 public class Dairy {  
      
    private String date,time,data;
    
 
   
    public String getDate() {  
        return date;  
    }  
    public void setDate(String date) {  
        this.date = date;  
    }  
    public String getTime() {  
        return time;  
    }  
    public void setTime(String time) {  
        this.time = time;  
    }  
    public String getData() {  
        return data;  
    }  
    public void setData(String data) {  
        this.data = data;  
    }  
      
    }  
    --------------------
## view class

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewDairy")  
public class ViewDairy extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        // request.getRequestDispatcher("SaveServlet").include(request, response);  
        out.println("<a href='indexD.html'>Add New Day</a>");  
        out.println("<h1>Dairy  List</h1>");  
          
        List<Dairy> list=DairyDao.getAllDairy();  
          
        out.print("<table border='1' width='100%'>");  
        out.print("<tr>");  
                 out.print("<th>Date</th>");
                 out.print("<th>Time</th>");
                  out.print("<th>Data</th>");
                
                     out.print("<th>Edit</th>");
                      out.print("<th>Delete</th>");
        out.print(" </tr>");
        for(Dairy d:list){  
         out.print("<tr>");
                 out.print("<td>"+d.getDate()+"</td>"); 
                 out.print("<td>"+d.getTime()+"</td>");
                 out.print("<td>"+d.getData()+"</td>");
                
                 out.print("<td><a href='EditDairy?date="+d.getDate()+"'>edit</a></td>");
                 out.print("<td><a href='DeleteDairy?date="+d.getDate()+"'>delete</a></td>");
                 out.print("</tr>");
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}

------------------
## save class

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
    -----------------

## edit class1

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

-----------------
## edit class 2

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

-------------------

## delete class

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

----------------
## index page

<!DOCTYPE html>  
    <html>  
    <head>  
     
  
    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <title>my Dairy</title> 
    </head> 
    <link rel="shortcut icon" href="https://upload.wikimedia.org/wikipedia/commons/2/27/M_Icon.png" type="image"/>
<style>
.well{
text-align:center;
font-size: 20px;
color:White;
background-color: #42f4f4;
margin-bottom: 5px;
background-image: url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3-5m0NXIKVxLg0cLEPN2na0VxkRqyDXG02WMOvPQB6Jv-Urtp);
background-position: 0% 25%;
background-size:cover;
background-repeat: no-repeat;
}

.jumbotron{

background-color: #42f4f4;
margin-bottom: 0px;
background-image: url(http://www.readersdigest.ca/wp-content/uploads/2011/01/4-ways-cheer-up-depressed-cat.jpg);
background-position: 15% 25%;
background-size:cover;
background-repeat: no-repeat;
height: 700px;

}
.red{
color:#ff1000;
}
.green{
color:green;
}
label{
display:inline-block;
width:80%;
text-align: left;
}

</style> 
    <body>  
 <div class ="container-fluid">  
     <div class ="well"> My personal diary </div>   
     <div class ="jumbotron">
    <form action="SaveDairy" method="post">  
    <table>  
    
    <tr><td>Date:</td><td><input type="text" name="date"/></td></tr>  
    <tr><td>Time:</td><td><input type="text" name="time"/></td></tr>  
    <tr><td>Data:</td><td><input type="text"  name="data"/></td></tr>  
   
    <!--tr><td colspan="40"><input type="submit" value="Save Dairy"/></td></tr--> 
    <button type="submit" class="btn-success">Save Dairy
<span class=" glyphicon glyphicon-hand-left"></span>
</button><br/> 
    </table>  
    </form>  
      
    <br/>  
    <a href="ViewDairy">view Dairy</a>
    </div>  
    </div>  
    </body>  
    </html>  