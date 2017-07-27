import java.io.*;
import javax.servlet.*;

public class Second implements Servlet{

     ServletConfig config=null;
    public void init(ServletConfig config)
    {
        this.config=config;
        System.out.println("servlet intia lized");
    }
public void service(ServletRequest req,ServletResponse res)
throws IOException,ServletException{

res.setContentType("text/html");

    PrintWriter out=res.getWriter();
    out.print("<head><body>");
    out.print("<h1>hai prakash ted</h1>");
    out.print("</body></head>");
}
public void destroy(){
    System.out.println("destroyed");
}
public ServletConfig getServletConfig(){
  return null;
}
public String getServletInfo(){
    return "hi";
}
    
} 
