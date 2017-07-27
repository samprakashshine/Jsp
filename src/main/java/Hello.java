import java.io.*;
import java.util.Arrays;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

// Extßend HttpServlet class
@WebServlet("/Hello")
public class Hello extends HttpServlet {

public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

List<String> disneyCharacters = Arrays.asList("Micky", "Donald", "Minnie", "Aurora", "Winnie", "Pluto");
request.setAttribute("disneyCharacters", disneyCharacters);
PrintWriter out = response.getWriter();
out.println(disneyCharacters);
// RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
// rd.forward(request, response);

}

// Method to handle POST method request.
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

doGet(request, response);
}
}