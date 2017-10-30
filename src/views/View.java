package views;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import controller.Controller;
import models.Animal;

public class View extends JFrame{
	
	
	JFrame frame;
	
	Animal viewModel;
	
	public View(Animal animalModel) {
		
		frame.getContentPane().add(this);
		frame.setBackground(Color.GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(animalModel.frameWidth, animalModel.frameHeight);
		frame.setVisible(true);
		viewModel = animalModel;
	}
	
	public void updateViewModel(Animal newViewModel) {
		this.viewModel = newViewModel;
	}
	
	@Override
	public void paint(Graphics g){
		g.drawImage(viewModel.sprite, viewModel.getXPosition(), viewModel.getYPosition(), Color.gray, this);
	}
	

}
