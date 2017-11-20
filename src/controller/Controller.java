package controller;


import java.awt.event.MouseEvent;
import java.util.ArrayList;

import models.Background;
import models.Interactable;
import models.Player;
import views.View;

public class Controller {
	
    String birdSprite = "sprite.png";
    String fishSprite = "sprite.png";
    String crabSprite = "sprite.png";
    
    //models
    public ArrayList<Background> backgroundModels;
    public Player playerModel;
    public ArrayList<Interactable> interactableModels;
    
    //view
    private View view;
    
    public Controller(Player playerModel, ArrayList<Background> backgroundModels, ArrayList<Interactable> interactableModels) {
		this.playerModel = playerModel;
		this.backgroundModels = backgroundModels;
		this.interactableModels = interactableModels;
		this.view = new View(playerModel, backgroundModels, this, interactableModels);
	}
    
    public void onPlayerComponentMouseReleased(MouseEvent mouseEvent) {
    	playerModel.onMouseReleased(mouseEvent);
    }
    
    public void tick(){
    	tickModels();
    	tickView();
    }
	
	public void tickModels() {
		for (Background backgroundModel : backgroundModels) {
			backgroundModel.onTick();
		}
		this.playerModel.onTick();
	}
	
	public void tickView(){
		view.repaint();
	}
    
	
}
