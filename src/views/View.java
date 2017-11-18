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

	public JLayeredPane layeredPane = new JLayeredPane();
	private PlayerComponent playerComponent;
	private ArrayList<BackgroundComponent> backgroundComponents;
	private Settings settings = new Settings();
	private int mainFrameDimension = 0;
	
	public View(Player playerModel, ArrayList<Background> backgroundModels) { //Maybe change this so it accepts an array of models
		//setup background components
		
		this.mainFrameDimension = Integer.parseInt(settings.globalSettings.getProperty("mainFrameDimension"));
		
		setSize(mainFrameDimension, mainFrameDimension);
		playerComponent = new PlayerComponent(playerModel);
		backgroundComponents = new ArrayList<BackgroundComponent>();
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, mainFrameDimension, mainFrameDimension);
		layeredPane.add(playerComponent, 20);

		BackgroundComponent temp = null;
		int loc = 0;
		for(Background currentModel: backgroundModels)
			temp = new BackgroundComponent(currentModel, loc);
			backgroundComponents.add(temp);
			backgroundComponents.iterator().next().setVisible(true);
			layeredPane.add(temp, loc);
			loc += 10;
	
		add(layeredPane);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void registerListenersFromController(Controller controller) {
		//frame.getContentPane().addMouseListener(controller.mouseListenerComponent);
		//frame.addMouseMotionListener(controller.mouseMotionListenerComponent);

	}
	
	@SuppressWarnings("serial")
	class PlayerComponent extends JComponent{
		private int xPosition, yPosition;
		BufferedImage playerImage;
		
		PlayerComponent(Player model){
			this.xPosition = model.getXPosition();
			this.yPosition = model.getYPosition();
			this.setSize(mainFrameDimension,mainFrameDimension);
			try {
				File imageFile = new File(model.getSpriteFile());
				if(imageFile.exists() == true){
					playerImage = ImageIO.read(imageFile);
				}
			}			
			catch (IOException e) {
				e.printStackTrace();
			}
			this.setVisible(true);
		}
		
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(playerImage, xPosition, yPosition, null);
		}
		
		void updateComponent(int x, int y){
			//this.xPosition = x;
			//this.yPosition = y;
			this.xPosition += 4;
			this.yPosition++;
			repaint();
		}
	}
	
	class BackgroundComponent extends JComponent{
		private int xPosition, yPosition, backgroundNumber;
		BufferedImage backgroundImage;
		
		BackgroundComponent(Background model, int modelNumber){
			this.xPosition = mainFrameDimension - model.getBackgroundWidth();
			this.yPosition = model.getYPosition();
			this.backgroundNumber = modelNumber;
			this.setSize(mainFrameDimension,mainFrameDimension);
			try {
				File imageFile = new File(model.getBackgroundImagefileName());
				System.out.println(imageFile.exists());
				backgroundImage = ImageIO.read(imageFile);
			}			
			catch (IOException e) {
				System.out.println(model.getBackgroundImagefileName());
				e.printStackTrace();
			}
			this.setVisible(true);
		}
		
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(backgroundImage, xPosition, yPosition, null);
		}
		
		void updateComponent(){
			this.xPosition -= 4; //move to left, simulates motion
			this.yPosition++; //not sure what to do yet
			repaint();
		}
		
		
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
