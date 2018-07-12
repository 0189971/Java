package polimorfismoabs;


public class MusicaClaseAbstract {
	public static void afina( Instrumento i, int sel ) {
		if( sel==1 ) { 
            i.ajustar();
            }
        else { 
            i.tocar( NotaMusical.Do );
            System.out.print( i  + " : " );
            i.romper();
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
            //new Instrumento() // no es posible
		};
		afinaTodos( orquesta, 1 );
		System.out.println( );
		afinaTodos( orquesta, 2 );
        
        System.out.println( );
        Instrumento cualquiera = orquesta[0];
        afina( cualquiera, 1 );
        afina( cualquiera, 2 );
        cualquiera = orquesta[1];
        afina( cualquiera, 1 );
        afina( cualquiera, 2 );
        cualquiera = orquesta[2];
        afina( cualquiera, 1 );
        afina( cualquiera, 2 );
        cualquiera = orquesta[3];
        afina( cualquiera, 1 );
        afina( cualquiera, 2 );
        cualquiera = orquesta[4];
        afina( cualquiera, 1 );
        afina( cualquiera, 2 );
        // Downcasting
//        Viento unInstrumento = new Viento();
//        Metal trombon = (Metal)unInstrumento;
//        afina( trombon, 1 );
//        afina( trombon, 2 );
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

