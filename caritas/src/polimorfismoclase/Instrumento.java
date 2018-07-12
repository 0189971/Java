package polimorfismoclase;


public class Instrumento {
	public void tocar( NotaMusical oNm ) {
		Print.print( this + ".tocar() " + oNm );
	}
	public void ajustar() {
		Print.print( this + ".ajustar()" );
	}
	public String toString() {
		return "Instrumento";
	}
}
