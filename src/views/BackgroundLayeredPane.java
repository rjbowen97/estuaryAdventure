package views;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

import models.Background;

public class BackgroundLayeredPane extends JLayeredPane {
	
	public ArrayList<BackgroundComponent> backgroundComponents;
	
	public BackgroundLayeredPane(ArrayList<Background> backgroundModels) {
		
		backgroundComponents = new ArrayList<BackgroundComponent>();
		BackgroundComponent backgroundComponentToAdd = null;
		
		for (int backgroundModelIndex = 0; backgroundModelIndex < backgroundModels.size(); backgroundModelIndex++) {
			backgroundComponentToAdd = new BackgroundComponent(backgroundModels.get(backgroundModelIndex));
			this.add(backgroundComponentToAdd, backgroundModelIndex);
			backgroundComponents.add(backgroundComponentToAdd);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for (BackgroundComponent backgroundComponent : backgroundComponents) {
			backgroundComponent.paint(g);
		}
		
	}
	
}
