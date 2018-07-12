package patron;

public class FlujosFactory implements IFlujosFactory {

    @Override
    public FlujoDeEntrada creaFlujoDeEntrada1() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FlujosDeEntrada creaFlujoDeEntrada() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return new FlujoBufferedInputStream();
    }

    @Override
    public FlujosDeEntradaTexto creaFlujoDeEntradaTexto() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FlujoAleatorio creaFlujoAleatorio() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FlujoDeSalida creaFlujoDeSalida1() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FlujosDeSalidaTexto creaFlujoDeSalidaTexto() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FlujosDeSalida creaFlujoDeSalida() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return new FlujoBufferedOutputStream();
    }
    
    /*
    @Override
	public FlujoDeEntrada creaFlujoDeEntrada1() {
		return new FlujoBufferedReader();
	}
    @Override
    public FlujosDeEntrada creaFlujoDeEntrada() {
        return new FlujoBufferedInputStream();
    }
    public FlujosDeEntradaTexto creaFlujoDeEntradaTexto() {
        return new FlujoFileReader();
    }
    @Override
    public FlujoAleatorio creaFlujoAleatorio() {
        return new FlujoRandomAccessFile();
    }
    @Override
    public FlujoDeSalida creaFlujoDeSalida1() {
        return new FlujoBufferedWriter();
    }
    @Override
	public FlujosDeSalida creaFlujoDeSalida() {
        return new FlujoBufferedOutputStream();
    }
    public FlujosDeSalidaTexto creaFlujoDeSalidaTexto() {
        return new FlujoFileWriter();
    }
    */
}