package views;

import java.util.ArrayList;

import javax.swing.JLayeredPane;

import controller.Controller;
import controller.Settings;
import models.Background;
import models.Interactable;
import models.Player;

public class MainLayeredPane extends JLayeredPane {
	
	PlayerComponent playerComponent;
	BackgroundLayeredPane backgroundLayeredPane;
	Controller controller;
	InteractableComponent interactableComponent;
	
	public MainLayeredPane(Player playerModel, ArrayList<Background> backgroundModels, Controller controller, ArrayList<Interactable> interactableModels) {
		this.controller = controller;
		this.backgroundLayeredPane = new BackgroundLayeredPane(backgroundModels);
		this.playerComponent = new PlayerComponent(playerModel, controller);
		this.interactableComponent = new InteractableComponent(interactableModels);
		
		this.add(backgroundLayeredPane, new Integer(0));
		this.add(playerComponent, new Integer(1));
		this.add(interactableComponent, new Integer(2));
		
		this.setBounds(0,0,Settings.getViewDimensionDefault(), Settings.getViewDimensionDefault());
		this.setVisible(true);
	}
}
