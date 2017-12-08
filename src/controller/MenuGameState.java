package controller;

import java.io.Serializable;

import models.Menu;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuGameState.
 */
public class MenuGameState implements GameStateInterface, Serializable {
	
	/** The controller. */
	public Controller controller;
	
	/** The menu. */
	public Menu menu;

	/**
	 * Instantiates a new menu game state.
	 * @param controller the main controller
	 * @param menu the menu model
	 */
	public MenuGameState(Controller controller, Menu menu)
	{
		this.controller = controller;
		this.menu = menu;
	}
	
	/* (non-Javadoc)
	 * @see controller.GameStateInterface#onTick()
	 */
	public void onTick()
	{
		menu.onTick();
	}
}