package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// TODO: Auto-generated Javadoc
/**
 * The Class ScoreBoardManager.
 */
public class ScoreBoardManager {

	/**
	 * Instantiates a new score board manager.
	 */
	public ScoreBoardManager() {
	}

	/**
	 * takes in the filename as a parameter. Creates a new score board, inputs, and reads
	 * 
	 * @param fileName the file name
	 * @return the score board
	 */
	public static ScoreBoard loadScoreBoard(String fileName){
		
		ScoreBoard loadedScoreBoard = new ScoreBoard();
		
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName));
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
	
	/**
	 * Saves the current score board, taking in the filename to hold it and the score board itself
	 * writes to the file
	 * @param scoreBoard the score board
	 * @param fileName the file name
	 */
	public static void saveScoreboard(ScoreBoard scoreBoard, String fileName){
		
		ObjectOutputStream outputObjectStream;
		
		try {
			outputObjectStream = new ObjectOutputStream(new FileOutputStream(fileName));
			outputObjectStream.writeObject(scoreBoard);
			outputObjectStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
}
