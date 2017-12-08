package controller;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Interface GameStateInterface.
 */
public interface GameStateInterface extends Serializable {
	
	/**
	 * On tick.
	 */
	/*
	 * A method to be called each tick if the game state is the current active gamestate
	 */
	public void onTick();
}
