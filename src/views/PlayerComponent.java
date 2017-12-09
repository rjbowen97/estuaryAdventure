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

import controller.Controller;
import controller.Settings;
import models.Player;
import models.PlayerAnimalType;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerComponent.
 */
class PlayerComponent extends JComponent implements Serializable {
	
	/** The player model. */
	private Player playerModel;
	
	/** The controller. */
	private Controller controller;
	
	/** The bird sprite. */
	private transient BufferedImage birdSprite;
	
	/** The fish sprite. */
	private transient BufferedImage fishSprite;
	
	/**
	 * Instantiates a new player component. This displays either a bird or a fish depending on the environment of the player
	 *
	 * @param playerModel the player model
	 * @param controller the controller
	 */
	PlayerComponent(Player playerModel, Controller controller){
		this.controller = controller;
		this.playerModel = playerModel;
		setPlayerSpriteImages();
		this.setBounds(playerModel.getXPosition(),playerModel.getYPosition(),Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.addMouseListener(new PlayerComponentMouseListener());
		this.setVisible(true);
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		
		if (playerModel.playerAnimalType.equals(PlayerAnimalType.BIRD)) {
			g.drawImage(this.birdSprite, playerModel.getXPosition(), playerModel.getYPosition(), null);
		}
		
		else {
			g.drawImage(this.fishSprite, playerModel.getXPosition(), playerModel.getYPosition(), null);
			
		}
	}
	
	/**
	 * Sets the player sprite images.
	 */
	public void setPlayerSpriteImages() {

		String birdSpriteFilePath = "./Graphics/Avatars/Bird/Bird.png";
		String fishSpriteFilePath = "./Graphics/Avatars/Fish/fish.png";
		
		ImageScaler imageScaler = new ImageScaler();
		
		BufferedImage unscaledBirdImage = null;
		BufferedImage unscaledFishImage = null;
		
		BufferedImage scaledBirdImage;
		BufferedImage scaledFishImage;

		try {
			File birdSpriteFile = new File(birdSpriteFilePath);
			File fishSpriteFile = new File(fishSpriteFilePath);

			if (birdSpriteFile.exists() == true){
				unscaledBirdImage = ImageIO.read(birdSpriteFile);
			}
			
			if (fishSpriteFile.exists() == true){
				unscaledFishImage = ImageIO.read(fishSpriteFile);
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		double xRatio = 0;
		double yRatio = 0;
		
		xRatio = ((double) this.playerModel.getWidth()) / ((double) unscaledBirdImage.getWidth());
		yRatio = ((double) this.playerModel.getHeight()) / ((double) unscaledBirdImage.getHeight());
		scaledBirdImage = imageScaler.scaleImageToInputRatio(unscaledBirdImage, xRatio, yRatio);
		
		xRatio = ((double) this.playerModel.getWidth()) / ((double) unscaledFishImage.getWidth());
		yRatio = ((double) this.playerModel.getHeight()) / ((double) unscaledFishImage.getHeight());
		scaledFishImage = imageScaler.scaleImageToInputRatio(unscaledFishImage, xRatio, yRatio);
		
		this.birdSprite = scaledBirdImage;
		this.fishSprite = scaledFishImage;
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
