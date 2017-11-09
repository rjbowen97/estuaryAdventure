package views;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import controller.Controller;
import models.Player;

public class View extends JFrame {
	
	public JLayeredPane frame = new JLayeredPane();
	public Player playerModel;
	
	public View(Player playerModel) { //Maybe change this so it accepts an array of models
		super();
		this.playerModel = playerModel;
	}
	
	public void registerListenersFromController(Controller controller) {
		frame.setPreferredSize(new Dimension(500,500));
		//frame.getContentPane().addMouseListener(controller.mouseListenerComponent);
		frame.addMouseMotionListener(controller.mouseMotionListenerComponent);
		
	}
	
}
