package models;

import java.io.Serializable;
import java.util.ArrayList;

public class ScoreBoard implements Serializable{
	
	public ArrayList<ScoreBoardEntry> scores;

	public ScoreBoard() {
		scores=new ArrayList<ScoreBoardEntry>();	
	}
	
	public void addNewScore(ScoreBoardEntry newEntry){
		scores.add(newEntry);
		scores.sort(null);
		if(scores.size()==10){
			scores.remove(10);
		}		
	}
	
	public void addNewScore(Player thePlayer){
		ScoreBoardEntry entry = new ScoreBoardEntry();
		entry.name="default";
		entry.score = thePlayer.getScore()+thePlayer.getHealth();
		this.addNewScore(entry);
	}
}
