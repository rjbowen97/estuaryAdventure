package models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Arena {

	private final int arenaWidth = 100;
	private final int arenaHeight = 300;
	private int xPosition;
	private int yPosition;
	private BufferedImage image;
	private String fileName;
	
	
	private int enemy;
	private int foodCount;
	
	public Arena(File inFile) {
		this.setPositionY(0);
		this.setXPosition(0);
		try{
			this.image = ImageIO.read(inFile);
			fileName = inFile.getName();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	public int getArena_width() {
		return arenaWidth;
	}

	public int getArena_height() {
		return arenaHeight;
	}


	public BufferedImage getImage() {
		return image;
	}


	public void setImage(BufferedImage image) {
		this.image = image;
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


	public String getFileName() {
		return fileName;
	}

}
