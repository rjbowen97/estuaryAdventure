package views;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		this.setBounds(playerModel.getXPosition(),playerModel.getYPosition(),Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.addMouseListener(new PlayerComponentMouseListener());
		this.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.fillRect(playerModel.getHitbox().topLeftCorner.x - 10, playerModel.getHitbox().topLeftCorner.y - 10, 10, 10);
		g.fillRect(playerModel.getHitbox().topRightCorner.x, playerModel.getHitbox().topRightCorner.y, 10, 10);
		g.fillRect(playerModel.getHitbox().bottomLeftCorner.x - 10, playerModel.getHitbox().bottomLeftCorner.y + 10, 10, 10);
		g.fillRect(playerModel.getHitbox().bottomRightCorner.x, playerModel.getHitbox().bottomRightCorner.y, 10, 10);
		
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
