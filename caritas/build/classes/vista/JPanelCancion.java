import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri May 16 15:43:53 CDT 2014
 */



/**
 * @author SHOCKIE
 */
public class JPanelCancion extends JPanel {
	public JPanelCancion() {
		initComponents();
	}

	private void btnSalirActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void btnLoginActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Open Source Project license - unknown
		lblIdCancion = new JLabel();
		lblNombreCancion = new JLabel();
		txtIdCancion = new JTextField();
		btnRegresar = new JButton();
		btnAdicionar = new JButton();
		lblGenero = new JLabel();
		cmbBoxGenero = new JComboBox();
		lblDuracion = new JLabel();
		spinnerMinutos = new JSpinner();
		spinnerSegundos = new JSpinner();
		lblMinutos = new JLabel();
		lblsegundos = new JLabel();
		lblNoTrack = new JLabel();
		spinnerNoTrack = new JSpinner();
		lblpopularidad = new JLabel();
		cmbBoxPopularidad = new JComboBox();
		txtIdNombreCancion = new JTextField();

		//======== this ========
		setLayout(null);

		//---- lblIdCancion ----
		lblIdCancion.setText("Id de la canci\u00f3n");
		add(lblIdCancion);
		lblIdCancion.setBounds(40, 45, 115, 16);

		//---- lblNombreCancion ----
		lblNombreCancion.setText("Nombre de la canci\u00f3n");
		add(lblNombreCancion);
		lblNombreCancion.setBounds(40, 135, 145, 16);
		add(txtIdCancion);
		txtIdCancion.setBounds(205, 40, 230, 28);

		//---- btnRegresar ----
		btnRegresar.setText("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalirActionPerformed(e);
			}
		});
		add(btnRegresar);
		btnRegresar.setBounds(95, 310, 95, 29);

		//---- btnAdicionar ----
		btnAdicionar.setText("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoginActionPerformed(e);
			}
		});
		add(btnAdicionar);
		btnAdicionar.setBounds(250, 310, 100, 29);

		//---- lblGenero ----
		lblGenero.setText("Genero");
		add(lblGenero);
		lblGenero.setBounds(new Rectangle(new Point(40, 90), lblGenero.getPreferredSize()));
		add(cmbBoxGenero);
		cmbBoxGenero.setBounds(205, 85, 230, cmbBoxGenero.getPreferredSize().height);

		//---- lblDuracion ----
		lblDuracion.setText("Duraci\u00f3n");
		add(lblDuracion);
		lblDuracion.setBounds(new Rectangle(new Point(40, 180), lblDuracion.getPreferredSize()));

		//---- spinnerMinutos ----
		spinnerMinutos.setModel(new SpinnerNumberModel(3, 0, 59, 1));
		add(spinnerMinutos);
		spinnerMinutos.setBounds(250, 175, 60, spinnerMinutos.getPreferredSize().height);

		//---- spinnerSegundos ----
		spinnerSegundos.setModel(new SpinnerNumberModel(25, 0, 59, 1));
		add(spinnerSegundos);
		spinnerSegundos.setBounds(370, 175, 60, spinnerSegundos.getPreferredSize().height);

		//---- lblMinutos ----
		lblMinutos.setText("MIN");
		add(lblMinutos);
		lblMinutos.setBounds(new Rectangle(new Point(210, 180), lblMinutos.getPreferredSize()));

		//---- lblsegundos ----
		lblsegundos.setText("SEG");
		add(lblsegundos);
		lblsegundos.setBounds(new Rectangle(new Point(330, 180), lblsegundos.getPreferredSize()));

		//---- lblNoTrack ----
		lblNoTrack.setText("N\u00famero de track");
		add(lblNoTrack);
		lblNoTrack.setBounds(40, 270, 120, 16);

		//---- spinnerNoTrack ----
		spinnerNoTrack.setModel(new SpinnerNumberModel(4, 1, 25, 1));
		add(spinnerNoTrack);
		spinnerNoTrack.setBounds(355, 265, 75, 28);

		//---- lblpopularidad ----
		lblpopularidad.setText("Popularidad");
		add(lblpopularidad);
		lblpopularidad.setBounds(new Rectangle(new Point(40, 225), lblpopularidad.getPreferredSize()));

		//---- cmbBoxPopularidad ----
		cmbBoxPopularidad.setModel(new DefaultComboBoxModel(new String[] {
			"Sin evaluar"
		}));
		add(cmbBoxPopularidad);
		cmbBoxPopularidad.setBounds(205, 220, 230, cmbBoxPopularidad.getPreferredSize().height);
		add(txtIdNombreCancion);
		txtIdNombreCancion.setBounds(205, 125, 230, 28);

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
	private JLabel lblIdCancion;
	private JLabel lblNombreCancion;
	private JTextField txtIdCancion;
	private JButton btnRegresar;
	private JButton btnAdicionar;
	private JLabel lblGenero;
	private JComboBox cmbBoxGenero;
	private JLabel lblDuracion;
	private JSpinner spinnerMinutos;
	private JSpinner spinnerSegundos;
	private JLabel lblMinutos;
	private JLabel lblsegundos;
	private JLabel lblNoTrack;
	private JSpinner spinnerNoTrack;
	private JLabel lblpopularidad;
	private JComboBox cmbBoxPopularidad;
	private JTextField txtIdNombreCancion;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
