package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.JSON;
import util.Scaler;

public class Parameters extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lTop, lSide, lDirection, lAge, lWeight, lHeight, lRace;
	private JTextField tAge, tWeight, tHeight;
	private JComboBox<String> cboxDirection, cboxRace;
	private JButton bRender;
	private GridBagConstraints clTop, clSide, clDirection, ccboxDirection, clAge, ctAge, clWeight, clHeight, clRace, ctWeight, ctHeight, ccboxRace, cbRender;
	private final static String[] DIRECTION = {"Male to female", "Female to male"};
	private final static double[] INCREASING = {0.0, 0.1, 0.3, 0.7, 1.0};
	private final static double[] DECREASING = {1.0, 0.7, 0.3, 0.1, 0.0};
	private final static String[] RACE = {"African", "Asian", "Caucasian"};
	private final static Insets STANDARDINSETS = new Insets(5, 5, 5, 5);

	/**
	 * Create the frame.
	 */
	public Parameters() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(1000, 700));
		setTitle("Journey");
		contentPane = new JPanel();
		contentPane.setLayout(new GridBagLayout());
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		
		// Images
		lTop = new JLabel(Scaler.getScaledImageIcon("img/top.jpg", 350, 200));
		lSide = new JLabel(Scaler.getScaledImageIcon("img/side.gif", 400, 500));
		
		// Direction
		lDirection = new JLabel("Direction");
		cboxDirection = new JComboBox<String>(DIRECTION);
		
		// Age
		lAge = new JLabel("Age (years)");
		tAge = new JTextField();
		
		// Weight
		lWeight = new JLabel("Weight (kg)");
		tWeight = new JTextField();
		
		// Height
		lHeight = new JLabel("Height (cm)");
		tHeight = new JTextField();
		
		// Preset
		lRace = new JLabel("Race");
		cboxRace = new JComboBox<String>(RACE);
		
		// Render
		bRender = new JButton("Render");
		bRender.addActionListener(new ButtonListener());
		
		// Constraints
		clTop = new GridBagConstraints();
		clSide = new GridBagConstraints();
		clDirection = new GridBagConstraints();
		ccboxDirection = new GridBagConstraints();
		clAge = new GridBagConstraints();
		ctAge = new GridBagConstraints();
		clWeight = new GridBagConstraints();
		ctWeight = new GridBagConstraints();
		clHeight = new GridBagConstraints();
		ctHeight = new GridBagConstraints();
		clRace = new GridBagConstraints();
		ccboxRace = new GridBagConstraints();
		cbRender = new GridBagConstraints();
		
		draw();
		
	}
	
	/*
	 * PRIVATE METHODS
	 */
	
	private void render() {
		
		// Get input parameters
		// TODO SANITISE INPUTS
		String direction = cboxDirection.getSelectedItem().toString();
		double age = Double.valueOf(tAge.getText());
		double weight = Double.valueOf(tWeight.getText());
		double height = Double.valueOf(tHeight.getText());
		String race = cboxRace.getSelectedItem().toString();
		
		// Normalise input parameters
		age = age / 100;
		weight = (weight - 30) / (100 - 30);
		height = (height - 130) / (200 - 130);
		
		double gender = 0.0;
		double[] muscle = INCREASING, breastSize = INCREASING, breastVolume = INCREASING, headOval = INCREASING;
		
		switch (direction) {
			case "Male to female": {
				gender = 1.0;
				muscle = DECREASING;
				breastSize = INCREASING;
				breastVolume = INCREASING;
				headOval = INCREASING;
				break;
			}
			case "Female to male": {
				gender = 0.0;
				muscle = INCREASING;
				breastSize = DECREASING;
				breastVolume = DECREASING;
				headOval = DECREASING;
				break;
			}
		}
		
		double african = 0.0, asian = 0.0, caucasian = 0.0;
		switch (race) {
			case "African": {
				african = 1.0;
				asian = 0.0;
				caucasian = 0.0;
				break;
			}
			case "Asian": {
				african = 0.0;
				asian = 1.0;
				caucasian = 0.0;
				break;
			}
			case "Caucasian": {
				african = 0.0;
				asian = 0.0;
				caucasian = 1.0;
				break;
			}
		}
		
		// Pass JSON parameters to MakeHuman engine
		JSON json = new JSON(age, weight, height, gender, african, asian, caucasian, muscle, breastSize, breastVolume, headOval);
		json.jsonify();
		
		// Launch Comparison
		Comparison journey = new Comparison(cboxDirection.getSelectedItem().toString());
		journey.setVisible(true);
		this.dispose();
	}
	
	private void draw() {
		
		// lTop
		clTop.gridx = 0;
		clTop.gridy = 0;
		clTop.gridwidth = 2;
		clTop.gridheight = 1;
		clTop.fill = GridBagConstraints.HORIZONTAL;
		clTop.fill = GridBagConstraints.VERTICAL;
		clTop.insets = STANDARDINSETS;
		
		// lSide
		clSide.gridx = 2;
		clSide.gridy = 0;
		clSide.gridwidth = 1;
		clSide.gridheight = 7;
		clSide.fill = GridBagConstraints.HORIZONTAL;
		clSide.fill = GridBagConstraints.VERTICAL;
		clSide.insets = STANDARDINSETS;
		
		// lDirection
		clDirection.gridx = 0;
		clDirection.gridy = 1;
		clDirection.gridwidth = 1;
		clDirection.gridheight = 1;
		clDirection.fill = GridBagConstraints.HORIZONTAL;
		clDirection.insets = STANDARDINSETS;
		
		// cboxDirection
		ccboxDirection.gridx = 1;
		ccboxDirection.gridy = 1;
		ccboxDirection.gridwidth = 1;
		ccboxDirection.gridheight = 1;
		ccboxDirection.fill = GridBagConstraints.HORIZONTAL;
		ccboxDirection.insets = STANDARDINSETS;
		
		// lAge
		clAge.gridx = 0;
		clAge.gridy = 2;
		clAge.gridwidth = 1;
		clAge.gridheight = 1;
		clAge.fill = GridBagConstraints.HORIZONTAL;
		clAge.insets = STANDARDINSETS;
		
		// tAge
		ctAge.gridx = 1;
		ctAge.gridy = 2;
		ctAge.gridwidth = 1;
		ctAge.gridheight = 1;
		ctAge.fill = GridBagConstraints.HORIZONTAL;
		ctAge.insets = STANDARDINSETS;
		
		// lWeight
		clWeight.gridx = 0;
		clWeight.gridy = 3;
		clWeight.gridwidth = 1;
		clWeight.gridheight = 1;
		clWeight.fill = GridBagConstraints.HORIZONTAL;
		clWeight.insets = STANDARDINSETS;
		
		// tWeight
		ctWeight.gridx = 1;
		ctWeight.gridy = 3;
		ctWeight.gridwidth = 1;
		ctWeight.gridheight = 1;
		ctWeight.fill = GridBagConstraints.HORIZONTAL;
		ctWeight.insets = STANDARDINSETS;
		
		// lHeight
		clHeight.gridx = 0;
		clHeight.gridy = 4;
		clHeight.gridwidth = 1;
		clHeight.gridheight = 1;
		clHeight.fill = GridBagConstraints.HORIZONTAL;
		clHeight.insets = STANDARDINSETS;
		
		// tHeight
		ctHeight.gridx = 1;
		ctHeight.gridy = 4;
		ctHeight.gridwidth = 1;
		ctHeight.gridheight = 1;
		ctHeight.fill = GridBagConstraints.HORIZONTAL;
		ctHeight.insets = STANDARDINSETS;
		
		// lRace
		clRace.gridx = 0;
		clRace.gridy = 5;
		clRace.gridwidth = 1;
		clRace.gridheight = 1;
		clRace.fill = GridBagConstraints.HORIZONTAL;
		clRace.insets = STANDARDINSETS;
		
		// cboxRace
		ccboxRace.gridx = 1;
		ccboxRace.gridy = 5;
		ccboxRace.gridwidth = 1;
		ccboxRace.gridheight = 1;
		ccboxRace.fill = GridBagConstraints.HORIZONTAL;
		ccboxRace.insets = STANDARDINSETS;
		
		// cbRender
		cbRender.gridx = 1;
		cbRender.gridy = 6;
		cbRender.gridwidth = 1;
		cbRender.gridheight = 1;
		cbRender.fill = GridBagConstraints.HORIZONTAL;
		cbRender.insets = STANDARDINSETS;
		
		Container container = this.getContentPane();
		container.add(lTop, clTop);
		container.add(lSide, clSide);
		container.add(lDirection, clDirection);
		container.add(cboxDirection, ccboxDirection);
		container.add(lAge, clAge);
		container.add(tAge, ctAge);
		container.add(lWeight, clWeight);
		container.add(tWeight, ctWeight);
		container.add(lHeight, clHeight);
		container.add(tHeight, ctHeight);
//		container.add(lRace, clRace);
//		container.add(cboxRace, ccboxRace);
		container.add(bRender, cbRender);
		
		pack();
		setLocationRelativeTo(null);
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			render();
		}
		
	}

}