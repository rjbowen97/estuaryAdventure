package models;

import java.io.Serializable;
import java.util.Random;

import controller.Controller;
import controller.Settings;

// TODO: Auto-generated Javadoc
/**
 * The Class finishLine.
 */
public class finishLine extends Interactable implements Serializable{
	
	/** The controller. */
	public Controller controller;
	
	/** The is in water. */
	public boolean isInWater = true;
	
	/** The is food. */
	private boolean isFood;	
	
	/** The activation tick. */
	public int activationTick;
	
	/** The is active. */
	public boolean isActive = false;
	
	/** The random. */
	private Random random = new Random();
	

	/**
	 * Instantiates a new finish line.
	 *
	 * @param activationTick the activation tick
	 * @param controller the controller
	 */
	public finishLine(int activationTick, Controller controller) {
		this.setxPosition(Settings.getInteractableStartXPosition());
		this.setyPosition(0);
		this.setWidth(200);
		this.setHeight(Settings.getViewDimensionYDefault());
		this.setSpeed(Settings.getInteractableSpeed());
		this.activationTick = activationTick;
		this.setHitbox();
		this.isFood = false;
		this.controller = controller;

	}
	
	/* (non-Javadoc)
	 * @see models.Interactable#onCollisionWithPlayerModel(models.Player)
	 */
	@Override 
	public void onCollisionWithPlayerModel(Player playerModel) {
		playerModel.score += 1;
		playerModel.health -= 1;
	}
	/**
	 * Checks if is active.
	 * @return true, if is active
	 */
	public boolean isActive() {
		return this.isActive;
	}
	/**
	 * Checks if is food.
	 * @return true, if is food
	 */
	public boolean isFood() {
		return isFood;
	}
	/**
	 * Gets the activation tick.
	 * @return the activation tick
	 */
	
	public int getActivationTick() {
		return this.activationTick;
	}
	
	/**
	 * Deactivate.
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
	

	/* (non-Javadoc)
	 * @see models.Interactable#setHitbox()
	 */
	@Override
	protected void setHitbox() {
		this.setHitbox(new Hitbox(this));		
	}

	/* (non-Javadoc)
	 * @see models.Interactable#updateHitbox()
	 */
	@Override
	protected void updateHitbox() {
		this.getHitbox().update();		
	}

	/* (non-Javadoc)
	 * @see models.Interactable#onTick()
	 */
	@Override
	public void onTick() {
		int newXPosition = this.getXPosition() - this.getSpeed();
		this.setxPosition(newXPosition);
		this.updateHitbox();
	}

	/* (non-Javadoc)
	 * @see models.Interactable#reset()
	 */
	@Override
	public void reset() {
	}

}
