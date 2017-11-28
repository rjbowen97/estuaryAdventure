package views;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import controller.GameOverGameState;
import controller.Settings;

// TODO: Auto-generated Javadoc
/**
 * The Class GameOverGameStatePanel.
 */
public class GameOverGameStatePanel extends JPanel {
	
	/** The controller. */
	Controller controller;
	
	/** The game over game state. */
	GameOverGameState gameOverGameState;
	
	/**
	 * Instantiates a new game over game state panel.
	 *
	 * @param gameOverGameState the game over game state
	 * @param controller the controller
	 */
	public GameOverGameStatePanel(GameOverGameState gameOverGameState, Controller controller) {
		this.gameOverGameState = gameOverGameState;
		this.controller = controller;
		
		JLabel gameOverLabel = new JLabel("GAME OVER");
		this.add(gameOverLabel);
		
		this.setBounds(0,0,Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.setVisible(true);
	}
}

