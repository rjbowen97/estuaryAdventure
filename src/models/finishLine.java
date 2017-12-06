package models;

import java.io.Serializable;
import java.util.Random;

import controller.Controller;
import controller.Settings;

public class finishLine extends Interactable implements Serializable{
	
	public Controller controller;
	public boolean isInWater = true;
	
	private boolean isFood;	
	
	/** The activation tick. */
	public int activationTick;
	
	/** The is active. */
	public boolean isActive = false;
	
	/** The random. */
	private Random random = new Random();
	

	public finishLine(int activationTick, Controller controller) {
		this.setxPosition(Settings.getInteractableStartXPosition());
		this.setyPosition(0);
		this.setWidth(100);
		this.setHeight(Settings.getViewDimensionYDefault());
		this.setSpeed(Settings.getInteractableSpeed());
		this.activationTick = activationTick;
		this.setHitbox();
		this.isFood = false;
		this.controller = controller;

	}
	@Override 
	public void onCollisionWithPlayerModel(Player playerModel) {
		playerModel.score += 1;
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
	

	@Override
	protected void setHitbox() {
		this.setHitbox(new Hitbox(this));		
	}

	@Override
	protected void updateHitbox() {
		this.getHitbox().update();		
	}

	@Override
	public void onTick() {
		int newXPosition = this.getXPosition() - this.getSpeed();
		this.setxPosition(newXPosition);
		this.updateHitbox();
	}

	@Override
	public void reset() {
	}

}
