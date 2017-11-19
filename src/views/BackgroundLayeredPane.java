package views;

import java.util.ArrayList;

import javax.swing.JLayeredPane;

import models.Background;

public class BackgroundLayeredPane extends JLayeredPane {
	
	public BackgroundLayeredPane(ArrayList<Background> backgroundModels) {
		BackgroundComponent backgroundComponentToAdd = null;
		
		for (int backgroundModelIndex = 0; backgroundModelIndex < backgroundModels.size(); backgroundModelIndex++) {
			backgroundComponentToAdd = new BackgroundComponent(backgroundModels.get(backgroundModelIndex));
			this.add(backgroundComponentToAdd, backgroundModelIndex);
		}
	}
}
