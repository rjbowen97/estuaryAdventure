package controller;

import views.GameOverGameStatePanel;

public class GameOverGameState {

	private GameOverGameStatePanel gameOverGameStatePanel;
	private int tickNumber = 0;
	
	public GameOverGameState() {
		this.gameOverGameStatePanel = new GameOverGameStatePanel();
	}
	
	public void onTick() {
		gameOverGameStatePanel.repaint();
		this.tickNumber++;
	}
	
}
