package controller;

import java.io.File;
import java.util.ArrayList;

import models.*;
import views.View;

public class GameWrapper {

	public static void main(String[] args) {

		Player mainModel = new Player(PlayerAnimalType.BIRD);
		ArrayList<Arena> backgroundModels = new ArrayList<Arena>();
    	File[] backgroundFiles = new File("./backgrounds").listFiles();
    	for(File currFile: backgroundFiles){
    		backgroundModels.add(new Arena(currFile));
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
