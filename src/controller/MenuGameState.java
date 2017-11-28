package controller;

import models.Menu;
import views.MenuPanel;

public class MenuGameState implements GameStateInterface {
	public Controller controller;
	public MenuPanel menuPanel;
	public Menu menu;

	public MenuGameState(Menu menu, Controller controller)
	{
		this.menu = menu;
		this.controller = controller;
		this.menuPanel = new MenuPanel(menu, controller);
	}
	public void onTick()
	{
		menu.onTick();
	}
}