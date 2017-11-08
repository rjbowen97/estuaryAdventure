package controller;


import models.Player;
import views.View;

import java.awt.event.*;

public class Controller {
	
    Player playerModel;
    View view;
    
    public MouseListenerComponent mouseListenerComponent = new MouseListenerComponent();
    public MouseMotionListenerComponent mouseMotionListenerComponent = new MouseMotionListenerComponent();
    
    public Controller(Player model, View view) {
		this.playerModel = model;
		this.view = view;
		
		setUpView();
	}
    
    private void setUpView() {
    	view.registerListenersFromController(this);
    }
    
    private class MouseMotionListenerComponent implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
		}
    	
    }
    
	private class MouseListenerComponent implements MouseListener {

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
