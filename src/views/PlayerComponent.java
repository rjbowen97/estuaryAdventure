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
	
	private Player playerModel;
	private Controller controller;
	
	PlayerComponent(Player playerModel, Controller controller){
		
		this.controller = controller;
		this.playerModel = playerModel;
		this.setBounds(playerModel.getXPosition(),playerModel.getYPosition(),Settings.getViewDimensionDefault(), Settings.getViewDimensionDefault());
		this.addMouseListener(new PlayerComponentMouseListener());
		this.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.fillRect(playerModel.getXPosition() - 5, playerModel.getYPosition(),5,5); //DEBUGGING
		
		g.drawImage(playerModel.getSpriteImage(), playerModel.getXPosition(), playerModel.getYPosition(), null);
	}
	
	private class PlayerComponentMouseListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent mouseEvent) {
		}

		@Override
		public void mouseEntered(MouseEvent mouseEvent) {
		}

		@Override
		public void mouseExited(MouseEvent mouseEvent) {
		}

		@Override
		public void mousePressed(MouseEvent mouseEvent) {
			
		}

		@Override
		public void mouseReleased(MouseEvent mouseEvent) {
			controller.onPlayerComponentMouseReleased(mouseEvent);
		}
	}
}
