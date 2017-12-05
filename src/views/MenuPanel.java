package views;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import controller.Controller;
import controller.Settings;
import models.Menu;

public class MenuPanel extends JPanel implements ActionListener, Serializable  {

	private Controller controller;
	private Menu menu;
	
	JTextField nameField;
	JButton setNameButton;
	
	JLabel difficultyLabel = new JLabel("Difficulty");
	

	//labels
	JLabel nameLabel;
	
	//buttons
	JButton playButton;
	JButton easyButton;
	JButton mediumButton;
	JButton hardButton;
	
	JButton quitButton;

	public MenuPanel(Menu menu, Controller controller) {
		this.menu = menu;
		this.controller = controller;
		
		Settings set = new Settings();
		
		nameLabel = new JLabel("Name:");
		nameLabel.setBounds(Settings.getViewDimensionXDefault()/2, Settings.getViewDimensionXDefault()/2, 10, 10);
		//label it
		this.add(nameLabel);
		this.nameField = new JTextField(20);
		nameField.setBounds(this.getWidth()/2+10, this.getHeight()/2, 10, 10);
		
		
		this.setNameButton = new JButton("Set name");
		this.setNameButton.setActionCommand("setName");
		setNameButton.addActionListener(this);
		
		this.playButton = new JButton("Play!");
		playButton.setBounds(Settings.getViewDimensionXDefault()-20, Settings.getViewDimensionYDefault()-20, 10,10);
		
		playButton.setActionCommand("play");
		playButton.addActionListener(this);
		
		this.quitButton = new JButton("quit");
		playButton.setBounds(0, 0, 10, 10);
		this.quitButton.addActionListener(this);

		
		this.add(difficultyLabel);
		this.add(nameField);
		this.add(setNameButton);
		this.add(this.playButton);
		this.add(this.quitButton);
		
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
		if (e.getActionCommand().equals("quit")) {
			this.setVisible(false);
			System.exit(0);
		}
		
		else if (e.getActionCommand().equals("setName")) {
			controller.setPlayerName(this.nameField.getText());
		}
		
	}

}
