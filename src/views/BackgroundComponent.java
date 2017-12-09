package views;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import controller.Settings;
import models.Background;

// TODO: Auto-generated Javadoc
/**
 * The Class BackgroundComponent.
 */
public class BackgroundComponent extends JComponent implements Serializable {
	
	/** The background model. */
	private Background backgroundModel;
	
	/** The air background image. */
	private transient BufferedImage airBackgroundImage;
	
	/** The water background image. */
	private transient BufferedImage waterBackgroundImage;
	
	/**
	 * Instantiates a new background component. Allows us to switch between air and water levels
	 *
	 * @param backgroundModel the background model, air or water
	 */
	BackgroundComponent(Background backgroundModel){
		this.setBounds(0,0,Settings.getViewDimensionXDefault(),Settings.getViewDimensionYDefault());
		this.backgroundModel = backgroundModel;
		setBackgroundSpriteImage();
		this.setVisible(true);
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (backgroundModel.backgroundType.equals("a")) {
			g.drawImage(this.airBackgroundImage, backgroundModel.getXPosition(), backgroundModel.getYPosition(), null);
			g.drawImage(this.airBackgroundImage, backgroundModel.getXPosition() + Settings.getViewDimensionXDefault(), backgroundModel.getYPosition(), null);
		}
		
		else {
			g.drawImage(this.waterBackgroundImage, backgroundModel.getXPosition(), backgroundModel.getYPosition(), null);
			g.drawImage(this.waterBackgroundImage, backgroundModel.getXPosition() + Settings.getViewDimensionXDefault(), backgroundModel.getYPosition(), null);
		}
	}
	
	/**
	 * Sets the background sprite image. Air or Water, Scales the background image properly to fit the screen
	 */
	public void setBackgroundSpriteImage() {
		String airBackgroundFilePath = "./Graphics/Backgrounds/AirBackground/b" + backgroundModel.backgroundLayerIndex + ".png";
		String waterBackgroundFilePath = "./Graphics/Backgrounds/WaterBackground/b" + backgroundModel.backgroundLayerIndex + ".png";
		
		ImageScaler imageScaler = new ImageScaler();
		
		BufferedImage unscaledAirImage = null;
		BufferedImage unscaledWaterImage = null;
		
    	File airBackgroundImageFile = new File(airBackgroundFilePath);
    	File waterBackgroundImageFile = new File(waterBackgroundFilePath);
    	
		try {			
			if (airBackgroundImageFile.exists() == true){
				unscaledAirImage = ImageIO.read(airBackgroundImageFile);
			}
			
			if (waterBackgroundImageFile.exists() == true){
				unscaledWaterImage = ImageIO.read(waterBackgroundImageFile);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		double xRatio = ((double) this.backgroundModel.getWidth()) / ((double) unscaledAirImage.getWidth());
		double yRatio = ((double) this.backgroundModel.getHeight()) / ((double) unscaledAirImage.getHeight());
		BufferedImage scaledAirSpriteImage = imageScaler.scaleImageToInputRatio(unscaledAirImage, xRatio, yRatio);
		
		xRatio = ((double) this.backgroundModel.getWidth()) / ((double) unscaledWaterImage.getWidth());
		yRatio = ((double) this.backgroundModel.getHeight()) / ((double) unscaledWaterImage.getHeight());
		BufferedImage scaledWaterSpriteImage = imageScaler.scaleImageToInputRatio(unscaledWaterImage, xRatio, yRatio);
		
		this.airBackgroundImage = scaledAirSpriteImage;
		this.waterBackgroundImage = scaledWaterSpriteImage;
		
	}
}