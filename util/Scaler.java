package util;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import gui.Comparison;

public class Scaler {
	
	public static ImageIcon getScaledImageIcon(String filename, int width, int height) {
		
		File file;
		ImageIcon icon = new ImageIcon();
		Image unscaled, scaled;
		try {
			file = new File(Comparison.class.getClassLoader().getResource(filename).toURI());
			icon = new ImageIcon(file.toString());
			unscaled = icon.getImage();
			scaled = unscaled.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(scaled);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return icon;
	}

}
