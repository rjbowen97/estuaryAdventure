package controller;


import java.io.Serializable;
import java.util.ArrayList;

import models.Background;
import models.Interactable;
import models.Menu;
import models.Player;
import models.PlayerAnimalType;
import models.ScoreBoard;
import models.ScoreBoardManager;
import models.finishLine;
import views.ScoreBoardPanel;
import views.View;

public class Controller implements Serializable {

	private GameState gameState;
	
	public MenuGameState menuGameState;
	public ActiveGameState activeGameState;
	public MiniGameGameState miniGameGameState;
	public GameOverGameState gameOverGameState;
	public ScoreBoard scoreBoard;
	public View view;
	
	public ScoreBoardPanel scoreBoardPanel;

	
	public Controller(Menu menuModel, Player playerModel, ArrayList<Interactable> interactableModels, ArrayList<Background> backgroundModels, ScoreBoard scoreBoard, finishLine finishLine) {
		this.gameState = GameState.MENU;

		this.menuGameState = new MenuGameState(this, menuModel);
		this.activeGameState = new ActiveGameState(this, playerModel, interactableModels, backgroundModels, finishLine);
		this.miniGameGameState = new MiniGameGameState(this);
		
		this.gameOverGameState = new GameOverGameState();
		
		this.scoreBoard = scoreBoard;
		this.scoreBoardPanel = new ScoreBoardPanel(this.scoreBoard, this);
		
		this.view = new View(playerModel, backgroundModels, this, interactableModels, finishLine);
		this.view.setContentPane(view.menuPanel);
		this.view.setLocationRelativeTo(null);
	}
	
	/**
	 * Called every tick by the gameWrapper main loop. Depending on the current game state, the appropriate onTick function is called
	 */
	public void tick(){
		if (gameState.equals(GameState.MENU)) {
			this.menuGameState.onTick();
		}
		
		if (gameState.equals(GameState.ACTIVE)) {
			this.activeGameState.onTick();
		}
	
		if (gameState.equals(GameState.MINI_GAME)) {
			this.miniGameGameState.onTick();
		}
	
		else { //gameOver
			this.gameOverGameState.onTick();
		}
		
		this.view.repaint();
	}
	
	public void pauseActiveGameStateModels() {
		for (Background background : activeGameState.backgroundModels) {
			background.setSpeed(0);
		}
		
		for (Interactable interactable : activeGameState.interactableModels) {
			interactable.setSpeed(0);
		}
	}
	
	public void resumeActiveGameStateModels() {
		for (Background background : activeGameState.backgroundModels) {
			background.setSpeed(Settings.getBackgroundBaseSpeed(background.backgroundLayerIndex));
		}
		
		for (Interactable interactable : activeGameState.interactableModels) {
			interactable.setSpeed(Settings.getInteractableSpeed());
		}
	}

	/**
	 * Changes the current level
	 * 
	 * @param targetLevel the level to change to
	 */
	public void changeLevels(String targetLevel) {
		if (targetLevel.equals("a")) {
			this.activeGameState.playerModel.playerAnimalType = PlayerAnimalType.BIRD;

			for (Background background : activeGameState.backgroundModels) {
				background.backgroundType = "a";
			}
			
			for (Interactable interactable : activeGameState.interactableModels) {
				interactable.isInWater = false;
			}
			
		}
		
		else {
			this.activeGameState.playerModel.playerAnimalType = PlayerAnimalType.FISH;

			for (Background background : activeGameState.backgroundModels) {
				background.backgroundType = "w";
			}
			
			for (Interactable interactable : activeGameState.interactableModels) {
				interactable.isInWater = true;
			}
		}
	}
	
	
	/**
	 * resets the current level
	 */
	public void resetLevel() {
		activeGameState.playerModel.xPosition = 0;
		activeGameState.playerModel.yPosition = 0;
		activeGameState.playerModel.score = 0;
		activeGameState.playerModel.resetScoreStreak();
		activeGameState.playerModel.health = 3;
		
		for (Background background : activeGameState.backgroundModels) {
			background.xPosition = 0;
		}
		
		int releaseTime = 0;
		for (Interactable interactable : activeGameState.interactableModels) {
			interactable.isActive = false;
			interactable.xPosition = Settings.getInteractableStartXPosition();
			interactable.activationTick = releaseTime;
			releaseTime += 5;
		}
		
		this.activeGameState.finishLineModel = new finishLine(Settings.getFinishLineRelease(), this);
		this.activeGameState.setTickNumber(0);
		
		miniGameGameState.miniGame.resetMiniGame();
		
	}

	/**
	 * Change game state from menu to active.
	 */
	public void changeGameStateFromMenuToActive() {
		this.view.setContentPane(view.activeGameStatePanel);
		this.gameState = GameState.ACTIVE;
	}
	
	/**
	 * Change game state from active to minigame.
	 */
	public void changeGameStateFromActiveToMinigame() {
		this.view.setContentPane(view.miniGameGameStatePanel);
		this.gameState = GameState.MINI_GAME;
	}
	
	public void changeGameStateFromGameOverToMenu(){
		this.view.setContentPane(view.menuPanel);
		this.gameState = GameState.MENU;
	}

	/**
	 * Change game state from mini game to active. If the player answers more than zero questions correct,
	 * a helper method is called
	 *
	 * @param correctAnswerCount The amount of questions answered correctly by the player in the miniGame's main loop
	 */
	public void changeGameStateFromMiniGameToActive(int correctAnswerCount) {
		if (correctAnswerCount > 0) {
			activeGameState.playerModel.onMiniGameEnd(correctAnswerCount);
		}
		
		view.miniGameGameStatePanel.displayCorrectAnswer();
		
		miniGameGameState.miniGame.resetMiniGame();
		activeGameState.playerModel.resetScoreStreak();
		
		this.view.setContentPane(view.activeGameStatePanel);
		this.gameState = GameState.ACTIVE;
		
	}

	/**
	 * Change game state from active to game over.
	 */
	public void changeGameStateFromActiveToGameOver() {
		scoreBoard.addNewScore(activeGameState.playerModel);
		ScoreBoardManager.saveScoreboard(scoreBoard,Settings.getScoreBoardFileName());
		this.scoreBoard = ScoreBoardManager.loadScoreBoard(Settings.getScoreBoardFileName());
		
		this.view.setContentPane(view.gameOverGameStatePanel);
		this.view.setContentPane(scoreBoardPanel);
		this.gameState = GameState.GAME_OVER;
	}
	
	/**
	 * Sets the player name
	 * @param playerName new player name
	 */
	
	public void setPlayerName(String playerName) {
		this.activeGameState.playerModel.setPlayerName(playerName);
	}
}
