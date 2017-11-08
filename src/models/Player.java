package models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Player {

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
	
	public final int imgWidth = 165;
	public final int imgHeight = 165;
	
	
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
	
	
}
