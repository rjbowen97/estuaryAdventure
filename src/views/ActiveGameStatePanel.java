package views;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

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
	
	public FinishLineComponent finishLineComponent;
	
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
		this.finishLineComponent = new FinishLineComponent(finishLine);
		
		this.add(backgroundLayeredPane, new Integer(0));
		this.add(finishLineComponent, new Integer(1));
		this.add(interactableComponent, new Integer(2));
		this.add(playerComponent, new Integer(3));
		this.add(hudPane, new Integer(4));
		
		this.setBounds(0,0,Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.setVisible(true);
	}
	
	private JTextArea stepOneArea;
	private JTextArea stepTwoArea;
	
	
	public void addTutorialText(int step) {
		
		int screenMiddleX = Settings.getViewDimensionXDefault() / 2;
		int screenMiddleY = Settings.getViewDimensionYDefault() / 2;
		
		if (step == 0) {
			stepOneArea = new JTextArea("Click above or below your American Shad"
					+ "\nestuary friend towards"
					+ "\n its food source!");
			
			stepOneArea.setBounds(screenMiddleX, screenMiddleY, 200, 200);
			stepOneArea.setEditable(false);
			this.add(stepOneArea, new Integer(5));
			stepOneArea.setVisible(true);
		}
		
		else if (step == 1) {
			stepTwoArea = new JTextArea("Watch out for his larger predators!");
			
			stepTwoArea.setBounds(screenMiddleX, screenMiddleY, 200, 200);
			stepTwoArea.setEditable(false);
			this.add(stepTwoArea, new Integer(6));
			stepTwoArea.setVisible(true);
			
		}
		
	}
}
