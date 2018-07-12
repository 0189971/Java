/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenredes;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;

/**
 *
 * @author javis
 */
public class ConexionBD {
   
    Connection cn;
    Statement st;
    
    public Connection conexion(){
      try{ 
        Class.forName("com.mysql.jdbc.Driver");
        cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sopaletras","root","");
        System.out.println("Se hizo la conexion exitosa");
      }catch(Exception e){
          System.out.println(e.getMessage());
      }return cn;
    }    
    
    Statement createStatement(){
        throw new UnsupportedOperationException("No soportado");
    }

    
}
