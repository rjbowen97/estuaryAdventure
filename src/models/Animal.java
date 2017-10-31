package models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Animal {

	//limits
	protected final int MAXHEALTH = 100;
	private int moveIncrement = 10;
	
	//attributes
	private int health;
	private int score;
	private int xPosition, yPosition;
	private int velocity;

	private String spriteFile = "sprite.jpg";
	public BufferedImage sprite;
	
	private boolean poweredUp;
	
	public final int frameWidth = 500;
	public final int frameHeight = 300;
	public final int imgWidth = 165;
	public final int imgHeight = 165;
	
	
	public Animal(AnimalType animalType) {
		
		if (animalType == AnimalType.BIRD){
			//sprite = birdSprite;
		}
		
		else if (animalType == AnimalType.FISH){
			//sprite = fishSprite;
		}
		
		else if (animalType == AnimalType.CRAB){
			//sprite = crabSprite;
		}
		
		LoadBufferedImage(); 
	}
	
	private void LoadBufferedImage() {
		try {
			sprite = ImageIO.read(new File(spriteFile));
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void isMoveHorizontal(boolean right){
		
		if(right){
			xPosition += moveIncrement;
		}
		else {
			xPosition -= moveIncrement;
		}
		
	}
	
	public void isMoveVertical(boolean up){
		
		if(up){
			yPosition += moveIncrement;
		}
		else {
			yPosition -= moveIncrement;
		}
		
	}
	
	//getters and setters
	public double getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health; 
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getVelocity() {
		return velocity;
	}
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	public boolean isPoweredUp() {
		return poweredUp;
	}
	public void setPoweredUp(boolean poweredUp) {
		this.poweredUp = poweredUp;
	}


}
