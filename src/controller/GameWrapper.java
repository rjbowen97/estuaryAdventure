package controller;

import java.io.File;
import java.util.ArrayList;

import models.*;
import views.View;

public class GameWrapper {

	public static void main(String[] args) {

		Player mainModel = new Player(PlayerAnimalType.BIRD);
		ArrayList<Arena> arenaModels = new ArrayList<Arena>();
    	File[] backgroundImageFiles = new File("./backgrounds").listFiles();
    	for(File currentBackgroundImageFiles: backgroundImageFiles){
    		arenaModels.add(new Arena(currentBackgroundImageFiles));
    	}  
		

		Controller mainController = new Controller(mainModel, new View(mainModel, arenaModels));

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
