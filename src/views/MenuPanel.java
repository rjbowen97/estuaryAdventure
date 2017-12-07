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
import java.awt.Dimension;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;

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
	private JPanel actionPanel;
	private JPanel panel;

	public MenuPanel(Menu menu, Controller controller) {
		this.menu = menu;
		this.controller = controller;
		
		Settings set = new Settings();
		setLayout(null);
		difficultyLabel.setBounds(184, 140, 60, 14);
		difficultyLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		difficultyLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		difficultyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		difficultyLabel.setVerticalAlignment(SwingConstants.TOP);
		
				
				this.add(difficultyLabel);
		
		actionPanel = new JPanel();
		actionPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		actionPanel.setBounds(46, 186, 337, 46);
		add(actionPanel);
		actionPanel.setLayout(null);
		
		this.playButton = new JButton("Play!");
		playButton.setBounds(6, 16, 80, 23);
		actionPanel.add(playButton);
		playButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		actionButtons.add(playButton);
		
		playButton.setActionCommand("play");
		
		this.quitButton = new JButton("Quit");
		quitButton.setBounds(251, 16, 80, 23);
		actionPanel.add(quitButton);
		actionButtons.add(quitButton);
		this.quitButton.addActionListener(this);
		playButton.addActionListener(this);
		
		panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(32, 11, 381, 75);
		add(panel);
		panel.setLayout(null);
		
		nameLabel = new JLabel("Name:");
		nameLabel.setBounds(6, 16, 36, 14);
		panel.add(nameLabel);
		nameLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBackground(UIManager.getColor("Label.background"));
		this.nameField = new JFormattedTextField();
		nameField.setBounds(52, 16, 323, 18);
		panel.add(nameField);
		nameField.setPreferredSize(new Dimension(300, 20));
		nameField.setFocusLostBehavior(JFormattedTextField.COMMIT);
		nameField.setMinimumSize(new Dimension(40, 20));
		nameField.setAlignmentY(10.0f);
		nameField.setAlignmentX(10.0f);
		nameField.setToolTipText("enter your name here");
		nameField.setHorizontalAlignment(SwingConstants.LEFT);
		
		this.setNameButton = new JButton("Set name");
		setNameButton.setBounds(129, 45, 80, 23);
		panel.add(setNameButton);
		setNameButton.setAlignmentY(Component.TOP_ALIGNMENT);
		actionButtons.add(setNameButton);
		this.setNameButton.setActionCommand("setName");
		setNameButton.addActionListener(this);
		AbstractFormatter formatter = nameField.getFormatter();
		
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
		if (e.getActionCommand().equals("Quit")) {
			this.setVisible(false);
			System.exit(0);
		}
		
		else if (e.getActionCommand().equals("setName")) {
			controller.setPlayerName(this.nameField.getText());
		}
		
	}

}
