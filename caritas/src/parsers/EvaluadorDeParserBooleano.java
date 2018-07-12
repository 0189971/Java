/*
 * Paquete al que pertenece la clase.
 */
package parsers;

/**
 *
 * @author sdelaot
 */
public class EvaluadorDeParserBooleano {
    public static void main( String [] args ) throws ParserException {
        String expresion = "(a x b) & c | !e";
        ParserBooleano unParser = new ParserBooleano();
        System.out.println( unParser.evaluar( expresion ) );
    }
}
