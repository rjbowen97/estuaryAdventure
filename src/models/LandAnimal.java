package models;

import java.awt.event.MouseEvent;

import controller.Settings;

public class LandAnimal extends Player {
	
	@Override
	public void onTick() {
	}
	
	@Override
	public void onClicked(MouseEvent mouseEvent) {
		
		System.out.println(mouseEvent.getY());
		System.out.println("^ mouse event ---- V this.positions");
		System.out.println(this.yPosition);
		System.out.println("----");
		
		if (mouseEvent.getY() > this.yPosition) {
			this.yPosition += Settings.getLandAnimalShuffleSpeed();
		}
		
		else {
			this.yPosition -= Settings.getLandAnimalShuffleSpeed();
		}
	}	
}
