package models;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class ScoreBoardTest.
 */
public class ScoreBoardTest {

	/**
	 * Instantiates a new score board test.
	 */
	public ScoreBoardTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Test add new score.
	 */
	@Test
	public void testAddNewScore() {
		//create a new scoreBoard
		ScoreBoard myScoreBoard = new ScoreBoard();
		
		//verify that it is empty
		assertTrue(myScoreBoard.scoreBoardEntries.isEmpty());
		
		//create a new score board entry
		ScoreBoardEntry myScoreBoardEntry = new ScoreBoardEntry();
		myScoreBoardEntry.name="C";
		myScoreBoardEntry.score = 9;
		
		//add it to the score board
		myScoreBoard.addNewScore(myScoreBoardEntry);
		
		//verify that there is only one score present in the score board
		assertTrue(myScoreBoard.scoreBoardEntries.size()==1);
		
		//verify that it is the correct score
		assertTrue(myScoreBoard.scoreBoardEntries.get(0).score==9);
		
		//create a second score board entry, with a higher score
		myScoreBoardEntry = new ScoreBoardEntry();
		myScoreBoardEntry.name="Curtis";
		myScoreBoardEntry.score = 10;
		
		//add it to the score board
		myScoreBoard.addNewScore(myScoreBoardEntry);
		
		//verify that there are two entries
		assertTrue(myScoreBoard.scoreBoardEntries.size()==2);
		
		//verify that the first entry is the higher score
		assertTrue(myScoreBoard.scoreBoardEntries.get(0).score==10);
		
		//create a third score board entry with the lowest score
		myScoreBoardEntry = new ScoreBoardEntry();
		myScoreBoardEntry.name="D";
		myScoreBoardEntry.score = 8;
		
		
		//add it to the score board
		myScoreBoard.addNewScore(myScoreBoardEntry);
		
		//verify that there are three entries in the score board
		assertTrue(myScoreBoard.scoreBoardEntries.size()==3);
		
		//verify that it is the last entry
		assertTrue(myScoreBoard.scoreBoardEntries.get(2).score==8);
		
		//create and add 7 new scores to the score board
		for(int i = 1;i<8;i++){
			myScoreBoardEntry = new ScoreBoardEntry();
			myScoreBoardEntry.name="Default";
			myScoreBoardEntry.score = i;
			myScoreBoard.addNewScore(myScoreBoardEntry);
		}
		
		//verify that there are 10 entries in the score board
		assertTrue(myScoreBoard.scoreBoardEntries.size()==10);
		
		//add an 11th entry with a lower score than the lowest to the score board
		myScoreBoardEntry = new ScoreBoardEntry();
		myScoreBoardEntry.name="loser";
		myScoreBoardEntry.score = 0;
		myScoreBoard.addNewScore(myScoreBoardEntry);
		
		//verify that the 11th entry was not added to the score board
		assertTrue(myScoreBoard.scoreBoardEntries.size()==10);
		
		//verify last score is still higher than the one added
		assertTrue(myScoreBoard.scoreBoardEntries.get(9).score==1);
		
	}

}
