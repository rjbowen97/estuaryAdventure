package models;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.Settings;

public abstract class Player implements GameModel{
		
	protected int health;
	protected int score;
	protected int xPosition;
	protected int yPosition;
	protected int hitboxHeight;
	protected int hitboxWidth;
	
	protected BufferedImage spriteImage;
	
	public Player() {
		this.xPosition = Settings.getPlayerStartXPosition();
		this.yPosition = Settings.getPlayerStartYPosition();
		this.setSpriteImage();
		this.setHitboxDimensions();
	}
	
	private void setHitboxDimensions() {
		this.hitboxHeight = this.spriteImage.getHeight();
		this.hitboxWidth = this.spriteImage.getWidth();
	}
	
	private void setSpriteImage() {
		BufferedImage spriteImageToUse = null;
		
		try {
			File spriteFile = new File("./sprites/sprite.jpg");
			
			if(spriteFile.exists() == true){
				spriteImageToUse = ImageIO.read(spriteFile);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		this.spriteImage = spriteImageToUse;
		
	}
	
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
	
	public int getHitboxHeight () {
		return hitboxHeight;
	}
	
	public int getHitboxWidth () {
		return hitboxWidth;
	}
	
}
