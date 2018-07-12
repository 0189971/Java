/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sdelaot
 */
public class ProcesoPorLotesInsertor extends InsertorBD {

    public ProcesoPorLotesInsertor( String bd, String usu, String passwd ) {
        super( bd, usu, passwd );
    }
    public int [] procesarPorLote( String tabla, String [] campos, 
        String [][] valores, int [] tipos  ) {
        String query;
        int [] tuplas = null;
        try {
            Statement stmt = getConexion().createStatement();
            for( int n=0; n<valores.length; n++ ) {
                query = construirQuery(tabla, campos, valores[n], tipos);
                stmt.addBatch( query );
                }
            tuplas = stmt.executeBatch();
        } catch( SQLException sqle ) {
            sqle.printStackTrace();
        }
        return tuplas;
    }
}
