package controller;

import models.Animal;
import models.AnimalType;
import views.View;

public class GameWrapper {

	public static void main(String[] args) {

		Animal mainModel = new Animal(AnimalType.BIRD);

		Controller mainController = new Controller(mainModel, new View(mainModel));

		for(int i = 0; i < 1000; i++){
			mainController.updateModel();
			mainController.updateView();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
