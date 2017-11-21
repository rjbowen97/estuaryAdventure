package quizMiniGame;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

import controller.Settings;

public class MiniGameView extends JFrame {

	MiniGame miniGame;
	
	public MiniGameView(MiniGame miniGame) {
		this.miniGame = miniGame;
		
		this.setBounds(0,0,Settings.getViewDimensionDefault(), Settings.getViewDimensionDefault());
		this.getContentPane().add(new MiniGameComponent());
		this.setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private class MiniGameComponent extends JComponent {
		public MiniGameComponent() {
			this.setBounds(0,0,Settings.getViewDimensionDefault(), Settings.getViewDimensionDefault());
		}
		
		@Override
		public void paintComponent(Graphics g) {
			
		}
	}
}
