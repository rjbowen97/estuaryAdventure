package models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.Settings;

public class Background extends GameModel {

	private int backgroundLayerIndex;

	public Background(int xPosition, int yPosition, int backgroundLayerIndex) {
		this.setxPosition(xPosition);
		this.setyPosition(yPosition);
		this.backgroundLayerIndex = backgroundLayerIndex;
		this.setSpeed(Settings.getBackgroundBaseSpeed(backgroundLayerIndex));
		this.setSpriteImage();
	}
	
	@Override
	protected void setHitbox() {
		this.setHitbox(new Hitbox(this));
	}

	@Override
	protected void updateHitbox() {
		this.getHitbox().update();
		
	}
	
	@Override
	protected void setSpriteImage() {
		BufferedImage spriteImageToUse = null;
		
    	File backgroundImageFile = new File("./backgrounds/b" + backgroundLayerIndex + ".jpg");
		try {			
			if(backgroundImageFile.exists() == true){
				spriteImageToUse = ImageIO.read(backgroundImageFile);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setSpriteImage(spriteImageToUse);
		
	}
	
	@Override
	public void onTick() {
		this.updateBackgroundPositions();
	}

	private void updateBackgroundPositions() {
		int newXPosition = this.getXPosition() - this.getSpeed();
		this.setxPosition(newXPosition);
	}

	@Override
	public void reset() {
	}
}