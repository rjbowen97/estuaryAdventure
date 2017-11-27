package views;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import controller.Controller;
import controller.Settings;
import models.Background;
import models.Interactable;
import models.Player;

public class View extends JFrame {

	public View(Player playerModel, ArrayList<Background> backgroundModels, Controller controller, ArrayList<Interactable> interactableModels) {

		
		this.setBounds(0,0,Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
