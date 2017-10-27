package views;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import controller.Controller;
import models.Animal;

public class View extends JFrame{
	
	
	public JFrame frame;
	private BufferedImage playerSprite, backgroundImage, interactableSprites[];
	
	private Animal mainModel;
	
	@Override
	public void paint(Graphics g){

	}
	
	public View(Animal model) {
		mainModel = model;
		frame = new JFrame();
		frame.setBackground(Color.cyan);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(Controller.getFramewidth(), Controller.getFrameheight());
		frame.setVisible(true);
		//frame.getContentPane().add(mainModel);		
	}

}
