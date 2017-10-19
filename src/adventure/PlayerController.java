package Controller;

import javax.swing.JPanel;
import Model.Interactable;
import Model.Animal;
import Model.Arena;
import Model.Bird;
import Model.Crab;
import Model.Fish;

public class PlayerController extends JPanel{

	private final static int frameWidth = 500;
	private final static int frameHeight = 300;
	private final static int imgWidth = 165;
	private final static int imgHeight = 165;
    final static int frameCount = 10;
    private static Animal player;
    
    private Interactable interactables[];
	
	public PlayerController(int animal_type, int num_food, int num_enemies) {
		if(animal_type < 1){
			//Bird
			player = new Bird();
			
		}else if(animal_type < 2){
			//Fish
			player = new Fish();
		}else{
			//Crab
			player = new Crab();
		}
		
		
	}

}
