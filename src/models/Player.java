package models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import controller.Settings;

public class Player {

	//limits
	protected final int MAXHEALTH = 3;
	private int moveIncrement = 10;
	
	//attributes
	private int health;
	private int score;
	private int xPosition, yPosition;
	private int velocity;
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
		
		size = Integer.parseInt(Settings.globalSettings.get("playerSize").toString());
		
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
	
	/* This function controls the horizontal movement of the model by incrementing
	 * the x position by a factor of the variable moveIncrement.
	 * 
	 * @param right boolean parameter that moves the model right if true and left if false by
	 * the move increment
	 * 
	 * */
	
	public void isMoveHorizontal(boolean right){
		if(right){
			xPosition += moveIncrement;
		}
		else {
			xPosition -= moveIncrement;
		}
	}
	
	/* This function controls the vertical movement of the model by incrementing
	 * the y position by a factor of moveIncrement.
	 * 
	 * @param up boolean parameter that moves the model up if true and down if false by
	 * the move increment
	 * 
	 * */
	
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
	
	/* Main
	 * 
	 * */

	public static void main(String[] Argsv){
		
		Player an = new Player(PlayerAnimalType.BIRD);

		
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		int n = 0;
		//once finished
		System.out.println("1: Move Right, 2 Move Left, 3 Move Up, 4 Move Down");
		
		while(n != -1){
			System.out.println("Enter a number: ");
			n = reader.nextInt(); // Scans the next token of the input as an int.
			System.out.println("Original X Position: " + an.getXPosition());
			System.out.println("Original Y Position: " + an.getYPosition());
			if(n == 1){
				an.isMoveHorizontal(true);
				System.out.println("Move Horizontal: "+ an.getXPosition());
			}else if(n == 2){
				an.isMoveHorizontal(false);
				System.out.println("Move Horizontal Back: "+ an.getXPosition());
			}else if(n == 3){
				an.isMoveVertical(false);
				System.out.println("Move Vertical: " + an.getYPosition());
			}else{
				an.isMoveVertical(true);
				System.out.println("Move Vertical Back: " + an.getYPosition());
			}
			
			
		}
		
		reader.close(); 
		
	}



	public String getSpriteFile() {
		return spriteFile;
	}



	public void setSpriteFile(String spriteFile) {
		this.spriteFile = spriteFile;
	}
	
	
}
