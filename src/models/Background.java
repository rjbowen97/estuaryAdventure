package models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Background {

	private int xPosition;
	private int yPosition;
	private int backgroundWidth;
	private int backgroundHeight;
	private String backgroundImagefileName;
	
	public Background(File backgroundImageFile, int xPosition, int yPosition, int width, int height) {
		this.setXPosition(xPosition);
		this.setPositionY(yPosition);
		
		this.backgroundImagefileName = "./Backgrounds/" + backgroundImageFile.getName();
	}
	
	public void setBackgroundWidth(int backgroundWidth) {
		this.backgroundWidth = backgroundWidth;
	}

	public void setBackgroundHeight(int backgroundHeight) {
		this.backgroundHeight = backgroundHeight;
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
	
	public int getYPosition() {
		return yPosition;
	}

	protected void setXPosition(int poisitionX) {
		this.xPosition = poisitionX;
	}

	public void updatePosition(){
		this.xPosition += 1;
	}

	protected void setPositionY(int positionY) {
		this.yPosition = positionY;
	}


	public String getBackgroundImagefileName() {
		return backgroundImagefileName;
	}

}
