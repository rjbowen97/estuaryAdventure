package controller;

import java.io.Serializable;

public interface GameStateInterface extends Serializable {
	
	/*
	 * A method to be called each tick if the game state is the current active gamestate
	 */
	public void onTick();
}
