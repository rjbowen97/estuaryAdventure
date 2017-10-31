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

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

import models.Animal;
import models.Arena;

public class View extends JPanel{
	
	public JFrame frame = new JFrame();
	public Animal playerViewModel;
	public ArrayList<Arena> arenas = null;
	
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
			playerViewModel.setXPosition(e.getX());
			playerViewModel.setYPosition(e.getY());
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public View(Animal animalModel) { //Maybe change this so it accepts an array of models
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(animalModel.frameWidth, animalModel.frameHeight);
		
		frame.addMouseListener((MouseListener) mouseClick);
		frame.addMouseMotionListener((MouseMotionListener) mouseClick);
		frame.add(new AnimatingPanel());
		
		frame.pack();		
		frame.setVisible(true);
		
		playerViewModel = animalModel;
	}
	
	private class AnimatingPanel extends JPanel {
        private static final int DIM_W = 500;
        private static final int DIM_H = 500;
        private static final int INCREMENT = 10;

        private BufferedImage backgroundImage;

        private int targetGraphicFirstCornerXCoord, targetGraphicFirstCornerYCoord, targetGraphicSecondCornerXCoord, targetGraphicSecondCornerYCoord;
        private int backgroundFirstCornerXCoord, backgroundFirstCornerYCoord, backgroundSecondCornerXCoord, backgroundSecondCornerYCoord;
        private int IMAGE_WIDTH;

        public AnimatingPanel() {
            initImages();
            initImagePoints();
            Timer timer = new Timer(40, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    moveBackground();
                    repaint();
                }
            });
            timer.start();

            FlowLayout layout = (FlowLayout)getLayout();
            layout.setHgap(0);
            layout.setVgap(0);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.drawImage(backgroundImage,
            		targetGraphicFirstCornerXCoord,
            		targetGraphicFirstCornerYCoord,
            		targetGraphicSecondCornerXCoord,
            		targetGraphicSecondCornerYCoord,
            		backgroundFirstCornerXCoord,
            		backgroundFirstCornerYCoord,
                    backgroundSecondCornerXCoord,
                    backgroundSecondCornerYCoord,
                    this);
    		g.drawImage(playerViewModel.sprite, playerViewModel.getXPosition(), playerViewModel.getYPosition(),this);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(DIM_W, DIM_H);
        }

        private void initImagePoints() {
            targetGraphicFirstCornerXCoord = 0;
            targetGraphicFirstCornerYCoord = 0;
            targetGraphicSecondCornerXCoord = DIM_W;
            targetGraphicSecondCornerYCoord = DIM_H;
            backgroundFirstCornerXCoord = 0;
            backgroundFirstCornerYCoord = 0;
            backgroundSecondCornerXCoord = DIM_W;
            backgroundSecondCornerYCoord = DIM_H;
        }

        private void initImages() {
            try {
                backgroundImage = ImageIO.read(new File("b1.png"));
                IMAGE_WIDTH = backgroundImage.getWidth();
                System.out.println(IMAGE_WIDTH);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        private void moveBackground() {
            if (backgroundFirstCornerXCoord > IMAGE_WIDTH) {
                backgroundFirstCornerXCoord = 0 - DIM_W;
                backgroundSecondCornerXCoord = 0;
            } else {
                backgroundFirstCornerXCoord += INCREMENT;
                backgroundSecondCornerXCoord += INCREMENT;
            }
        }
    }
	
	public void updateViewModel(Animal newViewModel) {
		this.playerViewModel = newViewModel;
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(playerViewModel.sprite, playerViewModel.getXPosition(), playerViewModel.getYPosition(),this);
		//if(arenas.isEmpty()) return;
//		for(Arena currentArena: arenas)
//			g.drawImage(currentArena.getImage(), currentArena.getPoisitionX(), currentArena.getPositionY(), this);
	}
	

}
