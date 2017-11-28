package views;

import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.JComponent;

import controller.Settings;
import models.Background;

// TODO: Auto-generated Javadoc
/**
 * The Class BackgroundComponent.
 */
public class BackgroundComponent extends JComponent implements Serializable {
	
	/** The background model. */
	private Background backgroundModel;
	
	/**
	 * Instantiates a new background component.
	 *
	 * @param backgroundModel the background model
	 */
	BackgroundComponent(Background backgroundModel){
		this.setBounds(0,0,Settings.getViewDimensionXDefault(),Settings.getViewDimensionYDefault());
		this.backgroundModel = backgroundModel;
		this.setVisible(true);
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundModel.getSpriteImage(), backgroundModel.getXPosition(), backgroundModel.getYPosition(), null);
		g.drawImage(backgroundModel.getSpriteImage(), backgroundModel.getXPosition() + Settings.getViewDimensionXDefault(), backgroundModel.getYPosition(), null);
		
	}
}