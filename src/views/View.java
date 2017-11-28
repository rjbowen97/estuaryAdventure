package views;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import controller.Controller;
import controller.Settings;
import models.Background;
import models.Interactable;
import models.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class View.
 */
public class View extends JFrame implements Serializable {

	Controller controller;
	
	/**
	 * Instantiates a new view.
	 *
	 * @param playerModel the player model
	 * @param backgroundModels the background models
	 * @param controller the controller
	 * @param interactableModels the interactable models
	 */
	public View(Player playerModel, ArrayList<Background> backgroundModels, Controller controller, ArrayList<Interactable> interactableModels) {
		
		this.controller = controller;
		initializeKeyBindings();
		
		this.setBounds(0,0,Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initializeKeyBindings() {
		InputMap rootPaneInputMap = this.getRootPane().getInputMap();
		ActionMap rootPaneActionMap = this.getRootPane().getActionMap();
		
		rootPaneInputMap.put(KeyStroke.getKeyStroke('s'), "save");
		
		SaveAction saveAction = new SaveAction();
		rootPaneActionMap.put("save", saveAction);
	}
	
	private class SaveAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Saving...");
			controller.saveCurrentControllerState();
		}
	}
	
}





