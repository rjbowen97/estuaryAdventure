package controller;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import models.Background;
import models.Interactable;
import models.Player;
import views.ActiveGameStatePanel;

// TODO: Auto-generated Javadoc
/**
 * The Class ActiveGameState.
 */
public class ActiveGameState {
	
	/** The controller. */
	public Controller controller;
	
	/** The player model. */
	public Player playerModel;
	
	/** The interactable models. */
	public ArrayList<Interactable> interactableModels;
	
	/** The background models. */
	public ArrayList<Background> backgroundModels;	
	
	/** The active game state panel. */
	public ActiveGameStatePanel activeGameStatePanel;
	
	/** The tick number. */
	private int tickNumber = 0;
	
	/**
	 * Instantiates a new active game state.
	 *
	 * @param controller the controller
	 * @param playerModel the player model
	 * @param interactableModels the interactable models
	 * @param backgroundModels the background models
	 */
	public ActiveGameState(Controller controller, Player playerModel, ArrayList<Interactable> interactableModels, ArrayList<Background> backgroundModels) {
		this.activeGameStatePanel = new ActiveGameStatePanel(playerModel, backgroundModels, controller, interactableModels);
		this.controller = controller;
		this.playerModel = playerModel;
		this.interactableModels = interactableModels;
		this.backgroundModels = backgroundModels;
	}
	
	/**
	 * On tick.
	 */
	public void onTick() {
		tickModels();
		checkGameState();
		this.tickNumber++;
	}
	
	/**
	 * Tick models.
	 */
	private void tickModels() {
		tickBackgroundModels();
		tickInteractableModels();
		tickPlayerModel();
		detectCollisions();
	}

	/**
	 * Tick background models.
	 */
	private void tickBackgroundModels() {
		for (Background backgroundModel : backgroundModels) {
			backgroundModel.onTick();
		}
	}

	/**
	 * Tick interactable models.
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
	 * Tick player model.
	 */
	private void tickPlayerModel() {
		this.playerModel.onTick();
	}

	/**
	 * Detect collisions.
	 */
	private void detectCollisions() {
		detectPlayerInteractableCollisions();
	}

	/**
	 * Detect player interactable collisions.
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
	 * Check game state.
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
	 * On player component mouse released.
	 *
	 * @param mouseEvent the mouse event
	 */
	public void onPlayerComponentMouseReleased(MouseEvent mouseEvent) {
		playerModel.onMouseReleased(mouseEvent);
	}
	
	
}
