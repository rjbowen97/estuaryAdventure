package controller;

import java.io.Serializable;

import quizMiniGame.MiniGame;
import quizMiniGame.MiniGameGameStatePanel;

/**
 * The Class MiniGameGameState.
 */
public class MiniGameGameState implements GameStateInterface, Serializable {

	public Controller controller;
	
	public MiniGame miniGame;
	
	public MiniGameGameStatePanel miniGameGameStatePanel;

	private int tickNumber = 0;

	/**
	 * Instantiates a new mini game game state.
	 *
	 * @param controller the main controller
	 */
	public MiniGameGameState(Controller controller) {
		this.controller = controller;
		this.miniGame = new MiniGame();
		this.miniGameGameStatePanel = new MiniGameGameStatePanel(this.miniGame, controller);
	}

	/**
	 * Called every tick when this game state is the current active game state
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
	 * Sets the mini game current player answer.
	 *
	 * @param currentPlayerAnswer the new mini game current player answer
	 */
	public void setMiniGameCurrentPlayerAnswer(String currentPlayerAnswer) {
		this.miniGame.setCurrentPlayerAnswer(currentPlayerAnswer);
	}
}
