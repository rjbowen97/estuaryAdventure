package controller;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class GameOverGameState.
 */
public class GameOverGameState implements GameStateInterface, Serializable {

	
	/** The tick number. */
	private int tickNumber = 0;
	
	/**
	 * Instantiates a new game over game state.
	 */
	public GameOverGameState() {
	}
	
	/**
	 * called each tick by the controller if this is the current active gameState.
	 */
	public void onTick() {
		this.tickNumber++;
	}
	
}
