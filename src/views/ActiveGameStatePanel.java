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
import models.FinishLine;

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
	 * Instantiates a new active game state panel. Combines all the models in the view so they can be displayed in 
	 * our active Jpanel.
	 *
	 * @param playerModel the player model
	 * @param backgroundModels the background models
	 * @param controller the controller
	 * @param interactableModels the interactable models
	 * @param FinishLine the finish line, ended up not being used in our final project as we could not find a way to make it disappear on game restart
	 */
	public ActiveGameStatePanel(Player playerModel, ArrayList<Background> backgroundModels, Controller controller, ArrayList<Interactable> interactableModels, FinishLine FinishLine) {
		
		this.backgroundLayeredPane = new BackgroundLayeredPane(backgroundModels);
		this.playerComponent = new PlayerComponent(playerModel, controller);
		this.interactableComponent = new InteractableComponent(interactableModels);
		this.hudPane = new HUDPane(playerModel);
//		this.finishLineComponent = new FinishLineComponent(FinishLine);
		
		this.add(backgroundLayeredPane, new Integer(0));
//		this.add(finishLineComponent, new Integer(1));
		this.add(interactableComponent, new Integer(2));
		this.add(playerComponent, new Integer(3));
		this.add(hudPane, new Integer(4));
		
		this.setBounds(0,0,Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		this.setVisible(true);
	}
	
	/** Step one area is our first pause state, used to give the user instructions in a tutorial. */
	private JTextArea stepOneArea;
	
	/** Step two area is our second pause state, used to give the user instructions in a tutorial. */
	private JTextArea stepTwoArea;
	
	
	/**
	 * Adds the tutorial text using JtextArea so that the user can recieve instructions in the tutorial.
	 *
	 * @param step step is our designation for each pause state
	 */
	public void addTutorialText(int step) {
		
		int screenMiddleX = Settings.getViewDimensionXDefault() - 210;
		int screenMiddleY = Settings.getViewDimensionYDefault() - 210;
		
		if (step == 0) {
			stepOneArea = new JTextArea("Click above or below your"
					+ "\nAmerican Shad"
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
		
		else {
			stepOneArea.setVisible(false);
			stepTwoArea.setVisible(false);
		}
		
	}
}
