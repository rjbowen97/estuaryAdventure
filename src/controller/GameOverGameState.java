package controller;

import models.ScoreBoard;
import views.GameOverGameStatePanel;

// TODO: Auto-generated Javadoc
/**
 * The Class GameOverGameState.
 */
public class GameOverGameState implements GameStateInterface {

	/** The controller. */
	private Controller controller;
	
	/** The game over game state panel. */
	public GameOverGameStatePanel gameOverGameStatePanel;
	
	/** The tick number. */
	private int tickNumber = 0;
	
	/**
	 * Instantiates a new game over game state.
	 *
	 * @param controller the controller
	 */
	public GameOverGameState(Controller controller) {
		this.controller = controller;
		this.gameOverGameStatePanel = new GameOverGameStatePanel(this, controller);
	}
	
	/**
	 * On tick.
	 */
	public void onTick() {
		gameOverGameStatePanel.repaint();
		this.tickNumber++;
	}
	
}
