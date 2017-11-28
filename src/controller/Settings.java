package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

/**
 * The Class Settings.
 */
public class Settings implements Serializable {
	
	/** The global settings. */
	private static Properties globalSettings;
	
	/**
	 * Instantiates a new settings. All methods of settings are static, instantiating simply eliminates null pointer errors
	 */
	public Settings() {
		globalSettings = new Properties();
		InputStream globalSettingsPropertiesInputStream = null;

		try {
			globalSettingsPropertiesInputStream = new FileInputStream("globalSettings.properties");
			globalSettings.load(globalSettingsPropertiesInputStream);

		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			if (globalSettingsPropertiesInputStream != null) {
				try {
					globalSettingsPropertiesInputStream.close();
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Gets the milliseconds between tick.
	 *
	 * @return the milliseconds between tick
	 */
	public static int getMillisecondsBetweenTick() {
		return Integer.parseInt(globalSettings.getProperty("millisecondsBetweenTick"));
	}

	/**
	 * Gets the view dimension X default.
	 *
	 * @return the view dimension X default
	 */
	public static int getViewDimensionXDefault() {
		return Integer.parseInt(globalSettings.getProperty("viewDimensionX"));
	}

	/**
	 * Gets the view dimension Y default.
	 *
	 * @return the view dimension Y default
	 */
	public static int getViewDimensionYDefault() {
		return Integer.parseInt(globalSettings.getProperty("viewDimensionY"));
	}

	/**
	 * Gets the player start X position.
	 *
	 * @return the player start X position
	 */
	public static int getPlayerStartXPosition() {
		return Integer.parseInt(globalSettings.getProperty("playerStartXPosition"));
	}

	/**
	 * Gets the player start Y position.
	 *
	 * @return the player start Y position
	 */
	public static int getPlayerStartYPosition() {
		return Integer.parseInt(globalSettings.getProperty("playerStartYPosition"));
	}

	/**
	 * Gets the non land animal flap speed.
	 *
	 * @return the non land animal flap speed
	 */
	public static int getNonLandAnimalFlapSpeed() {
		return Integer.parseInt(globalSettings.getProperty("nonLandAnimalFlapSpeed"));
	}

	/**
	 * Gets the non land animal fall speed.
	 *
	 * @return the non land animal fall speed
	 */
	public static int getNonLandAnimalFallSpeed() {
		return Integer.parseInt(globalSettings.getProperty("nonLandAnimalFallSpeed"));
	}

	/**
	 * Gets the land animal shuffle speed.
	 *
	 * @return the land animal shuffle speed
	 */
	public static int getLandAnimalShuffleSpeed() {
		return Integer.parseInt(globalSettings.getProperty("landAnimalShuffleSpeed"));
	}

	/**
	 * Gets the number of background layers.
	 *
	 * @return the number of background layers
	 */
	public static int getNumberOfBackgroundLayers() {
		return Integer.parseInt(globalSettings.getProperty("numberOfBackgroundLayers"));	
	}
	
	/**
	 * Gets the background base speed.
	 *
	 * @param backgroundLayerIndex the background layer index
	 * @return the background base speed
	 */
	public static int getBackgroundBaseSpeed(int backgroundLayerIndex) {
		return Integer.parseInt(globalSettings.getProperty("background" + backgroundLayerIndex + "BaseSpeed"));
	}
	
	/**
	 * Gets the interactable start X position.
	 *
	 * @return the interactable start X position
	 */
	public static int getInteractableStartXPosition() {
		return Integer.parseInt(globalSettings.getProperty("interactableStartXPosition"));
	}
	
	/**
	 * Gets the interactable speed.
	 *
	 * @return the interactable speed
	 */
	public static int getInteractableSpeed() {
		return Integer.parseInt(globalSettings.getProperty("interactableSpeed"));
	}
	
	/**
	 * Gets the mini game required score streak.
	 *
	 * @return the mini game required score streak
	 */
	public static int getMiniGameRequiredScoreStreak() {
		return Integer.parseInt(globalSettings.getProperty("miniGameRequiredScoreStreak"));
	}
	
	/**
	 * Gets the mini game question limit.
	 *
	 * @return the mini game question limit
	 */
	public static int getMiniGameQuestionLimit() {
		return Integer.parseInt(globalSettings.getProperty("miniGameQuestionLimit"));
	}

	/**
	 * Gets the score file name.
	 *
	 * @return the score file name
	 */
	public static String getScoreBoardFileName() {
		return globalSettings.getProperty("scoreBoardFileName");
	}
}
