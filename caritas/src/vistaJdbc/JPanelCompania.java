package vistaJdbc;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Fri Nov 15 18:58:31 CST 2013
 */



/**
 * @author SHOCKIE
 */
public class JPanelCompania extends JPanel {
	public JPanelCompania() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Open Source Project license - unknown
		panel1 = new JPanel();
		label1 = new JLabel();
		textField1 = new JTextField();
		label3 = new JLabel();
		textField2 = new JTextField();
		button1 = new JButton();

		//======== this ========
		setLayout(null);

		//======== panel1 ========
		{
			panel1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED), "Compa\u00f1ia disquera"));
			panel1.setLayout(null);

			//---- label1 ----
			label1.setText("Identificador");
			panel1.add(label1);
			label1.setBounds(new Rectangle(new Point(50, 45), label1.getPreferredSize()));
			panel1.add(textField1);
			textField1.setBounds(235, 40, 240, textField1.getPreferredSize().height);

			//---- label3 ----
			label3.setText("Nombre de la compa\u00f1ia");
			panel1.add(label3);
			label3.setBounds(new Rectangle(new Point(50, 155), label3.getPreferredSize()));
			panel1.add(textField2);
			textField2.setBounds(235, 155, 240, textField2.getPreferredSize().height);

			//---- button1 ----
			button1.setText("Insertar");
			panel1.add(button1);
			button1.setBounds(310, 245, 125, 40);

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
	private JLabel label1;
	private JTextField textField1;
	private JLabel label3;
	private JTextField textField2;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
