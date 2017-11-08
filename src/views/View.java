package views;
import javax.swing.JFrame;

import controller.Controller;
import models.Player;

public class View extends JFrame {
	
	public JFrame frame = new JFrame();
	public Player playerModel;
	
	public View(Player playerModel) { //Maybe change this so it accepts an array of models
		this.playerModel = playerModel;
	}
	
	public void registerListeners(Controller mouseController) {
		
	}
	
}
