package controller;

import javax.swing.JPanel;

import models.Animal;
import models.AnimalType;
import models.Interactable;
import views.View;
import java.awt.event.*;

public class Controller extends JPanel implements MouseListener, MouseMotionListener{
	
    String birdSprite = "sprite.png";
    String fishSprite = "sprite.png";
    String crabSprite = "sprite.png";
    
    
    private Interactable interactables[];
    Animal player;
    View view;
	
	public Controller(Animal model, View view) {
		this.player = model;
		this.view = view;
	}
	
	public void updateModel() {
	}
	
	public void updateView() {
		view.updateViewModel(player);
		view.frame.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
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
