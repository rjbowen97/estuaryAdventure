<<<<<<< HEAD
package views;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import controller.Controller;
import controller.Settings;
import models.Background;

@SuppressWarnings("serial")

class BackgroundComponent extends JComponent{
	private int xPosition, yPosition, backgroundNumber;
	protected BufferedImage backgroundImage;
	
	protected BackgroundComponent(Background model, int modelNumber){
		this.xPosition = Settings.globalSettings.;// - model.getBackgroundWidth();
		this.yPosition = model.getYPosition();
		this.backgroundNumber = modelNumber;
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
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(backgroundImage, xPosition, yPosition, null);
	}
	
	protected void updateComponent(){
		this.xPosition -= 4; //move to left, simulates motion
		this.yPosition++; //not sure what to do yet
		repaint();
	}
	
	
=======
package views;

import java.awt.Graphics;

import javax.swing.JComponent;

import controller.Settings;
import models.Background;

public class BackgroundComponent extends JComponent{
	
	private Background backgroundModel;
	
	BackgroundComponent(Background backgroundModel){
		this.setBounds(0,0,Settings.getViewDimensionXDefault(),Settings.getViewDimensionYDefault());
		this.backgroundModel = backgroundModel;
		this.setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundModel.getSpriteImage(), backgroundModel.getXPosition(), backgroundModel.getYPosition(), null);
		g.drawImage(backgroundModel.getSpriteImage(), backgroundModel.getXPosition() + Settings.getViewDimensionXDefault(), backgroundModel.getYPosition(), null);
		
	}
	
>>>>>>> branch 'workBench' of https://github.com/rjbowenUdel/estuaryAdventure.git
}