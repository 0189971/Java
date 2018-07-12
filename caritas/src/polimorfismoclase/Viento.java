package polimorfismoclase;

public class Viento extends Instrumento {
	public void tocar( NotaMusical oNm ) {
		Print.print( this + ".tocar() " + oNm );
	}
	public String toString() { 
		return "Viento"; 
	}
	public void ajustar() { 
		Print.print( this + ".ajustar()" ); 
	}
}
