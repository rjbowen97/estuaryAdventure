package views;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;
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

	private transient BufferedImage airFoodImage;
	private transient BufferedImage airNotFoodImage;
	private transient BufferedImage waterFoodImage;
	private transient BufferedImage waterNotFoodImage;
	private transient BufferedImage finishLineImage;
	/**
	 * Instantiates a new interactable component.
	 *
	 * @param interactableModels the interactable models
	 */
	public InteractableComponent(ArrayList<Interactable> interactableModels) {
		this.interactableModels = interactableModels;
		this.setSpriteImage();

		this.setBounds(0,0,Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());

		this.setVisible(true);
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		int sizeOfModels = interactableModels.size();
		int index = 0;
		for (Interactable interactableModel : interactableModels) {
			index++;

			if (interactableModel.isActive() == true) {

				if (index == sizeOfModels - 1)
				{
					g.drawImage(this.finishLineImage, interactableModel.getXPosition(), interactableModel.getYPosition(), null);	
				}

				else {
					if (interactableModel.isFood()) {

						if (interactableModel.isInWater) {
							g.drawImage(this.waterFoodImage, interactableModel.getXPosition(), interactableModel.getYPosition(), null);						
						}
						else {
							g.drawImage(this.airFoodImage, interactableModel.getXPosition(), interactableModel.getYPosition(), null);
						}
					}

					else {
						if (interactableModel.isInWater) {
							g.drawImage(this.waterNotFoodImage, interactableModel.getXPosition(), interactableModel.getYPosition(), null);
						}

						else {
							g.drawImage(this.airNotFoodImage, interactableModel.getXPosition(), interactableModel.getYPosition(), null);
						}
					}
				}
			}
		}
	}

	protected void setSpriteImage() {

		ImageScaler imageScaler = new ImageScaler();

		BufferedImage airFoodImage = null;
		BufferedImage airNotFoodImage = null;
		BufferedImage waterFoodImage = null;
		BufferedImage waterNotFoodImage = null;
		BufferedImage finishLineImage = null;

		try {
			File airFoodFile = new File("./Graphics/Fruit/Fruit/apple.png");
			File airNotFoodFile = new File("./Graphics/More Interactables/skull.png");
			File waterFoodFile = new File("./Graphics/More Interactables/Enemy Fish.png");
			File waterNotFoodFile = new File("./Graphics/Enemy fish.png");
			File finishLineFile = new File("./Graphics/FinishLine/finishLine.png");
			if (airFoodFile.exists() == true){
				airFoodImage = ImageIO.read(airFoodFile);
			}

			if (airNotFoodFile.exists() == true){
				airNotFoodImage = ImageIO.read(airNotFoodFile);
			}

			if (waterFoodFile.exists() == true){
				waterFoodImage = ImageIO.read(waterFoodFile);
			}

			if (waterNotFoodFile.exists() == true){
				waterNotFoodImage = ImageIO.read(waterNotFoodFile);
			}
			if(finishLineFile.exists() == true){
				finishLineImage = ImageIO.read(finishLineFile);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}			

		double xRatio = ((double) this.interactableModels.get(0).getWidth()) / ((double) airFoodImage.getWidth());
		double yRatio = ((double) this.interactableModels.get(0).getHeight()) / ((double) airFoodImage.getHeight());
		this.airFoodImage = imageScaler.scaleImageToInputRatio(airFoodImage, xRatio, yRatio);

		xRatio = ((double) this.interactableModels.get(0).getWidth()) / ((double) airNotFoodImage.getWidth());
		yRatio = ((double) this.interactableModels.get(0).getHeight()) / ((double) airNotFoodImage.getHeight());
		this.airNotFoodImage = imageScaler.scaleImageToInputRatio(airNotFoodImage, xRatio, yRatio);

		xRatio = ((double) this.interactableModels.get(0).getWidth()) / ((double) waterFoodImage.getWidth());
		yRatio = ((double) this.interactableModels.get(0).getHeight()) / ((double) waterFoodImage.getHeight());
		this.waterFoodImage = imageScaler.scaleImageToInputRatio(waterFoodImage, xRatio, yRatio);

		xRatio = ((double) this.interactableModels.get(0).getWidth()) / ((double) waterNotFoodImage.getWidth());
		yRatio = ((double) this.interactableModels.get(0).getHeight()) / ((double) waterNotFoodImage.getHeight());
		this.waterNotFoodImage = imageScaler.scaleImageToInputRatio(waterNotFoodImage, xRatio, yRatio);

		xRatio = ((double) this.interactableModels.get(interactableModels.size() - 1).getWidth()) / ((double) finishLineImage.getWidth());
		yRatio = ((double) this.interactableModels.get(interactableModels.size() - 1).getHeight()) / ((double) finishLineImage.getHeight());
		this.finishLineImage = imageScaler.scaleImageToInputRatio(finishLineImage, xRatio, Settings.getViewDimensionYDefault());
	}
}






