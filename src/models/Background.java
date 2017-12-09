package models;

import java.io.Serializable;

import controller.Settings;

/**
 * The Class Background, which are models used in the active gamestate panel.
 */
public class Background extends GameModel implements Serializable {

	/** The background layer index, which is used to determine the layer sprite and speed of the background */
	public int backgroundLayerIndex;
	
	/** The background type, which is used to determine the level sprite of the background */
	public String backgroundType;

	/**
	 * Instantiates a new background.
	 *
	 * @param xPosition the x position
	 * @param yPosition the y position
	 * @param backgroundLayerIndex the background layer index
	 */
	public Background(int xPosition, int yPosition, int backgroundLayerIndex) {
		this.setxPosition(xPosition);
		this.setyPosition(yPosition);
		this.setWidth(Settings.getViewDimensionXDefault());
		this.setHeight(Settings.getViewDimensionYDefault());
		this.backgroundLayerIndex = backgroundLayerIndex;
		this.backgroundType = "w";
		this.setSpeed(Settings.getBackgroundBaseSpeed(backgroundLayerIndex));
	}
	
	/* (non-Javadoc)
	 * @see models.GameModel#setHitbox()
	 */
	@Override
	public void setHitbox() {
		this.setHitbox(new Hitbox(this));
	}

	/* (non-Javadoc)
	 * @see models.GameModel#updateHitbox()
	 */
	@Override
	public void updateHitbox() {
		this.getHitbox().update();
		
	}
	
	/* (non-Javadoc)
	 * @see models.GameModel#onTick()
	 */
	@Override
	public void onTick() {
		this.updateBackgroundPositions();
	}

	/**
	 * Updates background positions.
	 */
	private void updateBackgroundPositions() {
		int newXPosition = this.getXPosition() - this.getSpeed();
		this.setxPosition(newXPosition);
	}

	/* (non-Javadoc)
	 * @see models.GameModel#reset()
	 */
	@Override
	public void reset() {
	}
	
	/* (non-Javadoc)
	 * @see models.GameModel#toString()
	 */
	public String toString(){
		String result =super.toString();
		result += "\nLayer Index: "+ backgroundLayerIndex;
		return result;
	}	
}