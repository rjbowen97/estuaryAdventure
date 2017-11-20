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
	
	private Background backgroundModel;
	private int mainFrameDimension;
	
	BackgroundComponent(Background backgroundModel){
		
		this.mainFrameDimension = Settings.getViewDimensionDefault();
		this.setBounds(0,0,mainFrameDimension,mainFrameDimension);
		this.backgroundModel = backgroundModel;
		this.setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(backgroundModel.getSpriteImage(), backgroundModel.getXPosition(), backgroundModel.getYPosition(), null);
	}
	
}