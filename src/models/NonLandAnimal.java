package models;

import java.awt.event.MouseEvent;
import java.io.Serializable;

import controller.Settings;

/**
 * The Class NonLandAnimal.
 */
public class NonLandAnimal extends Player implements Serializable {
	
	/* (non-Javadoc)
	 * @see models.Player#onTick()
	 */
	@Override
	public void onTick() {
		super.onTick();
		this.fallDown();
	}
	
	/**
	 * Fall down, which brings the player down a set amount each tick
	 */
	private void fallDown() {
		int newYPosition = this.getYPosition() + Settings.getNonLandAnimalFallSpeed();
		this.setyPosition(newYPosition);
	}
	
	/* (non-Javadoc)
	 * @see models.Player#onMouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void onMouseReleased(MouseEvent mouseEvent) {
		this.flap();
	}
	
	/**
	 * Flap, which moves the player up by a set amount
	 */
	private void flap() {
		int newYPosition = this.getYPosition() - Settings.getNonLandAnimalFlapSpeed();
		this.setyPosition(newYPosition);
	}
	
	/* (non-Javadoc)
	 * @see models.Player#toString()
	 */
	public String toString(){
		return super.toString() + "\nType: Non-Land Animal";
	}
	
}