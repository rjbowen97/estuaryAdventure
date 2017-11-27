package controller;

import views.MenuPanel;

public class MenuState {
	public Controller controller;
	public MenuPanel menuPanel;

	public MenuState(Controller controller)
	{
		this.controller = controller;
		this.menuPanel = new MenuPanel(controller, this);
	}
	public void onTick()
	{
	}
}