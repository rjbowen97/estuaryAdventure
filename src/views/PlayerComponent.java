package views;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import models.Player;

class PlayerComponent extends JComponent{
	
	Player playerModel;
	private int xPosition;
	private int yPosition;
	BufferedImage playerImage;
	
	PlayerComponent(Player playerModel){
		
		this.playerModel = playerModel;
		
		this.xPosition = this.playerModel.getXPosition();
		this.yPosition = this.playerModel.getYPosition();
		this.setSize(this.playerModel.getSize(),this.playerModel.getSize());
		try {
			File imageFile = new File(playerModel.getSpriteFile());
			if(imageFile.exists() == true){
				playerImage = ImageIO.read(imageFile);
			}
		}			
		catch (IOException e) {
			e.printStackTrace();
		}
		this.setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(playerImage, xPosition, yPosition, null);
	}
	
	void updateComponent(int x, int y){
		//this.xPosition = x;
		//this.yPosition = y;
		this.xPosition += 4;
		this.yPosition++;
		repaint();
	}
}
