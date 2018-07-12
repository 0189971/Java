package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Thu Apr 03 21:02:05 CST 2014
 */



/**
 * @author SHOCKIE
 */
public class JPanelLogin extends JPanel {
	public JPanelLogin() {
        super();
		initComponents();
	}

	private void btnSalirActionPerformed(ActionEvent e) {
		System.exit( 0 );
	}

	private void btnLoginActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Acceso a la aplicacion");
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Open Source Project license - unknown
		lblUsuario = new JLabel();
		lblPassword = new JLabel();
		txtUsuario = new JTextField();
		passwdPassword = new JPasswordField();
		btnSalir = new JButton();
		btnLogin = new JButton();

		//======== this ========
		setLayout(null);

		//---- lblUsuario ----
		lblUsuario.setText("Usuario:");
		add(lblUsuario);
		lblUsuario.setBounds(new Rectangle(new Point(55, 40), lblUsuario.getPreferredSize()));

		//---- lblPassword ----
		lblPassword.setText("Password:");
		add(lblPassword);
		lblPassword.setBounds(new Rectangle(new Point(55, 90), lblPassword.getPreferredSize()));
		add(txtUsuario);
		txtUsuario.setBounds(145, 40, 230, txtUsuario.getPreferredSize().height);
		add(passwdPassword);
		passwdPassword.setBounds(145, 85, 225, passwdPassword.getPreferredSize().height);

		//---- btnSalir ----
		btnSalir.setText("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalirActionPerformed(e);
			}
		});
		add(btnSalir);
		btnSalir.setBounds(new Rectangle(new Point(75, 160), btnSalir.getPreferredSize()));

		//---- btnLogin ----
		btnLogin.setText("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoginActionPerformed(e);
			}
		});
		add(btnLogin);
		btnLogin.setBounds(new Rectangle(new Point(230, 160), btnLogin.getPreferredSize()));

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
	private JLabel lblUsuario;
	private JLabel lblPassword;
	private JTextField txtUsuario;
	private JPasswordField passwdPassword;
	private JButton btnSalir;
	private JButton btnLogin;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
    private class TomadorDeEventoDeSalir implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            btnSalirActionPerformed(ae);
        }
        
    }
}
