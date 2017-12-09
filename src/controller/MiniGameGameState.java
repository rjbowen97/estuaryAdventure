package controller;

import java.io.Serializable;

import quizMiniGame.MiniGame;

/**
 * The Class MiniGameGameState, which is responsible for the business logic of the minigame.
 */
public class MiniGameGameState implements GameStateInterface, Serializable {

	/** The controller. */
	public Controller controller;
	
	/** The mini game. */
	public MiniGame miniGame;
	
	/** The tick number. */
	private int tickNumber = 0;

	/**
	 * Instantiates a new mini game game state.
	 *
	 * @param controller the main controller
	 */
	public MiniGameGameState(Controller controller) {
		this.controller = controller;
		this.miniGame = new MiniGame();
	}

	/**
	 * Called every tick when this game state is the current active game state.
	 */
	public void onTick() {
		this.miniGame.onTick();

		if (this.miniGame.isActive) {
		}

		else {
			controller.changeGameStateFromMiniGameToActive(miniGame.correctAnswerCount);
		}
		this.tickNumber++;
	}

	/**
	 * Stores the answer supplied by the player in the minigame.
	 *
	 * @param currentPlayerAnswer the new mini game current player answer
	 */
	public void setMiniGameCurrentPlayerAnswer(String currentPlayerAnswer) {
		this.miniGame.setCurrentPlayerAnswer(currentPlayerAnswer);
	}
}
