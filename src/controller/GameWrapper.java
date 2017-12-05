package controller;

import java.io.Serializable;
import java.util.ArrayList;

import models.Background;
import models.Interactable;
import models.LandAnimal;
import models.Menu;
import models.Player;
import models.ScoreBoard;
import models.ScoreBoardManager;


/**
 * The Class GameWrapper. In this class, the game is set up and run.
 */
public class GameWrapper implements Serializable {
	
	public static Controller controller;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		setUpGame();
		startGame();
	}
	
	/**
	 * Creates all of the models and the controller to be used in the game
	 */
	private static void setUpGame() {
		Settings settings = new Settings();
		
		Menu menuModel = new Menu();
		Player playerModel = new LandAnimal();
		ArrayList<Interactable> interactableModels = new ArrayList<Interactable>(generateInteractableModels());
		ArrayList<Background> backgroundModels = new ArrayList<Background>(generateBackgroundModels());
		
		ScoreBoard scoreBoard = ScoreBoardManager.loadScoreBoard(Settings.getScoreBoardFileName());
		
		controller = new Controller(menuModel, playerModel, interactableModels, backgroundModels, scoreBoard);
	}
	
	/**
	 * Loops every specified interval of time. In each loop, the controller object's tick function is called
	 */
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
	
	/**
	 * Generates interactable models.
	 *
	 * @return An array list of interactable models
	 */
	private static ArrayList<Interactable> generateInteractableModels() {
		ArrayList<Interactable> interactableModels = new ArrayList<Interactable>();
		
		for (int interactableIndex = 0; interactableIndex < 100; interactableIndex++) {
			interactableModels.add(new Interactable(interactableIndex * 5));
		}
		
		return interactableModels;
	}

	/**
	 * Generates background models.
	 *
	 * @return An array list of background models
	 */
	private static ArrayList<Background> generateBackgroundModels() {
		ArrayList<Background> backgroundModels = new ArrayList<Background>();
    	for (int backgroundImageFileIndex = 0; backgroundImageFileIndex < Settings.getNumberOfBackgroundLayers(); backgroundImageFileIndex++) {
    		backgroundModels.add(new Background(0, 0, backgroundImageFileIndex));
    	}
    	return backgroundModels;
	}
	
}
