package controller;

import views.MenuPanel;

public class MenuGameState implements GameStateInterface {
	public Controller controller;
	public MenuPanel menuPanel;

	public MenuGameState(Controller controller)
	{
		this.controller = controller;
		this.menuPanel = new MenuPanel(controller, this);
	}
	public void onTick()
	{
		
	}
}