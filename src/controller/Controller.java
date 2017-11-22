package controller;


import java.awt.event.MouseEvent;
import java.util.ArrayList;

import models.Background;
import models.Interactable;
import models.Player;
import models.ScoreBoard;
import models.ScoreBoardManager;
import quizMiniGame.MiniGame;
import quizMiniGame.MiniGameView;
import views.GameOverView;
import views.View;

public class Controller {

	private Player playerModel;
	private ArrayList<Interactable> interactableModels;
	private ArrayList<Background> backgroundModels;
	private MiniGame miniGame;
	private ScoreBoard scoreBoard;

	private View view;
	private MiniGameView miniGameView;
	private GameOverView gameOverView;

	private GameState gameState;
	private int tickNumber = 0;

	public Controller(Player playerModel, ArrayList<Interactable> interactableModels, ArrayList<Background> backgroundModels, ScoreBoard scoreBoard) {
		this.playerModel = playerModel;
		this.interactableModels = interactableModels;
		this.backgroundModels = backgroundModels;
		this.scoreBoard=scoreBoard;
		this.view = new View(playerModel, backgroundModels, this, interactableModels);

		this.miniGame = new MiniGame();
		//this.miniGameView = new MiniGameView(this.miniGame, this);

		this.gameOverView = new GameOverView();
		this.gameState = GameState.Active;
	}

	public void tick(){
		if (gameState.equals(GameState.Active)) {
			gameStateActiveTick();
		}
		
		
		else if (gameState.equals(GameState.MiniGame)) {
			gameStateMiniGameTick();
		}

		else { //gameOver
			gameStateGameOverTick();
		}

		this.tickNumber++;
	}

	private void gameStateActiveTick() {
		tickModels();
		checkGameState();
		tickView();
	}

	private void tickModels() {
		tickBackgroundModels();
		tickInteractableModels();
		tickPlayerModel();
		detectCollisions();
	}

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
		}

		else {
			if (this.miniGame.getCorrectAnswerFlag() > 0) {
				playerModel.powerUp();
			}

			else if (this.miniGame.getCorrectAnswerFlag() < 0) {
			}

			miniGameView.setVisible(false);
			playerModel.resetScoreStreak();
			miniGame.resetMiniGameOnNonZeroCorrectAnswerFlag();
			view.setVisible(true);
			this.gameState = GameState.Active;
		}
	}

	public void setMiniGameCurrentPlayerAnswer(String currentPlayerAnswer) {
		this.miniGame.setCurrentPlayerAnswer(currentPlayerAnswer);
	}

	private void gameStateGameOverTick() {
		scoreBoard.addNewScore(playerModel);
		ScoreBoardManager.saveScoreboard(scoreBoard);
		gameOverView.repaint();
	}

	public void onPlayerComponentMouseReleased(MouseEvent mouseEvent) {
		playerModel.onMouseReleased(mouseEvent);
	}


}
