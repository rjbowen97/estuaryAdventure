package views;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import controller.GameOverGameState;
import controller.Settings;

public class GameOverGameStatePanel extends JPanel {
	
	Controller controller;
	GameOverGameState gameOverGameState;
	
	public GameOverGameStatePanel(GameOverGameState gameOverGameState, Controller controller) {
		this.gameOverGameState = gameOverGameState;
		this.controller = controller;
		
		JLabel gameOverLabel = new JLabel("GAME OVER");
		this.add(gameOverLabel);
		
		this.setBounds(0,0,Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.setVisible(true);
	}
}

