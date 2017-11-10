package views;
import java.awt.BorderLayout;
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

	public JLayeredPane layers = new JLayeredPane();
	private PlayerComponent playerComponent;
	private ArrayList<BackgroundComponent> backgroundComponents;

	public View(Player playerModel, ArrayList<Arena> backgroundModels) { //Maybe change this so it accepts an array of models
		//setup background components
		playerComponent = new PlayerComponent(playerModel);
		for(Arena currentModel: backgroundModels)
			layers.add(new BackgroundComponent(currentModel), 10);
		setSize(500, 500);
		
		layers = new JLayeredPane();
		layers.add(playerComponent, 20);
	
		add(layers);
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
			this.setSize(model.imgWidth,model.imgHeight);
			this.setBackground(Color.black);
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
			this.xPosition = x;
			this.yPosition = y;
			repaint();
		}
	}
	
	class BackgroundComponent extends JComponent{
		private int xPosition, yPosition;
		BufferedImage backgroundImage;
		
		BackgroundComponent(Arena model){
			this.xPosition = model.getXPosition();
			this.yPosition = model.getYPosition();
			this.setSize(400,300);
			this.setBackground(Color.black);
			try {
				File imageFile = new File(model.getFileName());
				if(imageFile.exists() == true){
					backgroundImage = ImageIO.read(imageFile);
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
			g.drawImage(backgroundImage, xPosition, yPosition, null);
		}
		
		void updateComponent(){
			this.xPosition++;
			this.yPosition++;
			repaint();
		}
		
		
	}
	
	public void updateBackgrounds(){
		for(BackgroundComponent currComponent: backgroundComponents){
			currComponent.updateComponent();
		}
	}
	
	public void updatePlayer(int x, int y){
		playerComponent.updateComponent(x, y);
	}

	public void paint(){
//		playerComponent.repaint();
	}

}
