package views;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Settings;
import models.ScoreBoard;
import models.ScoreBoardEntry;

// TODO: Auto-generated Javadoc
/**
 * The Class ScoreBoardPanel.
 */
public class ScoreBoardPanel extends JPanel implements Serializable {
	
	/** The score board. */
	ScoreBoard scoreBoard;
	
	/** The score board entry labels. */
	ArrayList<JLabel> scoreBoardEntryLabels = new ArrayList<JLabel>();
	
	/**
	 * Instantiates a new score board panel.
	 *
	 * @param scoreBoard the score board
	 */
	public ScoreBoardPanel(ScoreBoard scoreBoard) {
		this.scoreBoard = scoreBoard;
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		for (ScoreBoardEntry scoreBoardEntry : scoreBoard.scoreBoardEntries) {
			this.scoreBoardEntryLabels.add(new JLabel("UserName: " + scoreBoardEntry.name + " Score: " + scoreBoardEntry.score));	
		}
		
		while (scoreBoardEntryLabels.size() < 10) {
			scoreBoardEntryLabels.add(new JLabel());
		}
		
		for (JLabel jLabel : scoreBoardEntryLabels) {
			this.add(jLabel);
		}
		
		this.setBounds(0, 0, Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		int currentLabelIndex = 0;
		for (ScoreBoardEntry scoreBoardEntry : scoreBoard.scoreBoardEntries) {
			scoreBoardEntryLabels.get(currentLabelIndex).setText(scoreBoardEntry.name + " Score: " + scoreBoardEntry.score);
			currentLabelIndex++;
		}
	}

}
