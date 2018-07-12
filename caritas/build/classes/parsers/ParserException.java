/*
 * Paquete al que pertenece la clase.
 */
package parsers;

/**
 * Excepcion que muestra los errores ocurridos en el parser
 * 
 * @author Saul De La O Torres
 * @version 1.0
 */
public class ParserException extends Exception {
    /**
     * Descripcion de la excepcion
     */
    String errStr; 
    /**
     * Construye la excepcion
     * 
     * @param mensaje el mensaje de la excepcion 
     */
    public ParserException( String mensaje ) {
        errStr = mensaje;
    }
    /**
     * Devuelve el estado de la excepcion
     * 
     * @return devuelve el mensaje de excepcion
     */
    @Override
    public String toString() {
        return errStr;
    }
}
