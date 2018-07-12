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
import jdbc.InsertorBD;

/**
 *
 * @author sdelaot
 */
public class InsertorGeneroServlet extends GenericServlet {
    protected Connection conn;
    private InsertorBD insertor;

    @Override
    public void init() {
        try {
            // Make sure the JdbcOdbcDriver class is loaded
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            insertor = new InsertorBD( 
                "/Users/sdelaot/Desktop/proyjava/caritas/", "", "" );

            // Try to connect to a database via ODBC
            //conn = DriverManager.getConnection( "jdbc:odbc:usingjsp" );
            conn = insertor.getConexion();
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
        String idGenero = request.getParameter( "idgenero" );
        String genero = request.getParameter( "nombregenero" );
        String tabla = "GENERO";
        String [] campos = {
            "ID_GENERO", "NOMBRE_GENERO"
            };
        String [] valores = {
            idGenero, genero
            };
        int [] tipos = {
            1, 3
            };
        
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<BODY>");
        out.println("<PRE>");
        
        int tuplas = insertor.insertarBD( tabla, campos, valores, tipos );
        if( tuplas==0 ) {
            out.println( tuplas + " Insercion exitosa en " + tabla + 
                " " + idGenero + " " + genero );
            }
        else {
            out.println( tuplas + " Insercion fallida en " + tabla  + 
                " " + idGenero + " " + genero );
            }
        out.println("</PRE>");
        out.println("</BODY>");
        out.println("</HTML>");
    }
}
