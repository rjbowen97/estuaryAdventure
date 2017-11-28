package models;

import java.io.Serializable;

/**
 * The Class GameModel.
 */
public abstract class GameModel implements Serializable {
	
	/** The x position of the game model */
	public int xPosition;
	
	/** The y position of the game model */
	public int yPosition;

	private int height;
	
	private int width;
	
	
	/** The speed, initially set to 0 */
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
	
	/** Initiate a hitbox for the image */
	private Hitbox hitbox;
	
	
	/**
	 * Sets the hitbox for the image/gamemodel
	 */
	protected abstract void setHitbox();
	
	/**
	 * Update hitbox for image
	 */
	protected abstract void updateHitbox();
	
	public abstract void onTick();
	
	/**
	 * Reset.
	 */
	public abstract void reset();
	
	/**
	 * Gets the hitbox of the image/game model
	 *
	 * @return the hitbox
	 */
	public Hitbox getHitbox() {
		return hitbox;
	}
	
	/**
	 * Sets the hitbox for the image/game model
	 *
	 * @param hitbox which is the new hitbox
	 */
	protected void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}
	
	/**
	 * Gets the x position of the model
	 *
	 * @return the x position
	 */
	public int getXPosition() {
		return this.xPosition;
	}
	
	/**
	 * Gets the y position of the model
	 *
	 * @return the y position
	 */
	public int getYPosition() {
		return this.yPosition;
	}
	
	/**
	 * Gets the speed of the model
	 *
	 * @return the speed
	 */
	public int getSpeed() {
		return this.speed;
	}
	
	/**
	 * Sets the x position of the model
	 *
	 * @param xPosition the new x position
	 */
	protected void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	/**
	 * Sets the y position of the model
	 *
	 * @param yPosition the new y position
	 */
	protected void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	
	/**
	 * Sets the speed of the model
	 *
	 * @param speed the new speed
	 */
	protected void setSpeed(int speed) {
		this.speed = speed;
	}
	/*
	 * toString method to return where the game model is
	 */
	public String toString(){
		String result = "X Position: " + this.getXPosition() + "\nY Position: " + this.getYPosition()+
				"\nSpeed: " + this.getSpeed() + "\n";
		return result;
	}
	
}
