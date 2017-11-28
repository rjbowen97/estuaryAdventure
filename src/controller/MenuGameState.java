package controller;

import java.io.Serializable;

import models.Menu;
import views.MenuPanel;

/**
 * The Class MenuGameState.
 */
public class MenuGameState implements GameStateInterface, Serializable {
	
	public Controller controller;
	public Menu menu;

	/**
	 * Instantiates a new menu game state.
	 *
	 * @param menu the menu model
	 * @param controller the main controller
	 */
	public MenuGameState(Menu menu, Controller controller)
	{
		this.menu = menu;
		this.controller = controller;
	}
	
	/* (non-Javadoc)
	 * @see controller.GameStateInterface#onTick()
	 */
	public void onTick()
	{
		menu.onTick();
	}
}