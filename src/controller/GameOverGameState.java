package controller;

import java.io.Serializable;

import models.ScoreBoard;
import views.GameOverGameStatePanel;
import views.ScoreBoardPanel;

public class GameOverGameState implements GameStateInterface, Serializable {

	private Controller controller;
	
	private int tickNumber = 0;
	
	/**
	 * Instantiates a new game over game state.
	 *
	 * @param controller the main controller passed from the controller
	 */
	public GameOverGameState(Controller controller) {
		this.controller = controller;
	}
	
	/**
	 * called each tick by the controller if this is the current active gameState
	 */
	public void onTick() {
		this.tickNumber++;
	}
	
}
