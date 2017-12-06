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
import oracle.jrockit.jfr.parser.ParseException;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ButtonGroup;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;

public class MenuPanel extends JPanel implements ActionListener, Serializable  {

	private Controller controller;
	private Menu menu;
	
	JFormattedTextField nameField;
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
	private final ButtonGroup actionButtons = new ButtonGroup();

	public MenuPanel(Menu menu, Controller controller) {
		this.menu = menu;
		this.controller = controller;
		
		Settings set = new Settings();
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		nameLabel = new JLabel("Name:");
		nameLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setBackground(UIManager.getColor("Label.background"));

		//label it
		this.add(nameLabel);
		this.nameField = new JFormattedTextField();
		nameField.setAlignmentY(10.0f);
		nameField.setAlignmentX(10.0f);
		nameField.setToolTipText("enter your name here");
		nameField.setHorizontalAlignment(SwingConstants.LEFT);
		AbstractFormatter formatter = nameField.getFormatter();
		if(formatter != null){
			String username = nameField.getText();
			try{
				formatter.stringToValue(username);
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
		}
		
		this.setNameButton = new JButton("Set name");
		setNameButton.setHorizontalAlignment(SwingConstants.LEFT);
		setNameButton.setAlignmentY(Component.TOP_ALIGNMENT);
		actionButtons.add(setNameButton);
		this.setNameButton.setActionCommand("setName");
		setNameButton.addActionListener(this);
		
		this.playButton = new JButton("Play!");
		playButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		actionButtons.add(playButton);
		
		playButton.setActionCommand("play");
		playButton.addActionListener(this);
		
		this.quitButton = new JButton("Quit");
		quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		quitButton.setBounds(new Rectangle(100, 40, 20, 20));
		quitButton.setHorizontalAlignment(SwingConstants.LEFT);
		quitButton.setVerticalAlignment(SwingConstants.TOP);
		actionButtons.add(quitButton);
		this.quitButton.addActionListener(this);
		this.add(nameField);
				difficultyLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
				difficultyLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
				difficultyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
				difficultyLabel.setVerticalAlignment(SwingConstants.TOP);
		
				
				this.add(difficultyLabel);
		this.add(setNameButton);
		this.add(this.playButton);
		this.add(this.quitButton);
		
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
