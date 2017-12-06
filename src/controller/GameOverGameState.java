package controller;

import java.io.Serializable;

public class GameOverGameState implements GameStateInterface, Serializable {

	
	private int tickNumber = 0;
	
	/**
	 * Instantiates a new game over game state.
	 *
	 * @param controller the main controller passed from the controller
	 */
	public GameOverGameState() {
	}
	
	/**
	 * called each tick by the controller if this is the current active gameState
	 */
	public void onTick() {
		this.tickNumber++;
	}
	
}
