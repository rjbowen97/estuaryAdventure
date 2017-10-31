package controller;

import javax.swing.JPanel;

import models.Animal;
import models.AnimalType;
import models.Interactable;
import views.View;
import java.awt.event.*;

public class Controller extends JPanel {
	
    String birdSprite = "sprite.png";
    String fishSprite = "sprite.png";
    String crabSprite = "sprite.png";
    
    
    private Interactable interactables[];
    Animal player;
    View view;
	
	public Controller(Animal model, View view) {
		this.player = model;
		this.view = view;
	}
	
	public void updateModel() {
	}
	
	public void updateView() {
		view.updateViewModel(player);
		view.frame.repaint();
	}
	
}
