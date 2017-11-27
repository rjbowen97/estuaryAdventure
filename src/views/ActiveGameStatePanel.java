package views;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.Popup;

import controller.Controller;
import controller.Settings;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Background;
import models.Interactable;
import models.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class ActiveGameStatePanel.
 */
public class ActiveGameStatePanel extends JLayeredPane {
	
	/** The player component. */
	private PlayerComponent playerComponent;
	
	/** The background layered pane. */
	private BackgroundLayeredPane backgroundLayeredPane;
	
	/** The interactable component. */
	private InteractableComponent interactableComponent;
	
	/** The hud pane. */
	private HUDPane hudPane;
	
	/**
	 * Instantiates a new active game state panel.
	 *
	 * @param playerModel the player model
	 * @param backgroundModels the background models
	 * @param controller the controller
	 * @param interactableModels the interactable models
	 */
	public ActiveGameStatePanel(Player playerModel, ArrayList<Background> backgroundModels, Controller controller, ArrayList<Interactable> interactableModels) {

		this.backgroundLayeredPane = new BackgroundLayeredPane(backgroundModels);
		this.playerComponent = new PlayerComponent(playerModel, controller);
		this.interactableComponent = new InteractableComponent(interactableModels);
		this.hudPane = new HUDPane(playerModel);
		
		this.add(backgroundLayeredPane, new Integer(0));
		this.add(interactableComponent, new Integer(1));
		this.add(playerComponent, new Integer(2));
		this.add(hudPane, new Integer(3));
		
		this.setBounds(0,0,Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.setVisible(true);
		
		
	}
}
