package quizMiniGame;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Settings;

public class MiniGameView extends JFrame {

	MiniGame miniGame;
	
	public MiniGameView(MiniGame miniGame) {
		this.miniGame = miniGame;
		
		this.setBounds(0,0,Settings.getViewDimensionDefault(), Settings.getViewDimensionDefault());
		this.getContentPane().add(new MiniGamePanel());
		this.pack();
		this.setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private class MiniGamePanel extends JPanel {
		
		
		JButton answerAButton = new JButton(miniGame.getCurrentQuestionAndAnswerPair().answer);
		
		public MiniGamePanel() {
			this.add(answerAButton);
			answerAButton.setSize(1000,1000);
			this.setBounds(0,0,Settings.getViewDimensionDefault(), Settings.getViewDimensionDefault());
		}
		
		@Override
		public void paintComponent(Graphics g) {
			g.drawString(miniGame.getCurrentQuestionAndAnswerPair().question, 500, 500);
		}
	}
}
