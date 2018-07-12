/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miweb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sdelaot
 */
public class HolaMundoServlet extends HttpServlet {

    @Override
    public void service( HttpServletRequest req, HttpServletResponse resp ) 
        throws ServletException, IOException {
        super.service( req, resp );
        PrintWriter out = resp.getWriter();
        out.print( "<html>" );
        out.print( "<head><title>Hola mundo servlet</title></head>" );
        out.print( "<body>" );
        out.print( "Hola mundo servlet en Java" );
        out.print( "</body>" );
        out.print( "</html>" );
        out.close();
    }
}
