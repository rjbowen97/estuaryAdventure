package views;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import controller.Controller;
import controller.Settings;
import models.Background;
import models.Player;

public class View extends JFrame {

	private MainLayeredPane mainLayeredPane;
	private int viewDimension;
	Controller controller;
	
	public View(Player playerModel, ArrayList<Background> backgroundModels, Controller controller) {
		
		this.controller = controller;
		this.viewDimension = Settings.getViewDimensionDefault();
		this.setBounds(0,0,Settings.getViewDimensionDefault(), Settings.getViewDimensionDefault());
		
		
		mainLayeredPane = new MainLayeredPane(playerModel, backgroundModels, controller);
		
		this.add(mainLayeredPane);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
