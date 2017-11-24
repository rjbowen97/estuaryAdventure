package controller;

import models.ScoreBoard;
import views.GameOverGameStatePanel;

public class GameOverGameState {

	public GameOverGameStatePanel gameOverGameStatePanel;
	private int tickNumber = 0;
	
	public GameOverGameState(ScoreBoard scoreBoard) {
		this.gameOverGameStatePanel = new GameOverGameStatePanel(this);
	}
	
	public void onTick() {
		gameOverGameStatePanel.repaint();
		this.tickNumber++;
	}
	
}
