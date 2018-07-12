package vistaJdbc;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Fri Nov 15 18:32:54 CST 2013
 */



/**
 * @author SHOCKIE
 */
public class JPanelCancion extends JPanel {
	public JPanelCancion() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Open Source Project license - unknown
		panel1 = new JPanel();
		label1 = new JLabel();
		textField1 = new JTextField();
		label2 = new JLabel();
		comboBox1 = new JComboBox();
		label3 = new JLabel();
		textField2 = new JTextField();
		button1 = new JButton();
		label4 = new JLabel();
		spinner1 = new JSpinner();
		spinner2 = new JSpinner();
		label5 = new JLabel();
		label6 = new JLabel();
		label7 = new JLabel();
		slider1 = new JSlider();
		label8 = new JLabel();
		spinner3 = new JSpinner();

		//======== this ========
		setLayout(null);

		//======== panel1 ========
		{
			panel1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED), "Canci\u00f3n"));
			panel1.setLayout(null);

			//---- label1 ----
			label1.setText("Identificador");
			panel1.add(label1);
			label1.setBounds(new Rectangle(new Point(60, 45), label1.getPreferredSize()));
			panel1.add(textField1);
			textField1.setBounds(210, 40, 240, textField1.getPreferredSize().height);

			//---- label2 ----
			label2.setText("Genero");
			panel1.add(label2);
			label2.setBounds(new Rectangle(new Point(60, 80), label2.getPreferredSize()));
			panel1.add(comboBox1);
			comboBox1.setBounds(210, 75, 240, comboBox1.getPreferredSize().height);

			//---- label3 ----
			label3.setText("Nombre de la canci\u00f3n");
			panel1.add(label3);
			label3.setBounds(new Rectangle(new Point(60, 115), label3.getPreferredSize()));
			panel1.add(textField2);
			textField2.setBounds(210, 110, 240, textField2.getPreferredSize().height);

			//---- button1 ----
			button1.setText("Insertar");
			panel1.add(button1);
			button1.setBounds(355, 290, 125, 40);

			//---- label4 ----
			label4.setText("Duraci\u00f3n");
			panel1.add(label4);
			label4.setBounds(new Rectangle(new Point(60, 155), label4.getPreferredSize()));

			//---- spinner1 ----
			spinner1.setModel(new SpinnerNumberModel(30, 0, 59, 1));
			panel1.add(spinner1);
			spinner1.setBounds(255, 150, 67, spinner1.getPreferredSize().height);

			//---- spinner2 ----
			spinner2.setModel(new SpinnerNumberModel(30, 1, 59, 1));
			panel1.add(spinner2);
			spinner2.setBounds(385, 150, 62, spinner2.getPreferredSize().height);

			//---- label5 ----
			label5.setText("Min");
			panel1.add(label5);
			label5.setBounds(new Rectangle(new Point(215, 155), label5.getPreferredSize()));

			//---- label6 ----
			label6.setText("Seg");
			panel1.add(label6);
			label6.setBounds(new Rectangle(new Point(340, 155), label6.getPreferredSize()));

			//---- label7 ----
			label7.setText("Popularidad");
			panel1.add(label7);
			label7.setBounds(new Rectangle(new Point(60, 195), label7.getPreferredSize()));

			//---- slider1 ----
			slider1.setMaximum(10);
			slider1.setMinorTickSpacing(1);
			slider1.setValue(5);
			slider1.setPaintLabels(true);
			slider1.setPaintTicks(true);
			panel1.add(slider1);
			slider1.setBounds(195, 185, 260, 45);

			//---- label8 ----
			label8.setText("N\u00famero de track");
			panel1.add(label8);
			label8.setBounds(new Rectangle(new Point(55, 240), label8.getPreferredSize()));

			//---- spinner3 ----
			spinner3.setModel(new SpinnerNumberModel(8, 0, 20, 1));
			panel1.add(spinner3);
			spinner3.setBounds(350, 235, 92, spinner3.getPreferredSize().height);

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
	private JLabel label2;
	private JComboBox comboBox1;
	private JLabel label3;
	private JTextField textField2;
	private JButton button1;
	private JLabel label4;
	private JSpinner spinner1;
	private JSpinner spinner2;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JSlider slider1;
	private JLabel label8;
	private JSpinner spinner3;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
