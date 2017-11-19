package views;
import java.util.ArrayList;

import javax.swing.JFrame;

import controller.Controller;
import controller.Settings;
import models.Background;
import models.Player;



@SuppressWarnings("serial")
public class View extends JFrame{

	private MainLayeredPane mainLayeredPane;
	private int viewDimension;
	Controller controller;
	
	public View(Player playerModel, ArrayList<Background> backgroundModels, Controller controller) {
		
		this.controller = controller;
		this.viewDimension = Settings.getViewDimensionDefault();
		this.setSize(viewDimension, viewDimension);
		
		mainLayeredPane = new MainLayeredPane(playerModel, backgroundModels);
		
		this.add(mainLayeredPane);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
