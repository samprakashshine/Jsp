# My Dairy App
-----
## pojo class
-------

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
    
    -------
## Dao class

import java.util.*;  
import java.sql.*;  
  
public class DairyDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dairyday", "root", "");
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Dairy d){  
        int status=0;  
        try{  
            Connection con=DairyDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into day(date,time,data) values (?,?,?)"); 
           
            ps.setString(1,d.getDate());  
            ps.setString(2,d.getTime());  
            ps.setString(3,d.getData());  
         
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
        
    public static List<Dairy> getAllDairy(){  
        List<Dairy> list=new ArrayList<Dairy>();  
          
        try{  
            Connection con=DairyDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from day");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Dairy d=new Dairy();  
              
                d.setDate(rs.getString(1));  
                d.setTime(rs.getString(2));  
                d.setData(rs.getString(3));  
                list.add(d);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
public static int delete(String date){  
        int status=0;  
        try{  
            Connection con=DairyDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from day where date=?");  
            ps.setString(1,date);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    } 
     public static int update(Dairy d){  
        int status=0;  
        try{  
            Connection con=DairyDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update day set date=?,time=?,data=?");  
            ps.setString(1,d.getDate());  
            ps.setString(2,d.getTime());  
            ps.setString(3,d.getData());  

              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static Dairy getDairyByDate(String date){  
        Dairy d=new Dairy();  
          
        try{  
            Connection con=DairyDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from day where date=?");  
            ps.setString(1,date);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                d.setDate(rs.getString(1));  
                d.setTime(rs.getString(2));  
                d.setData(rs.getString(3));  
                 
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return d;  
    }  
}

-----------

## View class 

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
-------
## edit class 1

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
        String date=request.getParameter("date");  
        
          
        Dairy d=DairyDao.getDairyByDate(date);  
          
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
-------
## edit class2

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
        String date=request.getParameter("date");  
        
          
        Dairy d=DairyDao.getDairyByDate(date);  
          
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
-------
## save class

    import java.io.IOException;  
    import java.io.PrintWriter;  
      
    import javax.servlet.ServletException;  
    import javax.servlet.annotation.WebServlet;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
    @WebServlet("/SaveServlet")  
    public class SaveServlet extends HttpServlet {  
        protected void doPost(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
              int id=Integer.parseInt(request.getParameter("id")); 
            String name=request.getParameter("name");  
            String password=request.getParameter("password");  
            String email=request.getParameter("email");  
            String country=request.getParameter("country");  
              
            Emp e=new Emp();
            e.setId(id); 
            e.setName(name);  
            e.setPassword(password);  
            e.setEmail(email);  
            e.setCountry(country);  
              
            int status=EmpDao.save(e);  
            if(status>0){  
                out.print("<p>Record saved successfully!</p>");  
             request.getRequestDispatcher("index.html").include(request, response);
               // request.getRequestDispatcher("ViewServlet").include(request, response);  
            }else{  
                out.println("Sorry! unable to save record");  
            }  
              
            out.close();  
        }  
      
    }  
    -----------------
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
    -------------------------


