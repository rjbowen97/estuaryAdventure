package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;
import controller.MenuGameState;
import controller.Settings;
import models.Menu;

public class MenuPanel extends JPanel  {

	private Controller controller;
	private Menu menu;
	
	JButton playButton;

	public MenuPanel(Menu menu, Controller controller) {
		this.menu = menu;
		this.controller = controller;
		this.setBounds(0, 0, Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g)
	{

	}

}
