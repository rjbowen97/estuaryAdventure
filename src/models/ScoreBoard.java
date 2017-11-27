package models;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;

import views.ScoreBoardPanel;

public class ScoreBoard implements Serializable{
	
	public ScoreBoardPanel scoreBoardPanel;
	
	public ArrayList<ScoreBoardEntry> scoreBoardEntries;

	public ScoreBoard() {
		scoreBoardEntries = new ArrayList<ScoreBoardEntry>();	
	}
	
	public void addNewScore(ScoreBoardEntry newEntry){
		scoreBoardEntries.add(newEntry);
		scoreBoardEntries.sort(null);
		if (scoreBoardEntries.size() > 10) {
			scoreBoardEntries.remove(10);
		}
	}
	
	public void addNewScore(Player player) {
		ScoreBoardEntry scoreBoardEntry = new ScoreBoardEntry();
		scoreBoardEntry.name = "default";
		scoreBoardEntry.score = calculateFinalPlayerScore(player);
		this.addNewScore(scoreBoardEntry);
	}
	
	private int calculateFinalPlayerScore(Player player) {
		int finalPlayerScore = 0;
		
		finalPlayerScore += player.getScore();
		finalPlayerScore += player.getHealth();
		
		return finalPlayerScore;
	}
	
}
