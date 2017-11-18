package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;

import models.*;
import views.View;

/*
 * This class essentially wraps the game up into a presentable/runnable product, Player model is
 * defined as well as the background. 
 */
public class GameWrapper {
	
	public Properties globalSettings;

	public static void main(String[] args) {
		
		Properties globalSettings = new Properties();
		InputStream configPropertiesInputStream = null;

		try {

			configPropertiesInputStream = new FileInputStream("config.properties");

			globalSettings.load(configPropertiesInputStream);

		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			if (configPropertiesInputStream != null) {
				try {
					configPropertiesInputStream.close();
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}
		}
		
		Player mainModel = new Player(PlayerAnimalType.BIRD);
		ArrayList<Background> backgroundModels = new ArrayList<Background>();
    	File[] backgroundImageFiles = new File("./backgrounds").listFiles();
    	for(File currentBackgroundImageFiles: backgroundImageFiles){
    		backgroundModels.add(new Background(currentBackgroundImageFiles, 0, 0));
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
