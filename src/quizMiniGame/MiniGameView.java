package quizMiniGame;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Settings;

public class MiniGameView extends JFrame {

	MiniGame miniGame;
	
	public MiniGameView(MiniGame miniGame) {
		this.miniGame = miniGame;
		
		this.setBounds(0,0,Settings.getViewDimensionDefault(), Settings.getViewDimensionDefault());
		this.setContentPane(new MiniGamePanel());
		this.setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private class MiniGamePanel extends JPanel implements ActionListener {
		
		JButton answerAButton = new JButton(miniGame.getCurrentQuestionAndAnswerPair().answer);
		JButton answerBButton = new JButton(miniGame.getCurrentQuestionAndAnswerPair().answer);
		JButton answerCButton = new JButton(miniGame.getCurrentQuestionAndAnswerPair().answer);
		JButton answerDButton = new JButton(miniGame.getCurrentQuestionAndAnswerPair().answer);
		
		public MiniGamePanel() {
			this.add(new JLabel(miniGame.getCurrentQuestionAndAnswerPair().question));
			
			answerAButton.setActionCommand("answerA");
			answerAButton.addActionListener(this);
			
			answerBButton.setActionCommand("answerB");
			answerBButton.addActionListener(this);
			
			answerCButton.setActionCommand("answerC");
			answerCButton.addActionListener(this);
			
			answerDButton.setActionCommand("answerD");
			answerDButton.addActionListener(this);
			
			
			this.add(answerAButton);
			this.add(answerBButton);
			this.add(answerCButton);
			this.add(answerDButton);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("answerA")) {
				System.out.println("A Chosen!");
			}
			
			else if (e.getActionCommand().equals("answerB")) {
				System.out.println("B Chosen!");
			}
			
			else if (e.getActionCommand().equals("answerC")) {
				System.out.println("C Chosen!");
			}
			
			else if (e.getActionCommand().equals("answerD")) {
				System.out.println("D Chosen!");
			}
			
		}
	}
}
