package quizMiniGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import controller.Settings;

public class MiniGameGameStatePanel extends JPanel implements ActionListener {

	MiniGame miniGame;
	Controller controller;

	JButton answerAButton;
	JButton answerBButton;
	JButton answerCButton;
	JButton answerDButton;

	public MiniGameGameStatePanel(MiniGame miniGame, Controller controller) {
		
		this.miniGame = miniGame;
		this.controller = controller;

		answerAButton = new JButton(miniGame.getCurrentQuestionAndAnswerPair().answerA);
		answerBButton = new JButton(miniGame.getCurrentQuestionAndAnswerPair().answerB);
		answerCButton = new JButton(miniGame.getCurrentQuestionAndAnswerPair().answerC);
		answerDButton = new JButton(miniGame.getCurrentQuestionAndAnswerPair().answerD);
		
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
		
		this.setBounds(0, 0, Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("answerA")) {
			controller.miniGameGameState.setMiniGameCurrentPlayerAnswer("A");
		}

		else if (e.getActionCommand().equals("answerB")) {
			controller.miniGameGameState.setMiniGameCurrentPlayerAnswer("B");
		}

		else if (e.getActionCommand().equals("answerC")) {
			controller.miniGameGameState.setMiniGameCurrentPlayerAnswer("C");
		}

		else if (e.getActionCommand().equals("answerD")) {
			controller.miniGameGameState.setMiniGameCurrentPlayerAnswer("D");
		}

	}
}
