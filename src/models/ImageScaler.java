package models;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import controller.Settings;

// TODO: Auto-generated Javadoc
/**
 * The Class ImageScaler.
 */
public class ImageScaler {
	
	
	/**
	 * Instantiates a new image scaler.
	 */
	public ImageScaler() {
	}
	
	/**
	 * Scale image to input ratio.
	 *
	 * @param nonScaledImage the non scaled image
	 * @param xRatio the x ratio
	 * @param yRatio the y ratio
	 * @return the buffered image
	 */
	public static BufferedImage scaleImageToInputRatio(BufferedImage nonScaledImage, double xRatio, double yRatio) {
		BufferedImage scaledImage = new BufferedImage(nonScaledImage.getWidth(), nonScaledImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
		AffineTransform affineTransform = new AffineTransform();

		affineTransform.scale(xRatio, yRatio);

		AffineTransformOp scaleOP = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_BILINEAR);
		scaledImage = scaleOP.filter(nonScaledImage, scaledImage);
		
		BufferedImage scaledAndCroppedImage = scaledImage.getSubimage(0, 0, (int) (nonScaledImage.getWidth() * xRatio), (int) (nonScaledImage.getHeight() * yRatio));
		return scaledAndCroppedImage; //or use it however you want
		
	}
	
	/**
	 * Scale image to view size.
	 *
	 * @param nonScaledImage the non scaled image
	 * @return the buffered image
	 */
	public static BufferedImage scaleImageToViewSize(BufferedImage nonScaledImage) {
		
		BufferedImage scaledImage = new BufferedImage(nonScaledImage.getWidth(), nonScaledImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
		AffineTransform affineTransform = new AffineTransform();

		affineTransform.scale(((float) Settings.getViewDimensionXDefault()) / ((float) nonScaledImage.getWidth()),
				((float) Settings.getViewDimensionYDefault()) / ((float) nonScaledImage.getHeight()));

		AffineTransformOp scaleOP = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_BILINEAR);
		scaledImage = scaleOP.filter(nonScaledImage, scaledImage);

		
		return scaledImage;
		
	}
	
	/**
	 * Crop image.
	 *
	 * @param src the src
	 * @param x the x
	 * @param y the y
	 * @return the buffered image
	 */
	private BufferedImage cropImage(BufferedImage src, int x, int y) {
	      BufferedImage dest = src.getSubimage(0, 0, x, y);
	      return dest; 
	   }
	
}
