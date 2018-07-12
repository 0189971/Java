package vistaJdbc;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.*;
import jdbc.ConsultorBD;
import jdbc.InsertorBD;
/*
 * Created by JFormDesigner on Fri Nov 15 18:05:27 CST 2013
 */



/**
 * @author Saul De La O Torres
 * @version 1.0
 */
public class JPanelArtista extends JPanel {
    private ConsultorBD consultor;
    private InsertorBD insertor;
	public JPanelArtista() {
		initComponents();
	}

	private void btnInsertarActionPerformed(ActionEvent e) {
        String tabla = "artista";
        String [] campos = {
            "id_artista", 
            "id_compania", 
            "nombre_artista"
            };
        String [] valores = {
            txtIdArtista.getText(),
            "" + (cmbBoxCompania.getSelectedIndex() + 1),
            txtNombreArtista.getText()
            };
        int [] tipos = {
            1, 1, 3
            };
        insertor = new InsertorBD(
            "/Users/sdelaot/Desktop/caritas/", "", "" );
        insertor.insertarBD(tabla, campos, valores, tipos);
        insertor.cierraBD();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Open Source Project license - unknown
		panel1 = new JPanel();
		lblIdArtista = new JLabel();
		txtIdArtista = new JTextField();
		lblCompania = new JLabel();
		cmbBoxCompania = new JComboBox();
		lblNombreArtista = new JLabel();
		txtNombreArtista = new JTextField();
		btnInsertar = new JButton();

		//======== this ========
		setLayout(null);

		//======== panel1 ========
		{
			panel1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED), "Artista"));
			panel1.setLayout(null);

			//---- lblIdArtista ----
			lblIdArtista.setText("Identificador");
			panel1.add(lblIdArtista);
			lblIdArtista.setBounds(new Rectangle(new Point(60, 45), lblIdArtista.getPreferredSize()));
			panel1.add(txtIdArtista);
			txtIdArtista.setBounds(205, 40, 240, txtIdArtista.getPreferredSize().height);
            consultor = new ConsultorBD( 
                "/Users/sdelaot/Desktop/caritas/", "", "" );
            ResultSet rs = consultor.getResultado( "select * from artista" );
            int contador = 1;
            try {
                while( rs.next() ) {
                    contador++;
                    }
            } catch( SQLException sqle ) {
                sqle.printStackTrace();
            }
            txtIdArtista.setText( "" + contador );

			//---- lblCompania ----
			lblCompania.setText("Compa\u00f1ia");
			panel1.add(lblCompania);
			lblCompania.setBounds(new Rectangle(new Point(60, 100), lblCompania.getPreferredSize()));
			panel1.add(cmbBoxCompania);
			cmbBoxCompania.setBounds(205, 95, 240, cmbBoxCompania.getPreferredSize().height);
            
            rs = consultor.getResultado( "select * from compania" );
            try {
                while( rs.next() ) {
                    cmbBoxCompania.addItem( rs.getString( 2 ) );
                    }
                consultor.cierraBD();
            } catch( SQLException sqle ) {
                sqle.printStackTrace();
            }

			//---- lblNombreArtista ----
			lblNombreArtista.setText("Nombre del artista");
			panel1.add(lblNombreArtista);
			lblNombreArtista.setBounds(new Rectangle(new Point(60, 160), lblNombreArtista.getPreferredSize()));
			panel1.add(txtNombreArtista);
			txtNombreArtista.setBounds(205, 155, 240, txtNombreArtista.getPreferredSize().height);

			//---- btnInsertar ----
			btnInsertar.setText("Insertar");
			btnInsertar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnInsertarActionPerformed(e);
				}
			});
			panel1.add(btnInsertar);
			btnInsertar.setBounds(310, 245, 125, 40);

			{ // compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < panel1.getComponentCount(); i++) {
					Rectangle bounds = panel1.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = panel1.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				panel1.setMinimumSize(preferredSize);
				panel1.setPreferredSize(preferredSize);
			}
		}
		add(panel1);
		panel1.setBounds(10, 10, 515, 350);

		{ // compute preferred size
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < getComponentCount(); i++) {
				Rectangle bounds = getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			setMinimumSize(preferredSize);
			setPreferredSize(preferredSize);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Open Source Project license - unknown
	private JPanel panel1;
	private JLabel lblIdArtista;
	private JTextField txtIdArtista;
	private JLabel lblCompania;
	private JComboBox cmbBoxCompania;
	private JLabel lblNombreArtista;
	private JTextField txtNombreArtista;
	private JButton btnInsertar;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
