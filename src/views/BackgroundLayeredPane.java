package views;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

import controller.Settings;
import models.Background;

public class BackgroundLayeredPane extends JLayeredPane {
	
	public ArrayList<BackgroundComponent> backgroundComponents;
	
	public BackgroundLayeredPane(ArrayList<Background> backgroundModels) {
		
		int mainFrameDimension = Integer.parseInt(Settings.globalSettings.getProperty("mainFrameDimension"));
		
		backgroundComponents = new ArrayList<BackgroundComponent>();
		BackgroundComponent backgroundComponentToAdd = null;
		
		this.setBounds(0, 0, mainFrameDimension, mainFrameDimension);
		
		for (int backgroundModelIndex = 0; backgroundModelIndex < backgroundModels.size(); backgroundModelIndex++) {
			backgroundComponentToAdd = new BackgroundComponent(backgroundModels.get(backgroundModelIndex));
			this.add(backgroundComponentToAdd, backgroundModelIndex);
			backgroundComponents.add(backgroundComponentToAdd);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		for (BackgroundComponent backgroundComponent : backgroundComponents) {
			backgroundComponent.paint(g);
		}
	}
	
}
