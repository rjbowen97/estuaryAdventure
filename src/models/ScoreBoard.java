package models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The Class ScoreBoard, which stores scoreboard entries from a serialized file.
 */
public class ScoreBoard implements Serializable {
	
	/**  The score board entries array. */
	public ArrayList<ScoreBoardEntry> scoreBoardEntries;

	/**
	 * Instantiates a new score board.
	 * creates an arrayList of ScoreBoardEntry objects
	 */
	public ScoreBoard() {
		scoreBoardEntries = new ArrayList<ScoreBoardEntry>();	 
	}
	
	/**
	 * Adds the new entry to the arrayList, sorts it in descending order,
	 * and removes the 11th element if it exists, keeping the top 10 scores.
	 *
	 * @param newEntry the new entry to add
	 */
	public void addNewScore(ScoreBoardEntry newEntry){
		scoreBoardEntries.add(newEntry);
		scoreBoardEntries.sort(null);
		if (scoreBoardEntries.size() > 10) {
			scoreBoardEntries.remove(10);
		}
	}
	
	/**
	 * Adds the new, score taking in a player object as a parameter,
	 * and then calls the new entry's addNewScore method using the player's information.
	 *
	 * @param playerModel the player
	 */
	public void addNewScore(Player playerModel) {
		ScoreBoardEntry scoreBoardEntry = new ScoreBoardEntry();
		scoreBoardEntry.name = playerModel.getPlayerName();
		scoreBoardEntry.score = calculateFinalPlayerScore(playerModel);
		this.addNewScore(scoreBoardEntry);
	}
	
	/**
	 * Calculate final player score by adding remaining health, the number of interactables collected,
	 * and the number of questions correct.
	 *
	 * @param playerModel the player
	 * @return the calculated score of the player
	 */
	private int calculateFinalPlayerScore(Player playerModel) {
		int finalPlayerScore = 0;
		
		finalPlayerScore += playerModel.getScore();
		finalPlayerScore += playerModel.getHealth();
		
		return finalPlayerScore;
	}
	
}
