package models;

import java.util.Random;

import controller.Settings;

public class Interactable implements GameModel {
	private int xPosition;
	private int yPosition;
	private boolean isFood;
	private String spriteFilePath;
	
	private boolean isActive = false;
	
	private int speed;
	
	private Random random = new Random();
	
	public Interactable() {
		this.xPosition = Settings.getInteractableStartXPosition();
		this.yPosition = random.nextInt(Settings.getViewDimensionDefault());
		this.isFood = random.nextBoolean();
		this.speed = Settings.getInteractableSpeed();
		
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
	
	public boolean isActive() {
		return this.isActive;
	}
	
	public String getSpriteFilePath() {
		return this.spriteFilePath;
	}
	
	@Override
	public void onTick() {
		this.xPosition -= this.speed;
	}
	
}