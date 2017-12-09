package views;

import java.io.Serializable;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import controller.GameOverGameState;
import controller.Settings;

// TODO: Auto-generated Javadoc
/**
 * The Class GameOverGameStatePanel.
 */
public class GameOverGameStatePanel extends JPanel implements Serializable {
	
	/** The controller. */
	Controller controller;
	
	/** The game over game state. */
	GameOverGameState gameOverGameState;
	
	/**
	 * Instantiates a new game over game state panel. This panel was not used in our final project and was replaced with 
	 * ScoreBoard Panel
	 *
	 * @param controller the controller
	 */
	public GameOverGameStatePanel(Controller controller) {
		this.controller = controller;
		
		JLabel gameOverLabel = new JLabel("GAME OVER");
		this.add(gameOverLabel);
		
		this.setBounds(0,0,Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.setVisible(true);
	}
}

