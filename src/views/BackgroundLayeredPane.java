package views;

import java.util.ArrayList;

import javax.swing.JLayeredPane;

import controller.Settings;
import models.Background;

public class BackgroundLayeredPane extends JLayeredPane {
	
	private ArrayList<BackgroundComponent> backgroundComponents;
	
	public BackgroundLayeredPane(ArrayList<Background> backgroundModels) {
		
		backgroundComponents = new ArrayList<BackgroundComponent>();
		BackgroundComponent backgroundComponentToAdd = null;
		
		this.setBounds(0, 0, Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		
		for (int backgroundModelIndex = 0; backgroundModelIndex < backgroundModels.size(); backgroundModelIndex++) {
			
			backgroundComponentToAdd = new BackgroundComponent(backgroundModels.get(backgroundModelIndex));
			
			this.add(backgroundComponentToAdd, new Integer(backgroundModelIndex));
			
			backgroundComponents.add(backgroundComponentToAdd);
		}
	}
}
