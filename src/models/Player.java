package models;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import controller.Settings;

public abstract class Player implements GameModel{

	public Player() {
		this.xPosition = Settings.getPlayerStartXPosition();
		this.yPosition = Settings.getPlayerStartYPosition();
		this.hitBoxHeight = Settings.getPlayerHitBoxHeight();
	}
		
	//attributes
	protected int health;
	protected int score;
	protected int xPosition;
	protected int yPosition;
	protected int hitBoxHeight;
	
	protected BufferedImage spriteImage;
	
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
	
	public BufferedImage getSpriteImage() {
		return spriteImage;
	}
	
	public int getHitBoxHeight () {
		return hitBoxHeight;
	}
}
