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
	
	public static int getViewDimensionDefault() {
		return Integer.parseInt(globalSettings.getProperty("viewDimension"));
	}
	
	public static int getBackgroundXPositionDefault(int backgroundLayerIndex) {
		return Integer.parseInt(globalSettings.getProperty("background" + backgroundLayerIndex + "XPosition"));
	}
	
	public static int getBackgroundYPositionDefault(int backgroundLayerIndex) {
		return Integer.parseInt(globalSettings.getProperty("background" + backgroundLayerIndex + "YPosition"));
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
	
	public static int getInteractableStartYPosition() {
		return Integer.parseInt(globalSettings.getProperty("interactableStartYPosition"));
	}
	
	public static int getInteractableSpeed() {
		return Integer.parseInt(globalSettings.getProperty("interactableSpeed"));
	}
}
