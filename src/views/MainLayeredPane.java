package views;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

import models.Background;
import models.Player;

public class MainLayeredPane extends JLayeredPane {
	
	PlayerComponent playerComponent;
	BackgroundLayeredPane backgroundLayeredPane;
	
	public MainLayeredPane(Player playerModel, ArrayList<Background> backgroundModels) {
		
		backgroundLayeredPane = new BackgroundLayeredPane(backgroundModels);
		playerComponent = new PlayerComponent(playerModel);
		
		this.add(backgroundLayeredPane, new Integer(0));
//		this.add(playerComponent, 1);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		backgroundLayeredPane.paint(g);
	}
	
}
