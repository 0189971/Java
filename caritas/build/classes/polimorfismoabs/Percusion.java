package polimorfismoabs;

public class Percusion extends Instrumento {
	public void tocar( NotaMusical oNm ) {
		Print.print( this + ".tocar() " + oNm );
	}
	public String toString() { 
		return "Percusion"; 
	}
	public void ajustar() { 
		Print.print( this + ".ajustar()" ); 
	}
    public void romper() {
        System.out.println( " Rompiendo : " + this );
    }
}
