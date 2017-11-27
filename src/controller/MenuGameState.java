package controller;

import views.MenuPanel;

public class MenuGameState  {
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