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

	private ArrayList<Background> backgroundModels;
	private Player playerModel;
	private ArrayList<Interactable> interactableModels;

	private GameState gameState;

	private View view;
	private GameOverView gameOverView;

	private MiniGame miniGame;
	private MiniGameView miniGameView;

	public Controller(Player playerModel, ArrayList<Background> backgroundModels, ArrayList<Interactable> interactableModels) {
		this.playerModel = playerModel;
		this.backgroundModels = backgroundModels;
		this.interactableModels = interactableModels;
		this.view = new View(playerModel, backgroundModels, this, interactableModels);
		this.gameOverView = new GameOverView();

		this.miniGame = new MiniGame();
		this.miniGameView = new MiniGameView(this.miniGame, this);

		this.gameState = GameState.Active;
	}

	public void onPlayerComponentMouseReleased(MouseEvent mouseEvent) {
		playerModel.onMouseReleased(mouseEvent);
	}

	public void tick(int tickNumber){
		if (gameState.equals(GameState.Active)) {
			GameStateActiveTick(tickNumber);
		}

		if (gameState.equals(GameState.MiniGame)) {
			miniGameGameStateTick();
		}

		else { //gameOver
			GameStateGameOverTick();
		}

	}

	private void checkGameState() {
		if (playerModel.getHealth() <= 0) {
			view.setVisible(false);
			gameOverView.setVisible(true);
			this.gameState = GameState.GameOver;
		}

		if (playerModel.getScoreStreak() > 1) {
			view.setVisible(false);
			miniGameView.setVisible(true);
			this.gameState = GameState.MiniGame;
		}
	}

	private void miniGameGameStateTick() {
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

	private void GameStateGameOverTick() {
		gameOverView.repaint();
	}

	private void GameStateActiveTick(int tickNumber) {
		tickModels(tickNumber);
		checkGameState();
		tickView();
	}

	private void tickModels(int tickNumber) {
		tickBackgroundModels();
		tickInteractableModels(tickNumber);
		tickPlayerModel();
		detectCollisions();
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

	private void tickBackgroundModels() {
		for (Background backgroundModel : backgroundModels) {
			backgroundModel.onTick();
		}
	}

	private void tickInteractableModels(int tickNumber) {
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

	private void tickView(){
		view.repaint();
	}


}
