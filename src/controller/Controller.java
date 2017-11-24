package controller;


import java.util.ArrayList;

import models.Background;
import models.Interactable;
import models.Player;
import models.ScoreBoard;
import models.ScoreBoardManager;
import views.View;

public class Controller {

	public ActiveGameState activeGameState;
	public MiniGameGameState miniGameGameState;
	public GameOverGameState gameOverGameState;
	public ScoreBoard scoreBoard;
	

	public View view;

	private GameState gameState;

	public Controller(Player playerModel, ArrayList<Interactable> interactableModels, ArrayList<Background> backgroundModels, ScoreBoard scoreBoard) {
		this.activeGameState = new ActiveGameState(this, playerModel, interactableModels, backgroundModels);
		this.miniGameGameState = new MiniGameGameState(this);
		this.scoreBoard = scoreBoard;
		this.gameOverGameState = new GameOverGameState(this);
		

		this.gameState = GameState.Active;
		this.view = new View(playerModel, backgroundModels, this, interactableModels);
		this.view.setContentPane(activeGameState.activeGameStatePanel);
	}

	public void tick(){
		if (gameState.equals(GameState.Active)) {
			this.activeGameState.onTick();
		}

		if (gameState.equals(GameState.MiniGame)) {
			this.miniGameGameState.onTick();
		}

		else { //gameOver
			this.gameOverGameState.onTick();
		}
		this.view.repaint();

	}

	public void changeGameStateFromActiveToMinigame() {
		this.view.setContentPane(miniGameGameState.miniGameGameStatePanel);
		this.gameState = GameState.MiniGame;
	}

	public void changeGameStateFromMiniGameToActive(int correctAnswerCount) {
		if (correctAnswerCount > 0) {
			activeGameState.playerModel.onMiniGameEnd(correctAnswerCount);
		}
		
		miniGameGameState.miniGame.resetMiniGame();
		activeGameState.playerModel.resetScoreStreak();
		
		this.view.setContentPane(activeGameState.activeGameStatePanel);
		this.gameState = GameState.Active;
		
	}

	public void changeGameStateFromActiveToGameOver() {
		scoreBoard.addNewScore(activeGameState.playerModel);
		ScoreBoardManager.saveScoreboard(scoreBoard);
		
		this.view.setContentPane(gameOverGameState.gameOverGameStatePanel);
		this.view.setContentPane(scoreBoard.scoreBoardPanel);
		this.gameState = GameState.GameOver;

	}
}
