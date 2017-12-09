package quizMiniGame;

import java.io.Serializable;

/**
 * The Class QuestionAndAnswerPair, which consists of a question, several possible answers, and the 
 * index of the correct answer
 */
public class QuestionAndAnswerPair implements Serializable {
	
	/** The question. */
	String question;
	
	/** The answer A. */
	String answerA;
	
	/** The answer B. */
	String answerB;
	
	/** The answer C. */
	String answerC;
	
	/** The correct answer index. */
	String correctAnswer;
	
	/**
	 * Instantiates a new question and answer pair.
	 *
	 * @param question the question
	 * @param answerA the answer A
	 * @param answerB the answer B
	 * @param answerC the answer C
	 * @param correctAnswer the correct answer index
	 */
	public QuestionAndAnswerPair(String question, String answerA, String answerB, String answerC, String correctAnswer) {
		this.question = question;
		this.answerA = answerA;
		this.answerB = answerB;
		this.answerC = answerC;
		this.correctAnswer = correctAnswer;
	}
}
