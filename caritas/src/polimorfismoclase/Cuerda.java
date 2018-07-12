package polimorfismoclase;


public class Cuerda extends Instrumento {
	public void tocar( NotaMusical oNm ) {
		Print.print( this + ".tocar() " + oNm );
	}
	public String toString() { 
		return "Cuerda"; 
	}
	public void ajustar() { 
		Print.print( this + ".ajustar()" ); 
	}
}
