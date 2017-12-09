package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.Settings;
import quizMiniGame.MiniGame;
import quizMiniGame.QuestionAndAnswerPair;

public class MiniGameTest {

	private MiniGame miniGame;
	
	@Before
	public void createMiniGame() {
		miniGame = new MiniGame();
		Settings settings = new Settings();
	}
	
	@Test
	public void testConstructo() {
		MiniGame constructedMiniGame = new MiniGame();
		assertTrue(constructedMiniGame.questionLimit == Settings.getMiniGameQuestionLimit());
	}
	
	@Test
	public void testCorrectAnswerFlag() {
		miniGame.setCurrentPlayerAnswer("");
		miniGame.onTick();
		
		assertTrue(miniGame.isActive == true);
		
		miniGame.setCurrentPlayerAnswer("B");
		miniGame.onTick();
		
		assertTrue(miniGame.getCurrentPlayerAnswer().equals(""));
		
		
	}

}
