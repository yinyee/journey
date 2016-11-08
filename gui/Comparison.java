package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.Scaler;

public class Comparison extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lCurrent, lCurrentImage, lFutureImage;
	private JLabel lTop, lLeft, lRight, lRotate, lMedicationLabel, lMedication, lExplanationLabel, lExplanation;
	private JComboBox<String> cboxFuture;
	private GridBagConstraints clTop, clLeft, clRight, clRotate, clCurrent, clCurrentImage, ccboxFuture, clFutureImage, clMedicationLabel, clMedication, clExplanationLabel, clExplanation;
	private ComboBoxListener cboxListener;
	private final static String[] FUTURE = {"Current", "After one week", "After one month", "After one year", "After two years"};
	private final static Insets STANDARDINSETS = new Insets(5, 5, 5, 5);
	private int imageWidth = 600;
	private int imageHeight = 400;
	private String folder;

	/**
	 * Create the frame.
	 */
	public Comparison(String direction) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(1000, 550));
		setTitle("Journey");
		contentPane = new JPanel();
		contentPane.setLayout(new GridBagLayout());
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		
		// Set folder
		switch (direction) {
			case "Male to female": {
				folder = "m2f/";
				break;
			}
			case "Female to male": {
				folder = "f2m/";
				break;
			}
		}
		
//		folder = "img/";
		
		// lTop
		lTop = new JLabel(Scaler.getScaledImageIcon("img/top.png", 300, 100));
		lLeft = new JLabel(Scaler.getScaledImageIcon("img/left.png", 500, 50));
		lRight = new JLabel(Scaler.getScaledImageIcon("img/right.png", 500, 50));
		
		// lRotate
		lRotate = new JLabel(Scaler.getScaledImageIcon("img/rotate.jpg", 170, 100));
		
		// Current image
		lCurrent = new JLabel("Current");
		lCurrentImage = new JLabel(Scaler.getScaledImageIcon(folder + "current.png", imageWidth, imageHeight));
		
		// Future image
		cboxFuture = new JComboBox<String>(FUTURE);
		lFutureImage = new JLabel(Scaler.getScaledImageIcon(folder + "current.png", imageWidth, imageHeight));
		
		// ComboBox listener
		cboxListener = new ComboBoxListener();
		cboxFuture.addActionListener(cboxListener);
		
		// Medication
		lMedicationLabel = new JLabel("Medication");
		lMedicationLabel.setFont(lMedicationLabel.getFont().deriveFont(Font.BOLD));
		lMedication = new JLabel(" ");
		
		// Explanation
		lExplanationLabel = new JLabel("Expected physical changes");
		lExplanationLabel.setFont(lExplanationLabel.getFont().deriveFont(Font.BOLD));
		lExplanation = new JLabel(" ");
		
		// GridBagConstraints
		clTop = new GridBagConstraints();
		clLeft = new GridBagConstraints();
		clRight = new GridBagConstraints();
		clRotate = new GridBagConstraints();
		clCurrent = new GridBagConstraints();
		clCurrentImage  = new GridBagConstraints();
		ccboxFuture  = new GridBagConstraints();
		clFutureImage  = new GridBagConstraints();
		clMedicationLabel = new GridBagConstraints();
		clMedication = new GridBagConstraints();
		clExplanationLabel = new GridBagConstraints();
		clExplanation = new GridBagConstraints();
		
		draw();
		
	}
	
	/*
	 * PRIVATE METHODS 
	 */
	
	private String transformSelection() {
		
		String futureImage;
		String selected = cboxFuture.getSelectedItem().toString();
		
		switch (selected) {
			case "Current": {
				futureImage = folder + "current.png";
				break;
			}
			case "After one week": {
				futureImage = folder + "week.png";
				lMedication.setText("4mg of oestrogen per day");
				lExplanation.setText("Heightened sense of smell");
				break;
			}
			case "After one month": {
				futureImage = folder + "month.png";
				lMedication.setText("100mg of spironolactone per day");
				lExplanation.setText("Breast tissue starts to form");
				break;
			}
			case "After one year": {
				futureImage = folder + "year.png";
				lMedication.setText("50mg of cyproterone acetatea per day");
				lExplanation.setText("Reduction in body and facial hair");
				break;
			}
			case "After two years": {
				futureImage = folder + "years.png";
				lMedication.setText("3.75mg of GnRH agonists per day");
				lExplanation.setText("Reduction in height and shoe size");
				break;
			}
			default: {
				futureImage = folder + "current.png";
				break;
			}
		}
		
		return futureImage;
		
	}
	
	private void draw() {
		
		// lTop
		clTop.gridx = 1;
		clTop.gridy = 0;
		clTop.gridwidth = 2;
		clTop.gridheight = 2;
		clTop.fill = GridBagConstraints.HORIZONTAL;
		clTop.fill = GridBagConstraints.VERTICAL;
		clTop.insets = STANDARDINSETS;
		
		// lLeft
		clLeft.gridx = 0;
		clLeft.gridy = 0;
		clLeft.gridwidth = 1;
		clLeft.gridheight = 10;
		clLeft.fill = GridBagConstraints.HORIZONTAL;
		clLeft.fill = GridBagConstraints.VERTICAL;
		clLeft.insets = STANDARDINSETS;
		
		// lRight
		clRight.gridx = 3;
		clRight.gridy = 0;
		clRight.gridwidth = 1;
		clRight.gridheight = 10;
		clRight.fill = GridBagConstraints.HORIZONTAL;
		clRight.fill = GridBagConstraints.VERTICAL;
		clRight.insets = STANDARDINSETS;
		
		// lRotate
		clRotate.gridx = 1;
		clRotate.gridy = 0;
		clRotate.gridwidth = 1;
		clRotate.gridheight = 1;
		clRotate.fill = GridBagConstraints.HORIZONTAL;
		clRotate.fill = GridBagConstraints.VERTICAL;
		clRotate.insets = STANDARDINSETS;
		
		// lCurrent
		clCurrent.gridx = 0;
		clCurrent.gridy = 0;
		clCurrent.gridwidth = 1;
		clCurrent.gridheight = 1;
		clCurrent.fill = GridBagConstraints.HORIZONTAL;
		clCurrent.insets = STANDARDINSETS;
		
		// lCurrentImage
		clCurrentImage.gridx = 0;
		clCurrentImage.gridy = 1;
		clCurrentImage.gridwidth = 1;
		clCurrentImage.gridheight = 5;
		clCurrentImage.fill = GridBagConstraints.HORIZONTAL;
		clCurrentImage.fill = GridBagConstraints.VERTICAL;
		clCurrentImage.insets = STANDARDINSETS;
		
		// cboxFuture
		ccboxFuture.gridx = 1;
		ccboxFuture.gridy = 0;
		ccboxFuture.gridwidth = 1;
		ccboxFuture.gridheight = 1;
		ccboxFuture.fill = GridBagConstraints.HORIZONTAL;
		ccboxFuture.insets = STANDARDINSETS;
		
		// lFutureImage
		clFutureImage.gridx = 1;
		clFutureImage.gridy = 1;
		clFutureImage.gridwidth = 1;
		clFutureImage.gridheight = 5;
		clFutureImage.fill = GridBagConstraints.HORIZONTAL;
		clFutureImage.fill = GridBagConstraints.VERTICAL;
		clFutureImage.insets = STANDARDINSETS;
		
		// lMedicationLabel
		clMedicationLabel.gridx = 0;
		clMedicationLabel.gridy = 6;
		clMedicationLabel.gridwidth = 1;
		clMedicationLabel.gridheight = 1;
		clMedicationLabel.fill = GridBagConstraints.HORIZONTAL;
		clMedicationLabel.insets = STANDARDINSETS;
		
		// lMedication
		clMedication.gridx = 0;
		clMedication.gridy = 7;
		clMedication.gridwidth = 1;
		clMedication.gridheight = 1;
		clMedication.fill = GridBagConstraints.HORIZONTAL;
		clMedication.insets = STANDARDINSETS;
				
		// lExplanationLabel
		clExplanationLabel.gridx = 1;
		clExplanationLabel.gridy = 6;
		clExplanationLabel.gridwidth = 1;
		clExplanationLabel.gridheight = 1;
		clExplanationLabel.fill = GridBagConstraints.HORIZONTAL;
		clExplanationLabel.insets = STANDARDINSETS;
		
		// lExplanation
		clExplanation.gridx = 1;
		clExplanation.gridy = 7;
		clExplanation.gridwidth = 1;
		clExplanation.gridheight = 1;
		clExplanation.fill = GridBagConstraints.HORIZONTAL;
		clExplanation.insets = STANDARDINSETS;
		
		// Add components to content pane
		Container container = this.getContentPane();
//		container.add(lTop, clTop);
//		container.add(lLeft, clLeft);
//		container.add(lRight, clRight);
//		container.add(lRotate, clRotate);
		container.add(lCurrent, clCurrent);
		container.add(lCurrentImage, clCurrentImage);
		container.add(cboxFuture, ccboxFuture);
		container.add(lFutureImage, clFutureImage);
		container.add(lMedicationLabel, clMedicationLabel);
		container.add(lMedication, clMedication);
		container.add(lExplanationLabel, clExplanationLabel);
		container.add(lExplanation, clExplanation);
		
		pack();
		setLocationRelativeTo(null);
		
	}
	
//private void draw() {
//		
//		// lTop
//		clTop.gridx = 1;
//		clTop.gridy = 0;
//		clTop.gridwidth = 2;
//		clTop.gridheight = 1;
//		clTop.fill = GridBagConstraints.HORIZONTAL;
//		clTop.fill = GridBagConstraints.VERTICAL;
//		clTop.insets = STANDARDINSETS;
//		
//		// lLeft
//		clLeft.gridx = 0;
//		clLeft.gridy = 0;
//		clLeft.gridwidth = 1;
//		clLeft.gridheight = 10;
//		clLeft.fill = GridBagConstraints.HORIZONTAL;
//		clLeft.fill = GridBagConstraints.VERTICAL;
//		clLeft.insets = STANDARDINSETS;
//		
//		// lRight
//		clRight.gridx = 3;
//		clRight.gridy = 0;
//		clRight.gridwidth = 1;
//		clRight.gridheight = 10;
//		clRight.fill = GridBagConstraints.HORIZONTAL;
//		clRight.fill = GridBagConstraints.VERTICAL;
//		clRight.insets = STANDARDINSETS;
//		
//		// lRotate
//		clRotate.gridx = 1;
//		clRotate.gridy = 0;
//		clRotate.gridwidth = 1;
//		clRotate.gridheight = 1;
//		clRotate.fill = GridBagConstraints.HORIZONTAL;
//		clRotate.fill = GridBagConstraints.VERTICAL;
//		clRotate.insets = STANDARDINSETS;
//		
//		// lCurrent
//		clCurrent.gridx = 1;
//		clCurrent.gridy = 1;
//		clCurrent.gridwidth = 1;
//		clCurrent.gridheight = 1;
//		clCurrent.fill = GridBagConstraints.HORIZONTAL;
//		clCurrent.insets = STANDARDINSETS;
//		
//		// lCurrentImage
//		clCurrentImage.gridx = 1;
//		clCurrentImage.gridy = 2;
//		clCurrentImage.gridwidth = 1;
//		clCurrentImage.gridheight = 5;
//		clCurrentImage.fill = GridBagConstraints.HORIZONTAL;
//		clCurrentImage.fill = GridBagConstraints.VERTICAL;
//		clCurrentImage.insets = STANDARDINSETS;
//		
//		// cboxFuture
//		ccboxFuture.gridx = 2;
//		ccboxFuture.gridy = 1;
//		ccboxFuture.gridwidth = 1;
//		ccboxFuture.gridheight = 1;
//		ccboxFuture.fill = GridBagConstraints.HORIZONTAL;
//		ccboxFuture.insets = STANDARDINSETS;
//		
//		// lFutureImage
//		clFutureImage.gridx = 2;
//		clFutureImage.gridy = 2;
//		clFutureImage.gridwidth = 1;
//		clFutureImage.gridheight = 5;
//		clFutureImage.fill = GridBagConstraints.HORIZONTAL;
//		clFutureImage.fill = GridBagConstraints.VERTICAL;
//		clFutureImage.insets = STANDARDINSETS;
//		
//		// lMedicationLabel
//		clMedicationLabel.gridx = 1;
//		clMedicationLabel.gridy = 7;
//		clMedicationLabel.gridwidth = 1;
//		clMedicationLabel.gridheight = 1;
//		clMedicationLabel.fill = GridBagConstraints.HORIZONTAL;
//		clMedicationLabel.insets = STANDARDINSETS;
//		
//		// lMedication
//		clMedication.gridx = 1;
//		clMedication.gridy = 8;
//		clMedication.gridwidth = 1;
//		clMedication.gridheight = 1;
//		clMedication.fill = GridBagConstraints.HORIZONTAL;
//		clMedication.insets = STANDARDINSETS;
//				
//		// lExplanationLabel
//		clExplanationLabel.gridx = 2;
//		clExplanationLabel.gridy = 7;
//		clExplanationLabel.gridwidth = 1;
//		clExplanationLabel.gridheight = 1;
//		clExplanationLabel.fill = GridBagConstraints.HORIZONTAL;
//		clExplanationLabel.insets = STANDARDINSETS;
//		
//		// lExplanation
//		clExplanation.gridx = 2;
//		clExplanation.gridy = 8;
//		clExplanation.gridwidth = 1;
//		clExplanation.gridheight = 1;
//		clExplanation.fill = GridBagConstraints.HORIZONTAL;
//		clExplanation.insets = STANDARDINSETS;
//		
//		// Add components to content pane
//		Container container = this.getContentPane();
//		container.add(lTop, clTop);
//		container.add(lLeft, clLeft);
//		container.add(lRight, clRight);
////		container.add(lRotate, clRotate);
//		container.add(lCurrent, clCurrent);
//		container.add(lCurrentImage, clCurrentImage);
//		container.add(cboxFuture, ccboxFuture);
//		container.add(lFutureImage, clFutureImage);
//		container.add(lMedicationLabel, clMedicationLabel);
//		container.add(lMedication, clMedication);
//		container.add(lExplanationLabel, clExplanationLabel);
//		container.add(lExplanation, clExplanation);
//		
//		pack();
//		setLocationRelativeTo(null);
//		
//	}
	
	private void refresh() {
		String selected = transformSelection();
		lFutureImage.setIcon(Scaler.getScaledImageIcon(selected, imageWidth, imageHeight));
		this.validate();
	}
	
	/*
	 * PRIVATE CLASSES 
	 */
	private class ComboBoxListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refresh();
		}
	}

}