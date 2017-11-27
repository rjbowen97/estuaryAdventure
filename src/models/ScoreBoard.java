package models;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;

import views.ScoreBoardPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class ScoreBoard.
 */
public class ScoreBoard implements Serializable{
	
	/** The score board panel. */
	public ScoreBoardPanel scoreBoardPanel;
	
	/** The score board entries. */
	public ArrayList<ScoreBoardEntry> scoreBoardEntries;

	/**
	 * Instantiates a new score board.
	 */
	public ScoreBoard() {
		scoreBoardEntries = new ArrayList<ScoreBoardEntry>();	
	}
	
	/**
	 * Adds the new score.
	 *
	 * @param newEntry the new entry
	 */
	public void addNewScore(ScoreBoardEntry newEntry){
		scoreBoardEntries.add(newEntry);
		scoreBoardEntries.sort(null);
		if (scoreBoardEntries.size() > 10) {
			scoreBoardEntries.remove(10);
		}
	}
	
	/**
	 * Adds the new score.
	 *
	 * @param player the player
	 */
	public void addNewScore(Player player) {
		ScoreBoardEntry scoreBoardEntry = new ScoreBoardEntry();
		scoreBoardEntry.name = "default";
		scoreBoardEntry.score = calculateFinalPlayerScore(player);
		this.addNewScore(scoreBoardEntry);
	}
	
	/**
	 * Calculate final player score.
	 *
	 * @param player the player
	 * @return the int
	 */
	private int calculateFinalPlayerScore(Player player) {
		int finalPlayerScore = 0;
		
		finalPlayerScore += player.getScore();
		finalPlayerScore += player.getHealth();
		
		return finalPlayerScore;
	}
	
}
