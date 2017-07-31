 import java.io.IOException;  
    import java.io.PrintWriter;  
      import java.io.IOException; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.*;
import java.net.Authenticator;
import java.util.*; 
import java.util.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
    import javax.servlet.ServletException;  
    import javax.servlet.annotation.WebServlet;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
    @WebServlet("/SaveDiary")  
    public class SaveDiary extends HttpServlet {  
        protected void doPost(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
             
            String date=request.getParameter("date");  
        String time=request.getParameter("time");  
            String data=request.getParameter("data");  
            
              
           Diary d=new Diary();
            d.setDate(date); 
            d.setTime(time);  
            d.setData(data);  
           
              
            int status=DiaryDao.save(d);  
            if(status>0){  
                out.print("<p>Record saved successfully!</p>");  
             request.getRequestDispatcher("indexD.html").include(request, response);
               // request.getRequestDispatcher("ViewServlet").include(request, response);  
            }else{  
                out.println("Sorry! unable to save record");  
            }  
              
            out.close();  
   

         response.setContentType("text/html;charset=UTF-8");
              
        String toMail = "prakash.s@kggroup.com";
        String filename=request.getParameter("filename");
  
        try {
           SaveDiary javaEmail = new SaveDiary();
         final String username = "prakash.s@kggroup.com";
final String password = "prakash@mail";
Properties props = new Properties();
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable", "false");
props.put("mail.smtp.host", "webmail.kggroup.com");
props.put("mail.smtp.port", "25");
Session session = Session.getInstance(props,
new javax.mail.Authenticator() {
protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(username, password);
}
});
try {
Message message = new MimeMessage(session);
message.setFrom(new InternetAddress("prakash.s@kggroup.com"));
message.setRecipients(Message.RecipientType.TO,
InternetAddress.parse(toMail));

message.setSubject("Diary registration successful");
message.setText("Details .............");

message.setContent(" <h3>Date:"+date+"<br>Time :"+time+"<br>Data:"+data,"text/html");
Transport.send(message);

System.out.println("Done");
}
catch (MessagingException e) 
{
throw new RuntimeException(e);
}
out.println("Process Completed\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.println("event registered successfully");
         }
      
      
    }
    