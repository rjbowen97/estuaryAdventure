package controller;

import java.io.File;
import java.util.ArrayList;

import models.*;
import views.View;

/*
 * This class essentially wraps the game up into a presentable/runnable product, Player model is
 * defined as well as the background. 
 */
public class GameWrapper {
	
	public static void main(String[] args) {
		
		Settings settings = new Settings();
		
		Player mainModel = new Player(PlayerAnimalType.BIRD);
		ArrayList<Background> backgroundModels = new ArrayList<Background>();
    	File[] backgroundImageFiles = new File("./backgrounds").listFiles();
    	for(File currentBackgroundImageFiles: backgroundImageFiles){
    		backgroundModels.add(new Background(currentBackgroundImageFiles,
    				Integer.parseInt(Settings.globalSettings.getProperty("backgroundXPosition")),
    				Integer.parseInt(Settings.globalSettings.getProperty("backgroundYPosition"))));
    	}  
    	
		Controller mainController = new Controller(mainModel, new View(mainModel, backgroundModels));

		for(int i = 0; i < 1000; i++){
			try {
				mainController.update();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
