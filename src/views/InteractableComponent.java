package views;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import controller.Settings;
import models.Interactable;

public class InteractableComponent extends JComponent {
	
	private ArrayList<Interactable> interactableModels;
	
	public InteractableComponent(ArrayList<Interactable> interactableModels) {
		this.interactableModels = interactableModels;
		
		this.setBounds(0,0,Settings.getViewDimensionDefault(), Settings.getViewDimensionDefault());
		
		this.setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		for (Interactable interactableModel : interactableModels) {
			if (interactableModel.isActive() == true) {
				
				g.fillRect(interactableModel.getXPosition() - 5, interactableModel.getYPosition() - 5, interactableModel.getHitboxWidth() + 10, interactableModel.getHitboxHeight() + 10); //DEBUGGING
								
				g.drawImage(interactableModel.getSpriteImage(), interactableModel.getXPosition(), interactableModel.getYPosition(), null);
			}
		}
	}
}





