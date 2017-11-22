package views;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

import controller.Settings;
import models.Interactable;

public class InteractableComponent extends JComponent {
	
	private ArrayList<Interactable> interactableModels;
	
	public InteractableComponent(ArrayList<Interactable> interactableModels) {
		this.interactableModels = interactableModels;
		
		this.setBounds(0,0,Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		
		this.setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		for (Interactable interactableModel : interactableModels) {
			if (interactableModel.isActive() == true) {
				
				g.fillRect(interactableModel.getHitbox().topLeftCorner.x - 10, interactableModel.getHitbox().topLeftCorner.y - 10, 10, 10);
				g.fillRect(interactableModel.getHitbox().topRightCorner.x, interactableModel.getHitbox().topRightCorner.y - 10, 10, 10);
				g.fillRect(interactableModel.getHitbox().bottomLeftCorner.x - 10, interactableModel.getHitbox().bottomLeftCorner.y, 10, 10);
				g.fillRect(interactableModel.getHitbox().bottomRightCorner.x, interactableModel.getHitbox().bottomRightCorner.y, 10, 10);
				
				g.drawImage(interactableModel.getSpriteImage(), interactableModel.getXPosition(), interactableModel.getYPosition(), null);
			}
		}
	}
}





