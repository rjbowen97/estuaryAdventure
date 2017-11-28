package models;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import controller.Settings;

// TODO: Auto-generated Javadoc
/**
 * The Class Background.
 */
public class Background extends GameModel implements Serializable {

	/** The background layer index. */
	private int backgroundLayerIndex;

	/**
	 * Instantiates a new background.
	 *
	 * @param xPosition the x position
	 * @param yPosition the y position
	 * @param backgroundLayerIndex the background layer index
	 */
	public Background(int xPosition, int yPosition, int backgroundLayerIndex) {
		this.setxPosition(xPosition);
		this.setyPosition(yPosition);
		this.backgroundLayerIndex = backgroundLayerIndex;
		this.setSpeed(Settings.getBackgroundBaseSpeed(backgroundLayerIndex));
		this.setSpriteImage();
	}
	
	/* (non-Javadoc)
	 * @see models.GameModel#setHitbox()
	 */
	@Override
	protected void setHitbox() {
		this.setHitbox(new Hitbox(this));
	}

	/* (non-Javadoc)
	 * @see models.GameModel#updateHitbox()
	 */
	@Override
	protected void updateHitbox() {
		this.getHitbox().update();
		
	}
	
	/* (non-Javadoc)
	 * @see models.GameModel#setSpriteImage()
	 */
	@Override
	protected void setSpriteImage() {
		BufferedImage nonScaledSpriteImageToUse = null;
		
    	File backgroundImageFile = new File("./Graphics/Backgrounds/AirBackground/b" + backgroundLayerIndex + ".png");
		try {			
			if(backgroundImageFile.exists() == true){
				nonScaledSpriteImageToUse = ImageIO.read(backgroundImageFile);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		BufferedImage scaledSpriteImageToUse = ImageScaler.scaleImageToViewSize(nonScaledSpriteImageToUse);
		this.setSpriteImage(scaledSpriteImageToUse);
		
	}
	
	/* (non-Javadoc)
	 * @see models.GameModel#onTick()
	 */
	@Override
	public void onTick() {
		this.updateBackgroundPositions();
	}

	/**
	 * Update background positions.
	 */
	private void updateBackgroundPositions() {
		int newXPosition = this.getXPosition() - this.getSpeed();
		this.setxPosition(newXPosition);
	}

	/* (non-Javadoc)
	 * @see models.GameModel#reset()
	 */
	@Override
	public void reset() {
	}
}