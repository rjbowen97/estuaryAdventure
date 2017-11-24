package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ScoreBoardManager {

	public ScoreBoardManager() {
		// TODO Auto-generated constructor stub
	}

	public static ScoreBoard loadScoreBoard(){
		
		ScoreBoard loadedScoreBoard = new ScoreBoard();
		
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("scores.txt"));
			loadedScoreBoard = (ScoreBoard) input.readObject();
			input.close();
			
		} catch (FileNotFoundException e) {
			return loadedScoreBoard;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return loadedScoreBoard;
	}
	
	public static void saveScoreboard(ScoreBoard scoreBoard){
		
		ObjectOutputStream outputObjectStream;
		
		try {
			outputObjectStream = new ObjectOutputStream(new FileOutputStream("scores.txt"));
			outputObjectStream.writeObject(scoreBoard);
			outputObjectStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
}
