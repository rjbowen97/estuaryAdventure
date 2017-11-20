package models;

import java.util.Random;

import controller.Settings;

public class Interactable implements GameModel {
	private int xPosition;
	private int yPosition;
	private boolean isFood;
	private String spriteFilePath;
	
	private int speed;
	
	private Random random = new Random();
	
	public Interactable() {
		this.xPosition = Settings.getInteractableStartXPosition();
		this.yPosition = random.nextInt(Settings.getViewDimensionDefault());
		this.isFood = random.nextBoolean();
		this.speed = random.nextInt(Settings.getInteractableMaxSpeed()) + 1;
		
		if (isFood) {
			this.spriteFilePath = "./sprites/foodSprite.jpg";
		} else {
			this.spriteFilePath = "./sprites/notFoodSprite.jpg";
		}
	}
	
	public int getXPosition() {
		return xPosition;
	}
	public int getYPosition() {
		return yPosition;
	}
	public boolean isFood() {
		return isFood;
	}
	
	public String getSpriteFilePath() {
		return this.spriteFilePath;
	}
	
	@Override
	public void onTick() {
		this.xPosition -= this.speed;
	}
	
}