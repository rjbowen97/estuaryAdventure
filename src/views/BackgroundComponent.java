package views;

import java.awt.Graphics;

import javax.swing.JComponent;

import controller.Settings;
import models.Background;

public class BackgroundComponent extends JComponent{
	
	private Background backgroundModel;
	
	BackgroundComponent(Background backgroundModel){
		this.setBounds(0,0,Settings.getViewDimensionXDefault(),Settings.getViewDimensionYDefault());
		this.backgroundModel = backgroundModel;
		this.setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundModel.getSpriteImage(), backgroundModel.getXPosition(), backgroundModel.getYPosition(), null);
		g.drawImage(backgroundModel.getSpriteImage(), backgroundModel.getXPosition() + Settings.getViewDimensionXDefault(), backgroundModel.getYPosition(), null);
		
	}
	
}