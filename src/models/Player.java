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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

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
		xPosition = 0;
		yPosition = 0;		
	}
	
	//getters and setters
	public double getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		System.out.println(this.health);
		this.health = health; 
	}
	
	public int getXPosition() {
		return xPosition;
	}
	
	public void setXPosition(int xPosition) {
		System.out.println("X Position " + xPosition);
		this.xPosition = xPosition;
	}
	
	public int getYPosition() {
		return yPosition;
	}
	
	public void setYPosition(int yPosition) {
		System.out.println("Y Position " + yPosition);
		this.yPosition = yPosition;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public boolean isPoweredUp() {
		return poweredUp;
	}
	
	public void setPoweredUp(boolean poweredUp) {
		this.poweredUp = poweredUp;
	}

	public String getSpriteFile() {
		return spriteFile;
	}



	public void setSpriteFile(String spriteFile) {
		this.spriteFile = spriteFile;
	}
	
	
}
