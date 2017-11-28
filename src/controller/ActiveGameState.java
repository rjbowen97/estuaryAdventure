package controller;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import models.Background;
import models.Interactable;
import models.Player;
import views.ActiveGameStatePanel;

public class ActiveGameState implements GameStateInterface {
	
	public Controller controller;
	
	public Player playerModel;
	
	public ArrayList<Interactable> interactableModels;
	
	public ArrayList<Background> backgroundModels;	
	
	public ActiveGameStatePanel activeGameStatePanel;
	
	private int tickNumber = 0;
	
	/**
	 * Instantiates a new active game state.
	 *
	 * @param controller The main controller created in the gameWrapper constructor
	 * @param playerModel Player model constructed in the gameWrapper constructor
	 * @param interactableModels An array of interactable models
	 * @param backgroundModels An array of background models
	 */
	public ActiveGameState(Controller controller, Player playerModel, ArrayList<Interactable> interactableModels, ArrayList<Background> backgroundModels) {
		this.activeGameStatePanel = new ActiveGameStatePanel(playerModel, backgroundModels, controller, interactableModels);
		this.controller = controller;
		this.playerModel = playerModel;
		this.interactableModels = interactableModels;
		this.backgroundModels = backgroundModels;
	}
	
	/**
	 * This function is called every tick when the active game state is the current game state of the game
	 */
	public void onTick() {
		tickModels();
		checkGameState();
		this.tickNumber++;
	}
	
	/**
	 * Calls helper functions to tick various models in the active game state object
	 */
	private void tickModels() {
		tickBackgroundModels();
		tickInteractableModels();
		tickPlayerModel();
		detectCollisions();
	}

	/**
	 * Ticks each background model in the backgroundModels ArrayList
	 */
	private void tickBackgroundModels() {
		for (Background backgroundModel : backgroundModels) {
			backgroundModel.onTick();
		}
	}

	/**
	 * Ticks each interactable model in the interactableModels ArrayList
	 */
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

	/**
	 * Ticks player model
	 */
	private void tickPlayerModel() {
		this.playerModel.onTick();
	}

	/**
	 * Calls helper functions to handle collision detections
	 */
	private void detectCollisions() {
		detectPlayerInteractableCollisions();
	}

	/**
	 * Detects player-interactable collisions. Goes through each interactable in the interactableModels arrayList,
	 * And checks if the current interactable is active. If the model is active, and its hitbox is overlapping with the
	 * player hitbox, then the appropriate functions are called
	 */
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
	
	/**
	 * Checks if the game state needs to be change
	 */
	private void checkGameState() {
		if (playerModel.getHealth() <= 0) {
			this.controller.changeGameStateFromActiveToGameOver();
		}

		if (playerModel.getScoreStreak() >= Settings.getMiniGameRequiredScoreStreak()) {
			this.controller.changeGameStateFromActiveToMinigame();;
		}
	}
	
	/**
	 * Called when a mouseclick is detected
	 *
	 * @param mouseEvent the mouse event
	 */
	public void onPlayerComponentMouseReleased(MouseEvent mouseEvent) {
		playerModel.onMouseReleased(mouseEvent);
	}
	
	
}
