package vistaJdbc;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Fri Nov 15 18:14:32 CST 2013
 */



/**
 * @author SHOCKIE
 */
public class JPanelDisco extends JPanel {
	public JPanelDisco() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Open Source Project license - unknown
		panel1 = new JPanel();
		label1 = new JLabel();
		textField1 = new JTextField();
		label2 = new JLabel();
		label3 = new JLabel();
		button1 = new JButton();
		textField3 = new JTextField();
		comboBox1 = new JComboBox();
		label4 = new JLabel();
		comboBox2 = new JComboBox();
		button2 = new JButton();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();

		//======== this ========
		setLayout(null);

		//======== panel1 ========
		{
			panel1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED), "Disco"));
			panel1.setLayout(null);

			//---- label1 ----
			label1.setText("Identificador");
			panel1.add(label1);
			label1.setBounds(new Rectangle(new Point(60, 25), label1.getPreferredSize()));
			panel1.add(textField1);
			textField1.setBounds(205, 20, 240, textField1.getPreferredSize().height);

			//---- label2 ----
			label2.setText("Nombre del disco");
			panel1.add(label2);
			label2.setBounds(new Rectangle(new Point(60, 60), label2.getPreferredSize()));

			//---- label3 ----
			label3.setText("A\u00f1o");
			panel1.add(label3);
			label3.setBounds(new Rectangle(new Point(60, 95), label3.getPreferredSize()));

			//---- button1 ----
			button1.setText("Insertar");
			panel1.add(button1);
			button1.setBounds(355, 295, 140, 40);
			panel1.add(textField3);
			textField3.setBounds(205, 55, 240, textField3.getPreferredSize().height);
			panel1.add(comboBox1);
			comboBox1.setBounds(new Rectangle(new Point(350, 90), comboBox1.getPreferredSize()));

			//---- label4 ----
			label4.setText("Artista");
			panel1.add(label4);
			label4.setBounds(new Rectangle(new Point(60, 130), label4.getPreferredSize()));
			panel1.add(comboBox2);
			comboBox2.setBounds(205, 125, 240, 27);

			//---- button2 ----
			button2.setText("Adicionar canci\u00f3n");
			panel1.add(button2);
			button2.setBounds(200, 295, 140, 40);

			//======== scrollPane1 ========
			{

				//---- table1 ----
				table1.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
					},
					new String[] {
						"id", "genero", "nombre", "duracion", "popularidad", "no track"
					}
				) {
					Class[] columnTypes = new Class[] {
						Integer.class, String.class, String.class, String.class, String.class, Integer.class
					};
					@Override
					public Class<?> getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				scrollPane1.setViewportView(table1);
			}
			panel1.add(scrollPane1);
			scrollPane1.setBounds(15, 170, 484, 110);

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
		panel1.setBounds(10, 0, 515, 350);

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
	private JLabel label3;
	private JButton button1;
	private JTextField textField3;
	private JComboBox comboBox1;
	private JLabel label4;
	private JComboBox comboBox2;
	private JButton button2;
	private JScrollPane scrollPane1;
	private JTable table1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
