package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Settings {
	public static Properties globalSettings;
	
	public Settings() {
		Settings.globalSettings = new Properties();
		InputStream globalSettingsPropertiesInputStream = null;

		try {
			globalSettingsPropertiesInputStream = new FileInputStream("globalSettings.properties");
			Settings.globalSettings.load(globalSettingsPropertiesInputStream);

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
}
