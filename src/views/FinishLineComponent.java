package views;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import controller.Settings;
import models.finishLine;

public class FinishLineComponent extends JComponent implements Serializable {

	private finishLine finishLineModel;

	private BufferedImage finishLineImage;

	public FinishLineComponent(finishLine finishLine) {
		this.finishLineModel = finishLine;

		this.setSpriteImage();

		this.setBounds(0, 0, Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.setVisible(true);

	}

	protected void setSpriteImage() {

		ImageScaler imageScaler = new ImageScaler();

		BufferedImage unscaledFinishLineImage = null;

		File finishLineFile = new File("./Graphics/FinishLine/finishLine.png");

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

	@Override
	public void paintComponent(Graphics g) {		
		if (finishLineModel.isActive() == true) {
			g.drawImage(this.finishLineImage, finishLineModel.getXPosition(), finishLineModel.getYPosition(), null);	
		}
	}
}
