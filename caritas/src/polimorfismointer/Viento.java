package polimorfismointer;

public class Viento implements Instrumento {
    @Override
	public void tocar( NotaMusical oNm ) {
		Print.print( this + ".tocar() " + oNm );
	}
    @Override
	public String toString() { 
		return "Viento"; 
	}
    @Override
	public void ajustar() { 
		Print.print( this + ".ajustar()" ); 
	}
}
