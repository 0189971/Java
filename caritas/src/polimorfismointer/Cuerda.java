package polimorfismointer;

public class Cuerda implements Instrumento {
    @Override
	public void tocar( NotaMusical oNm ) {
		Print.print( this + ".tocar() " + oNm );
	}
    @Override
	public String toString() { 
		return "Cuerda"; 
	}
    @Override
	public void ajustar() { 
		Print.print( this + ".ajustar()" ); 
	}
}
