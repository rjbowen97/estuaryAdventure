package quizMiniGame;

public class QuestionAndAnswerPair {
	String question;
	String answerA;
	String answerB;
	String answerC;
	String correctAnswer;
	
	public QuestionAndAnswerPair(String question, String answerA, String answerB, String answerC, String correctAnswer) {
		this.question = question;
		this.answerA = answerA;
		this.answerB = answerB;
		this.answerC = answerC;
		this.correctAnswer = correctAnswer;
	}
}
