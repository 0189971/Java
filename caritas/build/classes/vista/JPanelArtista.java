import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Fri May 16 16:10:00 CDT 2014
 */



/**
 * @author SHOCKIE
 */
public class JPanelArtista extends JPanel {
	public JPanelArtista() {
		initComponents();
	}

	private void btnSalirActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void btnLoginActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void btnAddCancionActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Open Source Project license - unknown
		lblIdDisco = new JLabel();
		lblAnio = new JLabel();
		txtIdDisco = new JTextField();
		btnRegresar = new JButton();
		btnAdicionar = new JButton();
		lblNombreDisco = new JLabel();
		txtAnio = new JTextField();
		btnAddCancion = new JButton();
		scrollPane1 = new JScrollPane();
		tableCanciones = new JTable();
		cmbBoxDisco = new JComboBox();

		//======== this ========
		setLayout(null);

		//---- lblIdDisco ----
		lblIdDisco.setText("Id del artista");
		add(lblIdDisco);
		lblIdDisco.setBounds(65, 25, 115, 16);

		//---- lblAnio ----
		lblAnio.setText("Nombre del artista");
		add(lblAnio);
		lblAnio.setBounds(65, 115, 145, 16);
		add(txtIdDisco);
		txtIdDisco.setBounds(230, 20, 230, 28);

		//---- btnRegresar ----
		btnRegresar.setText("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalirActionPerformed(e);
			}
		});
		add(btnRegresar);
		btnRegresar.setBounds(115, 150, 95, 29);

		//---- btnAdicionar ----
		btnAdicionar.setText("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoginActionPerformed(e);
			}
		});
		add(btnAdicionar);
		btnAdicionar.setBounds(285, 150, 100, 29);

		//---- lblNombreDisco ----
		lblNombreDisco.setText("Compa\u00f1ia");
		add(lblNombreDisco);
		lblNombreDisco.setBounds(65, 70, 130, 16);
		add(txtAnio);
		txtAnio.setBounds(230, 105, 230, 28);

		//---- btnAddCancion ----
		btnAddCancion.setText("Adicionar disco");
		btnAddCancion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddCancionActionPerformed(e);
			}
		});
		add(btnAddCancion);
		btnAddCancion.setBounds(175, 195, 157, 29);

		//======== scrollPane1 ========
		{

			//---- tableCanciones ----
			tableCanciones.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
				},
				new String[] {
					null, null, null
				}
			) {
				Class[] columnTypes = new Class[] {
					Integer.class, Object.class, Integer.class
				};
				@Override
				public Class<?> getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			scrollPane1.setViewportView(tableCanciones);
		}
		add(scrollPane1);
		scrollPane1.setBounds(10, 235, 500, 180);
		add(cmbBoxDisco);
		cmbBoxDisco.setBounds(230, 65, 230, cmbBoxDisco.getPreferredSize().height);

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
	private JLabel lblIdDisco;
	private JLabel lblAnio;
	private JTextField txtIdDisco;
	private JButton btnRegresar;
	private JButton btnAdicionar;
	private JLabel lblNombreDisco;
	private JTextField txtAnio;
	private JButton btnAddCancion;
	private JScrollPane scrollPane1;
	private JTable tableCanciones;
	private JComboBox cmbBoxDisco;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
