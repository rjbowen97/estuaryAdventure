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
	private int poisitionX;
	private int positionY;
	private BufferedImage image;
	
	
	private int enemy;
	private int foodCount;
	
	public Arena(String file_name) {
		this.setPositionY(0);
		this.setPoisitionX(0);
		try{
			File imageFile = new File(file_name);
			setImage(ImageIO.read(imageFile));
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


	public int getPoisitionX() {
		return poisitionX;
	}


	protected void setPoisitionX(int poisitionX) {
		this.poisitionX = poisitionX;
	}

	public void updatePosition(){
		this.poisitionX += 1;
	}
	
	public int getPositionY() {
		return positionY;
	}


	protected void setPositionY(int positionY) {
		this.positionY = positionY;
	}

}
