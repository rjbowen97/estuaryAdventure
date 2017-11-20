package models;

import java.io.File;

import controller.Settings;

public class Background implements GameModel {

	private String backgroundImagefileName;
	private int xPosition;
	private int yPosition;
	private int moveSpeed;

	public Background(File backgroundImageFile, int xPosition, int yPosition, int backgroundLayerIndex) {
		this.backgroundImagefileName = "./Backgrounds/" + backgroundImageFile.getName();
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.moveSpeed = Settings.getBackgroundBaseSpeed(backgroundLayerIndex);
	}

	public int getXPosition() {
		return xPosition;
	}

	public int getYPosition() {
		return yPosition;
	}


	@Override
	public void onTick() {
		this.updateBackgroundPositions();
	}

	public void updateBackgroundPositions() {
		this.xPosition -= this.moveSpeed;
	}

	public String getBackgroundImagefileName() {
		return backgroundImagefileName;
	}
}