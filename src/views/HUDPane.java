package views;

import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Settings;
import models.Player;

public class HUDPane extends JPanel{
	
	private Player playerModel;
	
	private JLabel healthLabel;
	private JLabel scoreLabel;
	
	
	public HUDPane(Player playerModel) {
		this.playerModel = playerModel;
				
		this.setBounds(0, 0, Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		
		this.healthLabel = new JLabel("HEALTH: " + this.playerModel.getHealth());
		this.scoreLabel = new JLabel("SCORE: " + this.playerModel.getScore());
				
				
		this.add(healthLabel);
		this.add(scoreLabel);
		
		this.setOpaque(false);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		this.healthLabel.setText("HEALTH: " + this.playerModel.getHealth());
		this.scoreLabel.setText("SCORE: " + this.playerModel.getScore());
		
	}
	
	
}
