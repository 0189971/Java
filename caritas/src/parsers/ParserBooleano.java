/*
 * Paquete al que pertenece la clase.
 */
package parsers;

/**
 * Clase que evalua expresiones booleanas y devuelve su resultado
 * 
 * @author Saul De La O Torres
 * @version 1.0
 */
public class ParserBooleano {
    /**
     * Ningun delimitador
     */
    private final int NINGUNO = 0;
    /**
     * Delimitador
     */
    private final int DELIMITADOR = 1;
    /**
     * Delimitador variable
     */
    private final int VARIABLE = 2;
    /**
     * Delimitador numerico
     */
    private final int NUMERO = 3;
    /**
     * Error de sintaxis
     */
    private final int SINTAXIS = 0;
    /**
     * Error de parentesis no balanceado
     */
    private final int PARENTESIS_DESBALANCEADOS = 1;
    /**
     * Error de no hay expresion
     */
    private final int SIN_EXPRESION = 2;
    /**
     * Error de division por cero
     */
    private final int DIVISION_POR_CERO = 3;
    /**
     * Este token indice End-Of-Expression (Final de Expresion)
     */
    private final String FDE = "\0";
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
     * Crea el objeto de parseo
     */
    public ParserBooleano() {
        expresion = "";
        expIndice = 0;
        token = "";
        tipoDeToken = 0;
    }
    /**
     * Punto de entrada al parser
     * 
     * @param expStr la expreseion a evaluar
     * 
     * @return devuelve el resultado del parser sobre la expresion
     * 
     * @throws ParserException lanza la excepcion
     */
    public boolean evaluar( String expStr ) throws ParserException {
        boolean resultado;
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
    private boolean evaluarExpresionDos() throws ParserException {
        char op;
        boolean resultado;
        boolean resultadoParcial;
        resultado = evaluarExpresionTres();
        while( (op = token.charAt(0)) == '&' || op == '|' ) {
            getToken();
            resultadoParcial = evaluarExpresionTres();
            System.out.print( resultado + " " );
            switch( op ) {
                case '|':
                    resultado = resultado | resultadoParcial;
                    break;
                case '&':
                    resultado = resultado & resultadoParcial;
                    break;
                }
            System.out.println( op + " " + resultadoParcial + " = " + resultado );
            }
        return resultado;
    }
    /**
     * evalua una operacion de or exclusiva
     * 
     * @return devuelve el valor de la operacion
     * 
     * @throws ParserException lanza la exepcion
     */
    private boolean evaluarExpresionTres() throws ParserException {
        char op;
        boolean resultado;
        boolean resultadoParcial;
        resultado = evaluarExpresionCuatro();
        while( ( op=token.charAt( 0 ) ) == 'x' ) {
                //|| op == '/' || op == '%') {
            getToken();
            resultadoParcial = evaluarExpresionCuatro();
            System.out.print( resultado + " " );
            switch( op ) {
                case 'x':
                    resultado = 
                        calcularOrExclusivo( resultado, resultadoParcial );
                    break;
                    /*
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
                    */
                }
            System.out.println( op + " " + resultadoParcial + " = " + resultado );
            }
        return resultado;
    }
    /**
     * Procesa una negacion
     * 
     * @return devuelve el valor de la evaluacion exponencial
     * 
     * @throws ParserException lanza la excepcion
     */
    private boolean evaluarExpresionCuatro() throws ParserException {
        boolean resultado = false;;
        boolean resultadoParcial = false;;
        double ex;
        String op = "";
        //System.out.println( " TOKEN A" + token );
        if( ( tipoDeToken==DELIMITADOR )
                && token.equals( "!" ) ) {
            op = token;
            getToken();
            }
        resultadoParcial = evaluarExpresionCinco();
        boolean temporal = resultadoParcial;
        
        if( op.equals( "!" ) ) {
            System.out.print( " " + temporal );
            resultado = !resultadoParcial;
            System.out.println( " = " + op + "" + resultado );
            }
        /*
        String op = "";
        //System.out.println( " TOKEN : " + token + " TIPO : " + tipoDeToken );
        if( ( tipoDeToken==DELIMITADOR )
                && token.equals( "!" ) ) {
            op = token;
            System.out.println( " TOKEN : " + op );
            getToken();
            }
        getToken();
        //System.out.println( " TOKEN : " + token + " TIPO : " + tipoDeToken );
        resultadoParcial = evaluarExpresionCinco();
        if( op.equals( "!" ) ) {
            resultado = !resultadoParcial;
            }
        System.out.println( resultado + " = " + op + 
                    resultadoParcial );
        */
        return resultado;
    }
    /**
     * Evalua un unario + o -
     * 
     * @return devuelve el valor del token con la aplicacion del unario
     * 
     * @throws ParserException lanza la excepcion
     *//*
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
    private boolean evaluarExpresionCinco() throws ParserException {
        boolean resultado;
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
    private boolean convertirAtomica() throws ParserException {
        boolean resultado = false;
        int numero = (int)(Math.random()*10.0)+1;
        if( numero>=6 ) {
            resultado = true;
            }
        getToken();
        /*
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
        */
        return resultado;
    }
    /**
     * Evalua dos valores booleano con or exclusiva
     * 
     * @param valorUno el valor uno
     * @param valorDos el valor dos
     * 
     * @return devuelve el resultado de la operacion
     */
    public boolean calcularOrExclusivo( boolean valorUno, boolean valorDos ) {
        if( valorUno==valorDos ) {
            return false;
            }
        return true;
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
        //System.out.println( c );
        if( ( " &|x!=()".indexOf( c )!=-1 ) ) {
            return true;
            }
        return false;
    }
}
