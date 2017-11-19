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
	private int xPosition, yPosition;
	BufferedImage backgroundImage;
	private int mainFrameDimension;
	
	BackgroundComponent(Background model){
		
		this.mainFrameDimension = Integer.parseInt(Settings.globalSettings.getProperty("mainFrameDimension"));
		
		this.xPosition = mainFrameDimension - model.getBackgroundWidth();
		this.yPosition = model.getYPosition();
		
		this.setSize(mainFrameDimension,mainFrameDimension);
		
		try {
			File imageFile = new File(model.getBackgroundImagefileName());
			System.out.println(imageFile.exists());
			backgroundImage = ImageIO.read(imageFile);
		}			
		catch (IOException e) {
			System.out.println(model.getBackgroundImagefileName());
			e.printStackTrace();
		}
		this.setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(backgroundImage, xPosition, yPosition, null);
	}
	
	void updateComponent(){
		this.xPosition -= 4; //move to left, simulates motion
		this.yPosition++; //not sure what to do yet
		repaint();
	}
	
	
}