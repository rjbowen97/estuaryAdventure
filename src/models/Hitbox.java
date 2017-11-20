package models;

public class Hitbox {
	
	private GameModel gameModel;
	
	private int startCornerXPosition;
	private int startCornerYPosition;
	private int endCornerXPosition;
	private int endCornerYPosition;
	
	public Hitbox(GameModel gameModel) {
		this.gameModel = gameModel;
		this.startCornerXPosition = gameModel.getXPosition();
		this.startCornerYPosition = gameModel.getYPosition();
		this.endCornerXPosition = gameModel.getXPosition() + gameModel.getSpriteImage().getWidth();
		this.endCornerYPosition = gameModel.getYPosition() + gameModel.getSpriteImage().getHeight();
	}
	
	public void update() {
		this.startCornerXPosition = gameModel.getXPosition();
		this.startCornerYPosition = gameModel.getYPosition();
		this.endCornerXPosition = gameModel.getXPosition() + gameModel.getSpriteImage().getWidth();
		this.endCornerYPosition = gameModel.getYPosition() + gameModel.getSpriteImage().getHeight();
	}
	
}
