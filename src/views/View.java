package views;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import models.Animal;
import models.Arena;

public class View extends JPanel{
	
	public JFrame frame = new JFrame();
	public Animal viewModel;
	public ArrayList<Arena> arenas = null;
	private final String backgroundFolder = "/backgrounds";
	
	private int backgroundPosition;
		
	private JLayeredPane layeredPane;
	
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
			viewModel.setXPosition(e.getX());
			viewModel.setYPosition(e.getY());
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public View(Animal animalModel) {
		super();
		frame.getContentPane().add(this);
		frame.setBackground(Color.GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(animalModel.frameWidth, animalModel.frameHeight);
		frame.addMouseListener((MouseListener) mouseClick);
		frame.addMouseMotionListener((MouseMotionListener) mouseClick);
		
		viewModel = animalModel;
		getArenas(); //does nothing for now
		frame.setVisible(true);
	}
	
	private void getArenas(){
//		for(String imageFile: new File(backgroundFolder).list())
//				arenas.add(new Arena(imageFile));		
	}
	
	public void updateArenas(){
//		for(Arena ar: arenas)
//			ar.updatePosition();
		backgroundPosition = (backgroundPosition > frame.getWidth()) ? 0 : backgroundPosition + 10;		
	}
	
	public void updateViewModel(Animal newViewModel) {
		this.viewModel = newViewModel;
	}
	
		
	@Override
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(new Arena("b1.png").getImage(), backgroundPosition, 0, this);
		g.drawImage(new Arena("b2.png").getImage(), -backgroundPosition, 0, this);
		g.drawImage(new Arena("b3.png").getImage(), 200, 0, this);
		g.drawImage(new Arena("b4.png").getImage(), 210, 0, this);
		g.drawImage(new Arena("b5.png").getImage(), 310, 0, this);
		g.drawImage(viewModel.sprite, viewModel.getXPosition(), viewModel.getYPosition(), Color.gray, this);
		//if(arenas.isEmpty()) return;
//		for(Arena currentArena: arenas)
//			g.drawImage(currentArena.getImage(), currentArena.getPoisitionX(), currentArena.getPositionY(), this);
	}
	

}
