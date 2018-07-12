/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

/**
 *
 * @author sdelaot
 */
public class MiAplicacionJDBC {
    public static void consultar( String query, String [] campos,
        int [] tipos ) {
        ConsultorBD consultor = new ConsultorBD( 
            "/Users/sdelaot/Desktop/proyjava/caritas/", "", "" );
        System.out.println( consultor.getResultado( query, tipos));
        consultor.cierraBD();
    }
    public static void insertar( String tabla, String [] campos, 
        String [] valores, int [] tipos ) {
        InsertorBD insertor = new InsertorBD( 
            "/Users/sdelaot/Desktop/proyjava/caritas/", "", "" );
        
        if( insertor.insertarBD(tabla, campos, valores, tipos)==1 ) {
            System.out.println( "Insercion exitosa" );
            }
        else {
            System.out.println( "Insercion fallida" );
            }
    }
    public static void actualizar( String tabla, String [] campos, 
        String [] valores, String [] donde ) {
        ActualizadorBD actualizador = new ActualizadorBD( 
            "/Users/sdelaot/Desktop/proyjava/caritas/", "", "" );
        
        if( actualizador.actualizaBD( tabla, campos, valores, donde )==1 ) {
            System.out.println( "actualizacion exitosa" );
            }
        else {
            System.out.println( "actualizacion fallida" );
            }
    }
    public static void main( String [] args ) {
        String [] query = {
            "SELECT * FROM GENERO",
            "Select * from compania",
            "insert into genero ( id_genero, nombre_genero ) "+
                "values ( 21, Folklorica )"
            };
        String [][] campos = {
            { "ID_GENERO", "NOMBRE_GENERO" },
            { "id_compania", "nombre_compania" }
            };
        String tabla = "GENERO";
        int [][] tipos = {
            { 1, 3 },
            { 1, 3 }
            };
        String [][] valores = {
            { "21", "Folklorica" },
            { "22", "Banda" },
            { "23", "Duranguense" },
            { "24", "Reggaethon" },
            { "25", "Nortena" },
            { "26", "Barroca" },
            { "27", "Gotica" },
            { "28", "Huaracha" },
            { "29", "Tango" },
            { "30", "Samba" },
            { "31", "Electronica" },
            { "32", "High Energy"},
            { "33", "Troba"},
            { "34", "industrial" },
            { "38", "Dembow dominicano" }
            };
        String unQuery = "Insert GENERO values " + 
                "( 40, Folklorica ), ( 41, Folklorica ), ( 42, Folklorica ), " +
                "( 43, Folklorica ), ( 44, Folklorica ), ( 45, Folklorica );";
        String [] donde = {
            "ID_GENERO",
            "34"
            };
        String [][] nuevosCampos = {
            { "ID_GENERO", "NOMBRE_GENERO" }
            };
        String [][] nuevosValores =  {
            { "34", "Industrial" }
            };
        consultar( query[0], campos[0], tipos[0] );
        //insertar( tabla, campos[0], valores[14], tipos[0] );
        //actualizar( tabla, nuevosCampos[0], nuevosValores[0], donde );
        OperadorBD operador = new OperadorBD( "/Users/sdelaot/Desktop/proyjava/caritas/", "", "" );
        int tupla = operador.insertaActualizaBD(unQuery);
        System.out.println( tupla );
        consultar( query[0], campos[0], tipos[0] );
    }
}
