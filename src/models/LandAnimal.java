package models;

import java.awt.event.MouseEvent;

import controller.Settings;

public class LandAnimal extends Player {
	
	@Override
	public void onTick() {
		
	}
	
	@Override
	public void onMouseReleased(MouseEvent mouseEvent) {
		if (mouseEvent.getY() > this.yPosition) {
			this.yPosition += Settings.getLandAnimalShuffleSpeed();
		}
		
		else {
			this.yPosition -= Settings.getLandAnimalShuffleSpeed();
		}
	}	
}
