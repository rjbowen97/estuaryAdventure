package views;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Settings;

public class GameOverView extends JFrame {

	public GameOverView() {
		this.setBounds(0,0,Settings.getViewDimensionDefault(), Settings.getViewDimensionDefault());
		this.setContentPane(new GameOverPanel());
		this.setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class GameOverPanel extends JPanel {
		public GameOverPanel() {
			JLabel gameOverLabel = new JLabel("GAME OVER");
			gameOverLabel.setSize(100,100);
			this.add(gameOverLabel);
			this.setBounds(0,0,Settings.getViewDimensionDefault(), Settings.getViewDimensionDefault());
		}
	}
}

