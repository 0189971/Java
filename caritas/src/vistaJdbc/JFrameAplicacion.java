package vistaJdbc;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Fri Nov 15 19:13:16 CST 2013
 */



/**
 * @author SHOCKIE
 */
public class JFrameAplicacion extends JFrame {
    private JPanelArtista panelArtista;
	public JFrameAplicacion() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Open Source Project license - unknown
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		panelIzquierdo = new JPanel();
		btnArtista = new JButton();
		btnCompania = new JButton();
		btnGenero = new JButton();
		btnDisco = new JButton();
		panelCentral = new JPanel();
		buttonBar = new JPanel();
		btnConfiguracion = new JButton();
		btnSalir = new JButton();

		//======== this ========
		setTitle("Artistas");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== dialogPane ========
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setLayout(new BorderLayout());

			//======== contentPanel ========
			{
				contentPanel.setLayout(new BorderLayout());

				//======== panelIzquierdo ========
				{
					panelIzquierdo.setLayout(null);

					//---- btnArtista ----
					btnArtista.setText("Artista");
					panelIzquierdo.add(btnArtista);
					btnArtista.setBounds(5, 50, 110, btnArtista.getPreferredSize().height);

					//---- btnCompania ----
					btnCompania.setText("Compa\u00f1ia");
					panelIzquierdo.add(btnCompania);
					btnCompania.setBounds(5, 120, 110, btnCompania.getPreferredSize().height);

					//---- btnGenero ----
					btnGenero.setText("Genero");
					panelIzquierdo.add(btnGenero);
					btnGenero.setBounds(5, 180, 110, btnGenero.getPreferredSize().height);

					//---- btnDisco ----
					btnDisco.setText("Disco");
					panelIzquierdo.add(btnDisco);
					btnDisco.setBounds(5, 250, 110, btnDisco.getPreferredSize().height);

					{ // compute preferred size
						Dimension preferredSize = new Dimension();
						for(int i = 0; i < panelIzquierdo.getComponentCount(); i++) {
							Rectangle bounds = panelIzquierdo.getComponent(i).getBounds();
							preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
							preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
						}
						Insets insets = panelIzquierdo.getInsets();
						preferredSize.width += insets.right;
						preferredSize.height += insets.bottom;
						panelIzquierdo.setMinimumSize(preferredSize);
						panelIzquierdo.setPreferredSize(preferredSize);
					}
				}
				contentPanel.add(panelIzquierdo, BorderLayout.WEST);

				//======== panelCentral ========
				{
					panelCentral.setLayout(null);
                    panelArtista = new JPanelArtista();
                    panelCentral.add( panelArtista );
                    panelArtista.setSize( 560, 400 );

					{ // compute preferred size
						Dimension preferredSize = new Dimension();
						for(int i = 0; i < panelCentral.getComponentCount(); i++) {
							Rectangle bounds = panelCentral.getComponent(i).getBounds();
							preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
							preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
						}
						Insets insets = panelCentral.getInsets();
						preferredSize.width += insets.right;
						preferredSize.height += insets.bottom;
						panelCentral.setMinimumSize(preferredSize);
						panelCentral.setPreferredSize(preferredSize);
					}
				}
				contentPanel.add(panelCentral, BorderLayout.CENTER);
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			//======== buttonBar ========
			{
				buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
				buttonBar.setLayout(new GridBagLayout());
				((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
				((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

				//---- btnConfiguracion ----
				btnConfiguracion.setText("Configuraci\u00f3n BD");
				buttonBar.add(btnConfiguracion, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- btnSalir ----
				btnSalir.setText("Salir");
				buttonBar.add(btnSalir, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			dialogPane.add(buttonBar, BorderLayout.SOUTH);
		}
		contentPane.add(dialogPane, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Open Source Project license - unknown
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JPanel panelIzquierdo;
	private JButton btnArtista;
	private JButton btnCompania;
	private JButton btnGenero;
	private JButton btnDisco;
	private JPanel panelCentral;
	private JPanel buttonBar;
	private JButton btnConfiguracion;
	private JButton btnSalir;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
