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
	public int backgroundLayerIndex;

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
		this.setWidth(Settings.getViewDimensionXDefault());
		this.setHeight(Settings.getViewDimensionYDefault());
		this.setSpriteFilePath();
		this.backgroundLayerIndex = backgroundLayerIndex;
		this.setSpeed(Settings.getBackgroundBaseSpeed(backgroundLayerIndex));
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
	
	public String toString(){
		String result =super.toString();
		result += "\nLayer Index: "+ backgroundLayerIndex;
		return result;
	}

	@Override
	protected void setSpriteFilePath() {
		spriteFilePath = "./Graphics/Backgrounds/AirBackground/b" + this.backgroundLayerIndex + ".png";
	}
	
}