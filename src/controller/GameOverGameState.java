package controller;

import models.ScoreBoard;
import views.GameOverGameStatePanel;

public class GameOverGameState {

	private Controller controller;
	public GameOverGameStatePanel gameOverGameStatePanel;
	private int tickNumber = 0;
	
	public GameOverGameState(Controller controller) {
		this.controller = controller;
		this.gameOverGameStatePanel = new GameOverGameStatePanel(this, controller);
	}
	
	public void onTick() {
		gameOverGameStatePanel.repaint();
		this.tickNumber++;
	}
	
}
