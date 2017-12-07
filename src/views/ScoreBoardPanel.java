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
		private JPanel actionPanel;
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
		actionPanel = new JPanel();
		actionPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		actionPanel.setBounds(46, 186, 337, 46);
		add(actionPanel);
		actionPanel.setLayout(null);
//		scorePanel.setBounds(200, 0, 400, 450);
//		this.add(scorePanel);
		this.setBounds(0, 0, 800, 450);
		
		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(this);
		
		this.replayButton = new JButton("Replay");
		add(replayButton);
		replayButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		actionButtons.add(replayButton);
		
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
		if (e.getActionCommand().equals("replay")) {
			controller.resetLevel();
		}
		if(e.getActionCommand() == "Quit"){
			System.exit(0);
		}
	}

}
