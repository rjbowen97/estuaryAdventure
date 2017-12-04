package models;

import java.io.Serializable;
import java.util.Random;

import controller.Settings;

public class finishLine extends GameModel implements Serializable{
	

	public boolean isInWater = true;
	
	private boolean isFood;	
	
	/** The activation tick. */
	public int activationTick;
	
	/** The is active. */
	public boolean isActive = false;
	
	/** The random. */
	private Random random = new Random();
	

	public finishLine(int activationTick) {
		this.setxPosition(Settings.getInteractableStartXPosition());
		//this.setyPosition(); // -100 because this is the spriteImage height for interactables
		this.setWidth(100);
		this.setHeight(1000);
		this.setSpeed(Settings.getInteractableSpeed());
		this.activationTick = activationTick;
		this.setHitbox();

	}
	
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
	

	@Override
	protected void setHitbox() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateHitbox() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

}
