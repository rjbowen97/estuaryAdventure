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
		
		ScoreBoard theReturn=new ScoreBoard();
		
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("scores.txt"));
			theReturn=(ScoreBoard)(input.readObject());
			input.close();
			
		} catch (FileNotFoundException e) {
			return theReturn;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return theReturn;
	}
	
	public static void saveScoreboard(ScoreBoard scores){
		
		ObjectOutputStream output;
		try {
			output = new ObjectOutputStream(new FileOutputStream("scores.txt"));
			output.writeObject(scores);
			output.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
}
