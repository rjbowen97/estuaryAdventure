package controller;

import java.util.ArrayList;

import models.Background;
import models.ImageScaler;
import models.Interactable;
import models.LandAnimal;
import models.Player;
import models.ScoreBoard;
import models.ScoreBoardManager;


public class GameWrapper {
	
	private static Controller controller;
	
	public static void main(String[] args) {
		setUpGame();
		startGame();
	}
	
	private static void setUpGame() {
		Settings settings = new Settings();
		ImageScaler imageScaler = new ImageScaler();
		
		Player playerModel = new LandAnimal();
		ArrayList<Background> backgroundModels = new ArrayList<Background>(generateBackgroundModels());
		ArrayList<Interactable> interactableModels = new ArrayList<Interactable>(generateInteractableModels());
		
		ScoreBoard scoreBoard = ScoreBoardManager.loadScoreBoard(settings.getScoreFileName());
		
		controller = new Controller(playerModel, interactableModels, backgroundModels, scoreBoard);
	}
	
	private static void startGame() {
		while (true) {
			try {
				controller.tick();
				Thread.sleep(Settings.getMillisecondsBetweenTick());
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
