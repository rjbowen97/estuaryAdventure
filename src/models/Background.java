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
	private int backgroundLayerIndex;
	private String backgroundImagefileName;
	
	public Background(File backgroundImageFile, int xPosition, int yPosition, int backgroundLayerIndex) {
		
		this.backgroundImagefileName = "./Backgrounds/" + backgroundImageFile.getName();
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.backgroundLayerIndex = backgroundLayerIndex;
	}

	public int getXPosition() {
		return xPosition;
	}
	
	public int getYPosition() {
		return yPosition;
	}
	
	public void updateBackgroundPositions() {
		this.xPosition -= backgroundLayerIndex;
	}
	
	public String getBackgroundImagefileName() {
		return backgroundImagefileName;
	}

}
