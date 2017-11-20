package views;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import controller.Controller;
import controller.Settings;
import models.Player;

class PlayerComponent extends JComponent{
	
	Player playerModel;
	BufferedImage playerImage;
	Controller controller;
	
	PlayerComponent(Player playerModel, Controller controller){
		
		this.controller = controller;
		this.playerModel = playerModel;
		this.setBounds(playerModel.getXPosition(),playerModel.getYPosition(),Settings.getViewDimensionDefault(), Settings.getViewDimensionDefault());
		this.addMouseListener(new PlayerComponentMouseListener());
		
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
	public void paintComponent(Graphics g) {
		g.drawImage(playerImage, playerModel.getXPosition(), playerModel.getYPosition(), null);
	}
	
	private class PlayerComponentMouseListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent mouseEvent) {
			controller.onPlayerComponentClicked(mouseEvent);
		}

		@Override
		public void mouseEntered(MouseEvent mouseEvent) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent mouseEvent) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent mouseEvent) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent mouseEvent) {
			// TODO Auto-generated method stub
			
		}
	}
}
