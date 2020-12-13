package io.github.freeze_dolphin.layout_generator.windows;

import java.awt.EventQueue;
import java.lang.reflect.Field;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Generator {

	private JFrame frame;
	private final int size;

	/**
	 * Launch the application.
	 */
	public static void call(int size) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Generator window = new Generator(size);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Generator(int size) {
		this.size = size;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 384, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Editing", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(16, 14, 336, 240);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		Switchers switchers = new Switchers(panel);

		try {
			Class<?> c = Switchers.class;
			for (Field f : c.getFields()) {
				String name = f.getName();
				switch (size) {
				case 1: 
					if (!name.startsWith("t1") || name.endsWith("_1")) {
						((JToggleButton) f.get(switchers)).setEnabled(false);
					}
					break;
				case 2: 
					if ((!name.startsWith("t1") && !name.startsWith("t2")) || name.endsWith("_1")) {
						((JToggleButton) f.get(switchers)).setEnabled(false);
					}
					break;
				case 3: 
					if ((!name.startsWith("t1") && !name.startsWith("t2") && !name.startsWith("t3")) || name.endsWith("_1")) {
						((JToggleButton) f.get(switchers)).setEnabled(false);
					}
					break;
				case 4: 
					if (!name.startsWith("t1") && name.endsWith("_1")) {
						((JToggleButton) f.get(switchers)).setEnabled(false);
					}
					break;
				case 5: 
					if ((!name.startsWith("t1") && !name.startsWith("t2")) && name.endsWith("_1")) {
						((JToggleButton) f.get(switchers)).setEnabled(false);
					}
					break;
				case 6: 
					if ((!name.startsWith("t1") && !name.startsWith("t2") && !name.startsWith("t3")) && name.endsWith("_1")) {
						((JToggleButton) f.get(switchers)).setEnabled(false);
					}
					break;
				default: 
					((JToggleButton) f.get(switchers)).setEnabled(false);
					break;
				}
			}
		} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		JTextPane textPane = new JTextPane();
		textPane.setBounds(12, 307, 340, 157);
		frame.getContentPane().add(textPane);

		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StringBuilder sb = new StringBuilder("new int[] {");
				boolean first = false;
				try {
					Class<?> c = Switchers.class;
					for (Field f : c.getFields()) {
						if (f == null) continue;
						JToggleButton jtb = ((JToggleButton) f.get(switchers));
						if (jtb.isEnabled() && jtb.isSelected()) {
							if (!first) {
								first = true;
								sb.append(convert(jtb.getName()));
							}
							sb.append(", " + convert(jtb.getName()));
						}
					}
				} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
				sb.append("}");		
				textPane.setText(sb.toString());
			}
		});
		btnGenerate.setBounds(12, 268, 340, 25);
		frame.getContentPane().add(btnGenerate);

	}

	private static int convert(String fieldName) {
		int rt = 0;

		String[] s = fieldName.split("");
		if (fieldName.endsWith("_1")) { rt = 27; }
		rt = rt + Integer.parseInt(s[2]) - 1;
		return rt;
	}

	public int getSize() {
		return size;
	}

	private class Switchers {

		public Switchers(JPanel panel) {
			t11.setBounds(12, 14, 24, 24);
			panel.add(t11);			
			t12.setBounds(48, 14, 24, 24);
			panel.add(t12);
			t13.setBounds(84, 14, 24, 24);
			panel.add(t13);
			t14.setBounds(120, 14, 24, 24);
			panel.add(t14);
			t15.setBounds(156, 14, 24, 24);
			panel.add(t15);
			t16.setBounds(192, 14, 24, 24);
			panel.add(t16);
			t17.setBounds(228, 14, 24, 24);
			panel.add(t17);
			t18.setBounds(264, 14, 24, 24);
			panel.add(t18);
			t19.setBounds(300, 14, 24, 24);
			panel.add(t19);
			t21.setBounds(12, 52, 24, 24);
			panel.add(t21);
			t22.setBounds(48, 52, 24, 24);
			panel.add(t22);
			t23.setBounds(84, 52, 24, 24);
			panel.add(t23);
			t24.setBounds(120, 52, 24, 24);
			panel.add(t24);
			t25.setBounds(156, 52, 24, 24);
			panel.add(t25);
			t26.setBounds(192, 52, 24, 24);
			panel.add(t26);
			t27.setBounds(228, 52, 24, 24);
			panel.add(t27);
			t28.setBounds(264, 52, 24, 24);
			panel.add(t28);
			t29.setBounds(300, 52, 24, 24);
			panel.add(t29);
			t31.setBounds(12, 90, 24, 24);
			panel.add(t31);
			t32.setBounds(48, 90, 24, 24);
			panel.add(t32);
			t33.setBounds(84, 90, 24, 24);
			panel.add(t33);
			t34.setBounds(120, 90, 24, 24);
			panel.add(t34);
			t35.setBounds(156, 90, 24, 24);
			panel.add(t35);
			t36.setBounds(192, 90, 24, 24);
			panel.add(t36);
			t37.setBounds(228, 90, 24, 24);
			panel.add(t37);
			t38.setBounds(264, 90, 24, 24);
			panel.add(t38);
			t39.setBounds(300, 90, 24, 24);
			panel.add(t39);
			t11_1.setBounds(12, 128, 24, 24);
			panel.add(t11_1);
			t12_1.setBounds(48, 128, 24, 24);
			panel.add(t12_1);
			t13_1.setBounds(84, 128, 24, 24);
			panel.add(t13_1);
			t14_1.setBounds(120, 128, 24, 24);
			panel.add(t14_1);
			t15_1.setBounds(156, 128, 24, 24);
			panel.add(t15_1);
			t16_1.setBounds(192, 128, 24, 24);
			panel.add(t16_1);
			t17_1.setBounds(228, 128, 24, 24);
			panel.add(t17_1);
			t18_1.setBounds(264, 128, 24, 24);
			panel.add(t18_1);
			t19_1.setBounds(300, 128, 24, 24);
			panel.add(t19_1);
			t21_1.setBounds(12, 166, 24, 24);
			panel.add(t21_1);
			t22_1.setBounds(48, 166, 24, 24);
			panel.add(t22_1);
			t23_1.setBounds(84, 166, 24, 24);
			panel.add(t23_1);
			t24_1.setBounds(120, 166, 24, 24);
			panel.add(t24_1);
			t25_1.setBounds(156, 166, 24, 24);
			panel.add(t25_1);
			t26_1.setBounds(192, 166, 24, 24);
			panel.add(t26_1);
			t27_1.setBounds(228, 166, 24, 24);
			panel.add(t27_1);
			t28_1.setBounds(264, 166, 24, 24);
			panel.add(t28_1);
			t29_1.setBounds(300, 166, 24, 24);
			panel.add(t29_1);
			t31_1.setBounds(12, 204, 24, 24);
			panel.add(t31_1);
			t32_1.setBounds(48, 204, 24, 24);
			panel.add(t32_1);
			t33_1.setBounds(84, 204, 24, 24);
			panel.add(t33_1);
			t34_1.setBounds(120, 204, 24, 24);
			panel.add(t34_1);
			t35_1.setBounds(156, 204, 24, 24);
			panel.add(t35_1);
			t36_1.setBounds(192, 204, 24, 24);
			panel.add(t36_1);
			t37_1.setBounds(228, 204, 24, 24);
			panel.add(t37_1);
			t38_1.setBounds(264, 204, 24, 24);
			panel.add(t38_1);
			t39_1.setBounds(300, 204, 24, 24);
			panel.add(t39_1);
		}

		public JToggleButton t11 = new JToggleButton("");
		public JToggleButton t12 = new JToggleButton("");
		public JToggleButton t13 = new JToggleButton("");
		public JToggleButton t14 = new JToggleButton("");
		public JToggleButton t15 = new JToggleButton("");
		public JToggleButton t16 = new JToggleButton("");
		public JToggleButton t17 = new JToggleButton("");
		public JToggleButton t18 = new JToggleButton("");
		public JToggleButton t19 = new JToggleButton("");
		public JToggleButton t21 = new JToggleButton("");
		public JToggleButton t22 = new JToggleButton("");
		public JToggleButton t23 = new JToggleButton("");
		public JToggleButton t24 = new JToggleButton("");
		public JToggleButton t25 = new JToggleButton("");
		public JToggleButton t26 = new JToggleButton("");
		public JToggleButton t27 = new JToggleButton("");
		public JToggleButton t28 = new JToggleButton("");
		public JToggleButton t29 = new JToggleButton("");
		public JToggleButton t31 = new JToggleButton("");
		public JToggleButton t32 = new JToggleButton("");		
		public JToggleButton t33 = new JToggleButton("");
		public JToggleButton t34 = new JToggleButton("");
		public JToggleButton t35 = new JToggleButton("");
		public JToggleButton t36 = new JToggleButton("");
		public JToggleButton t37 = new JToggleButton("");
		public JToggleButton t38 = new JToggleButton("");
		public JToggleButton t39 = new JToggleButton("");
		public JToggleButton t11_1 = new JToggleButton("");
		public JToggleButton t12_1 = new JToggleButton("");
		public JToggleButton t13_1 = new JToggleButton("");
		public JToggleButton t14_1 = new JToggleButton("");
		public JToggleButton t15_1 = new JToggleButton("");
		public JToggleButton t16_1 = new JToggleButton("");
		public JToggleButton t17_1 = new JToggleButton("");
		public JToggleButton t18_1 = new JToggleButton("");
		public JToggleButton t19_1 = new JToggleButton("");
		public JToggleButton t21_1 = new JToggleButton("");
		public JToggleButton t22_1 = new JToggleButton("");
		public JToggleButton t23_1 = new JToggleButton("");
		public JToggleButton t24_1 = new JToggleButton("");
		public JToggleButton t25_1 = new JToggleButton("");
		public JToggleButton t26_1 = new JToggleButton("");
		public JToggleButton t27_1 = new JToggleButton("");
		public JToggleButton t28_1 = new JToggleButton("");
		public JToggleButton t29_1 = new JToggleButton("");
		public JToggleButton t31_1 = new JToggleButton("");
		public JToggleButton t32_1 = new JToggleButton("");
		public JToggleButton t33_1 = new JToggleButton("");
		public JToggleButton t34_1 = new JToggleButton("");
		public JToggleButton t35_1 = new JToggleButton("");
		public JToggleButton t36_1 = new JToggleButton("");
		public JToggleButton t37_1 = new JToggleButton("");
		public JToggleButton t38_1 = new JToggleButton("");
		public JToggleButton t39_1 = new JToggleButton("");
	}

}
