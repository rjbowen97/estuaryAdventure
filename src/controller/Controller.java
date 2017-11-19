package controller;


import java.util.ArrayList;

import models.Background;
import models.Player;
import views.View;

public class Controller {
	
    String birdSprite = "sprite.png";
    String fishSprite = "sprite.png";
    String crabSprite = "sprite.png";
    
    //models
    public ArrayList<Background> backgroundModels;
    public Player playerModel;
    
    //view
    private View view;
    
    /*
     * The controllers need to have their own custom listeners that they attach to the
     * view's custom component to define when the components update
     * Controller tells View to update components on mouse motion 
     */
    /*
     * This constructor for controller takes an instance of Player and View so that it can
     * update the view and model
     * @param model An object of the Player class that can be updated through the controller
     * @param view An object of the View class taht can be updated through the controller  
     * @see Player
     * @see View
     */
    public Controller(Player playerModel, ArrayList<Background> backgroundModels) {
		this.playerModel = playerModel;
		this.backgroundModels = backgroundModels;
		this.view = new View(playerModel, backgroundModels, this);
	}
    
    public void onViewClicked() {
    	playerModel.onViewClicked();
    }
    
    /*
     * This method consolidates the updates into one call
     */
    public void update(){
    	updateModels();
    	updateView();
    }
	
	public void updateModels() {
		for (Background backgroundModel : backgroundModels) {
			backgroundModel.updateBackgroundPositions();
		}
		
		this.playerModel.onTick();
	}
	
	public void updateView(){
		view.repaint();
	}
    
	
}
