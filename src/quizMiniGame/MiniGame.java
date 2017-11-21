package quizMiniGame;

import java.util.ArrayList;

import models.GameModel;

public class MiniGame extends GameModel {
	
	private ArrayList<QuestionAndAnswerPair> questionAndAnswerPairs;
	
	private QuestionAndAnswerPair currentQuestionAndAnswerPair;
	
	private String currentPlayerAnswer;
	
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
			if (currentPlayerAnswer.equals(currentQuestionAndAnswerPair.answer)) {
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
	
	@Override
	protected void setSpriteImage() {
		
	}

	@Override
	protected void setHitbox() {
		
	}

	@Override
	protected void updateHitbox() {
		
	}

}