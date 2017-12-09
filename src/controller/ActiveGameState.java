package controller;

import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;

import models.Background;
import models.Interactable;
import models.Player;
import models.FinishLine;

/**
 * This class contains the main gameplay elements, such as the food, predators, and player
 */
public class ActiveGameState implements GameStateInterface, Serializable {

	/** The controller. */
	public Controller controller;

	/** The player model. */
	public Player playerModel;
	
	/** The interactable models. */
	public ArrayList<Interactable> interactableModels;
	
	/** The background models. */
	public ArrayList<Background> backgroundModels;
	
	/** The finish line model. */
	public FinishLine finishLineModel;

	/** Is set to true on the first runthrough of the game */
	public boolean isTutorial = true;

	/** Keeps track of what tick the main gameloop is on. Particularly important for 'releasing'
	 * foods and predators. */
	private int tickNumber = 0;

	/**
	 * Instantiates a new active game state.
	 *
	 * @param controller The main controller created in the gameWrapper constructor
	 * @param playerModel Player model constructed in the gameWrapper constructor
	 * @param interactableModels An array of interactable models
	 * @param backgroundModels An array of background models
	 * @param FinishLine the finish line model
	 */
	public ActiveGameState(Controller controller, Player playerModel, ArrayList<Interactable> interactableModels, ArrayList<Background> backgroundModels, FinishLine FinishLine) {
		this.controller = controller;
		this.playerModel = playerModel;
		this.interactableModels = interactableModels;
		this.backgroundModels = backgroundModels;
		this.finishLineModel = FinishLine;
	}

	/**
	 * Called every tick when the active game state is the current game state of the game.
	 * The tutorial script is iterated through if the current game is a tutorial
	 */
	public void onTick() {
		
		if (isTutorial) {
			tickTutorialScript();
		}
		
		tickModels();
		changeGameStateIfNeeded();
		setTickNumber(getTickNumber() + 1);
	}
	
	/**
	 * A tick based system that guides the player through how to play the game
	 */
	private void tickTutorialScript() {
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
			controller.activeGameState.finishLineModel.activationTick = 151;
			controller.triggerTutorialStepDisplay(2);
		}
	}

	/**
	 * Calls helper functions to tick various models in the active game state object.
	 * This also checks for collisions after the models are ticked
	 */
	private void tickModels() {
		tickBackgroundModels();
		tickInteractableModels();
		tickPlayerModel();
		tickFinishLineModel();
		detectCollisions();
	}

	/**
	 * Ticks each background model in the backgroundModels ArrayList.
	 */
	private void tickBackgroundModels() {
		for (Background backgroundModel : backgroundModels) {
			backgroundModel.onTick();
		}
	}

	/**
	 * Ticks each interactable model in the interactableModels ArrayList.
	 */
	private void tickInteractableModels() {
		for (Interactable interactableModel : interactableModels) {

			if (interactableModel.getActivationTick() == getTickNumber()) {
				interactableModel.activate();
			}

			if (interactableModel.isActive()) {
				interactableModel.onTick();				
			}
		}
	}

	/**
	 * Ticks player model.
	 */
	private void tickPlayerModel() {
		this.playerModel.onTick();
	}

	/**
	 * Ticks finish line model.
	 */
	private void tickFinishLineModel() {
	
		if (finishLineModel.getActivationTick() == getTickNumber()) {
			finishLineModel.activate();
		}
	
		if (finishLineModel.isActive) {
			this.finishLineModel.onTick();
		}
	
	}

	/**
	 * Calls helper functions to handle collision detections.
	 */
	private void detectCollisions() {
		detectPlayerInteractableCollisions();
		detectPlayerFinishLineCollision();
	}

	/**
	 * Detects player-interactable collisions. Goes through each interactable in the interactableModels arrayList,
	 * and checks if the current interactable is active. If the model is active, and its hitBox is overlapping with the
	 * player hitBox, then the appropriate functions are called
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
	 * Detect player finish line collision.
	 */
	private void detectPlayerFinishLineCollision() {
		if (finishLineModel.getHitbox().isOverlapping(playerModel.getHitbox())) {
			finishLineModel.onCollisionWithPlayerModel(playerModel);
		}
	}

	/**
	 * Checks if the game state needs to be changed.
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
	 * Sets the tick number.
	 *
	 * @param tickNumber the tickNumber to set
	 */
	public void setTickNumber(int tickNumber) {
		this.tickNumber = tickNumber;
	}

	/**
	 * Called when a mouse click is detected.
	 *
	 * @param mouseEvent the mouse event
	 */
	public void onPlayerComponentMouseReleased(MouseEvent mouseEvent) {
		playerModel.onMouseReleased(mouseEvent);
	}

	/**
	 * Gets the tick number.
	 *
	 * @return the tickNumber
	 */
	public int getTickNumber() {
		return tickNumber;
	}


}
