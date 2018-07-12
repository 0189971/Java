package patron;

public interface IFlujosFactory {
    public FlujoDeEntrada creaFlujoDeEntrada1();
    public FlujosDeEntrada creaFlujoDeEntrada();
    public FlujosDeEntradaTexto creaFlujoDeEntradaTexto();
	public FlujoAleatorio creaFlujoAleatorio();
	public FlujoDeSalida creaFlujoDeSalida1();
    public FlujosDeSalidaTexto creaFlujoDeSalidaTexto();
	public FlujosDeSalida creaFlujoDeSalida();
}