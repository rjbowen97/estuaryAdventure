package views;
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
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initializeKeyBindings() {
		InputMap rootPaneInputMap = this.getRootPane().getInputMap();
		ActionMap rootPaneActionMap = this.getRootPane().getActionMap();
		
		rootPaneInputMap.put(KeyStroke.getKeyStroke('a'), "activateActiveGameState");
		ActivateActiveGameStateAction activeGameAction = new ActivateActiveGameStateAction();
		rootPaneActionMap.put("activateActiveGameState", activeGameAction);

		rootPaneInputMap.put(KeyStroke.getKeyStroke('m'), "activateMiniGameGameState");
		ActivateMiniGameGameStateAction activateMiniGameGameStateAction = new ActivateMiniGameGameStateAction();
		rootPaneActionMap.put("activateMiniGameGameState", activateMiniGameGameStateAction);

		rootPaneInputMap.put(KeyStroke.getKeyStroke('g'), "activateGameOverGameState");
		ActivateGameOverGameStateAction activateGameOverGameStateAction = new ActivateGameOverGameStateAction();
		rootPaneActionMap.put("activateGameOverGameState", activateGameOverGameStateAction);
		
		rootPaneInputMap.put(KeyStroke.getKeyStroke('i'), "changeToAirLevel");
		ChangeToAirLevelAction changeToAirLevelAction = new ChangeToAirLevelAction();
		rootPaneActionMap.put("changeToAirLevel", changeToAirLevelAction);

		rootPaneInputMap.put(KeyStroke.getKeyStroke('w'), "changeToWaterLevel");
		ChangeToWaterLevelAction changeToWaterLevelAction= new ChangeToWaterLevelAction();
		rootPaneActionMap.put("changeToWaterLevel", changeToWaterLevelAction);
		
		rootPaneInputMap.put(KeyStroke.getKeyStroke('r'), "resetLevel");
		ResetLevelAction resetLevelAction= new ResetLevelAction();
		rootPaneActionMap.put("resetLevel", resetLevelAction);
	}
	
	private class ActivateActiveGameStateAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Activating ActiveGameState");
			controller.changeGameStateFromMenuToActive();
		}
	}

	private class ActivateMiniGameGameStateAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Activating MiniGameGameState");
			controller.changeGameStateFromActiveToMinigame();
		}
	}

	private class ActivateGameOverGameStateAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Activating GameOverGameState");
			controller.changeGameStateFromActiveToGameOver();
		}
	}

	private class ChangeToAirLevelAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Changing to air level");
			controller.changeLevels("a");
		}
	}

	private class ChangeToWaterLevelAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Changing to water");
			controller.changeLevels("w");;
		}
	}

	private class ResetLevelAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Resetting level");
			controller.resetLevel();
		}
	}
	
}





