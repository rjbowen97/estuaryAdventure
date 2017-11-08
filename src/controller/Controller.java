package controller;

import javax.swing.JComponent;
import javax.swing.JPanel;

import models.Player;
import views.View;

import java.awt.Component;
import java.awt.event.*;

public class Controller extends JPanel {
	
    Player playerModel;
    View view;
    
    Component mouseComponent = new MouseComponent();
	
    public Controller(Player model, View view) {
		this.playerModel = model;
		this.view = view;
	}
    
	private class MouseComponent extends JComponent implements MouseListener, MouseMotionListener {
		
		@Override
		public void mouseDragged(MouseEvent e) {
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
	}
	
}
