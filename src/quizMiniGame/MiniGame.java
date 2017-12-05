package quizMiniGame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import controller.Settings;
import models.GameModel;

// TODO: Auto-generated Javadoc
/**
 * The Class MINI_GAME.
 */
public class MiniGame extends GameModel implements Serializable {
	
	/** The question and answer pairs. */
	private ArrayList<QuestionAndAnswerPair> questionAndAnswerPairs;
	
	/** The current question and answer pair. */
	private QuestionAndAnswerPair currentQuestionAndAnswerPair;
	
	/** The current player answer. */
	private String currentPlayerAnswer = "";
	
	/** The is active. */
	public boolean isActive = true;
	
	/** The correct answer count. */
	public int correctAnswerCount = 0;
	
	/** The question limit. */
	public int questionLimit;
	
	/**
	 * Instantiates a new mini game.
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
	 * Update correct answer flag.
	 */
	private void updateCorrectAnswerFlag() {
		
		Random random = new Random();
		
		if (currentPlayerAnswer.isEmpty()) {
			this.isActive = true;
		}
		
		else {
			if (currentPlayerAnswer.equals(currentQuestionAndAnswerPair.correctAnswer)) {
				this.isActive = true;
				
				this.currentPlayerAnswer = "";
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
		this.currentPlayerAnswer = "";
	}
}






