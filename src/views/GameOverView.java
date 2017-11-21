package views;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

import controller.Settings;

public class GameOverView extends JFrame {

	public GameOverView() {
		this.setBounds(0,0,Settings.getViewDimensionDefault(), Settings.getViewDimensionDefault());
		this.getContentPane().add(new GameOverComponent());
		this.setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class GameOverComponent extends JComponent {
		public GameOverComponent() {
			this.setBounds(0,0,Settings.getViewDimensionDefault(), Settings.getViewDimensionDefault());
		}

		@Override
		public void paintComponent(Graphics g) {
			g.drawString("GAME OVER", 500, 500);
		}

	}

}

