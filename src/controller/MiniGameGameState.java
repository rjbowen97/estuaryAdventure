package controller;

import quizMiniGame.MiniGame;
import quizMiniGame.MiniGameView;

public class MiniGameGameState {

	private MiniGame miniGame;
	private MiniGameView miniGameView;

	private int tickNumber = 0;

	public MiniGameGameState() {
		this.miniGame = new MiniGame();
		this.miniGameView = new MiniGameView(this.miniGame, this);
	}

	public void onTick() {
		this.miniGame.onTick();

		if (this.miniGame.getCorrectAnswerFlag() == 0) {
		}

		else {
			if (this.miniGame.getCorrectAnswerFlag() > 0) {
				playerModel.powerUp();
			}

			else if (this.miniGame.getCorrectAnswerFlag() < 0) {
			}

			miniGameView.setVisible(false);
			playerModel.resetScoreStreak();
			miniGame.resetMiniGameOnNonZeroCorrectAnswerFlag();
			view.setVisible(true);
			this.gameState = GameState.Active;
		}
		this.tickNumber++;
	}

	public void setMiniGameCurrentPlayerAnswer(String currentPlayerAnswer) {
		this.miniGame.setCurrentPlayerAnswer(currentPlayerAnswer);
	}
}
