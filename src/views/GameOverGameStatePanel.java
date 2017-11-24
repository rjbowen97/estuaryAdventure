package views;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Settings;

public class GameOverGameStatePanel extends JPanel {
	
	public GameOverGameStatePanel() {
		JLabel gameOverLabel = new JLabel("GAME OVER");
		gameOverLabel.setSize(100,100);
		this.add(gameOverLabel);
		this.setBounds(0,0,Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
	}
}
