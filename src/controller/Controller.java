package controller;

import javax.swing.JPanel;

import models.Animal;
import models.AnimalType;
import models.Interactable;
import views.View;

public class Controller extends JPanel{

	private final static int frameWidth = 500;
	private final static int frameHeight = 300;
	private final static int imgWidth = 165;
	private final static int imgHeight = 165;
    final static int frameCount = 10;
    private static Animal player;
    
    String birdSprite = "sprite.png";
    String fishSprite = "sprite.png";
    String crabSprite = "sprite.png";
    
    
    private Interactable interactables[];
    
    Animal currentAnimalModel;
    View mainView;
	
	public Controller(AnimalType animalType, int foodCount, int enemyCount) {
		
		if (animalType == AnimalType.BIRD){
			player = new Animal(birdSprite);
		}
		
		else if (animalType == AnimalType.FISH){
			player = new Animal(fishSprite);
		}
		
		else if (animalType == AnimalType.CRAB){
			player = new Animal(crabSprite);
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
