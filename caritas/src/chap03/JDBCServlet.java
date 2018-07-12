package chap03;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import jdbc.OperadorBD;

public class JDBCServlet extends GenericServlet {
    protected Connection conn;
    private OperadorBD opera;

    @Override
    public void init() {
        try {
            // Make sure the JdbcOdbcDriver class is loaded
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            opera = new OperadorBD( 
                "/Users/sdelaot/Desktop/proyjava/caritas/", "", "" );

            // Try to connect to a database via ODBC
            //conn = DriverManager.getConnection( "jdbc:odbc:usingjsp" );
            conn = opera.getConexion();
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
        
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<BODY>");
        out.println("<PRE>");
        out.println( "The JDBC connection is:" );
        out.println( conn );
        out.println("</PRE>");
        out.println("</BODY>");
        out.println("</HTML>");
    }
}
