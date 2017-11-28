package controller;

import quizMiniGame.MiniGame;
import quizMiniGame.MiniGameGameStatePanel;

// TODO: Auto-generated Javadoc
/**
 * The Class MiniGameGameState.
 */
public class MiniGameGameState implements GameStateInterface {

	/** The controller. */
	public Controller controller;
	
	/** The mini game. */
	public MiniGame miniGame;
	
	/** The mini game game state panel. */
	public MiniGameGameStatePanel miniGameGameStatePanel;

	/** The tick number. */
	private int tickNumber = 0;

	/**
	 * Instantiates a new mini game game state.
	 *
	 * @param controller the controller
	 */
	public MiniGameGameState(Controller controller) {
		this.controller = controller;
		this.miniGame = new MiniGame();
		this.miniGameGameStatePanel = new MiniGameGameStatePanel(this.miniGame, controller);
	}

	/**
	 * On tick.
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
