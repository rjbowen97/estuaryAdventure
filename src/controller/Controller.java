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
import models.FinishLine;
import views.ScoreBoardPanel;
import views.View;

/**
 * The Class Controller.
 */
public class Controller implements Serializable {

	/** The game state. */
	private GameState gameState;
	
	/** The menu game state. */
	public MenuGameState menuGameState;
	
	/** The active game state. */
	public ActiveGameState activeGameState;
	
	/** The mini game game state. */
	public MiniGameGameState miniGameGameState;
	
	/** The game over game state. */
	public GameOverGameState gameOverGameState;
	
	/** The score board. */
	public ScoreBoard scoreBoard;
	
	/** The score board panel. */
	public ScoreBoardPanel scoreBoardPanel;

	/** The view. */
	public View view;
	
	/**
	 * Instantiates a new controller.
	 *
	 * @param menuModel the menu model
	 * @param playerModel the player model
	 * @param interactableModels the interactable models
	 * @param backgroundModels the background models
	 * @param scoreBoard the score board
	 * @param FinishLine the finish line
	 */
	public Controller(Menu menuModel, Player playerModel, ArrayList<Interactable> interactableModels, ArrayList<Background> backgroundModels, ScoreBoard scoreBoard, FinishLine FinishLine) {
		this.gameState = GameState.MENU;

		this.menuGameState = new MenuGameState(this, menuModel);
		this.activeGameState = new ActiveGameState(this, playerModel, interactableModels, backgroundModels, FinishLine);
		this.miniGameGameState = new MiniGameGameState(this);
		
		this.gameOverGameState = new GameOverGameState();
		
		this.scoreBoard = scoreBoard;
		this.scoreBoardPanel = new ScoreBoardPanel(this.scoreBoard, this);
		
		this.view = new View(playerModel, backgroundModels, this, interactableModels, FinishLine);
		this.view.setContentPane(view.menuPanel);
		this.view.setLocationRelativeTo(null);
	}
	
	/**
	 * Called every tick by the gameWrapper main loop. Depending on the current game state, the appropriate onTick function is called.
	 * This function then updates the view.
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
	
	/**
	 * Sets the interactable models to a controlled tutorial set.
	 */
	public void setInteractablesToTutorialSet() {
		
		ArrayList<Interactable> tutorialInteractables =  new ArrayList<Interactable>();
		this.activeGameState.interactableModels = tutorialInteractables;
		
		Interactable goodInteractable = new Interactable(-1);
		goodInteractable.setFood(true);
		this.activeGameState.interactableModels.add(goodInteractable);
		
		Interactable badInteractable = new Interactable(-1);
		badInteractable.setFood(false);
		this.activeGameState.interactableModels.add(badInteractable);
		
		this.view.activeGameStatePanel.interactableComponent.interactableModels = tutorialInteractables;
	}
	
	/**
	 * Pauses active game state models for the tutorial.
	 */
	public void pauseActiveGameStateModels() {
		for (Background background : activeGameState.backgroundModels) {
			background.setSpeed(0);
		}
		
		for (Interactable interactable : activeGameState.interactableModels) {
			interactable.setSpeed(0);
		}
		
		activeGameState.finishLineModel.setSpeed(0);
	}
	
	/**
	 * Resumes the active game state for the tutorial.
	 */
	public void resumeActiveGameStateModels() {
		for (Background background : activeGameState.backgroundModels) {
			background.setSpeed(Settings.getBackgroundBaseSpeed(background.backgroundLayerIndex));
		}
		
		for (Interactable interactable : activeGameState.interactableModels) {
			interactable.setSpeed(Settings.getInteractableSpeed());
		}
		
		activeGameState.finishLineModel.setSpeed(Settings.getInteractableSpeed());
	}
	
	/**
	 * Displays the appropriate text field during the tutorial.
	 *
	 * @param step The step of the text field currently being shown
	 */
	public void triggerTutorialStepDisplay(int step) {
		view.activeGameStatePanel.addTutorialText(step);
	}

	/**
	 * Changes the sprites of the models to reflect the current level environment (water or air).
	 *
	 * @param targetLevel the level to change to (a for air, or w for water)
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
	 * resets the current level by setting the model properties to their starting values.
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
		
		ArrayList<Interactable> interactables = new ArrayList<Interactable>();
		
		interactables = generateInteractableModels();
		
		activeGameState.interactableModels = interactables;
		view.activeGameStatePanel.interactableComponent.interactableModels = interactables;
		
		this.activeGameState.finishLineModel = new FinishLine(Settings.getFinishLineRelease(), this);
		this.activeGameState.setTickNumber(0);
		
		miniGameGameState.miniGame.resetMiniGame();
	}
	
	/**
	 * Generates interactable models based on the amount of interactables and the
	 * release time intervals set in the globalSettings.properties file.
	 *
	 * @return the ArrayList of interactable models
	 */
	private ArrayList<Interactable> generateInteractableModels() {
		ArrayList<Interactable> interactableModels = new ArrayList<Interactable>();
		
		for (int interactableIndex = 0; interactableIndex < Settings.getInteractableCount(); interactableIndex++) {
			interactableModels.add(new Interactable(interactableIndex * Settings.getInteractableReleaseInterval()));
		}
		
		return interactableModels;
	}

	/**
	 * Changes the game state from menu to active.
	 */
	public void changeGameStateFromMenuToActive() {
		this.view.setContentPane(view.activeGameStatePanel);
		this.gameState = GameState.ACTIVE;
	}
	
	/**
	 * Changes the game state from active to minigame.
	 */
	public void changeGameStateFromActiveToMinigame() {
		this.view.getContentPane().add(view.miniGameGameStatePanel, new Integer(7));
		this.gameState = GameState.MINI_GAME;
	}
	
	/**
	 * Changes the game state from game over to menu.
	 */
	public void changeGameStateFromGameOverToMenu(){
		this.view.setContentPane(view.menuPanel);
		this.gameState = GameState.MENU;
	}

	/**
	 * Changes the game state from mini game to active. If the player answers more than zero questions correct,
	 * a helper method is called
	 *
	 * @param correctAnswerCount The amount of questions answered correctly by the player in the miniGame's main loop
	 */
	public void changeGameStateFromMiniGameToActive(int correctAnswerCount) {
		if (correctAnswerCount > 0) {
			activeGameState.playerModel.onMiniGameEnd(correctAnswerCount);
		}
		
		view.miniGameGameStatePanel.displayCorrectAnswer();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		view.miniGameGameStatePanel.hideCorrectAnswer();
		
		miniGameGameState.miniGame.resetMiniGame();
		activeGameState.playerModel.resetScoreStreak();
		
		this.view.getContentPane().remove(view.miniGameGameStatePanel);
		this.gameState = GameState.ACTIVE;
		
	}

	/**
	 * Changes the game state from active to game over.
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
	 * Sets the player name.
	 *
	 * @param playerName new player name
	 */
	
	public void setPlayerName(String playerName) {
		this.activeGameState.playerModel.setPlayerName(playerName);
	}
}
