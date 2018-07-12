/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Un panel con botones de radio para ejecutar codigo "emboscado"
 * y estudiar el comportamiento de su excepcion
 * @author sdelaot
 */
public class PanelDePruebaDeExcepciones extends Box {
    private ButtonGroup grupo;
	private JTextField campoDeTexto;
	private double [] a = new double[10];
	public PanelDePruebaDeExcepciones() {
		super( BoxLayout.Y_AXIS );
		grupo = new ButtonGroup();

		// anadir los botones de radio del codigo "embaucado"
		addRadioButton( "Entero divide por cero", 
			new ActionListener() {
				public void actionPerformed( ActionEvent event ) {
					a[1] = 1 / (a.length -  a.length);
				}
			} );

		addRadioButton( "Division por cero en punto flotante", 
			new	ActionListener() {
				public void actionPerformed( ActionEvent event ) {
					a[1] = a[2] / (a[3] -  a[3]);
				}
			} );

		addRadioButton( "Limite del arreglo", 
			new	ActionListener() {
				public void actionPerformed( ActionEvent event ) {
					a[1]= a[10];
				}
			} );

		addRadioButton( "Mutacion", 
			new ActionListener() {
				public void actionPerformed( ActionEvent event ) {
					a = (double[])event.getSource();
				}
			} );

		addRadioButton( "Apuntador nulo", 
			new ActionListener() {
				public void actionPerformed( ActionEvent event ) {
					event = null;
					System.out.println( event.getSource() );
				}
			} );

		addRadioButton( " sqrt( -1 )", 
			new	ActionListener() {
				public void actionPerformed( ActionEvent event ) {
					a[1] = Math.sqrt( -1 );
				}
			} );
	
		addRadioButton( "Sobreflujo (Overflow)", 
			new ActionListener() {
				public void actionPerformed (ActionEvent event ) {
					a[1] = 1000 * 1000 * 1000 * 1000;
					int n = (int)a[1];
				}
			} );

		addRadioButton( "Para cada archivo", 
			new ActionListener() {
				public void actionPerformed( ActionEvent event ) {
					try {
						FileInputStream is = 
                          new FileInputStream( "para un archivo" );
					} catch( IOException exception ) {
						campoDeTexto.setText( exception.toString() );
					}
				}
			} );

		addRadioButton( "Lanzando desconocido", 
			new ActionListener() {
				public void actionPerformed( ActionEvent event ) {
					throw new UnknownError();
				}
			} );
		// anadir el campo de texto para mostrar la excepcion
		campoDeTexto = new JTextField( 50 );
		add( campoDeTexto );
	}

	/**
	 Anadir un boton de radio al panel con un oyente.
	 Captura cualquier excepcion del metodo actionPerformed
	 del oyente.
	 @param s es el rotulo del boton de radio
	 @param listener es el oyente de accion del boton de radio
	*/
	private void addRadioButton( String s, ActionListener listener ) {
		final JRadioButton boton = new JRadioButton( s, false ) {
		//el boton llama a este metodo para disparar
		//	un evento de accion. Lo sobrescribimos para capturar excepciones
			protected void fireActionPerformed( ActionEvent event ) {
				try {
					campoDeTexto.setText( "Asi es una excepcion" );
					super.fireActionPerformed( event );
				} catch( Exception exception ) {
					campoDeTexto.setText( exception.toString() );
				}
			}
		};
		boton.addActionListener( listener );
		add( boton );
		grupo.add( boton );
	}
}
