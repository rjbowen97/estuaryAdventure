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
}
