package controller;

import javax.swing.JPanel;

import models.Animal;
import models.AnimalType;
import models.Interactable;

public class Controller extends JPanel{

	private final static int frameWidth = 500;
	private final static int frameHeight = 300;
	private final static int imgWidth = 165;
	private final static int imgHeight = 165;
    final static int frameCount = 10;
    private static Animal player;
    
    private Interactable interactables[];
	
	public Controller(AnimalType animalType, int foodCount, int enemyCount) {
		if (animalType == AnimalType.BIRD){
			player = new Animal();
		}
		
		else if (animalType == AnimalType.FISH){
			player = new Animal();
		}
		
		else if (animalType == AnimalType.CRAB){
			player = new Animal();
		}
		
	}

	public static int getFramewidth() {
		return frameWidth;
	}

	public static int getFrameheight() {
		return frameHeight;
	}

	public static int getImgheight() {
		return imgHeight;
	}

	public static int getImgwidth() {
		return imgWidth;
	}

}
