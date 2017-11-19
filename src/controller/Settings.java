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
	
}
