package models;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
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
		BufferedImage nonScaledSpriteImageToUse = null;
		
    	File backgroundImageFile = new File("./Graphics/Backgrounds/AirBackground/b" + backgroundLayerIndex + ".png");
		try {			
			if(backgroundImageFile.exists() == true){
				nonScaledSpriteImageToUse = ImageIO.read(backgroundImageFile);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		BufferedImage scaledSpriteImageToUse = ImageScaler.scaleImageToViewSize(nonScaledSpriteImageToUse);
		this.setSpriteImage(scaledSpriteImageToUse);
		
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