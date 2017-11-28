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
	private BufferedImage spriteImage;
	
	/**
	 * Instantiates a new background component.
	 *
	 * @param backgroundModel the background model
	 */
	BackgroundComponent(Background backgroundModel){
		this.setBounds(0,0,Settings.getViewDimensionXDefault(),Settings.getViewDimensionYDefault());
		this.backgroundModel = backgroundModel;
		this.setVisible(true);
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.spriteImage, backgroundModel.getXPosition(), backgroundModel.getYPosition(), null);
		g.drawImage(this.spriteImage, backgroundModel.getXPosition() + Settings.getViewDimensionXDefault(), backgroundModel.getYPosition(), null);
		
	}
	
	protected void setBackgroundSpriteImage() {
		BufferedImage spriteImageToUse = null;
		
    	File backgroundImageFile = new File("./Graphics/Backgrounds/AirBackground/b" + backgroundModel.backgroundLayerIndex + ".png");
		try {			
			if(backgroundImageFile.exists() == true){
				spriteImageToUse = ImageIO.read(backgroundImageFile);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		this.spriteImage = spriteImageToUse;
	}
}