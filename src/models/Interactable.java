package models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import controller.Settings;

public class Interactable extends GameModel {

	private boolean isFood;	
	private int activationTick;
	private boolean isActive = false;
	
	private Random random = new Random();
	
	public Interactable(int activationTick) {
		this.xPosition = Settings.getInteractableStartXPosition();
		this.yPosition = random.nextInt(Settings.getViewDimensionDefault());
		this.isFood = random.nextBoolean();
		this.speed = Settings.getInteractableSpeed();
		this.activationTick = activationTick;
		this.setSpriteImage();
		this.setHitboxDimensions();
	}
	
	private void setHitboxDimensions() {
		this.hitboxHeight = this.spriteImage.getHeight();
		this.hitboxWidth = this.spriteImage.getWidth();
	}
	
	protected void setSpriteImage() {
		
		BufferedImage foodImage = null;
		BufferedImage notFoodImage = null;
		
		try {
			File foodFile = new File("./sprites/foodSprite.jpg");
			File notFoodFile = new File("./sprites/notFoodSprite.jpg");
			
			if(foodFile.exists() == true){
				foodImage = ImageIO.read(foodFile);
			}
			
			if(notFoodFile.exists() == true){
				notFoodImage = ImageIO.read(notFoodFile);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		if (this.isFood == true) {
			this.spriteImage = foodImage;
		}
		
		else {
			this.spriteImage = notFoodImage;
		}
	}
	
	public void collisionWithPlayerModel(Player playerModel) {
		this.deactivate();
	}
	
	private void deactivate() {
		this.isActive = false;
	}
	
	public void activate() {
		this.isActive = true;
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
	
	public int getActivationTick() {
		return this.activationTick;
	}
	
	public BufferedImage getSpriteImage() {
		return this.spriteImage;
	}
	
	@Override
	public void onTick() {
		this.xPosition -= this.speed;
	}
	
}