package views;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MenuPanel extends JPanel implements ActionListener, Serializable {

	private Controller controller;
	private Menu menu;
	
	JFormattedTextField nameField;
	JButton setNameButton;
	
	JLabel illegalName = new JLabel("Illegal Name: Please Enter New Name");

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
	private JPanel namePanel;

	public MenuPanel(Menu in_menu, Controller controller) {
		this.menu = in_menu;
		this.controller = controller;
		setBounds(new Rectangle(0, 0, 960, 540));
		
		Settings set = new Settings();
		illegalName.setMaximumSize(new Dimension(200, 14));
		illegalName.setVisible(false);
		setLayout(null);
		
		namePanel = new JPanel();
		namePanel.setBounds(132, 65, 381, 70);
		namePanel.setBorder(null);
		add(namePanel);
		namePanel.setLayout(null);
		
		nameLabel = new JLabel("Name:");
		nameLabel.setBounds(6, 16, 36, 14);
		namePanel.add(nameLabel);
		nameLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBackground(UIManager.getColor("Label.background"));
		this.nameField = new JFormattedTextField();
		nameField.setBounds(52, 16, 323, 18);
		namePanel.add(nameField);
		nameField.setPreferredSize(new Dimension(300, 20));
		nameField.setFocusLostBehavior(JFormattedTextField.COMMIT);
		nameField.setMinimumSize(new Dimension(40, 20));
		nameField.setAlignmentY(10.0f);
		nameField.setAlignmentX(10.0f);
		nameField.setToolTipText("enter your name here");
		nameField.setHorizontalAlignment(SwingConstants.LEFT);
		
		this.setNameButton = new JButton("Set name");
		setNameButton.setBounds(129, 45, 80, 23);
		namePanel.add(setNameButton);
		setNameButton.setAlignmentY(Component.TOP_ALIGNMENT);
		actionButtons.add(setNameButton);
		this.setNameButton.setActionCommand("setName");
		illegalName.setBounds(243, 45, 80, 14);
		namePanel.add(illegalName);
		illegalName.setVerticalTextPosition(SwingConstants.BOTTOM);
		illegalName.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		illegalName.setHorizontalAlignment(SwingConstants.CENTER);
		illegalName.setVerticalAlignment(SwingConstants.TOP);
		setNameButton.addActionListener(this);
		
		actionPanel = new JPanel();
		actionPanel.setBounds(132, 188, 381, 46);
		actionPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(actionPanel);
		actionPanel.setLayout(null);
		
		this.playButton = new JButton("Play!");
		playButton.setBounds(247, 11, 80, 23);
		actionPanel.add(playButton);
		playButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		actionButtons.add(playButton);
		
		playButton.setActionCommand("play");
		
		this.quitButton = new JButton("Quit");
		quitButton.setBounds(10, 11, 80, 23);
		actionPanel.add(quitButton);
		actionButtons.add(quitButton);
		this.quitButton.addActionListener(this);
		playButton.addActionListener(this);
		
		
		this.setVisible(true);
		
	}
	@Override
	public void paintComponent(Graphics g)
	{

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = this.nameField.getText();
		if (e.getActionCommand().equals("play")) {
			if(name == "N/A" || name == "Default" || name.isEmpty()){ 
			}else{
				controller.setInteractablesToTutorialSet();
				controller.changeGameStateFromMenuToActive();
			}
		}
		if (e.getActionCommand().equals("Quit")) {
			this.setVisible(false);
			System.exit(0);
		}
		
		else if (e.getActionCommand().equals("setName")) {
			
			
			Scanner s = null;
			try {
				s = new Scanner(new File("swearWords.txt"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ArrayList<String> badWords = new ArrayList<String>();
			while (s.hasNext()){
			    badWords.add(s.next());
			}
			s.close();
			
			for(String a: badWords)
			{
				if(name.equals(a))
				{
					illegalName.setVisible(true);
					name = "N/A";
					break;
				}else{
					illegalName.setVisible(false);
				}
			}
			controller.setPlayerName(name);
		}
		
	}

}
