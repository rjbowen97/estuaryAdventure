package controller;

import javax.swing.JPanel;

import models.Animal;
import models.AnimalType;
import models.Interactable;
import views.View;

public class Controller extends JPanel{
	
    String birdSprite = "sprite.png";
    String fishSprite = "sprite.png";
    String crabSprite = "sprite.png";
    
    
    private Interactable interactables[];
    
    Animal player;
    View view;
	
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
		
		view = new View(player);
	}
	
	public void updateModel() {
	}
	
	public void updateView() {
		view.updateViewModel(player);
		view.frame.repaint();
	}
	
}
