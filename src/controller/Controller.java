package controller;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import models.Background;
import models.Interactable;
import models.Menu;
import models.Player;
import models.ScoreBoard;
import models.ScoreBoardManager;
import views.MenuPanel;
import views.ScoreBoardPanel;
import views.View;

public class Controller implements Serializable {

	public MenuGameState menuGameState;

	public ActiveGameState activeGameState;
	
	public MiniGameGameState miniGameGameState;
	
	public GameOverGameState gameOverGameState;
	
	public ScoreBoard scoreBoard;

	public View view;

	private GameState gameState;
	
	public void setCurrentControllerState() {
		Controller controllerIn = null;
		
	      try {
	         FileInputStream fileIn = new FileInputStream("controller.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         controllerIn = (Controller) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
	      System.out.println(controllerIn.toString());
	      
	      this.view.setVisible(false);
	      
	      GameWrapper.controller = controllerIn;
	      
	      GameWrapper.controller.view.setVisible(true);
	}
	
	public void saveCurrentControllerState() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("controller.ser");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(this);
			objectOutputStream.close();
			fileOutputStream.close();
			System.out.println("Controller successfully saved to file!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Instantiates a new controller.
	 *
	 * @param playerModel the main player model
	 * @param interactableModels the interactable models
	 * @param backgroundModels the background models
	 * @param scoreBoard the score board
	 * @param menuModel the score board
	 * 
	 */
	public Controller(Player playerModel, ArrayList<Interactable> interactableModels, ArrayList<Background> backgroundModels, ScoreBoard scoreBoard, Menu menuModel) {
		this.menuGameState = new MenuGameState(menuModel, this);
		this.activeGameState = new ActiveGameState(this, playerModel, interactableModels, backgroundModels);
		this.miniGameGameState = new MiniGameGameState(this);
		
		this.scoreBoard = scoreBoard;
		this.scoreBoard.scoreBoardPanel = new ScoreBoardPanel(this.scoreBoard);
		
		this.gameOverGameState = new GameOverGameState(this);
		

		this.gameState = GameState.Menu;
		this.view = new View(playerModel, backgroundModels, this, interactableModels);
		this.view.setContentPane(view.menuPanel);
	}

	/**
	 * Called every tick by the gameWrapper main loop. Depending on the current game state, the appropriate onTick function is called
	 */
	public void tick(){
		if (gameState.equals(GameState.Menu)) {
			this.menuGameState.onTick();
		}
		
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
	
	/**
	 * Change game state from menu to active.
	 */
	public void changeGameStateFromMenuToActive() {
		this.view.setContentPane(view.activeGameStatePanel);
		this.gameState = GameState.Active;
	}

	/**
	 * Change game state from active to minigame.
	 */
	public void changeGameStateFromActiveToMinigame() {
		this.view.setContentPane(view.miniGameGameStatePanel);
		this.gameState = GameState.MiniGame;
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
		this.gameState = GameState.Active;
		
	}

	/**
	 * Change game state from active to game over.
	 */
	public void changeGameStateFromActiveToGameOver() {
		scoreBoard.addNewScore(activeGameState.playerModel);
		ScoreBoardManager.saveScoreboard(scoreBoard,Settings.getScoreFileName());
		this.scoreBoard = ScoreBoardManager.loadScoreBoard(Settings.getScoreFileName());
		
		this.view.setContentPane(view.gameOverGameStatePanel);
		this.view.setContentPane(scoreBoard.scoreBoardPanel);
		this.gameState = GameState.GameOver;

	}
	
	public void setPlayerName(String playerName) {
		this.activeGameState.playerModel.setPlayerName(playerName);
	}
}
