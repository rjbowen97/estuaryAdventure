package views;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import controller.Controller;
import controller.Settings;
import models.*;



@SuppressWarnings("serial")
public class View extends JFrame{

	public JLayeredPane mainLayeredPane = new JLayeredPane();
	public JLayeredPane backgroundLayeredPane = new JLayeredPane();
	
	private PlayerComponent playerComponent;
	private ArrayList<BackgroundComponent> backgroundComponents;
	private int mainFrameDimension;
	
	public View(Player playerModel, ArrayList<Background> backgroundModels) { //Maybe change this so it accepts an array of models
		//setup background components
		
		this.mainFrameDimension = Integer.parseInt(Settings.globalSettings.getProperty("mainFrameDimension"));
		
		setSize(mainFrameDimension, mainFrameDimension);
		playerComponent = new PlayerComponent(playerModel);
		backgroundComponents = new ArrayList<BackgroundComponent>();
		
		mainLayeredPane = new JLayeredPane();
		mainLayeredPane.setBounds(0, 0, mainFrameDimension, mainFrameDimension);
		mainLayeredPane.add(playerComponent, 20);

		BackgroundComponent temp = null;
		int loc = 0;
		for(Background currentModel: backgroundModels)
			temp = new BackgroundComponent(currentModel, loc);
			backgroundComponents.add(temp);
			backgroundComponents.iterator().next().setVisible(true);
			mainLayeredPane.add(temp, loc);
			loc += 10;
	
		add(mainLayeredPane);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void registerListenersFromController(Controller controller) {
		//frame.getContentPane().addMouseListener(controller.mouseListenerComponent);
		//frame.addMouseMotionListener(controller.mouseMotionListenerComponent);

	}
	
	public void updateBackgrounds(){
		for(BackgroundComponent currComponent: backgroundComponents){
			System.out.println(currComponent.backgroundNumber  + ": " +currComponent.xPosition);
			currComponent.updateComponent();
		}
	}
	
	public void updatePlayer(int x, int y){
		playerComponent.updateComponent(x, y);
	}

}
