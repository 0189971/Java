package polimorfismointer;

public class Percusion implements Instrumento {
    @Override
	public void tocar( NotaMusical oNm ) {
		Print.print( this + ".tocar() " + oNm );
	}
    @Override
	public String toString() { 
		return "Percusion"; 
	}
    @Override
	public void ajustar() { 
		Print.print( this + ".ajustar()" ); 
	}
}
