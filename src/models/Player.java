package models;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import controller.Settings;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public abstract class Player extends GameModel implements Serializable{

	private String playerName;
	
	/** The health. */
	private int health = 3;
	
	/** The score. */
	private int score = 0;
	
	/** The powered up. */
	private boolean poweredUp = false;
	
	/** The score streak. */
	private int scoreStreak = 0;

	/**
	 * Instantiates a new player.
	 */
	public Player() {
 
		this.playerName = "Default";
		this.setxPosition(Settings.getPlayerStartXPosition());
		this.setyPosition(Settings.getPlayerStartYPosition());
		this.setSpriteImage();
		this.setHitbox();
	}

	/**
	 * On mini game end.
	 *
	 * @param correctAnswerCount the correct answer count
	 */
	public void onMiniGameEnd(int correctAnswerCount) {
		this.powerUp();
		this.score += correctAnswerCount;
	}
	
	/**
	 * Power up.
	 */
	private void powerUp() {
		if (this.poweredUp == false) {
			this.poweredUp = true;
			System.out.println("POWERED UP!");
		}
	}

	/**
	 * Reset score streak.
	 */
	public void resetScoreStreak() {
		this.scoreStreak = 0;
	}

	/* (non-Javadoc)
	 * @see models.GameModel#reset()
	 */
	@Override
	public void reset() {
	}

	/* (non-Javadoc)
	 * @see models.GameModel#setHitbox()
	 */
	@Override
	protected void setHitbox() {
		this.setHitbox(new Hitbox(this));
	}

	/* (non-Javadoc)
	 * @see models.GameModel#onTick()
	 */
	@Override
	public void onTick() {
		this.updateHitbox();
	}

	/* (non-Javadoc)
	 * @see models.GameModel#updateHitbox()
	 */
	@Override
	protected void updateHitbox() {
		this.getHitbox().update();

	}

	/* (non-Javadoc)
	 * @see models.GameModel#setSpriteImage()
	 */
	@Override
	protected void setSpriteImage() {
		BufferedImage nonScaledSpriteImageToUse = null;

		try {
			File spriteFile = new File("./Graphics/Avatars/Bird/Bird.png");

			if(spriteFile.exists() == true){
				nonScaledSpriteImageToUse = ImageIO.read(spriteFile);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		BufferedImage scaledSpriteImageToUse = ImageScaler.scaleImageToInputRatio(nonScaledSpriteImageToUse, 0.2, 0.2);

		this.setSpriteImage(scaledSpriteImageToUse);
	}

	/**
	 * On mouse released.
	 *
	 * @param mouseEvent the mouse event
	 */
	public abstract void onMouseReleased(MouseEvent mouseEvent);

	/**
	 * On collision with interactable model.
	 *
	 * @param interactableModel the interactable model
	 */
	public void onCollisionWithInteractableModel(Interactable interactableModel) {
		if (interactableModel.isFood()) {
			this.score++;
			this.scoreStreak++;
		}

		else {
			
			if (this.poweredUp == true) {
				this.poweredUp = false;
			}
			
			else {
				this.health--;			
				this.scoreStreak = 0;
			}
			
		}
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public String getPlayerName() {
		return this.playerName;
	}
	
	/**
	 * Gets the health.
	 *
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Gets the score streak.
	 *
	 * @return the score streak
	 */
	public int getScoreStreak() {
		return scoreStreak;
	}

	/**
	 * Gets the powered up.
	 *
	 * @return the powered up
	 */
	public boolean getPoweredUp() {
		return poweredUp;
	}
	
	public String toString(){
		return super.toString() + "Player Name: " + this.playerName + "\nHealth: " + this.health + "\nScore: " + this.score + "\nPowered UP: " + this.poweredUp +
				"\nScore Streak: " + this.scoreStreak;
	}
}
