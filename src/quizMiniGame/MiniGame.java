package quizMiniGame;

import java.util.ArrayList;

import models.GameModel;

public class MiniGame extends GameModel {
	
	private ArrayList<QuestionAndAnswerPair> questionAndAnswerPairs;
	
	private QuestionAndAnswerPair currentQuestionAndAnswerPair;
	
	private String currentPlayerAnswer = "";
	
	private int correctAnswerFlag = 0;
	
	public MiniGame() {
		QuestionAndAnswerPairsReader questionAndAnswerPairsReader = new QuestionAndAnswerPairsReader();
		this.questionAndAnswerPairs = questionAndAnswerPairsReader.getQuestionAndAnswerPairs();
		this.currentQuestionAndAnswerPair = this.questionAndAnswerPairs.get(0);
	}

	@Override
	public void onTick() {
		updateCorrectAnswerFlag();
	}
	
	private void updateCorrectAnswerFlag() {
		
		if (currentPlayerAnswer.isEmpty()) {
			this.correctAnswerFlag = 0;
		}
		
		else {
			if (currentPlayerAnswer.equals(currentQuestionAndAnswerPair.correctAnswer)) {
				this.correctAnswerFlag = 1;
			}
			
			else {
				this.correctAnswerFlag = -1;
			}
		}
	}
	
	public int getCorrectAnswerFlag() {
		return this.correctAnswerFlag;
	}
	
	public QuestionAndAnswerPair getCurrentQuestionAndAnswerPair() {
		return this.currentQuestionAndAnswerPair;
	}
	
	public void setCurrentPlayerAnswer(String currentPlayerAnswer) {
		this.currentPlayerAnswer = currentPlayerAnswer;
	}
	
	@Override
	protected void setSpriteImage() {
		
	}

	@Override
	protected void setHitbox() {
		
	}

	@Override
	protected void updateHitbox() {
		
	}

	@Override
	public void reset() {
	}
	
	public void resetMiniGameOnNonZeroCorrectAnswerFlag() {
		this.resetCurrentPlayerAnswer();
		this.resetCorrectAnswerFlag();
	}
	
	private void resetCurrentPlayerAnswer() {
		this.currentPlayerAnswer = "";
	}
	
	private void resetCorrectAnswerFlag() {
		this.correctAnswerFlag = 0;
	}

}