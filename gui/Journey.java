package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.Scaler;

public class Journey extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lWelcome;
	private JButton bStart;
	private GridBagConstraints clWelcome, cbStart;
	private final static Insets STANDARDINSETS = new Insets(5, 5, 5, 5);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Journey frame = new Journey();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Journey() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(1000, 700));
		contentPane = new JPanel();
		contentPane.setLayout(new GridBagLayout());
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		
		lWelcome = new JLabel(Scaler.getScaledImageIcon("img/landing.jpg", 975, 675));
		bStart = new JButton("Start your journey");
		bStart.addActionListener(new ButtonListener());
		
		clWelcome = new GridBagConstraints();
		cbStart = new GridBagConstraints();
		
		draw();
		
	}
	
	private void draw() {
		
		// lWelcome
		clWelcome.gridx = 0;
		clWelcome.gridy = 0;
		clWelcome.gridwidth = 1;
		clWelcome.gridheight = 1;
		clWelcome.fill = GridBagConstraints.HORIZONTAL;
		clWelcome.fill = GridBagConstraints.VERTICAL;
		clWelcome.insets = STANDARDINSETS;
		
		// bStart
		cbStart.gridx = 0;
		cbStart.gridy = 1;
		cbStart.gridwidth = 1;
		cbStart.gridheight = 1;
		cbStart.fill = GridBagConstraints.HORIZONTAL;
		cbStart.insets = STANDARDINSETS;
		
		contentPane.add(lWelcome, clWelcome);
		contentPane.add(bStart,  cbStart);
		
		pack();
		setLocationRelativeTo(null);
		
	}
	
	private void onClick() {
		Parameters parameters = new Parameters();
		parameters.setVisible(true);
		this.dispose();
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			onClick();
		}
		
	}

}