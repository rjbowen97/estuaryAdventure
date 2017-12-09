package controller;

import java.io.Serializable;

/**
 * An enum representing the different gameStates the game is in
 */
public enum GameState implements Serializable {
	
	/** The menu. */
	MENU,
	
	/** The active. */
	ACTIVE,
	
	/** The mini game. */
	MINI_GAME,
	
	/** The game over. */
	GAME_OVER,
}
