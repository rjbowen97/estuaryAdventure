package models;

import java.io.Serializable;

/**
 * An abstract class inherited by all models in the game
 */
public abstract class GameModel implements Serializable {
	
	/**  The x position of the game model. */
	public int xPosition;
	
	/**  The y position of the game model. */
	public int yPosition;

	/** The height. */
	private int height;
	
	/** The width. */
	private int width;
	
	/**  The speed, initially set to 0. */
	protected int speed = 0;
	
	/**  The hitbox. */
	private Hitbox hitbox;
	
	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width.
	 *
	 * @param width the new width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Sets the hitbox for the gamemodel based on its width and height.
	 */
	protected abstract void setHitbox();
	
	/**
	 * Updates the game models' hitbox position.
	 */
	protected abstract void updateHitbox();
	
	/**
	 * What the model is to perform when ticked.
	 */
	public abstract void onTick();
	
	/**
	 * Resets the model to a state as if it was just created
	 */
	public abstract void reset();
	
	/**
	 * Gets the hitbox of the game model.
	 *
	 * @return the hitbox
	 */
	public Hitbox getHitbox() {
		return hitbox;
	}
	
	/**
	 * Sets the hitbox for the game model.
	 *
	 * @param hitbox which is the new hitbox
	 */
	protected void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}
	
	/**
	 * Gets the x position of the model.
	 *
	 * @return the x position
	 */
	public int getXPosition() {
		return this.xPosition;
	}
	
	/**
	 * Gets the y position of the model.
	 *
	 * @return the y position
	 */
	public int getYPosition() {
		return this.yPosition;
	}
	
	/**
	 * Gets the speed of the model.
	 *
	 * @return the speed
	 */
	public int getSpeed() {
		return this.speed;
	}
	
	/**
	 * Sets the x position of the model.
	 *
	 * @param xPosition the new x position
	 */
	protected void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	/**
	 * Sets the y position of the model.
	 *
	 * @param yPosition the new y position
	 */
	protected void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	
	/**
	 * Sets the speed of the model.
	 *
	 * @param speed the new speed
	 */
	public void setSpeed(int speed) {
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
