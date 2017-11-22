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

	private GameState gameState;

	public Controller(Player playerModel, ArrayList<Interactable> interactableModels, ArrayList<Background> backgroundModels) {

		this.gameState = GameState.Active;
	}

	public void tick(){
		if (gameState.equals(GameState.Active)) {
			gameStateActiveTick();
		}

		if (gameState.equals(GameState.MiniGame)) {
			gameStateMiniGameTick();
		}

		else { //gameOver
			gameStateGameOverTick();
		}
	}

	private void gameStateActiveTick() {
		
	}

	private void gameStateMiniGameTick() {
		
	}

	private void gameStateGameOverTick() {
		
	}

	public void onPlayerComponentMouseReleased(MouseEvent mouseEvent) {
		playerModel.onMouseReleased(mouseEvent);
	}
	
	public void changeGameStateFromActiveToMinigame() {
		
	}
	
	public void changeGameStateFromMiniGameToActive() {
		
	}
	
	public void changeGameStateFromActiveToGameOver() {
		
	}


}
