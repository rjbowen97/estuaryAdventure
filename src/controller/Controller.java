package controller;

import javax.swing.JComponent;
import javax.swing.JPanel;

import models.Player;
import views.View;

import java.awt.Component;
import java.awt.event.*;

public class Controller extends JPanel {
	
    Player player;
    View view;
    
    Component mouseComponent = new MouseComponent();
	
    public Controller(Player model, View view) {
		this.player = model;
		this.view = view;
	}
    
    
	private class MouseComponent extends JComponent implements MouseListener, MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
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

	}
	
}
