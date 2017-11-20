package models;

import java.awt.image.BufferedImage;

public abstract class GameModel {
	private int xPosition;
	private int yPosition;
	private BufferedImage spriteImage;
	private int speed = 0;
	
	protected abstract void setSpriteImage();

	public abstract void onTick();
	
	public int getXPosition() {
		return this.xPosition;
	}
	
	public int getYPosition() {
		return this.yPosition;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public BufferedImage getSpriteImage() {
		return this.spriteImage;
	}
	
	protected void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	protected void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	
	protected void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
}
