package chap03;

import java.io.*;
import javax.servlet.*;

public class HelloWorldServlet extends GenericServlet {
    @Override
    public void service( ServletRequest request,
        ServletResponse response ) throws IOException {
        // Tell the web server that the response is HTML
        response.setContentType("text/html");        

        // Get the PrintWriter for writing out the response
        PrintWriter out = response.getWriter();

        // Write the HTML back to the browser
        out.println("<HTML>");
        out.println("<BODY>");
        out.println("<H1>Hello World!</H1>");
        out.println("</BODY>");
        out.println("</HTML>");
    }
}
