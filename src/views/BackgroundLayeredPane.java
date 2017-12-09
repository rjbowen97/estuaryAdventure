package views;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

import controller.Settings;
import models.Background;

// TODO: Auto-generated Javadoc
/**
 * The Class BackgroundLayeredPane.
 */
public class BackgroundLayeredPane extends JLayeredPane implements Serializable {
	
	/** The background components. */
	private ArrayList<BackgroundComponent> backgroundComponents;
	
	/**
	 * Instantiates a new background layered pane. We decided to use a layered pane in order to have different background speeds
	 * for each layer in order to increase immersion and visual efficacy 
	 *
	 * @param backgroundModels the background models, list of layered panes used
	 */
	public BackgroundLayeredPane(ArrayList<Background> backgroundModels) {
		
		backgroundComponents = new ArrayList<BackgroundComponent>();
		BackgroundComponent backgroundComponentToAdd = null;
		
		this.setBounds(0, 0, Settings.getViewDimensionXDefault(), Settings.getViewDimensionYDefault());
		
		for (int backgroundModelIndex = 0; backgroundModelIndex < backgroundModels.size(); backgroundModelIndex++) {
			
			backgroundComponentToAdd = new BackgroundComponent(backgroundModels.get(backgroundModelIndex));
			
			this.add(backgroundComponentToAdd, new Integer(backgroundModelIndex));
			
			backgroundComponents.add(backgroundComponentToAdd);
		}
	}
}
