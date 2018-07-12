/*
 * Paquete al que pertenece la clase.
 */
package com.sqlmagic.tinysql;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

class Conecta {
    public void cargaDriver() {
        try {
            /*
             * Register the JDBC driver for dBase
             */
            Class.forName( "com.sqlmagic.tinysql.dbfFileDriver" );
        } catch ( ClassNotFoundException e ) {
            //System.err.println( "JDBC Driver could not be registered!!\n" );
            String deDonde = "tinySQLcmd.main() :\n";
            System.out.println( deDonde + " " + e.getMessage() );
            System.err.println( "JDBC El Driver no ha sido registrado!!\n" );
            if ( tinySQLGlobals.DEBUG ) {
                e.printStackTrace();
                }
        }
    }
    public Connection getConexion() throws SQLException {
        File conPath = new File( "." );
        String tinySQLDir = conPath.getAbsolutePath();
        //System.out.println( " HOLA: " + tinySQLDir );
        //String baseAlarma = tinySQLDir + "/alarma.DBF";
        //System.out.println( " BASE: " + baseAlarma );
        Connection con;
        System.out.println( "Connecting to " + tinySQLDir );
        con = DriverManager.getConnection( 
                "jdbc:dbfFile:" + tinySQLDir, "", "" );
        return con;
    }
}

class OperacionDeBD {
    private Conecta conector;
    public OperacionDeBD() {
        conector = new Conecta();
    }
    public Conecta getConector() {
        return conector;
    }
}

class SelectorDeTuplas extends OperacionDeBD {
    private LinkedList<Alarma> listaAlarma;
    private LinkedList<Evento> listaEvento;
    public SelectorDeTuplas() {
        super();
        listaAlarma = new LinkedList<Alarma>();
        listaEvento = new LinkedList<Evento>();
    }
    
}

class Alarma {
    /**
     * Identificador de la alarma numero que se incrementa
     */
    private int idAlarma;
    /**
     * Si esta o no reconocida<br>
     * N: Se pone imagen de llamas<br>
     * S se pone imagen de signo de admiracion !<br>
     */
    private String reconocida;
    /**
     * La hora a la que ocurrio la alarma (descripcion):<br>
     * diaSemana + " " + diaMes + " " + mes + " " + anio + ", " + hh:mm:ss<br>
     * diaSemana: Lun, Mar, Mir, Jue, Vie, Sab, Dom<br>
     * diaMes: 1-31 segun sea el caso de cada mes<br>
     * mes: Ene, Feb, Mar, Abr, May, Jun, Jul, Ago, Sep, Oct, Nov, Dic<br>
     * anio: yyyy<br>
     */
    private String hora;
    /**
     * Donde ocurrio la alarma en estacion<br>
     * PAN, PUE, VEL, CDEP, MIU, JAM, CHB, LCAR, CMED, CHI, PAT, TCB<br>
     */
    private String localizacion;
    /**
     * Descripcion de la alarma ocurrida
     */
    private String descripcion;
    /**
     * Crea una alarma por defecto
     */
    public Alarma() {
        this( 0, "", "", "", "" );
    }
    /**
     * Crea una alarma con toda su informacion
     * 
     * @param id identificador de la alarma
     * @param recon reconocimiento de la alarma
     * @param hr hora en que ocurrio la alarma
     * @param loc localizacion de la alarma
     * @param desc descripcion de la alarma
     */
    public Alarma( int id, String recon, String hr, String loc, String desc ) {
        idAlarma     = id;
        reconocida   = recon;
        hora         = hr;
        localizacion = loc;
        descripcion  = desc;
    }
    public Alarma( Alarma unaAlarma ) {
        idAlarma     = unaAlarma.idAlarma;
        reconocida   = unaAlarma.reconocida;
        hora         = unaAlarma.hora;
        localizacion = unaAlarma.localizacion;
        descripcion  = unaAlarma.descripcion;
    }
    /**
     * Crea una alarma con toda su informacion
     * 
     * @param id identificador de la alarma
     * @param recon reconocimiento de la alarma
     * @param hr hora en que ocurrio la alarma
     * @param loc localizacion de la alarma
     * @param desc descripcion de la alarma
     */
    public void setAlarma( int id, String recon, String hr, String loc, 
        String desc ) {
        idAlarma     = id;
        reconocida   = recon;
        hora         = hr;
        localizacion = loc;
        descripcion  = desc;
    }
    /**
     * devuelve la alarma convertida en arreglo
     * 
     * @return devuelve un arreglo de cadenas
     */
    public String [] getAlarmaArreglo() {
        String [] laAlarma = {
            "" + idAlarma,
            reconocida,
            hora,
            localizacion,
            descripcion
            };
        return laAlarma;
    }
    /**
     * Devuelve la alarma convertida a String
     * 
     * @return devuelve la alarma
     */
    public String getAlarmaString() {
        StringBuilder builder = new StringBuilder();
        builder.append( "").append( idAlarma );
        builder.append(";").append( reconocida );
        builder.append(";").append( hora );
        builder.append(";").append( localizacion );
        builder.append(";").append( descripcion );
        return builder.toString();
    }
}

class Evento {}
/**
 *
 * @author sdelaot
 */
public class PininosTinySQL {
    public static void main( String [] args ) throws SQLException {
        Conecta tiny = new Conecta();
        tiny.cargaDriver();
        Connection con = tiny.getConexion();
        if( con!=null ) {
            String query = "select * from equipo";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while( rs.next() ) {
                System.out.print( "\t" + rs.getInt( 1 ) );
                System.out.println( "\t" + rs.getString( 2 ) );
                //System.out.println( "\t" + rs.getString( 3 ) );
                //System.out.print( "\t" + rs.getString( 4 ) );
                //System.out.println( "\t" + rs.getString( 5 ) );
                }
            }
    }
}
