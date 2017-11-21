package views;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Settings;

public class GameOverView extends JFrame {
	
	public GameOverView() {
		this.setBounds(0,0,Settings.getViewDimensionDefault(), Settings.getViewDimensionDefault());
		this.add(new GameOverPane());
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private class GameOverPane extends JPanel {
		public GameOverPane() {
			this.add(new GameOverComponent());
		}
		
		
		private class GameOverComponent extends JComponent {
			public GameOverComponent() {
			}
			
			@Override
			public void paint(Graphics g) {
				g.drawString("GAME OVER", Settings.getViewDimensionDefault() / 2, Settings.getViewDimensionDefault() / 2);
			}
			
		}
		
	}
}

