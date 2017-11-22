package controller;


import java.awt.event.MouseEvent;
import java.util.ArrayList;

import models.Background;
import models.Interactable;
import models.Player;
import quizMiniGame.MiniGame;
import quizMiniGame.MiniGameView;
import views.GameOverView;
import views.View;

public class Controller {

	public ActiveGameState activeGameState;
	public MiniGameGameState miniGameGameState;
	public GameOverGameState gameOverGameState;
	
	private GameState gameState;

	public Controller(Player playerModel, ArrayList<Interactable> interactableModels, ArrayList<Background> backgroundModels) {

		this.activeGameState = new ActiveGameState(this, playerModel, interactableModels, backgroundModels);
		this.miniGameGameState = new MiniGameGameState(this);
		this.gameOverGameState = new GameOverGameState();
		
		this.gameState = GameState.Active;
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
	}
	
	public void changeGameStateFromActiveToMinigame() {
		activeGameState.view.setVisible(false);
		miniGameGameState.miniGameView.setVisible(true);
		this.gameState = GameState.MiniGame;
	}
	
	public void changeGameStateFromMiniGameToActive(boolean answerWasCorrect) {
		if (answerWasCorrect) {
			activeGameState.playerModel.resetScoreStreak();
			activeGameState.playerModel.powerUp();
		}
		
		else {
			activeGameState.playerModel.resetScoreStreak();
			miniGameGameState.miniGame.resetMiniGameOnNonZeroCorrectAnswerFlag();
		}
		
		miniGameGameState.miniGameView.setVisible(false);
		activeGameState.view.setVisible(true);
		
		this.gameState = GameState.Active;
	}
	
	public void changeGameStateFromActiveToGameOver() {
		this.gameState = GameState.GameOver;

	}
}
