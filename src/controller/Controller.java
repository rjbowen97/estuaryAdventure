package controller;


import java.awt.event.MouseEvent;
import java.util.ArrayList;

import models.Background;
import models.Interactable;
import models.Player;
import models.ScoreBoard;
import models.ScoreBoardManager;
import quizMiniGame.MiniGame;
import quizMiniGame.MiniGameGameStatePanel;
import views.GameOverGameStatePanel;
import views.View;

public class Controller {

<<<<<<< HEAD
	public ActiveGameState activeGameState;
	public MiniGameGameState miniGameGameState;
	public GameOverGameState gameOverGameState;
=======
	private Player playerModel;
	private ArrayList<Interactable> interactableModels;
	private ArrayList<Background> backgroundModels;
	private MiniGame miniGame;
	private ScoreBoard scoreBoard;
>>>>>>> 27edbef1df1c34f790eb4f9e53bbefec060f3834

	public View view;

	private GameState gameState;

<<<<<<< HEAD
	public Controller(Player playerModel, ArrayList<Interactable> interactableModels, ArrayList<Background> backgroundModels) {

=======
	public Controller(Player playerModel, ArrayList<Interactable> interactableModels, ArrayList<Background> backgroundModels, ScoreBoard scoreBoard) {
		this.playerModel = playerModel;
		this.interactableModels = interactableModels;
		this.backgroundModels = backgroundModels;
		this.scoreBoard=scoreBoard;
		this.view = new View(playerModel, backgroundModels, this, interactableModels);

		this.miniGame = new MiniGame();
		//this.miniGameView = new MiniGameView(this.miniGame, this);
>>>>>>> 27edbef1df1c34f790eb4f9e53bbefec060f3834

		this.activeGameState = new ActiveGameState(this, playerModel, interactableModels, backgroundModels);
		this.miniGameGameState = new MiniGameGameState(this);
		this.gameOverGameState = new GameOverGameState();

		this.gameState = GameState.Active;
		this.view = new View(playerModel, backgroundModels, this, interactableModels);
		this.view.setContentPane(activeGameState.activeGameStatePanel);
	}

	public void tick(){
		if (gameState.equals(GameState.Active)) {
			this.activeGameState.onTick();
		}
<<<<<<< HEAD

		if (gameState.equals(GameState.MiniGame)) {
			this.miniGameGameState.onTick();
=======
		
		
		else if (gameState.equals(GameState.MiniGame)) {
			gameStateMiniGameTick();
>>>>>>> 27edbef1df1c34f790eb4f9e53bbefec060f3834
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

<<<<<<< HEAD
	public void changeGameStateFromMiniGameToActive(boolean answerWasCorrect) {
		if (answerWasCorrect) {
			activeGameState.playerModel.resetScoreStreak();
			activeGameState.playerModel.powerUp();
=======
	private void tickBackgroundModels() {
		for (Background backgroundModel : backgroundModels) {
			backgroundModel.onTick();
		}
	}

	private void tickInteractableModels() {
		for (Interactable interactableModel :interactableModels) {

			if (interactableModel.getActivationTick() == tickNumber) {
				interactableModel.activate();
			}

			if (interactableModel.isActive()) {
				interactableModel.onTick();				
			}
		}
	}

	private void tickPlayerModel() {
		this.playerModel.onTick();
	}

	private void detectCollisions() {
		detectPlayerInteractableCollisions();
	}

	private void detectPlayerInteractableCollisions() {
		for (Interactable interactableModel : interactableModels) {

			if (interactableModel.isActive()) {
				if (playerModel.getHitbox().isOverlapping(interactableModel.getHitbox())) {
					playerModel.onCollisionWithInteractableModel(interactableModel);
					interactableModel.onCollisionWithPlayerModel(playerModel);
				}
			}
		}
	}

	private void checkGameState() {
		if (playerModel.getHealth() <= 0) {
			view.setVisible(false);
			gameOverView.setVisible(true);
			this.gameState = GameState.GameOver;
		}

		if (playerModel.getScoreStreak() >= Settings.getMiniGameRequiredScoreStreak()) {
			view.setVisible(false);
			this.miniGameView = new MiniGameView(this.miniGame, this); 
			miniGameView.setVisible(true);
			this.gameState = GameState.MiniGame;
		}
	}

	private void tickView(){
		view.repaint();
	}

	private void gameStateMiniGameTick() {
		this.miniGame.onTick();

		if (this.miniGame.getCorrectAnswerFlag() == 0) {
>>>>>>> 27edbef1df1c34f790eb4f9e53bbefec060f3834
		}

		else {
			activeGameState.playerModel.resetScoreStreak();
			miniGameGameState.miniGame.resetMiniGameOnNonZeroCorrectAnswerFlag();
		}

<<<<<<< HEAD
		this.view.setContentPane(activeGameState.activeGameStatePanel);
=======
	private void gameStateGameOverTick() {
		scoreBoard.addNewScore(playerModel);
		ScoreBoardManager.saveScoreboard(scoreBoard);
		gameOverView.repaint();
	}
>>>>>>> 27edbef1df1c34f790eb4f9e53bbefec060f3834

		this.gameState = GameState.Active;
	}

	public void changeGameStateFromActiveToGameOver() {
		this.view.setContentPane(gameOverGameState.gameOverGameStatePanel);
		this.gameState = GameState.GameOver;

	}
}
