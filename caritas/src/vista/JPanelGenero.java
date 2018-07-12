import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri May 16 15:50:59 CDT 2014
 */



/**
 * @author SHOCKIE
 */
public class JPanelGenero extends JPanel {
	public JPanelGenero() {
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
		lblIdGenero = new JLabel();
		lblNombreGenero = new JLabel();
		txtIdGenero = new JTextField();
		btnRegresar = new JButton();
		btnAdicionar = new JButton();
		txtIdNombreGenero = new JTextField();

		//======== this ========
		setLayout(null);

		//---- lblIdGenero ----
		lblIdGenero.setText("Id del genero");
		add(lblIdGenero);
		lblIdGenero.setBounds(55, 40, 115, 16);

		//---- lblNombreGenero ----
		lblNombreGenero.setText("Nombre del genero");
		add(lblNombreGenero);
		lblNombreGenero.setBounds(55, 90, 145, 16);
		add(txtIdGenero);
		txtIdGenero.setBounds(220, 35, 230, 28);

		//---- btnRegresar ----
		btnRegresar.setText("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalirActionPerformed(e);
			}
		});
		add(btnRegresar);
		btnRegresar.setBounds(110, 145, 95, 29);

		//---- btnAdicionar ----
		btnAdicionar.setText("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoginActionPerformed(e);
			}
		});
		add(btnAdicionar);
		btnAdicionar.setBounds(265, 145, 100, 29);
		add(txtIdNombreGenero);
		txtIdNombreGenero.setBounds(220, 80, 230, 28);

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
	private JLabel lblIdGenero;
	private JLabel lblNombreGenero;
	private JTextField txtIdGenero;
	private JButton btnRegresar;
	private JButton btnAdicionar;
	private JTextField txtIdNombreGenero;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
