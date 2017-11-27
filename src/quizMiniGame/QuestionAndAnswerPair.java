package quizMiniGame;

// TODO: Auto-generated Javadoc
/**
 * The Class QuestionAndAnswerPair.
 */
public class QuestionAndAnswerPair {
	
	/** The question. */
	String question;
	
	/** The answer A. */
	String answerA;
	
	/** The answer B. */
	String answerB;
	
	/** The answer C. */
	String answerC;
	
	/** The correct answer. */
	String correctAnswer;
	
	/**
	 * Instantiates a new question and answer pair.
	 *
	 * @param question the question
	 * @param answerA the answer A
	 * @param answerB the answer B
	 * @param answerC the answer C
	 * @param correctAnswer the correct answer
	 */
	public QuestionAndAnswerPair(String question, String answerA, String answerB, String answerC, String correctAnswer) {
		this.question = question;
		this.answerA = answerA;
		this.answerB = answerB;
		this.answerC = answerC;
		this.correctAnswer = correctAnswer;
	}
}
