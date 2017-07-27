import java.io.IOException;  
    import java.io.PrintWriter;  
      
    import javax.servlet.ServletException;  
    import javax.servlet.annotation.WebServlet;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse; 
    import javax.servlet.http.*; 
    import java.util.*; 
    import java.io.*;  
import javax.servlet.*;  
    @WebServlet("/fruitservlet")  
    public class fruitservlet extends HttpServlet {  
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            //response.setContentType("text/html");  
            //PrintWriter out=response.getWriter();  
            List<Fruit> fruitList = new ArrayList<Fruit>();

Fruit appleFruit = new Fruit("Apple", 100.0);
Fruit orangeFruit = new Fruit("Orange",101.0);
Fruit mangoFruit = new Fruit("Mango",102.0);

fruitList.add(appleFruit);
fruitList.add(orangeFruit);
fruitList.add(mangoFruit);

 List<String> disneyCharacters = Arrays.asList("Micky", "Donald", "Minnie", "Aurora", "Winnie", "Pluto");
        request.setAttribute("disneyCharacters", disneyCharacters);


   /* List<Fruit> list=fruitList;  
          
        out.print("<table border='1' width='100%'>");  
        out.print("<tr>");  
                 out.print("<th>Name</th>");
                 out.print("<th>Price</th>");
            
        out.print(" </tr>");
        for(Fruit e:list){  
         out.print("<tr>");
                 out.print("<td>"+e.getName()+"</td>"); 
                 out.print("<td>"+e.getPrice()+"</td>");
                 out.print("</tr>");
        }  
        out.print("</table>");  
        out.close();*/
        request.setAttribute("fruitList", fruitList);
        request.setAttribute("disneyCharacters", disneyCharacters);
       //  request.setAttribute("Hello", Hello);

    //  request.getRequestDispatcher("indexfruit.jsp").include(request, response);
    //request.setAttribute("webURL", urls); 
RequestDispatcher rd = getServletContext().getRequestDispatcher("/indexF.jsp");  
rd.forward(request, response);

             }
    }
