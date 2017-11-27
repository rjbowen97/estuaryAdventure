package views;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Settings;
import models.ScoreBoard;
import models.ScoreBoardEntry;

public class ScoreBoardPanel extends JPanel {
	
	ScoreBoard scoreBoard;
	ArrayList<JLabel> scoreBoardEntryLabels = new ArrayList<JLabel>();
	
	public ScoreBoardPanel(ScoreBoard scoreBoard) {
		this.scoreBoard = scoreBoard;
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		for (ScoreBoardEntry scoreBoardEntry : scoreBoard.scoreBoardEntries) {
			this.scoreBoardEntryLabels.add(new JLabel(scoreBoardEntry.name + " " + scoreBoardEntry.score));	
		}
		
		for (JLabel jLabel : scoreBoardEntryLabels) {
			this.add(jLabel);
		}
		
		this.setBounds(0, 0, Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.setVisible(true);
	}

}
