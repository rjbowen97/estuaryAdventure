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
	
	/** The score board entries array */
	public ArrayList<ScoreBoardEntry> scoreBoardEntries;

	/**
	 * Instantiates a new score board.
	 * creates an arrayList of ScoreBoardEntry objects
	 */
	public ScoreBoard() {
		scoreBoardEntries = new ArrayList<ScoreBoardEntry>();	
	}
	
	/**
	 * Adds the new entry to the arrayList, sorts it in descending order
	 * and lops off the 11th element, keeping the top 10 scores
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
	 * Adds the new score taking in a player object as a parameter,
	 * and calls the new entry add score method using the players information
	 * @param player the player
	 */
	public void addNewScore(Player player) {
		ScoreBoardEntry scoreBoardEntry = new ScoreBoardEntry();
		scoreBoardEntry.name = "default";
		scoreBoardEntry.score = calculateFinalPlayerScore(player);
		this.addNewScore(scoreBoardEntry);
	}
	
	/**
	 * Calculate final player score by adding health and score
	 * score is number of interactables collected and number of questions correct
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
