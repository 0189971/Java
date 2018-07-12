import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri May 16 15:53:50 CDT 2014
 */



/**
 * @author SHOCKIE
 */
public class JPanelCompania extends JPanel {
	public JPanelCompania() {
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
		lblIdCompania = new JLabel();
		lblNombreCompania = new JLabel();
		txtIdCompania = new JTextField();
		btnRegresar = new JButton();
		btnAdicionar = new JButton();
		txtIdNombreCompania = new JTextField();

		//======== this ========
		setLayout(null);

		//---- lblIdCompania ----
		lblIdCompania.setText("Id de la compa\u00f1ia");
		add(lblIdCompania);
		lblIdCompania.setBounds(35, 25, 125, 16);

		//---- lblNombreCompania ----
		lblNombreCompania.setText("Nombre de la compa\u00f1ia");
		add(lblNombreCompania);
		lblNombreCompania.setBounds(35, 75, 165, 16);
		add(txtIdCompania);
		txtIdCompania.setBounds(215, 20, 230, 28);

		//---- btnRegresar ----
		btnRegresar.setText("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalirActionPerformed(e);
			}
		});
		add(btnRegresar);
		btnRegresar.setBounds(95, 130, 95, 29);

		//---- btnAdicionar ----
		btnAdicionar.setText("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoginActionPerformed(e);
			}
		});
		add(btnAdicionar);
		btnAdicionar.setBounds(250, 130, 100, 29);
		add(txtIdNombreCompania);
		txtIdNombreCompania.setBounds(215, 65, 230, 28);

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
	private JLabel lblIdCompania;
	private JLabel lblNombreCompania;
	private JTextField txtIdCompania;
	private JButton btnRegresar;
	private JButton btnAdicionar;
	private JTextField txtIdNombreCompania;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
