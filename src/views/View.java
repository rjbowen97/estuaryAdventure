package views;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import controller.Controller;
import controller.Settings;
import models.Background;
import models.Interactable;
import models.Player;
import quizMiniGame.MiniGameGameStatePanel;

// TODO: Auto-generated Javadoc
/**
 * The Class View.
 */
public class View extends JFrame implements Serializable {

	public ActiveGameStatePanel activeGameStatePanel;
	public GameOverGameStatePanel gameOverGameStatePanel;
	public MenuPanel menuPanel;
	public MiniGameGameStatePanel miniGameGameStatePanel;

	Controller controller;

	public void reloadImages() {
	}
	
	/**
	 * Instantiates a new view.
	 *
	 * @param playerModel the player model
	 * @param backgroundModels the background models
	 * @param controller the controller
	 * @param interactableModels the interactable models
	 */
	public View(Player playerModel, ArrayList<Background> backgroundModels, Controller controller, ArrayList<Interactable> interactableModels) {
		
		this.activeGameStatePanel = new ActiveGameStatePanel(playerModel, backgroundModels, controller, interactableModels);
		this.gameOverGameStatePanel = new GameOverGameStatePanel(controller);
		this.menuPanel = new MenuPanel(controller.menuGameState.menu, controller);
		this.miniGameGameStatePanel = new MiniGameGameStatePanel(controller.miniGameGameState.miniGame, controller);

		this.controller = controller;
		initializeKeyBindings();
		this.setBounds(0,0,Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initializeKeyBindings() {
		InputMap rootPaneInputMap = this.getRootPane().getInputMap();
		ActionMap rootPaneActionMap = this.getRootPane().getActionMap();
		
		rootPaneInputMap.put(KeyStroke.getKeyStroke('m'), "miniGame");
		miniGameAction miniGameAction = new miniGameAction();
		rootPaneActionMap.put("miniGame", miniGameAction);
		
		rootPaneInputMap.put(KeyStroke.getKeyStroke('a'), "activeGame");
		activeGameAction activeGameAction = new activeGameAction();
		rootPaneActionMap.put("activeGame", activeGameAction);

		rootPaneInputMap.put(KeyStroke.getKeyStroke('g'), "gameOver");
		gameOverAction gameOverAction = new gameOverAction();
		rootPaneActionMap.put("gameOver", gameOverAction);
		
		rootPaneInputMap.put(KeyStroke.getKeyStroke('i'), "changeToAir");
		changeToAirAction changeToAirAction = new changeToAirAction();
		rootPaneActionMap.put("changeToAir", changeToAirAction);

		rootPaneInputMap.put(KeyStroke.getKeyStroke('w'), "changeToWater");
		changeToWaterAction changeToWaterAction= new changeToWaterAction();
		rootPaneActionMap.put("changeToWater", changeToWaterAction);
		
		rootPaneInputMap.put(KeyStroke.getKeyStroke('r'), "resetLevel");
		resetLevelAction resetLevelAction= new resetLevelAction();
		rootPaneActionMap.put("resetLevel", resetLevelAction);
		
	}
	
	private class resetLevelAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Resetting level");
			controller.resetLevel();
		}
	}
	
	private class changeToAirAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Changing to air");
			controller.changeLevels("a");
		}
	}
	
	private class changeToWaterAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Changing to water");
			controller.changeLevels("w");;
		}
	}
	
	private class miniGameAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Mini game activating...");
			controller.changeGameStateFromActiveToMinigame();
		}
	}
	
	private class activeGameAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("active game activating...");
			controller.changeGameStateFromMenuToActive();
		}
	}
	
	private class gameOverAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("game over activating...");
			controller.changeGameStateFromActiveToGameOver();
		}
	}
	
}





