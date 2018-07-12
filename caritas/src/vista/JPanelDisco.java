import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Fri May 16 16:05:33 CDT 2014
 */



/**
 * @author SHOCKIE
 */
public class JPanelDisco extends JPanel {
	public JPanelDisco() {
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
		txtNombreDisco = new JTextField();
		btnAddCancion = new JButton();
		scrollPane1 = new JScrollPane();
		tableCanciones = new JTable();

		//======== this ========
		setLayout(null);

		//---- lblIdDisco ----
		lblIdDisco.setText("Id del disco");
		add(lblIdDisco);
		lblIdDisco.setBounds(60, 35, 115, 16);

		//---- lblAnio ----
		lblAnio.setText("A\u00f1o");
		add(lblAnio);
		lblAnio.setBounds(60, 125, 145, 16);
		add(txtIdDisco);
		txtIdDisco.setBounds(225, 30, 230, 28);

		//---- btnRegresar ----
		btnRegresar.setText("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalirActionPerformed(e);
			}
		});
		add(btnRegresar);
		btnRegresar.setBounds(110, 160, 95, 29);

		//---- btnAdicionar ----
		btnAdicionar.setText("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoginActionPerformed(e);
			}
		});
		add(btnAdicionar);
		btnAdicionar.setBounds(280, 160, 100, 29);

		//---- lblNombreDisco ----
		lblNombreDisco.setText("Nombre del disco");
		add(lblNombreDisco);
		lblNombreDisco.setBounds(60, 80, 130, 16);
		add(txtAnio);
		txtAnio.setBounds(225, 115, 230, 28);
		add(txtNombreDisco);
		txtNombreDisco.setBounds(225, 70, 230, 28);

		//---- btnAddCancion ----
		btnAddCancion.setText("Adicionar canci\u00f3n");
		btnAddCancion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddCancionActionPerformed(e);
			}
		});
		add(btnAddCancion);
		btnAddCancion.setBounds(new Rectangle(new Point(170, 205), btnAddCancion.getPreferredSize()));

		//======== scrollPane1 ========
		{

			//---- tableCanciones ----
			tableCanciones.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
				},
				new String[] {
					null, null, null, null, null, null
				}
			));
			scrollPane1.setViewportView(tableCanciones);
		}
		add(scrollPane1);
		scrollPane1.setBounds(5, 245, 500, 180);

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
	private JTextField txtNombreDisco;
	private JButton btnAddCancion;
	private JScrollPane scrollPane1;
	private JTable tableCanciones;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
