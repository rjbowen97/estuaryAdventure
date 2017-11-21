package models;

import java.awt.event.MouseEvent;

import controller.Settings;

public class NonLandAnimal extends Player {
	
	@Override
	public void onTick() {
		super.onTick();
		this.fallDown();
	}
	
	private void fallDown() {
		int newYPosition = this.getYPosition() + Settings.getNonLandAnimalFallSpeed();
		this.setyPosition(newYPosition);
	}
	
	@Override
	public void onMouseReleased(MouseEvent mouseEvent) {
		this.flap();
	}
	
	private void flap() {
		int newYPosition = this.getYPosition() - Settings.getNonLandAnimalFlapSpeed();
		this.setyPosition(newYPosition);
	}
}