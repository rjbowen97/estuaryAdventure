package controller;

import java.util.ArrayList;

import models.Background;
import models.ImageScaler;
import models.Interactable;
import models.NonLandAnimal;
import models.Player;


public class GameWrapper {
	
	private static Controller controller;
	
	public static void main(String[] args) {
		setUpGame();
		startGame();
	}
	
	private static void setUpGame() {
		Settings settings = new Settings();
		ImageScaler imageScaler = new ImageScaler();
		
		Player playerModel = new NonLandAnimal();
		ArrayList<Background> backgroundModels = new ArrayList<Background>(generateBackgroundModels());
		ArrayList<Interactable> interactableModels = new ArrayList<Interactable>(generateInteractableModels());
		
		controller = new Controller(playerModel, backgroundModels, interactableModels);
	}
	
	private static void startGame() {
		while (true) {
			try {
				controller.tick();
				Thread.sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static ArrayList<Background> generateBackgroundModels() {
		ArrayList<Background> backgroundModels = new ArrayList<Background>();
    	for (int backgroundImageFileIndex = 0; backgroundImageFileIndex < Settings.getNumberOfBackgroundLayers(); backgroundImageFileIndex++) {
    		backgroundModels.add(new Background(0, 0, backgroundImageFileIndex));
    	}
    	return backgroundModels;
	}
	
	private static ArrayList<Interactable> generateInteractableModels() {
		ArrayList<Interactable> interactableModels = new ArrayList<Interactable>();
		
    	for (int interactableIndex = 0; interactableIndex < 100; interactableIndex++) {
    		interactableModels.add(new Interactable(interactableIndex * 5));
    	}
    	
    	return interactableModels;
	}
	
}
