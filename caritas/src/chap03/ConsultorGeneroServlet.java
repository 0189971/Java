/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chap03;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import jdbc.ConsultorBD;

/**
 *
 * @author sdelaot
 */
public class ConsultorGeneroServlet extends GenericServlet {
    protected Connection conn;
    private ConsultorBD consultor;

    @Override
    public void init() {
        try {
            // Make sure the JdbcOdbcDriver class is loaded
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            consultor = new ConsultorBD( 
                "/Users/sdelaot/Desktop/proyjava/caritas/", "", "" );

            // Try to connect to a database via ODBC
            //conn = DriverManager.getConnection( "jdbc:odbc:usingjsp" );
            conn = consultor.getConexion();
        } catch ( Exception exc ) {
            // If there's an error, use the servlet logging API
            getServletContext().log( "Error making JDBC connection: ", exc );
        }
    }

    @Override
    public void destroy() {
        try {
            // Only try to close the connection if it's non-null
            if( conn!=null ) {
                conn.close();
                }
        } catch ( SQLException exc ) {
            // If there's an error, use the servlet logging API
            getServletContext().log( "Error closing JDBC connection: ", exc );
        }
    }

    @Override
    public void service( ServletRequest request, ServletResponse response )
        throws java.io.IOException {
        response.setContentType("text/html");
        
        String query = "SELECT * FROM GENERO";
        int [] tipos = {
            1, 3
            };
        
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<BODY>");
        out.println("<PRE>");
        out.println( "El Catalogo de genero es:<br>" );
        out.println( consultor.getResultado( query, tipos ) );
        out.println("</PRE>");
        out.println("</BODY>");
        out.println("</HTML>");
    }
}
