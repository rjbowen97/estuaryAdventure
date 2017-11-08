package controller;

import models.Player;
import models.PlayerAnimalType;
import views.View;

public class GameWrapper {

	public static void main(String[] args) {

		Player mainModel = new Player(PlayerAnimalType.BIRD);

		Controller mainController = new Controller(mainModel, new View(mainModel));

		for(int i = 0; i < 1000; i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
