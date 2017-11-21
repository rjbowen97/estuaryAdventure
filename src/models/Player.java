package models;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.Settings;

public abstract class Player extends GameModel {
		
	private int health = 3;
	private int score = 0;
	private boolean poweredUp = false;
	private int scoreStreak = 0;
	
	public Player() {
		
		this.setxPosition(Settings.getPlayerStartXPosition());
		this.setyPosition(Settings.getPlayerStartYPosition());
		this.setSpriteImage();
		this.setHitbox();
	}
	
	public void powerUp() {
		if (this.poweredUp == false) {
			this.poweredUp = true;
			System.out.println("POWERED UP!");
		}
	}
	
	public void resetScoreStreak() {
		this.scoreStreak = 0;
	}
	
	@Override
	public void reset() {
	}
	
	@Override
	protected void setHitbox() {
		this.setHitbox(new Hitbox(this));
	}

	@Override
	public void onTick() {
		this.updateHitbox();
	}
	
	@Override
	protected void updateHitbox() {
		this.getHitbox().update();
		
	}
	
	@Override
	protected void setSpriteImage() {
		BufferedImage spriteImageToUse = null;
		
		try {
			File spriteFile = new File("./sprites/sprite.jpg");
			
			if(spriteFile.exists() == true){
				spriteImageToUse = ImageIO.read(spriteFile);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setSpriteImage(spriteImageToUse);
	}
	
	public abstract void onMouseReleased(MouseEvent mouseEvent);
	
	public void onCollisionWithInteractableModel(Interactable interactableModel) {
		if (interactableModel.isFood()) {
			this.score++;
			this.scoreStreak++;
		}
		
		else {
			this.health--;
			this.scoreStreak = 0;
		}
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getScoreStreak() {
		return scoreStreak;
	}
}
