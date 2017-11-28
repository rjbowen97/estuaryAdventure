package controller;

import models.ScoreBoard;
import views.GameOverGameStatePanel;
import views.ScoreBoardPanel;

public class GameOverGameState implements GameStateInterface {

	private Controller controller;
	
	public GameOverGameStatePanel gameOverGameStatePanel;
	
	private int tickNumber = 0;
	
	/**
	 * Instantiates a new game over game state.
	 *
	 * @param controller the main controller passed from the controller
	 */
	public GameOverGameState(Controller controller) {
		this.controller = controller;
		this.gameOverGameStatePanel = new GameOverGameStatePanel(this, controller);
	}
	
	/**
	 * called each tick by the controller if this is the current active gameState
	 */
	public void onTick() {
		gameOverGameStatePanel.repaint();
		controller.scoreBoard.scoreBoardPanel.repaint();
		this.tickNumber++;
	}
	
}
