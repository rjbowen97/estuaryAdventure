package views;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import controller.Settings;
import models.ScoreBoard;
import models.ScoreBoardEntry;
import java.awt.Button;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

// TODO: Auto-generated Javadoc
/**
 * The Class ScoreBoardPanel.
 */
public class ScoreBoardPanel extends JPanel implements Serializable, ActionListener{
	
	/** The score board. */
	ScoreBoard scoreBoard;
	
	/** The score board entry labels. */
	ArrayList<JLabel> scoreBoardEntryLabels = new ArrayList<JLabel>();

	//buttons
		JButton replayButton;
		
		JButton quitButton;
		private final ButtonGroup actionButtons = new ButtonGroup();
		private JPanel panel;

		private Controller controller;
	
	/**
	 * Instantiates a new score board panel.
	 *
	 * @param scoreBoard the score board
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
	
	@Override
	public void paintComponent(Graphics g) {
		int currentLabelIndex = 0;
		for (ScoreBoardEntry scoreBoardEntry : scoreBoard.scoreBoardEntries) {
			scoreBoardEntryLabels.get(currentLabelIndex).setText(scoreBoardEntry.name + " Score: " + scoreBoardEntry.score);
			currentLabelIndex++;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "replay") {
			System.out.println("swag");
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
