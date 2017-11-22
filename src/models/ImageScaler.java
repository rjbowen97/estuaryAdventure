package models;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import controller.Settings;

public class ImageScaler {
	
	
	public ImageScaler() {
	}
	
	public static BufferedImage scaleImageToViewSize(BufferedImage nonScaledImage) {
		
		BufferedImage scaledImage = new BufferedImage(nonScaledImage.getWidth(), nonScaledImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
		AffineTransform affineTransform = new AffineTransform();

		affineTransform.scale(((float) Settings.getViewDimensionXDefault()) / ((float) nonScaledImage.getWidth()),
				((float) Settings.getViewDimensionYDefault()) / ((float) nonScaledImage.getHeight()));

		AffineTransformOp scaleOP = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_BILINEAR);
		scaledImage = scaleOP.filter(nonScaledImage, scaledImage);

		return scaledImage;
		
	}
	
}
