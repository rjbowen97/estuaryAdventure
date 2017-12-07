package controller;

import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;

import models.Background;
import models.Interactable;
import models.Player;
import models.finishLine;
import sun.security.krb5.internal.TicketFlags;

public class ActiveGameState implements GameStateInterface, Serializable {

	public Controller controller;

	public Player playerModel;
	public ArrayList<Interactable> interactableModels;
	public ArrayList<Background> backgroundModels;
	public finishLine finishLineModel;

	public boolean isTutorial = true;

	private int tickNumber = 0;

	/**
	 * Instantiates a new active game state.
	 *
	 * @param controller The main controller created in the gameWrapper constructor
	 * @param playerModel Player model constructed in the gameWrapper constructor
	 * @param interactableModels An array of interactable models
	 * @param backgroundModels An array of background models
	 */
	public ActiveGameState(Controller controller, Player playerModel, ArrayList<Interactable> interactableModels, ArrayList<Background> backgroundModels, finishLine finishLine) {
		this.controller = controller;
		this.playerModel = playerModel;
		this.interactableModels = interactableModels;
		this.backgroundModels = backgroundModels;
		this.finishLineModel = finishLine;
	}

	/**
	 * This function is called every tick when the active game state is the current game state of the game
	 */
	public void onTick() {

		if (isTutorial) {
			
			
			if (tickNumber == 1) {
				controller.activeGameState.interactableModels.get(0).activationTick = this.getTickNumber() + 1;
			}
			
			else if (tickNumber > 25 && tickNumber < 50) {
				controller.triggerTutorialStepDisplay(0);
				controller.pauseActiveGameStateModels();
				
			}
			
			else if (tickNumber > 50 && tickNumber < 75) {
				controller.resumeActiveGameStateModels();
			}
			
			else if (tickNumber == 100) {
				controller.activeGameState.interactableModels.get(1).activationTick = this.getTickNumber() + 1;
			}
			
			else if (tickNumber > 125 && tickNumber < 150) {
				controller.triggerTutorialStepDisplay(1);
				controller.pauseActiveGameStateModels();
			}
			
			else if (tickNumber > 150) {
				controller.resumeActiveGameStateModels();
			}
		}

		tickModels();
		changeGameStateIfNeeded();
		setTickNumber(getTickNumber() + 1);
	}

	/**
	 * Calls helper functions to tick various models in the active game state object
	 */
	private void tickModels() {
		tickBackgroundModels();
		tickInteractableModels();
		tickPlayerModel();
		tickFinishLineModel();
		detectCollisions();
	}

	private void tickFinishLineModel() {

		if (finishLineModel.getActivationTick() == getTickNumber()) {
			finishLineModel.activate();
		}

		if (finishLineModel.isActive) {
			this.finishLineModel.onTick();
		}

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

			if (interactableModel.getActivationTick() == getTickNumber()) {
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
		detectPlayerFinishLineCollision();
	}

	private void detectPlayerFinishLineCollision() {
		if (finishLineModel.getHitbox().isOverlapping(playerModel.getHitbox())) {
			finishLineModel.onCollisionWithPlayerModel(playerModel);
		}
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
	private void changeGameStateIfNeeded() {
		if (playerModel.getHealth() <= 0) {
			controller.changeGameStateFromActiveToGameOver();
		}

		if (playerModel.getScoreStreak() >= Settings.getMiniGameRequiredScoreStreak()) {
			controller.changeGameStateFromActiveToMinigame();;
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

	/**
	 * @return the tickNumber
	 */
	public int getTickNumber() {
		return tickNumber;
	}

	/**
	 * @param tickNumber the tickNumber to set
	 */
	public void setTickNumber(int tickNumber) {
		this.tickNumber = tickNumber;
	}


}
