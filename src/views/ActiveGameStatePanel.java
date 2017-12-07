package views;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

import controller.Controller;
import controller.Settings;
import models.Background;
import models.Interactable;
import models.Player;
import models.finishLine;

// TODO: Auto-generated Javadoc
/**
 * The Class ActiveGameStatePanel.
 */
public class ActiveGameStatePanel extends JLayeredPane implements Serializable {
	
	/** The player component. */
	public PlayerComponent playerComponent;
	
	/** The background layered pane. */
	public BackgroundLayeredPane backgroundLayeredPane;
	
	/** The interactable component. */
	public InteractableComponent interactableComponent;
	
//	public FinishLineComponent finishLineComponent;
	
	/** The hud pane. */
	public HUDPane hudPane;
	
	/**
	 * Instantiates a new active game state panel.
	 *
	 * @param playerModel the player model
	 * @param backgroundModels the background models
	 * @param controller the controller
	 * @param interactableModels the interactable models
	 */
	public ActiveGameStatePanel(Player playerModel, ArrayList<Background> backgroundModels, Controller controller, ArrayList<Interactable> interactableModels, finishLine finishLine) {
		
		this.backgroundLayeredPane = new BackgroundLayeredPane(backgroundModels);
		this.playerComponent = new PlayerComponent(playerModel, controller);
		this.interactableComponent = new InteractableComponent(interactableModels);
		this.hudPane = new HUDPane(playerModel);
//		this.finishLineComponent = new FinishLineComponent(finishLine);
		
		this.add(backgroundLayeredPane, new Integer(0));
//		this.add(finishLineComponent, new Integer(1));
		this.add(interactableComponent, new Integer(2));
		this.add(playerComponent, new Integer(3));
		this.add(hudPane, new Integer(4));
		
		this.setBounds(0,0,Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.setVisible(true);
		
		
	}
}
