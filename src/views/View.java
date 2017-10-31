package views;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import models.Animal;

public class View extends JPanel{
	
	public JFrame frame = new JFrame();
	public Animal playerViewModel;
	
	Component mouseClick = new MouseComponent();
	
	private class MouseComponent extends JComponent implements MouseListener, MouseMotionListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
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
		frame.setSize(animalModel.imgWidth, animalModel.imgHeight);
		
		frame.addMouseListener((MouseListener) mouseClick);
		frame.addMouseMotionListener((MouseMotionListener) mouseClick);
		frame.add(new MainGamePanel());
		
		frame.pack();		
		frame.setVisible(true);
		
		playerViewModel = animalModel;
	}
	
	private class MainGamePanel extends JPanel {
        private static final int DIM_W = 500;
        private static final int DIM_H = 500;
        private static final int BACKGROUND_INCREMENT = 10;

        private BufferedImage backgroundImage;

        private int targetGraphicFirstCornerXCoord, targetGraphicFirstCornerYCoord, targetGraphicSecondCornerXCoord, targetGraphicSecondCornerYCoord;
        private int backgroundFirstCornerXCoord, backgroundFirstCornerYCoord, backgroundSecondCornerXCoord, backgroundSecondCornerYCoord;
        private int BACKGROUND_WIDTH;

        public MainGamePanel() {
            initImages();
            initBackgroundImagePoints();
            Timer timer = new Timer(40, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    moveBackground();
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.LIGHT_GRAY);
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

        private void initBackgroundImagePoints() {
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
                backgroundImage = ImageIO.read(new File("b1.jpg"));
                BACKGROUND_WIDTH = backgroundImage.getWidth();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        private void moveBackground() {
            if (backgroundFirstCornerXCoord > BACKGROUND_WIDTH) {
                backgroundFirstCornerXCoord = 0 - DIM_W;
                backgroundSecondCornerXCoord = 0;
            } else {
                backgroundFirstCornerXCoord += BACKGROUND_INCREMENT;
                backgroundSecondCornerXCoord += BACKGROUND_INCREMENT;
            }
        }
    }
	
	public void updateViewModel(Animal newViewModel) {
		this.playerViewModel = newViewModel;
	}
}
