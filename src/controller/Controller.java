package controller;


import java.awt.event.MouseEvent;
import java.util.ArrayList;

import models.Background;
import models.Interactable;
import models.Player;
import views.View;

public class Controller {
	
    private ArrayList<Background> backgroundModels;
    private Player playerModel;
    private ArrayList<Interactable> interactableModels;
    
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
    
    public void tick(int tickNumber){
    	tickModels();
    	tickView();
    }
	
	private void tickModels() {
		tickBackgroundModels();
		tickInteractableModels();
		tickPlayerModel();
	}
	
	private void tickBackgroundModels() {
		for (Background backgroundModel : backgroundModels) {
			backgroundModel.onTick();
		}
	}
	
	private void tickInteractableModels() {
		for (Interactable interactableModel :interactableModels) {
			if (interactableModel.isActive()) {
				interactableModel.onTick();				
			}
		}
	}
	
	private void tickPlayerModel() {
		this.playerModel.onTick();
	}
	
	private void tickView(){
		view.repaint();
	}
    
	
}
