package views;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import models.Animal;

public class View extends JPanel{
	
	public JFrame frame = new JFrame();
	public Animal viewModel;
	
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
