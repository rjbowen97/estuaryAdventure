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
	private String backgroundImagefileName;
	
	public Background(File backgroundImageFile, int xPosition, int yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.backgroundImagefileName = "./Backgrounds/" + backgroundImageFile.getName();
	}

	public int getXPosition() {
		return xPosition;
	}
	
	public int getYPosition() {
		return yPosition;
	}

	public String getBackgroundImagefileName() {
		return backgroundImagefileName;
	}

}
