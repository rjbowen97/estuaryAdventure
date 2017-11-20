package views;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import controller.Settings;
import models.Interactable;

public class InteractableComponent extends JComponent {
	
	Interactable interactableModel;
	BufferedImage interactableImage;
	
	public InteractableComponent(Interactable interactableModel) {
		this.interactableModel = interactableModel;
		this.setBounds(interactableModel.getXPosition(),interactableModel.getYPosition(),Settings.getViewDimensionDefault(), Settings.getViewDimensionDefault());
		
		try {
			File imageFile = new File(interactableModel.getSpriteFilePath());
			if(imageFile.exists() == true){
				interactableImage = ImageIO.read(imageFile);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		this.setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		System.out.println("paint interactable called");
		g.drawImage(interactableImage, interactableModel.getXPosition(), interactableModel.getYPosition(), null);
	}
}
