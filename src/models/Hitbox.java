package models;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Hitbox.
 */
public class Hitbox implements Serializable {

	/** The game model. */
	private GameModel gameModel;

	/** The top left corner. */
	public Point topLeftCorner;
	
	/** The top right corner. */
	public Point topRightCorner;
	
	/** The bottom left corner. */
	public Point bottomLeftCorner;
	
	/** The bottom right corner. */
	public Point bottomRightCorner;


	/**
	 * Instantiates a new hitbox.
	 *
	 * @param gameModel the game model
	 */
	public Hitbox(GameModel gameModel) {
		this.gameModel = gameModel;
		this.topLeftCorner = new Point(gameModel.getXPosition(),gameModel.getYPosition());
		this.topRightCorner = new Point(gameModel.getXPosition() + gameModel.getSpriteImage().getWidth(), gameModel.getYPosition());
		this.bottomLeftCorner = new Point(gameModel.getXPosition(),gameModel.getYPosition() + gameModel.getSpriteImage().getHeight());
		this.bottomRightCorner = new Point(gameModel.getXPosition() + gameModel.getSpriteImage().getWidth(), gameModel.getYPosition() + gameModel.getSpriteImage().getHeight());
	}

	/**
	 * Update.
	 */
	public void update() {
		this.topLeftCorner.update(gameModel.getXPosition(),gameModel.getYPosition());
		this.topRightCorner.update(gameModel.getXPosition() + gameModel.getSpriteImage().getWidth(), gameModel.getYPosition());
		this.bottomLeftCorner.update(gameModel.getXPosition(),gameModel.getYPosition() + gameModel.getSpriteImage().getHeight());
		this.bottomRightCorner.update(gameModel.getXPosition() + gameModel.getSpriteImage().getWidth(), gameModel.getYPosition() + gameModel.getSpriteImage().getHeight());
	}

	/**
	 * Checks if is overlapping.
	 *
	 * @param otherHitbox the other hitbox
	 * @return true, if is overlapping
	 */
	public boolean isOverlapping(Hitbox otherHitbox) {
		
	if (!this.topLeftCorner.isAbove(otherHitbox.topLeftCorner)
				&& (this.topLeftCorner.isAbove(otherHitbox.bottomLeftCorner))
				&& this.topLeftCorner.isToTheRightOf(otherHitbox.topLeftCorner)
				&& !this.topLeftCorner.isToTheRightOf(otherHitbox.topRightCorner)) {
		return true;
	}

		if (!this.topRightCorner.isAbove(otherHitbox.topLeftCorner)
				&& (this.topRightCorner.isAbove(otherHitbox.bottomLeftCorner))
				&& this.topRightCorner.isToTheRightOf(otherHitbox.topLeftCorner)
				&& !this.topRightCorner.isToTheRightOf(otherHitbox.topRightCorner)) {

			return true;
		}

		if (!this.bottomLeftCorner.isAbove(otherHitbox.topLeftCorner)
				&& (this.bottomLeftCorner.isAbove(otherHitbox.bottomLeftCorner))
				&& this.bottomLeftCorner.isToTheRightOf(otherHitbox.topLeftCorner)
				&& !this.bottomLeftCorner.isToTheRightOf(otherHitbox.topRightCorner)) {

			return true;
		}

		if (!this.bottomRightCorner.isAbove(otherHitbox.topLeftCorner)
				&& (this.bottomRightCorner.isAbove(otherHitbox.bottomLeftCorner))
				&& this.bottomRightCorner.isToTheRightOf(otherHitbox.topLeftCorner)
				&& !this.bottomRightCorner.isToTheRightOf(otherHitbox.topRightCorner)) {

			return true;
		}

		//----

		if (!otherHitbox.topLeftCorner.isAbove(this.topLeftCorner)
				&& (otherHitbox.topLeftCorner.isAbove(this.bottomLeftCorner))
				&& otherHitbox.topLeftCorner.isToTheRightOf(this.topLeftCorner)
				&& !otherHitbox.topLeftCorner.isToTheRightOf(this.topRightCorner)) {
			return true;
		}

		if (!otherHitbox.topRightCorner.isAbove(this.topLeftCorner)
				&& (otherHitbox.topRightCorner.isAbove(this.bottomLeftCorner))
				&& otherHitbox.topRightCorner.isToTheRightOf(this.topLeftCorner)
				&& !otherHitbox.topRightCorner.isToTheRightOf(this.topRightCorner)) {
			return true;
		}

		if (!otherHitbox.bottomLeftCorner.isAbove(this.topLeftCorner)
				&& (otherHitbox.bottomLeftCorner.isAbove(this.bottomLeftCorner))
				&& otherHitbox.bottomLeftCorner.isToTheRightOf(this.topLeftCorner)
				&& !otherHitbox.bottomLeftCorner.isToTheRightOf(this.topRightCorner)) {
			return true;
		}

		if (!otherHitbox.bottomRightCorner.isAbove(this.topLeftCorner)
				&& (otherHitbox.bottomRightCorner.isAbove(this.bottomLeftCorner))
				&& otherHitbox.bottomRightCorner.isToTheRightOf(this.topLeftCorner)
				&& !otherHitbox.bottomRightCorner.isToTheRightOf(this.topRightCorner)) {
			return true;
		}

		return false;

	}
	
	public String toString(){
		String result = "Top Left Corner X: " + this.topLeftCorner.x + " Y:" + this.topLeftCorner.y +
				"Top Right Corner X: " + this.topRightCorner.x + " Y:" + this.topRightCorner.y +
				"Bottom Left Corner X: " + this.bottomLeftCorner.x + " Y:" + this.bottomLeftCorner.y +
				"Bottom Right Corner X: " + this.bottomRightCorner.x + " Y:" + this.bottomRightCorner.y;
		return result;
	}

	/**
	 * The Class Point.
	 */
	public class Point implements Serializable {
		
		/** The x. */
		public int x;
		
		/** The y. */
		public int y;

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString(){
			return "X: " + this.x + "\nY: " + this.y;
		}
		
		/**
		 * Instantiates a new point.
		 *
		 * @param x the x
		 * @param y the y
		 */
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		/**
		 * Update.
		 *
		 * @param x the x
		 * @param y the y
		 */
		public void update(int x, int y) {
			this.x = x;
			this.y = y;
		}

		/**
		 * Checks if is above.
		 *
		 * @param otherPoint the other point
		 * @return true, if is above
		 */
		public boolean isAbove(Point otherPoint) {
			if (this.y <= otherPoint.y) {
				return true;
			}

			return false;
		}

		/**
		 * Checks if is to the right of.
		 *
		 * @param otherPoint the other point
		 * @return true, if is to the right of
		 */
		public boolean isToTheRightOf(Point otherPoint) {
			if (this.x >= otherPoint.x) {
				return true;
			}

			return false;
		}

	}

}
