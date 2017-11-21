package quizMiniGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import controller.Settings;

public class MiniGameView extends JFrame {

	MiniGame miniGame;
	Controller controller;

	public MiniGameView(MiniGame miniGame, Controller controller) {
		this.miniGame = miniGame;
		this.controller = controller;

		this.setBounds(0,0,Settings.getViewDimensionDefault(), Settings.getViewDimensionDefault());
		this.setContentPane(new MiniGamePanel());
		this.setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class MiniGamePanel extends JPanel implements ActionListener {

		JButton answerAButton = new JButton(miniGame.getCurrentQuestionAndAnswerPair().answerA);
		JButton answerBButton = new JButton(miniGame.getCurrentQuestionAndAnswerPair().answerB);
		JButton answerCButton = new JButton(miniGame.getCurrentQuestionAndAnswerPair().answerC);
		JButton answerDButton = new JButton(miniGame.getCurrentQuestionAndAnswerPair().answerD);

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
				controller.setMiniGameCurrentPlayerAnswer("A");
			}

			else if (e.getActionCommand().equals("answerB")) {
				controller.setMiniGameCurrentPlayerAnswer("B");
			}

			else if (e.getActionCommand().equals("answerC")) {
				controller.setMiniGameCurrentPlayerAnswer("C");
			}

			else if (e.getActionCommand().equals("answerD")) {
				controller.setMiniGameCurrentPlayerAnswer("D");
			}

		}
	}
}
