package io.github.freeze_dolphin.layout_generator.windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class ReferringSize {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void call(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReferringSize window = new ReferringSize();
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
	public ReferringSize() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 240, 108);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("Inventory Size: ");
		lblNewLabel.setBounds(12, 14, 90, 17);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblNewLabel);

		JComboBox<Integer> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1, 2, 3, 4, 5, 6}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(113, 11, 109, 23);
		frame.getContentPane().add(comboBox);

		JButton btnProcess = new JButton("Process");
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LayoutGeneratorWindowCaller.initializeGenerator(comboBox.getSelectedIndex() + 1);
				frame.dispose();
			}
		});
		btnProcess.setBounds(123, 41, 101, 25);
		frame.getContentPane().add(btnProcess);
	}
}
