package models;

import java.awt.event.MouseEvent;
import java.io.Serializable;

import controller.Settings;

/**
 * The Class Player.
 */
public abstract class Player extends GameModel implements Serializable {

	/** The player name. */
	private String playerName;
	
	/**  The health of the player. */
	public int health = 3;
	
	/** The score of the player. */
	public int score = 0;
	
	/**  Whether the player has earned a power up or not, initially false. */
	private boolean poweredUp = false;
	
	/** The score streak. */
	private int scoreStreak = 0;

	/** The player animal type enum. */
	public PlayerAnimalType playerAnimalType;
	
	/**
	 * Instantiates a new player, their position, and their username.
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
	 * On mini game end, adds how many correct answers to the score and activates the power up variable.
	 *
	 * @param correctAnswerCount the correct answer count
	 */
	public void onMiniGameEnd(int correctAnswerCount) {
		this.powerUp();
		this.score += correctAnswerCount;
	}
	
	/**
	 * Powers up the player if it is not already powered up.
	 */
	private void powerUp() {
		if (this.poweredUp == false) {
			this.poweredUp = true;
		}
	}

	/**
	 * Resets the score streak of the player.
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

	/**
	 * On mouse released.
	 *
	 * @param mouseEvent the mouse event
	 */
	public abstract void onMouseReleased(MouseEvent mouseEvent);

	/**
	 * Determines actions based on what interactable the player comes into contact with.
	 * If it is food, player's score and scoreStreak are incremented. If not, the player loses health (unless powered up, which deactivates the
	 * powered up).
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
	 * Sets the player's name.
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
