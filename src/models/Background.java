package models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Background {

	private final int backgroundWidth = 100;
	private final int backgroundHeight = 300;
	private int xPosition;
	private int yPosition;
	private String backgroundImagefileName;
	
	public Background(File backgroundImageFile) {
		this.setPositionY(0);
		this.setXPosition(0);
		this.backgroundImagefileName = "./Backgrounds/" + backgroundImageFile.getName();
	}
	
	
	public int getBackgroundWidth() {
		return backgroundWidth;
	}

	public int getBackgroundHeight() {
		return backgroundHeight;
	}

	public int getXPosition() {
		return xPosition;
	}


	protected void setXPosition(int poisitionX) {
		this.xPosition = poisitionX;
	}

	public void updatePosition(){
		this.xPosition += 1;
	}
	
	public int getYPosition() {
		return yPosition;
	}


	protected void setPositionY(int positionY) {
		this.yPosition = positionY;
	}


	public String getBackgroundImagefileName() {
		return backgroundImagefileName;
	}

}
