package quizMiniGame;

import java.util.ArrayList;
import java.util.Random;

import controller.Settings;
import models.GameModel;

public class MiniGame extends GameModel {
	
	private ArrayList<QuestionAndAnswerPair> questionAndAnswerPairs;
	
	private QuestionAndAnswerPair currentQuestionAndAnswerPair;
	
	private String currentPlayerAnswer = "";
	
	public boolean isActive = true;
	
	public int correctAnswerCount = 0;
	
	public int questionLimit;
	
	public MiniGame() {
		QuestionAndAnswerPairsReader questionAndAnswerPairsReader = new QuestionAndAnswerPairsReader();
		this.questionLimit = Settings.getMiniGameQuestionLimit();
		this.questionAndAnswerPairs = questionAndAnswerPairsReader.getQuestionAndAnswerPairs();
		this.currentQuestionAndAnswerPair = this.questionAndAnswerPairs.get(0);
	}

	@Override
	public void onTick() {
		updateCorrectAnswerFlag();
	}
	
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
	
	public void resetMiniGame() {
		this.correctAnswerCount = 0;
		this.resetCurrentPlayerAnswer();
	}
	
	private void resetCurrentPlayerAnswer() {
		this.currentPlayerAnswer = "";
	}
}






