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
import models.finishLine;
import quizMiniGame.MiniGameGameStatePanel;
import java.awt.Frame;
import java.awt.GridLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class View.
 */
public class View extends JFrame implements Serializable {

	/** The active game state panel. */
	public ActiveGameStatePanel activeGameStatePanel;
	
	/** The game over game state panel. */
	public GameOverGameStatePanel gameOverGameStatePanel;
	
	/** The menu panel. */
	public MenuPanel menuPanel;
	
	/** The mini game game state panel. */
	public MiniGameGameStatePanel miniGameGameStatePanel;

	/** The controller. */
	Controller controller;
	
	/**
	 * Instantiates a new view.
	 *
	 * @param playerModel the player model
	 * @param backgroundModels the background models
	 * @param controller the controller
	 * @param interactableModels the interactable models
	 * @param finishLine the finish line
	 */
	public View(Player playerModel, ArrayList<Background> backgroundModels, Controller controller, ArrayList<Interactable> interactableModels, finishLine finishLine) {
		
		this.activeGameStatePanel = new ActiveGameStatePanel(playerModel, backgroundModels, controller, interactableModels, finishLine);
		this.gameOverGameStatePanel = new GameOverGameStatePanel(controller);
		this.menuPanel = new MenuPanel(controller.menuGameState.menu, controller);
		this.miniGameGameStatePanel = new MiniGameGameStatePanel(controller.miniGameGameState.miniGame, controller);
		this.controller = controller;
		initializeKeyBindings();
		this.setBounds(0,0,Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.setExtendedState(Frame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.menuPanel.setLocation(Settings.getViewDimensionXDefault()/2, 0);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Initialize key bindings.
	 */
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
	
	/**
	 * The Class ActivateActiveGameStateAction.
	 */
	private class ActivateActiveGameStateAction extends AbstractAction {
		
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Activating ActiveGameState");
			controller.changeGameStateFromMenuToActive();
		}
	}

	/**
	 * The Class ActivateMiniGameGameStateAction.
	 */
	private class ActivateMiniGameGameStateAction extends AbstractAction {
		
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Activating MiniGameGameState");
			controller.changeGameStateFromActiveToMinigame();
		}
	}

	/**
	 * The Class ActivateGameOverGameStateAction.
	 */
	private class ActivateGameOverGameStateAction extends AbstractAction {
		
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Activating GameOverGameState");
			controller.changeGameStateFromActiveToGameOver();
		}
	}

	/**
	 * The Class ChangeToAirLevelAction.
	 */
	private class ChangeToAirLevelAction extends AbstractAction {
		
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Changing to air level");
			controller.pauseActiveGameStateModels();
		}
	}

	/**
	 * The Class ChangeToWaterLevelAction.
	 */
	private class ChangeToWaterLevelAction extends AbstractAction {
		
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Changing to water");
			controller.resumeActiveGameStateModels();
		}
	}

	/**
	 * The Class ResetLevelAction.
	 */
	private class ResetLevelAction extends AbstractAction {
		
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Resetting level");
			controller.resetLevel();
		}
	}
	
}





