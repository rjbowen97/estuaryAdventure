package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;
import controller.MenuGameState;
import controller.Settings;
import models.Menu;

public class MenuPanel extends JPanel implements ActionListener  {

	private Controller controller;
	private Menu menu;
	
	JButton playButton;

	public MenuPanel(Menu menu, Controller controller) {
		this.menu = menu;
		this.controller = controller;
		
		this.playButton = new JButton("Play!");

		playButton.setActionCommand("play");
		playButton.addActionListener(this);
		
		this.add(this.playButton);
		
		this.setBounds(0, 0, Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.setVisible(true);
	}
	@Override
	public void paintComponent(Graphics g)
	{

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("play")) {
			controller.changeGameStateFromMenuToActive();
		}
		
	}

}
