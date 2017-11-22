package controller;

import views.GameOverView;

public class GameOverGameState {

	private GameOverView gameOverView;
	private int tickNumber = 0;
	
	public GameOverGameState() {
		this.gameOverView = new GameOverView();
	}
	
	public void onTick() {
		gameOverView.repaint();
		this.tickNumber++;
	}
	
}
