package models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import controller.Settings;

public class Player {

	//limits
	
	//attributes
	private int health;
	private int score;

	private int xPosition;
	private int yPosition;
	private int size;

	private String spriteFile = "./sprites/sprite.jpg";
	public BufferedImage sprite;
	
	private boolean poweredUp;
	
	/* This constructor takes in the animal type, which is then used to
	 * display the correct animal type to the screen, and sets the starting position to 0,0.
	 * 
	 * @param animalType enum parameter to determine which sprite to use.
	 * 
	 * */
	
	public Player(PlayerAnimalType animalType) {
				
		if (animalType == PlayerAnimalType.BIRD){
			//sprite = birdSprite;
		}
		
		else if (animalType == PlayerAnimalType.FISH){
			//sprite = fishSprite;
		}
		
		else if (animalType == PlayerAnimalType.CRAB){
			//sprite = crabSprite;
		}
		
		this.size = Integer.parseInt(Settings.globalSettings.getProperty("playerSize"));
		
	}
	
	public void move(int xIncrement, int yIncrement) {
		this.xPosition += xIncrement;
		this.yPosition += yIncrement;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getXPosition() {
		return xPosition;
	}
	
	public void setXPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	
	public int getYPosition() {
		return yPosition;
	}
	
	public void setYPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	
	public String getSpriteFile() {
		return spriteFile;
	}
	
	public void setSpriteFile(String spriteFile) {
		this.spriteFile = spriteFile;
	}
	
	public boolean isPoweredUp() {
		return poweredUp;
	}
	
	public void setPoweredUp(boolean poweredUp) {
		this.poweredUp = poweredUp;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
}
