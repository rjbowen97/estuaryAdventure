package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import models.Background;
import models.ImageScaler;
import models.Interactable;
import models.LandAnimal;
import models.NonLandAnimal;
import models.Player;
import models.ScoreBoard;
import models.ScoreBoardEntry;
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
		
		controller = new Controller(playerModel, interactableModels, backgroundModels);
		
		
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
