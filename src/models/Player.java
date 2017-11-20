package models;

import java.awt.event.MouseEvent;

import controller.Settings;

public abstract class Player implements GameModel{

	public Player() {
		this.xPosition = Settings.getPlayerStartXPosition();
		this.yPosition = Settings.getPlayerStartYPosition();
	}
		
	//attributes
	protected int health;
	protected int score;

	protected int xPosition;
	protected int yPosition;

	protected String spriteFile = "./sprites/sprite.jpg";
	
	public abstract void onMouseReleased(MouseEvent mouseEvent);
	
	public int getHealth() {
		return health;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getXPosition() {
		return xPosition;
	}
	
	public int getYPosition() {
		return yPosition;
	}
	
	public String getSpriteFile() {
		return spriteFile;
	}
}
