package views;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import controller.ActiveGameState;
import controller.Controller;
import controller.Settings;
import models.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerComponent.
 */
class PlayerComponent extends JComponent implements Serializable {
	
	/** The player model. */
	private Player playerModel;
	
	/** The controller. */
	private Controller controller;
	
	private transient BufferedImage playerSprite;
	
	/**
	 * Instantiates a new player component.
	 *
	 * @param playerModel the player model
	 * @param controller the controller
	 */
	PlayerComponent(Player playerModel, Controller controller){
		this.controller = controller;
		this.playerModel = playerModel;
		setPlayerSpriteImage();
		this.setBounds(playerModel.getXPosition(),playerModel.getYPosition(),Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.addMouseListener(new PlayerComponentMouseListener());
		this.setVisible(true);
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(this.playerSprite, playerModel.getXPosition(), playerModel.getYPosition(), null);
	}
	
	private void setPlayerSpriteImage() {
		
		ImageScaler imageScaler = new ImageScaler();
		
		BufferedImage unscaledImage = null;
		
		BufferedImage scaledImage;

		try {
			File spriteFile = new File(playerModel.spriteFilePath);

			if(spriteFile.exists() == true){
				unscaledImage = ImageIO.read(spriteFile);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		double xRatio = ((double) this.playerModel.getWidth()) / ((double) unscaledImage.getWidth());
		double yRatio = ((double) this.playerModel.getHeight()) / ((double) unscaledImage.getHeight());
		scaledImage = imageScaler.scaleImageToInputRatio(unscaledImage, xRatio, yRatio);
		
		this.playerSprite = scaledImage;
	}
	
	/**
	 * The listener interface for receiving playerComponentMouse events.
	 * The class that is interested in processing a playerComponentMouse
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addPlayerComponentMouseListener<code> method. When
	 * the playerComponentMouse event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see PlayerComponentMouseEvent
	 */
	private class PlayerComponentMouseListener implements MouseListener {
		
		/* (non-Javadoc)
		 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
		 */
		@Override
		public void mouseClicked(MouseEvent mouseEvent) {
		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
		 */
		@Override
		public void mouseEntered(MouseEvent mouseEvent) {
		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
		 */
		@Override
		public void mouseExited(MouseEvent mouseEvent) {
		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
		 */
		@Override
		public void mousePressed(MouseEvent mouseEvent) {
			
		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
		 */
		@Override
		public void mouseReleased(MouseEvent mouseEvent) {
			controller.activeGameState.onPlayerComponentMouseReleased(mouseEvent);
		}
	}
}
