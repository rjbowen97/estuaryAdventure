package views;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import models.ScoreBoard;
import models.ScoreBoardEntry;

// TODO: Auto-generated Javadoc
/**
 * The Class ScoreBoardPanel.
 */
public class ScoreBoardPanel extends JPanel implements Serializable, ActionListener{
	
	/** The score board. */
	ScoreBoard scoreBoard;
	
	/** The score board entry labels. */
	ArrayList<JLabel> scoreBoardEntryLabels = new ArrayList<JLabel>();

	/** The replay button. */
	//buttons
		JButton replayButton;
		
		/** The quit button. */
		JButton quitButton;
		
		/** The action buttons. */
		private final ButtonGroup actionButtons = new ButtonGroup();
		
		/** The panel. */
		private JPanel panel;

		/** The controller. */
		private Controller controller;
	
	/**
	 * Instantiates a new score board panel. This is what the user sees when they complete the game or it is ended
	 * This contains scores of previous users who have played the game as well as Replay and quit buttons
	 *
	 * @param scoreBoard the score board
	 * @param controller the controller
	 */
	public ScoreBoardPanel(ScoreBoard scoreBoard, Controller controller) {
		this.scoreBoard = scoreBoard;
		this.controller = controller;
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		for (ScoreBoardEntry scoreBoardEntry : scoreBoard.scoreBoardEntries) {
			this.scoreBoardEntryLabels.add(new JLabel("UserName: " + scoreBoardEntry.name + " Score: " + scoreBoardEntry.score));	
		}
		
		while (scoreBoardEntryLabels.size() < 10) {
			scoreBoardEntryLabels.add(new JLabel());
		}
		
		int y = 10;
		JPanel scorePanel = new JPanel();
		scorePanel.setBounds(0, 0, 800, 450);
		add(scorePanel);
		for (JLabel jLabel : scoreBoardEntryLabels) {
			jLabel.setBounds(0, y, scorePanel.getWidth(), 20);
			y+=10;
			this.add(jLabel);
		}
//		scorePanel.setBounds(200, 0, 400, 450);
//		this.add(scorePanel);
		this.setBounds(0, 0, 800, 450);
		
		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(this);
		
		this.replayButton = new JButton("Play again for a new level!");
		add(replayButton);
		replayButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		actionButtons.add(replayButton);
		replayButton.addActionListener(this);
		replayButton.setActionCommand("replay");
		add(quitButton);
		
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		int currentLabelIndex = 0;
		for (ScoreBoardEntry scoreBoardEntry : scoreBoard.scoreBoardEntries) {
			scoreBoardEntryLabels.get(currentLabelIndex).setText(scoreBoardEntry.name + " Score: " + scoreBoardEntry.score);
			currentLabelIndex++;
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * Listens for user interaction, replays and resets the level upon the ReplayButton and Quits on quit
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "replay") {
			controller.resetLevel();
			
			if (controller.activeGameState.interactableModels.get(0).isInWater) {				
				controller.changeLevels("a");
			}
			
			else {
				controller.changeLevels("w");
			}
			
			controller.activeGameState.isTutorial = false;
			
			controller.changeGameStateFromMenuToActive();
		}
		else if(e.getActionCommand() == "Quit"){
			System.out.println("1");
			System.exit(0);
		}
	}

}
