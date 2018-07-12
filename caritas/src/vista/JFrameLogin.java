package vista;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;
/*
 * Created by JFormDesigner on Thu Apr 03 20:54:39 CST 2014
 */



/**
 * @author SHOCKIE
 */
public class JFrameLogin extends JFrame {
    private JPanelLogin panel;
	public JFrameLogin() {
        super();
		initComponents();
        this.setSize( 390, 230 );
        this.setVisible( true );
        this.addWindowListener(new TomadorDeEventoFrame());
        this.setResizable( false );
	}

	private void btnArtistaActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void btnDiscoActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void btnCompaniaActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void btnGeneroActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void btnCancionActionPerformed(ActionEvent e) {
		// TODO add your code here
	}
    private class TomadorDeEventoFrame implements WindowListener {

        @Override
        public void windowOpened(WindowEvent we) {
            
        }

        @Override
        public void windowClosing(WindowEvent we) {
            System.exit( 0 );
        }

        @Override
        public void windowClosed(WindowEvent we) {
            System.exit( 0 );
        }

        @Override
        public void windowIconified(WindowEvent we) {
            
        }

        @Override
        public void windowDeiconified(WindowEvent we) {
            
        }

        @Override
        public void windowActivated(WindowEvent we) {
            
        }

        @Override
        public void windowDeactivated(WindowEvent we) {
            
        }
    
    }

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Open Source Project license - unknown
		panel1 = new JPanel();
		btnArtista = new JButton();
		btnDisco = new JButton();
		btnCompania = new JButton();
		btnGenero = new JButton();
		btnCancion = new JButton();

		//======== this ========
		setTitle("Aplicaci\u00f3n de m\u00fasica");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== panel1 ========
		{
			panel1.setLayout(null);

			//---- btnArtista ----
			btnArtista.setText("Artista");
			btnArtista.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnArtistaActionPerformed(e);
				}
			});
			panel1.add(btnArtista);
			btnArtista.setBounds(5, 30, 100, btnArtista.getPreferredSize().height);

			//---- btnDisco ----
			btnDisco.setText("Disco");
			btnDisco.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnDiscoActionPerformed(e);
				}
			});
			panel1.add(btnDisco);
			btnDisco.setBounds(5, 270, 100, btnDisco.getPreferredSize().height);

			//---- btnCompania ----
			btnCompania.setText("Compa\u00f1ia");
			btnCompania.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnCompaniaActionPerformed(e);
				}
			});
			panel1.add(btnCompania);
			btnCompania.setBounds(5, 190, 100, btnCompania.getPreferredSize().height);

			//---- btnGenero ----
			btnGenero.setText("Genero");
			btnGenero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnGeneroActionPerformed(e);
				}
			});
			panel1.add(btnGenero);
			btnGenero.setBounds(5, 350, 100, btnGenero.getPreferredSize().height);

			//---- btnCancion ----
			btnCancion.setText("Canci\u00f3n");
			btnCancion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnCancionActionPerformed(e);
				}
			});
			panel1.add(btnCancion);
			btnCancion.setBounds(5, 110, 100, btnCancion.getPreferredSize().height);

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
		contentPane.add(panel1, BorderLayout.WEST);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Open Source Project license - unknown
	private JPanel panel1;
	private JButton btnArtista;
	private JButton btnDisco;
	private JButton btnCompania;
	private JButton btnGenero;
	private JButton btnCancion;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
