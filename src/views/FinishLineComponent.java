package views;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import controller.Settings;
import models.FinishLine;

// TODO: Auto-generated Javadoc
/**
 * The Class FinishLineComponent.
 */
public class FinishLineComponent extends JComponent implements Serializable {

	/** The finish line model. */
	private FinishLine finishLineModel;

	/** The finish line image. */
	private BufferedImage finishLineImage;

	/**
	 * Instantiates a new finish line component. In our final project we were not able to instantiate the view portion of our 
	 * finishline as we could not find a way to make it reappear at a certain point on game restart
	 *
	 * @param FinishLine the finish line
	 */
	public FinishLineComponent(FinishLine FinishLine) {
		this.finishLineModel = FinishLine;

		this.setSpriteImage();

		this.setBounds(0, 0, Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.setVisible(true);

	}

	/**
	 * Sets the sprite image.
	 */
	protected void setSpriteImage() {

		ImageScaler imageScaler = new ImageScaler();

		BufferedImage unscaledFinishLineImage = null;

		File finishLineFile = new File("./Graphics/FinishLine/FinishLine.png");

		if (finishLineFile.exists() == true) {
			try {
				unscaledFinishLineImage = ImageIO.read(finishLineFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		double xRatio = 0;
		double yRatio = 0;
		
		xRatio = ((double) this.finishLineModel.getWidth()) / ((double) unscaledFinishLineImage.getWidth());
		yRatio = ((double) this.finishLineModel.getHeight()) / ((double) unscaledFinishLineImage.getHeight());
		
		BufferedImage scaledFinishLineImage = imageScaler.scaleImageToInputRatio(unscaledFinishLineImage, xRatio, yRatio);
		this.finishLineImage = scaledFinishLineImage;
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
//		if (finishLineModel.isActive() == true) {
//			g.drawImage(this.finishLineImage, finishLineModel.getXPosition(), finishLineModel.getYPosition(), null);	
//		}
	}
}
