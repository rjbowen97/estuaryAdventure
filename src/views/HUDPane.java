package views;

import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Settings;
import models.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class HUDPane.
 */
public class HUDPane extends JPanel implements Serializable {
	
	/** The player model. */
	private Player playerModel;
	
	/** The health label. */
	private JLabel healthLabel;
	
	/** The score label. */
	private JLabel scoreLabel;
	
	/** The score streak label. */
	private JLabel scoreStreakLabel;
	
	/** The powered up label. */
	private JLabel poweredUpLabel;
	
	/** The player name label. */
	private JLabel playerNameLabel;
	
	
	/**
	 * Instantiates a new HUD pane.
	 *
	 * @param playerModel the player model
	 */
	public HUDPane(Player playerModel) {
		this.playerModel = playerModel;
				
		this.setBounds(0, 0, Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		
		this.healthLabel = new JLabel("HEALTH: " + this.playerModel.getHealth());
		this.scoreLabel = new JLabel("SCORE: " + this.playerModel.getScore());
		this.scoreStreakLabel = new JLabel("SCORE STREAK: " + this.playerModel.getScoreStreak());
		this.playerNameLabel = new JLabel("PLAYER NAME: " + this.playerModel.getPlayerName());
		
		this.poweredUpLabel = new JLabel("POWERED UP!");
		this.poweredUpLabel.setVisible(false);
				
		this.add(healthLabel);
		this.add(scoreLabel);
		this.add(scoreStreakLabel);
		this.add(poweredUpLabel);
		this.add(playerNameLabel);
		
		this.setOpaque(false);
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		this.healthLabel.setText("HEALTH: " + this.playerModel.getHealth());
		this.scoreLabel.setText("SCORE: " + this.playerModel.getScore());
		this.scoreStreakLabel.setText("SCORE STREAK: " + this.playerModel.getScoreStreak());
		this.playerNameLabel.setText("PLAYER NAME: " + this.playerModel.getPlayerName());
		
		if (playerModel.getPoweredUp() == true) {
			this.poweredUpLabel.setVisible(true);
		}
		
		else {
			this.poweredUpLabel.setVisible(false);
		}
		
	}
	
	
}
