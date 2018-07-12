/*
 * Paquete al que pertenece la clase.
 */
package parsers;

/**
 * Esta clase contiene un parser recursivo descendente que no usa variables
 * 
 * @author sdelaot
 */
public class Parser {
    /**
     * Ningun delimitador
     */
    final int NINGUNO = 0;
    /**
     * Delimitador
     */
    final int DELIMITADOR = 1;
    /**
     * Delimitador variable
     */
    final int VARIABLE = 2;
    /**
     * Delimitador numerico
     */
    final int NUMERO = 3;
    /**
     * Error de sintaxis
     */
    final int SINTAXIS = 0;
    /**
     * Error de parentesis no balanceado
     */
    final int PARENTESIS_DESBALANCEADOS = 1;
    /**
     * Error de no hay expresion
     */
    final int SIN_EXPRESION = 2;
    /**
     * Error de division por cero
     */
    final int DIVISION_POR_CERO = 3;
    /**
     * Este token indice End-Of-Expression (Final de Expresion)
     */
    final String FDE = "\0";
    /**
     * Referencia a la expresion de tipo cadena
     */
    private String expresion; 
    /**
     * Indice actual en la expresion
     */
    private int expIndice; 
    /**
     * Retiene el token actual
     */
    private String token; 
    /**
     * Retiene el tipo de token
     */
    private int tipoDeToken; 
    /**
     * Punto de entrada al parser
     * 
     * @param expStr la expreseion a evaluar
     * 
     * @return devuelve el resultado del parser sobre la expresion
     * 
     * @throws ParserException lanza la excepcion
     */
    public double evaluar( String expStr ) throws ParserException {
        double resultado;
        expresion = expStr;
        expIndice = 0;
        getToken();
        if( token.equals( FDE ) ) {
            tomarError( SIN_EXPRESION ); // no hay expresion presente
            }
        // Parsea y evalua la expresion.
        resultado = evaluarExpresionDos();
        if( !token.equals( FDE ) ) { // ultimo token debe ser FDE
            tomarError( SINTAXIS );
            }
        return resultado;
    }
    /**
     * Suma o resta dos terminos
     * 
     * @return devuelve el resultado de la operacion
     * 
     * @throws ParserException lanza la excepcion
     */
    private double evaluarExpresionDos() throws ParserException {
        char op;
        double resultado;
        double resultadoParcial;
        resultado = evaluarExpresionTres();
        while( (op = token.charAt(0)) == '+' || op == '-' ) {
            getToken();
            resultadoParcial = evaluarExpresionTres();
            switch( op ) {
                case '-':
                    resultado = resultado - resultadoParcial;
                    break;
                case '+':
                    resultado = resultado + resultadoParcial;
                    break;
                }
            }
        return resultado;
    }
    /**
     * Multiplica o divide dos factores
     * 
     * @return devuelve el valor de la operacion
     * 
     * @throws ParserException lanza la exepcion
     */
    private double evaluarExpresionTres() throws ParserException {
        char op;
        double resultado;
        double resultadoParcial;
        resultado = evaluarExpresionCuatro();
        while( ( op=token.charAt( 0 ) ) == '*'
                || op == '/' || op == '%') {
            getToken();
            resultadoParcial = evaluarExpresionCuatro();
            switch( op ) {
                case '*':
                    resultado = resultado * resultadoParcial;
                    break;
                case '/':
                    if( resultadoParcial==0.0 ) {
                        tomarError( DIVISION_POR_CERO );
                        }
                    resultado = resultado / resultadoParcial;
                    break;
                case '%':
                    if( resultadoParcial==0.0 ) {
                        tomarError( DIVISION_POR_CERO );
                        }
                    resultado = resultado % resultadoParcial;
                    break;
                }
            }
        return resultado;
    }
    /**
     * Procesa un exponencial
     * 
     * @return devuelve el valor de la evaluacion exponencial
     * 
     * @throws ParserException lanza la excepcion
     */
    private double evaluarExpresionCuatro() throws ParserException {
        double resultado;
        double resultadoParcial;
        double ex;
        int t;
        resultado = evaluarExpresionCinco();

        if( token.equals( "^" ) ) {
            getToken();
            resultadoParcial = evaluarExpresionCuatro();
            ex = resultado;
            if (resultadoParcial == 0.0) {
                resultado = 1.0;
                } 
            else {
                for( t=(int)resultadoParcial-1; t>0; t-- ) {
                    resultado = resultado * ex;
                    }
                }
            }
        return resultado;
    }
    /**
     * Evalua un unario + o -
     * 
     * @return devuelve el valor del token con la aplicacion del unario
     * 
     * @throws ParserException lanza la excepcion
     */
    private double evaluarExpresionCinco() throws ParserException {
        double resultado;
        String op;
        op = "";
        if( ( tipoDeToken==DELIMITADOR )
                && token.equals( "+" ) || token.equals( "-" ) ) {
            op = token;
            getToken();
            }
        resultado = evaluarExpresionSeis();
        if( op.equals( "-" ) ) {
            resultado = -resultado;
            }
        return resultado;
    }
    /**
     * Procesa los parentesion de la expresion
     * 
     * @return devuelve el valor del siguiente token despues del parentesis
     * 
     * @throws ParserException lanza la excepcion de parentesis desbalanceados
     */
    private double evaluarExpresionSeis() throws ParserException {
        double resultado;
        if( token.equals( "(" ) ) {
            getToken();
            resultado = evaluarExpresionDos();
            if( !token.equals( ")" ) ) {
                tomarError( PARENTESIS_DESBALANCEADOS );
                }
            getToken();
            } 
        else {
            resultado = convertirAtomica();
            }
        return resultado;
    }
    /**
     * Toma el valor de un numero
     * 
     * @return devuelve el valor de la cadena numerica convertida
     * 
     * @throws ParserException 
     */
    private double convertirAtomica() throws ParserException {
        double resultado = 0.0;
        switch( tipoDeToken ) {
            case NUMERO:
                try {
                    resultado = Double.parseDouble( token );
                } catch (NumberFormatException exc) {
                    tomarError( SINTAXIS );
                }
                getToken();
                break;
            default:
                tomarError( SINTAXIS );
                break;
            }
        return resultado;
    }
    /**
     * Toma el error ocurrido durante el parseo
     * 
     * @param error el error ocurrido
     * 
     * @throws ParserException se lanza la excepcion 
     */
    private void tomarError(int error) throws ParserException {
        String[] err = {
            "Error de Sintaxis",
            "Parentesis no balanceados",
            "No hay expresion presente",
            "Division por cero"
            };
        throw new ParserException( err[error] );
    }
    /**
     * Obtiene el siguiente token
     */
    private void getToken() {
        tipoDeToken = NINGUNO;
        token = "";
        // Verifica el final de la expresion
        if( expIndice==expresion.length() ) {
            token = FDE;
            return;
            }
        // Salta cualquier espacio en blanco
        while( expIndice<expresion.length()
                && Character.isWhitespace( expresion.charAt( expIndice ) ) ) {
            ++expIndice;
            }
        // Trailing whitespace ends expression.
        if( expIndice==expresion.length()) {
            token = FDE;
            return;
            }
        // es operador
        if( esDelimitador( expresion.charAt( expIndice ) ) ) { 
            token += expresion.charAt( expIndice );
            expIndice++;
            tipoDeToken = DELIMITADOR;
            } 
        else // es variable
        if( Character.isLetter( expresion.charAt( expIndice ) ) ) { 
            while( !esDelimitador( expresion.charAt( expIndice ) ) ) {
                token += expresion.charAt( expIndice );
                expIndice++;
                if( expIndice>=expresion.length() ) {
                    break;
                    }
                }
            tipoDeToken = VARIABLE;
            } 
        else // es numero
        if( Character.isDigit( expresion.charAt( expIndice ) ) ) { 
            while( !esDelimitador( expresion.charAt( expIndice ) ) ) {
                token += expresion.charAt( expIndice );
                expIndice++;
                if( expIndice>=expresion.length() ) {
                    break;
                    }
                }
            tipoDeToken = NUMERO;
            } 
        else { // caracter desconocido termina la expresion
            token = FDE;
            return;
            }
    }
    /**
     * Pregunta si el caracter c es delimitador
     * 
     * @param c el caracter por el que se pregunta
     * 
     * @return devuelve true si c es delimitador y false en caso contrario
     */
    private boolean esDelimitador( char c ) {
        if( ( " +-/*%^=()".indexOf( c )!=-1 ) ) {
            return true;
            }
        return false;
    }
}
