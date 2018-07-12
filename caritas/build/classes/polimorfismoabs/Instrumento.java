package polimorfismoabs;

public abstract class Instrumento {
	public abstract void tocar( NotaMusical oNm );
	public abstract void ajustar();
    public void romper() {
        System.out.println( "Rompiendo intrumento" );
    }
}
