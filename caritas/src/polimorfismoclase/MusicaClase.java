package polimorfismoclase;


public class MusicaClase {
	public static void afina( Instrumento i, int sel ) {
		if( sel==1 ) { 
            i.ajustar();
            }
        else { 
            i.tocar( NotaMusical.Do );
            }
	}
	public static void afinaTodos( Instrumento [] e, int sel ) {
		for( Instrumento i : e ) { 
            afina( i, sel );
            }
	}
	public static void main( String [] args ) {
		Instrumento [] orquesta = {
			new Viento(),
			new Percusion(),
			new Cuerda(),
			new Metal(),
			new VientoMadera(),
			new Instrumento()
		};
		afinaTodos( orquesta, 1 );
		System.out.println( );
		afinaTodos( orquesta, 2 );
        System.out.println( );
        Viento viento = new VientoMadera();
        afina( viento, 1 );
        afina( viento, 2 );
        viento = new Metal();
        afina( viento, 1 );
        afina( viento, 2 );
        Instrumento padre = new Instrumento();
        Viento hijo = (Viento)padre;
        afina( padre, 1 );
	}
} 
/* Salida:
Viento.ajustar() 
Percusion.ajustar() 
Cuerda.ajustar() 
Metal.ajustar() 
VientoMadera.ajustar() 
Instrumento.ajustar() 

Viento.tocar() Do
Percusion.tocar() Do
Cuerda.tocar() Do
Metal.tocar() Do
VientoMadera.tocar() Do
Instrumento.tocar() Do

		System.out.println( );
		for( int n=0; n<orquesta.length; n++ ) 
			afina( orquesta[n], 1 );
		System.out.println( );
		for( int n=0; n<orquesta.length; n++ ) 
			afina( orquesta[n], 2 );
*///:~

