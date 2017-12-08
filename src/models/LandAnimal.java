package models;

import java.awt.event.MouseEvent;
import java.io.Serializable;

import controller.Settings;

// TODO: Auto-generated Javadoc
/**
 * The Class LandAnimal.
 */
public class LandAnimal extends Player implements Serializable {
	
	/* (non-Javadoc)
	 * @see models.Player#onTick()
	 */
	@Override
	public void onTick() {
		super.onTick();
	}
	
	/* (non-Javadoc)
	 * @see models.Player#onMouseReleased(java.awt.event.MouseEvent)
	 */
	/* 
	 * On mouse release, find where the mouse was released and if it is above the current animal then the animal rises up, if below the animal goes down
	 * @see models.Player#onMouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void onMouseReleased(MouseEvent mouseEvent) {
		if (mouseEvent.getY() > this.getYPosition()) {
			int newYPosition = this.getYPosition() + Settings.getLandAnimalShuffleSpeed();
			this.setyPosition(newYPosition);
		}
		
		else {
			int newYPosition = this.getYPosition() - Settings.getLandAnimalShuffleSpeed();
			this.setyPosition(newYPosition);
		}
	}
	
	/* (non-Javadoc)
	 * @see models.Player#toString()
	 */
	public String toString(){
		return super.toString() + "\nType: Land Animal"; 
	}
}
