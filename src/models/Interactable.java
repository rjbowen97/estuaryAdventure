package models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

import javax.imageio.ImageIO;

import controller.Settings;

// TODO: Auto-generated Javadoc
/**
 * The Class Interactable.
 */
public class Interactable extends GameModel implements Serializable {

	private boolean isFood;	
	
	/** The activation tick. */
	private int activationTick;
	
	/** The is active. */
	private boolean isActive = false;
	
	/** The random. */
	private Random random = new Random();
	
	/**
	 * Creates a new interactable, determines its position and whether or not it is food
	 *
	 * @param activationTick the activation tick
	 */
	public Interactable(int activationTick) {
		this.setxPosition(Settings.getInteractableStartXPosition());
		this.setyPosition(random.nextInt(Settings.getViewDimensionYDefault() - 100)); // -100 because this is the spriteImage height for interactables
		this.setWidth(50);
		this.setHeight(50);
		
		this.isFood = random.nextBoolean();
		this.setSpeed(Settings.getInteractableSpeed());
		this.activationTick = activationTick;
		this.setHitbox();
	}
	
	/* (non-Javadoc)
	 * @see models.GameModel#setSpriteImage()
	 */
	
	/**
	 * On collision with player model eliminate the interactable
	 *
	 * @param playerModel the player model
	 */
	public void onCollisionWithPlayerModel(Player playerModel) {
		this.deactivate();
	}
	
	/**
	 * Deactivate
	 */
	private void deactivate() {
		this.isActive = false;
	}
	
	/**
	 * Activate.
	 */
	public void activate() {
		this.isActive = true;
	}
	
	/**
	 * Checks if is food.
	 *
	 * @return true, if is food
	 */
	public boolean isFood() {
		return isFood;
	}
	
	/**
	 * Checks if is active.
	 *
	 * @return true, if is active
	 */
	public boolean isActive() {
		return this.isActive;
	}
	
	/**
	 * Gets the activation tick.
	 *
	 * @return the activation tick
	 */
	public int getActivationTick() {
		return this.activationTick;
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
	 * @see models.GameModel#onTick()
	 */
	@Override
	public void onTick() {
		int newXPosition = this.getXPosition() - this.getSpeed();
		this.setxPosition(newXPosition);
		this.updateHitbox();
	}

	/* (non-Javadoc)
	 * @see models.GameModel#reset()
	 */
	@Override
	public void reset() {
	}
	
	
	public String toString(){
		return super.toString() + "Is Active: " + this.isActive + "\nIs Food: " + this.isFood + 
				"\nActivation Tick: " + this.activationTick;
	}

	@Override
	protected void setSpriteFilePath() {
		this.spriteFilePath = "";
	}
	
	
}