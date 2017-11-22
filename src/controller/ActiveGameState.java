package controller;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import models.Background;
import models.Interactable;
import models.Player;
import views.ActiveGameStatePanel;
import views.View;

public class ActiveGameState {
	
	public Controller controller;
	public Player playerModel;
	public ArrayList<Interactable> interactableModels;
	public ArrayList<Background> backgroundModels;	
	public ActiveGameStatePanel activeGameStatePanel;
	
	private int tickNumber = 0;
	
	public ActiveGameState(Controller controller, Player playerModel, ArrayList<Interactable> interactableModels, ArrayList<Background> backgroundModels) {
		this.activeGameStatePanel = new ActiveGameStatePanel(playerModel, backgroundModels, controller, interactableModels);
		this.controller = controller;
		this.playerModel = playerModel;
		this.interactableModels = interactableModels;
		this.backgroundModels = backgroundModels;
	}
	
	public void onTick() {
		tickModels();
		checkGameState();
		this.tickNumber++;
	}
	
	private void tickModels() {
		tickBackgroundModels();
		tickInteractableModels();
		tickPlayerModel();
		detectCollisions();
	}

	private void tickBackgroundModels() {
		for (Background backgroundModel : backgroundModels) {
			backgroundModel.onTick();
		}
	}

	private void tickInteractableModels() {
		for (Interactable interactableModel :interactableModels) {

			if (interactableModel.getActivationTick() == tickNumber) {
				interactableModel.activate();
			}

			if (interactableModel.isActive()) {
				interactableModel.onTick();				
			}
		}
	}

	private void tickPlayerModel() {
		this.playerModel.onTick();
	}

	private void detectCollisions() {
		detectPlayerInteractableCollisions();
	}

	private void detectPlayerInteractableCollisions() {
		for (Interactable interactableModel : interactableModels) {

			if (interactableModel.isActive()) {
				if (playerModel.getHitbox().isOverlapping(interactableModel.getHitbox())) {
					playerModel.onCollisionWithInteractableModel(interactableModel);
					interactableModel.onCollisionWithPlayerModel(playerModel);
				}
			}
		}
	}
	
	private void checkGameState() {
		if (playerModel.getHealth() <= 0) {
			this.controller.changeGameStateFromActiveToGameOver();
		}

		if (playerModel.getScoreStreak() >= Settings.getMiniGameRequiredScoreStreak()) {
			this.controller.changeGameStateFromActiveToMinigame();;
		}
	}
	
	public void onPlayerComponentMouseReleased(MouseEvent mouseEvent) {
		playerModel.onMouseReleased(mouseEvent);
	}
	
	
}
