package models;

import java.awt.image.BufferedImage;

public abstract class GameModel {
	private int xPosition;
	private int yPosition;
	private BufferedImage spriteImage;
	private int speed = 0;
	private Hitbox hitbox;
	
	protected abstract void setSpriteImage();
	protected abstract void setHitbox();
	protected abstract void updateHitbox();
	public abstract void onTick();
	
	public Hitbox getHitbox() {
		return hitbox;
	}
	
	protected void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}
	
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
	
	protected void setSpriteImage(BufferedImage spriteImage) {
		this.spriteImage = spriteImage;
	}
	
	
}
