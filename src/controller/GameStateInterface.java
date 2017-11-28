package controller;

public interface GameStateInterface {
	
	/*
	 * A method to be called each tick if the game state is the current active gamestate
	 */
	public void onTick();
}
