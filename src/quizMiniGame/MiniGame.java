package quizMiniGame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import controller.Settings;
import models.GameModel;

// TODO: Auto-generated Javadoc
/**
 * The Class MiniGame, which keeps track of the player's answer and various question and answer pairs
 */
public class MiniGame extends GameModel implements Serializable {
	
	/** The question and answer pairs. */
	private ArrayList<QuestionAndAnswerPair> questionAndAnswerPairs;
	
	/** The current question and answer pair. */
	private QuestionAndAnswerPair currentQuestionAndAnswerPair;
	
	/** The current player answer. */
	private String currentPlayerAnswer = "";
	
	/** The number of questions answered correctly by the player. */
	public int correctAnswerCount = 0;
	
	/** The amount of questions able to be answered in a row before the minigame ends. */
	public int questionLimit;
	
	/** True if the minigame is currently being playerd. */
	public boolean isActive = true;
	
	
	/**
	 * Instantiates a new MiniGame.
	 */
	public MiniGame() {
		QuestionAndAnswerPairsReader questionAndAnswerPairsReader = new QuestionAndAnswerPairsReader();
		this.questionLimit = Settings.getMiniGameQuestionLimit();
		this.questionAndAnswerPairs = questionAndAnswerPairsReader.getQuestionAndAnswerPairs();
		this.currentQuestionAndAnswerPair = this.questionAndAnswerPairs.get(0);
	}

	/* (non-Javadoc)
	 * @see models.GameModel#onTick()
	 */
	@Override
	public void onTick() {
		updateCorrectAnswerFlag();
	}
	
	/**
	 * Updates the correct answer flag if the player answers the current question and answer pair.
	 */
	private void updateCorrectAnswerFlag() {
		
		Random random = new Random();
		
		if (getCurrentPlayerAnswer().isEmpty()) {
			this.isActive = true;
		}
		
		else {
			if (getCurrentPlayerAnswer().equals(currentQuestionAndAnswerPair.correctAnswer)) {
				this.isActive = true;
				
				this.setCurrentPlayerAnswer("");
				this.currentQuestionAndAnswerPair = this.questionAndAnswerPairs.get(random.nextInt(questionAndAnswerPairs.size()));
				this.correctAnswerCount++;
				
				if (this.correctAnswerCount == this.questionLimit) {
					this.isActive = false;
				}
			}
			
			else {
				this.isActive = false;
			}
		}
	}
	
	/**
	 * Gets the current question and answer pair.
	 *
	 * @return the current question and answer pair
	 */
	public QuestionAndAnswerPair getCurrentQuestionAndAnswerPair() {
		return this.currentQuestionAndAnswerPair;
	}
	
	/**
	 * Sets the current player answer.
	 *
	 * @param currentPlayerAnswer the new current player answer
	 */
	public void setCurrentPlayerAnswer(String currentPlayerAnswer) {
		this.currentPlayerAnswer = currentPlayerAnswer;
	}
	

	/**
	 * Reset mini game.
	 */
	public void resetMiniGame() {
		this.correctAnswerCount = 0;
		this.resetCurrentPlayerAnswer();
	}

	/**
	 * Reset current player answer.
	 */
	private void resetCurrentPlayerAnswer() {
		this.setCurrentPlayerAnswer("");
	}

	/* (non-Javadoc)
	 * @see models.GameModel#setHitbox()
	 */
	@Override
	protected void setHitbox() {
	}

	/* (non-Javadoc)
	 * @see models.GameModel#updateHitbox()
	 */
	@Override
	protected void updateHitbox() {
	}

	/* (non-Javadoc)
	 * @see models.GameModel#reset()
	 */
	@Override
	public void reset() {
	}

	/**
	 * @return the currentPlayerAnswer
	 */
	public String getCurrentPlayerAnswer() {
		return currentPlayerAnswer;
	}
}






