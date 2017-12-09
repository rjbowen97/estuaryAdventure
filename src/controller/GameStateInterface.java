package controller;

import java.io.Serializable;

/**
 * A functional interface GameStateInterface, which necessitates any game state has
 * a function to be called when it must be ticked
 */
public interface GameStateInterface extends Serializable {

	/*
	 * A method to be called each tick if the game state is the current active gamestate
	 */
	public void onTick();
}
