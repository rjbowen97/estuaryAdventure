package views;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JComponent;

import controller.Settings;
import models.Interactable;

// TODO: Auto-generated Javadoc
/**
 * The Class InteractableComponent.
 */
public class InteractableComponent extends JComponent implements Serializable {
	
	/** The interactable models. */
	private ArrayList<Interactable> interactableModels;
	
	/**
	 * Instantiates a new interactable component.
	 *
	 * @param interactableModels the interactable models
	 */
	public InteractableComponent(ArrayList<Interactable> interactableModels) {
		this.interactableModels = interactableModels;
		
		this.setBounds(0,0,Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		
		this.setVisible(true);
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		for (Interactable interactableModel : interactableModels) {
			if (interactableModel.isActive() == true) {
				g.drawImage(interactableModel.getSpriteImage(), interactableModel.getXPosition(), interactableModel.getYPosition(), null);
			}
		}
	}
}





