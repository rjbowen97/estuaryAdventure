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
import models.*;



@SuppressWarnings("serial")
public class View extends JFrame{

	private final int MAIN_FRAME_DIMENSION = 700;
	public JLayeredPane layeredPane = new JLayeredPane();
	private PlayerComponent playerComponent;
	private ArrayList<BackgroundComponent> backgroundComponents;

	public View(Player playerModel, ArrayList<Background> backgroundModels) { //Maybe change this so it accepts an array of models
		//setup background components
		setSize(MAIN_FRAME_DIMENSION, MAIN_FRAME_DIMENSION);
		playerComponent = new PlayerComponent(playerModel);
		backgroundComponents = new ArrayList<BackgroundComponent>();
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, MAIN_FRAME_DIMENSION, MAIN_FRAME_DIMENSION);
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
	
	class BackgroundComponent extends JComponent{
		private int xPosition, yPosition, backgroundNumber;
		BufferedImage backgroundImage;
		
		BackgroundComponent(Background model, int modelNumber){
			this.xPosition = MAIN_FRAME_DIMENSION - model.getBackgroundWidth();
			this.yPosition = model.getYPosition();
			this.backgroundNumber = modelNumber;
			this.setSize(MAIN_FRAME_DIMENSION,MAIN_FRAME_DIMENSION);
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
