package models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Animal {

	//limits
	protected final int MAXHEALTH = 100;
	
	//attributes
	private int health;
	private int score;
	private int xPosition, yPosition;
	private int xAcceleration;
	private int yAcceleration;
	private int velocity;

	private String spriteFile = "C:\\Users\\RJ\\Coding\\IDEs\\Eclipse\\workspace\\estuaryAdventure\\src\\models\\sprite.png";
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
	
	public void move(){
		
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
	public int getXAcceleration() {
		return xAcceleration;
	}
	public void setXAcceleration(int xAcceleration) {
		this.xAcceleration = xAcceleration;
	}
	public int getYAcceleration() {
		return yAcceleration;
	}
	public void setYAcceleration(int yAcceleration) {
		this.yAcceleration = yAcceleration;
	}


}
