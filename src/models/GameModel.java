package models;

import java.awt.image.BufferedImage;
import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class GameModel.
 */
public abstract class GameModel implements Serializable {
	
	/** The x position. */
	private int xPosition;
	
	/** The y position. */
	private int yPosition;

	private int height;
	
	private int width;
	
	/** The sprite image. */
	public String spriteFilePath;
	
	/** The speed. */
	private int speed = 0;
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	/** The hitbox. */
	private Hitbox hitbox;
	
	/**
	 * Sets the sprite image.
	 */
	protected abstract void setSpriteFilePath();
	
	/**
	 * Sets the hitbox.
	 */
	protected abstract void setHitbox();
	
	/**
	 * Update hitbox.
	 */
	protected abstract void updateHitbox();
	
	/**
	 * On tick.
	 */
	public abstract void onTick();
	
	/**
	 * Reset.
	 */
	public abstract void reset();
	
	/**
	 * Gets the hitbox.
	 *
	 * @return the hitbox
	 */
	public Hitbox getHitbox() {
		return hitbox;
	}
	
	/**
	 * Sets the hitbox.
	 *
	 * @param hitbox the new hitbox
	 */
	protected void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}
	
	/**
	 * Gets the x position.
	 *
	 * @return the x position
	 */
	public int getXPosition() {
		return this.xPosition;
	}
	
	/**
	 * Gets the y position.
	 *
	 * @return the y position
	 */
	public int getYPosition() {
		return this.yPosition;
	}
	
	/**
	 * Gets the speed.
	 *
	 * @return the speed
	 */
	public int getSpeed() {
		return this.speed;
	}
	
	/**
	 * Sets the x position.
	 *
	 * @param xPosition the new x position
	 */
	protected void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	/**
	 * Sets the y position.
	 *
	 * @param yPosition the new y position
	 */
	protected void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	
	/**
	 * Sets the speed.
	 *
	 * @param speed the new speed
	 */
	protected void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public String toString(){
		String result = "X Position: " + this.getXPosition() + "\nY Position: " + this.getYPosition()+
				"\nSpeed: " + this.getSpeed() + "\n";
		return result;
	}
	
}
