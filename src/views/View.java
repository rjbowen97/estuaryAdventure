package views;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import models.Animal;

public class View extends JPanel{
	
	public JFrame frame = new JFrame();
	public Animal viewModel;
	
	Component mouseClick = new MyComponent();
	
	class MyComponent extends JComponent implements MouseListener, MouseMotionListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			System.out.println("CLICKED!");
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			System.out.println(e.getX());
			
			viewModel.setXPosition(e.getX());
			viewModel.setYPosition(e.getY());
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public View(Animal animalModel) {
		frame.getContentPane().add(this);
		frame.setBackground(Color.GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(animalModel.frameWidth, animalModel.frameHeight);
		frame.addMouseListener((MouseListener) mouseClick);
		frame.addMouseMotionListener((MouseMotionListener) mouseClick);
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
