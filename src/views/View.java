package views;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import controller.Settings;
import models.Background;
import models.Interactable;
import models.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class View.
 */
public class View extends JFrame {

	/**
	 * Instantiates a new view.
	 *
	 * @param playerModel the player model
	 * @param backgroundModels the background models
	 * @param controller the controller
	 * @param interactableModels the interactable models
	 */
	public View(Player playerModel, ArrayList<Background> backgroundModels, Controller controller, ArrayList<Interactable> interactableModels) {

		this.setBounds(0,0,Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
