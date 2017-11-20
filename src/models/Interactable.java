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
		this.setxPosition(Settings.getInteractableStartXPosition());
		this.setyPosition(random.nextInt(Settings.getViewDimensionDefault()));
		this.isFood = random.nextBoolean();
		this.setSpeed(Settings.getInteractableSpeed());
		this.activationTick = activationTick;
		this.setSpriteImage();
	}
	
	@Override
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
			this.setSpriteImage(foodImage);
		}
		
		else {
			this.setSpriteImage(notFoodImage);
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
	
	public boolean isFood() {
		return isFood;
	}
	
	public boolean isActive() {
		return this.isActive;
	}
	
	public int getActivationTick() {
		return this.activationTick;
	}
	
	@Override
	public void onTick() {
		int newXPosition = this.getXPosition() - this.getSpeed();
		this.setxPosition(newXPosition);
	}
	
}