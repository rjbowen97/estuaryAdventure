package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Settings {
	private static Properties globalSettings;
	
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
	
	public static int getNumberOfBackgroundLayers() {
		return Integer.parseInt(globalSettings.getProperty("numberOfBackgroundLayers"));	
	}
	
	public static int getViewDimensionXDefault() {
		return Integer.parseInt(globalSettings.getProperty("viewDimensionX"));
	}
	
	public static int getViewDimensionYDefault() {
		return Integer.parseInt(globalSettings.getProperty("viewDimensionY"));
	}
	
	public static int getBackgroundBaseSpeed(int backgroundLayerIndex) {
		return Integer.parseInt(globalSettings.getProperty("background" + backgroundLayerIndex + "BaseSpeed"));
	}
	
	public static int getNonLandAnimalFallSpeed() {
		return Integer.parseInt(globalSettings.getProperty("nonLandAnimalFallSpeed"));
	}
	
	public static int getNonLandAnimalFlapSpeed() {
		return Integer.parseInt(globalSettings.getProperty("nonLandAnimalFlapSpeed"));
	}
	
	public static int getLandAnimalShuffleSpeed() {
		return Integer.parseInt(globalSettings.getProperty("landAnimalShuffleSpeed"));
	}
	
	public static int getPlayerStartXPosition() {
		return Integer.parseInt(globalSettings.getProperty("playerStartXPosition"));
	}
	
	public static int getPlayerStartYPosition() {
		return Integer.parseInt(globalSettings.getProperty("playerStartYPosition"));
	}
	
	public static int getInteractableStartXPosition() {
		return Integer.parseInt(globalSettings.getProperty("interactableStartXPosition"));
	}
	
	public static int getInteractableSpeed() {
		return Integer.parseInt(globalSettings.getProperty("interactableSpeed"));
	}
	
	public static int getMiniGameRequiredScoreStreak() {
		return Integer.parseInt(globalSettings.getProperty("miniGameRequiredScoreStreak"));
	}
	
	public static int getMillisecondsBetweenTick() {
		return Integer.parseInt(globalSettings.getProperty("millisecondsBetweenTick"));
	}
	public static int getMiniGameQuestionLimit() {
		return Integer.parseInt(globalSettings.getProperty("miniGameQuestionLimit"));
	}
}
