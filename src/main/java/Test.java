import javax.servlet.*;
import java.io.*;

public class Test implements Servlet
{

ServletConfig config=null;

public void init(ServletConfig config){

this.config = config;

}

public void service(ServletRequest request,ServletResponse res)
throws IOException,ServletException
{
    res.setContentType("text/html") ;
    PrintWriter out=res.getWriter();
    out.print("<head><body>");
    out.print("<h1>hai</h1>");
    out.print("</body></head>");
}
public void destroy(){}
public ServletConfig getServletConfig(){
    return config;
}
public String getServletInfo(){
    return "copy rigth 2007";
}
}

