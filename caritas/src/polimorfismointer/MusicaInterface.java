package polimorfismointer;

public class MusicaInterface {
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
		Instrumento[] orquesta = {
			new Viento(),
			new Percusion(),
			new Cuerda(),
			new Metal(),
			new VientoMadera()
            //,
            //new Instrumento() // no se puede crear un objeto de una interface
		};
		afinaTodos( orquesta, 1 );
		System.out.println( );
		afinaTodos( orquesta, 2 );
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
*///:~

