package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

import controller.Controller;
import controller.MenuGameState;
import controller.Settings;

public class MenuPanel extends JPanel  {
	
	public Rectangle playButton = new Rectangle(Settings.getViewDimensionXDefault()/2, 300, 150, 75);
	public Rectangle quitButton = new Rectangle(Settings.getViewDimensionXDefault()/2, 600, 150, 75);
	private Controller controller;
	private MenuGameState menuGameState;
		
	public MenuPanel(Controller controller, MenuGameState menuGameState) {
		this.controller = controller;
		this.menuGameState = menuGameState;
		this.setBounds(0, 0, Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g)
		{
			Graphics2D g2d = (Graphics2D)	g;
			Font font1 = new Font("arial", Font.BOLD, 50);
			g.setFont(font1);
			g.setColor(Color.white);
			g.drawString("ESTUARY ADVENTURE", (Settings.getViewDimensionXDefault()/2), 100);
			Font font2 = new Font("arial", Font.BOLD,30);
			g.drawString("Play", playButton.x, playButton.y);
			g2d.draw(playButton);
			g.drawString("Quit", quitButton.x, quitButton.y);
			g2d.draw(quitButton);
		}
	
}
