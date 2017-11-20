package quizMiniGame;

import java.util.ArrayList;

public class MiniGame {
	
	ArrayList<QuestionAndAnswerPair> questionAndAnswerPairs;
	
	public MiniGame() {
		QuestionAndAnswerPairsReader questionAndAnswerPairsReader = new QuestionAndAnswerPairsReader();
		this.questionAndAnswerPairs = questionAndAnswerPairsReader.getQuestionAndAnswerPairs();
	}

}
