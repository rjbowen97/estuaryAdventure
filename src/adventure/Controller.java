package adventure;

import javax.swing.JPanel;

public class Controller extends JPanel{

	private final static int frameWidth = 500;
	private final static int frameHeight = 300;
	private final static int imgWidth = 165;
	private final static int imgHeight = 165;
    final static int frameCount = 10;
    private static Animal player;
    
    private Interactable interactables[];
	
	public Controller(int animal_type, int num_food, int num_enemies) {
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
