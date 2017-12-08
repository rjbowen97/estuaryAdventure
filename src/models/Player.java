package models;

import java.awt.event.MouseEvent;
import java.io.Serializable;

import controller.Settings;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public abstract class Player extends GameModel implements Serializable {

	/** The player name. */
	private String playerName;
	
	/**  The health of the player. */
	public int health = 3;
	
	/** The score. */
	public int score = 0;
	
	/**  Whether the player has earned a power up or not, initially false. */
	private boolean poweredUp = false;
	
	/** The score streak. */
	private int scoreStreak = 0;

	/** The player animal type. */
	public PlayerAnimalType playerAnimalType;
	
	/**
	 * Instantiates a new player, their position and their username.
	 */
	public Player() {
 
		this.playerName = "Default";
		this.setxPosition(Settings.getPlayerStartXPosition());
		this.setyPosition(Settings.getPlayerStartYPosition());

		this.setHeight(150);
		this.setWidth(150);
		this.playerAnimalType = PlayerAnimalType.FISH;
		this.setHitbox();
	}

	/**
	 * On mini game end, adds how many correct answers and adds the powerup and score .
	 *
	 * @param correctAnswerCount the correct answer count
	 */
	public void onMiniGameEnd(int correctAnswerCount) {
		this.powerUp();
		this.score += correctAnswerCount;
	}
	
	/**
	 * If the player achieves the powerup, the player receives it, if not they do not.
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

	/**
	 * On mouse released.
	 *
	 * @param mouseEvent the mouse event
	 */
	public abstract void onMouseReleased(MouseEvent mouseEvent);

	/**
	 * Determines actions based on what interactable the player comes into contact with, if it is food, player goes into minigame, if not player loses health.
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

	/**
	 * Sets the player name.
	 *
	 * @param playerName the new player name
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	/**
	 * Gets the player name.
	 *
	 * @return the player name
	 */
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
	 * Checks whether player is poweredUp or not.
	 *
	 * @return the powered up
	 */
	public boolean getPoweredUp() {
		return poweredUp;
	}
	
	/* (non-Javadoc)
	 * @see models.GameModel#toString()
	 */
	public String toString(){
		return super.toString() + "Player Name: " + this.playerName + "\nHealth: " + this.health + "\nScore: " + this.score + "\nPowered UP: " + this.poweredUp +
				"\nScore Streak: " + this.scoreStreak;
	}
}
