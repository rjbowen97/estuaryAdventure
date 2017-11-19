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

	private String spriteFile = "./sprites/sprite.jpg";
		
	/* This constructor takes in the animal type, which is then used to
	 * display the correct animal type to the screen, and sets the starting position to 0,0.
	 * 
	 * @param animalType enum parameter to determine which sprite to use.
	 * 
	 * */
	
	public Player(PlayerAnimalType animalType) {
		
	}
	
	public void move(int xIncrement, int yIncrement) {
		this.xPosition += xIncrement;
		this.yPosition += yIncrement;
	}
	
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
