package models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.Settings;

public class Background implements GameModel {

	private int xPosition;
	private int yPosition;
	private int moveSpeed;
	private BufferedImage spriteImage;

	public Background(File backgroundImageFile, int xPosition, int yPosition, int backgroundLayerIndex) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.moveSpeed = Settings.getBackgroundBaseSpeed(backgroundLayerIndex);
		this.setSpriteImage(backgroundImageFile);
	}
	
	private void setSpriteImage(File backgroundImageFile) {
		BufferedImage spriteImageToUse = null;
		
		try {			
			if(backgroundImageFile.exists() == true){
				spriteImageToUse = ImageIO.read(backgroundImageFile);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		this.spriteImage = spriteImageToUse;
		
	}

	public int getXPosition() {
		return xPosition;
	}

	public int getYPosition() {
		return yPosition;
	}

	public BufferedImage getSpriteImage() {
		return this.spriteImage;
	}
	
	@Override
	public void onTick() {
		this.updateBackgroundPositions();
	}

	private void updateBackgroundPositions() {
		this.xPosition -= this.moveSpeed;
	}
}