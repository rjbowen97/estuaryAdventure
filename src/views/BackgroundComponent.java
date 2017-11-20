package views;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import controller.Settings;
import models.Background;

public class BackgroundComponent extends JComponent{
	
	Background backgroundModel;
	BufferedImage backgroundImage;
	private int mainFrameDimension;
	
	BackgroundComponent(Background backgroundModel){
		
		this.mainFrameDimension = Settings.getViewDimensionDefault();
		this.setBounds(0,0,mainFrameDimension,mainFrameDimension);
		
		this.backgroundModel = backgroundModel;
		
		try {
			File imageFile = new File(backgroundModel.getBackgroundImagePath());
			System.out.println(imageFile.exists());
			backgroundImage = ImageIO.read(imageFile);
		}			
		catch (IOException e) {
			System.out.println(backgroundModel.getBackgroundImagePath());
			e.printStackTrace();
		}
		this.setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(backgroundImage, backgroundModel.getXPosition(), backgroundModel.getYPosition(), null);
	}
	
}