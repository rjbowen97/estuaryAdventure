package models;

import java.util.Random;

import controller.Settings;

public class Interactable implements GameModel {
	private int xPosition;
	private int yPosition;
	private boolean isFood;
	private String spriteFilePath;
	
	Random random = new Random();
	
	public Interactable() {
		this.xPosition = random.nextInt(Settings.getViewDimensionDefault());
		this.yPosition = Settings.getInteractableStartYPosition();
		this.isFood = random.nextBoolean();
		
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
		this.xPosition -= Settings.getInteractableSpeed();
	}
	
}