package models;

import java.awt.event.MouseEvent;

import controller.Settings;

public class LandAnimal extends Player {
	
	@Override
	public void onTick() {
		
	}
	
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
