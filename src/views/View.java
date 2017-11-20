package views;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import controller.Controller;
import controller.Settings;
import models.Background;
import models.Player;

public class View extends JFrame {

	private MainLayeredPane mainLayeredPane;
	private int viewDimension;
	Controller controller;
	
	public View(Player playerModel, ArrayList<Background> backgroundModels, Controller controller) {
		
		this.controller = controller;
		this.viewDimension = Settings.getViewDimensionDefault();
		this.setSize(viewDimension, viewDimension);
		
		mainLayeredPane = new MainLayeredPane(playerModel, backgroundModels);
		
		this.add(mainLayeredPane);
		this.addMouseListener(new viewMouseListener());
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private class viewMouseListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent mouseEvent) {
			controller.onViewClicked(mouseEvent);
		}

		@Override
		public void mouseEntered(MouseEvent mouseEvent) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent mouseEvent) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent mouseEvent) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent mouseEvent) {
			// TODO Auto-generated method stub
			
		}
	}
}
