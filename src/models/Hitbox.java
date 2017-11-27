package models;

public class Hitbox {

	private GameModel gameModel;

	public Point topLeftCorner;
	public Point topRightCorner;
	public Point bottomLeftCorner;
	public Point bottomRightCorner;


	public Hitbox(GameModel gameModel) {
		this.gameModel = gameModel;
		this.topLeftCorner = new Point(gameModel.getXPosition(),gameModel.getYPosition());
		this.topRightCorner = new Point(gameModel.getXPosition() + gameModel.getSpriteImage().getWidth(), gameModel.getYPosition());
		this.bottomLeftCorner = new Point(gameModel.getXPosition(),gameModel.getYPosition() + gameModel.getSpriteImage().getHeight());
		this.bottomRightCorner = new Point(gameModel.getXPosition() + gameModel.getSpriteImage().getWidth(), gameModel.getYPosition() + gameModel.getSpriteImage().getHeight());
	}

	public void update() {
		this.topLeftCorner.update(gameModel.getXPosition(),gameModel.getYPosition());
		this.topRightCorner.update(gameModel.getXPosition() + gameModel.getSpriteImage().getWidth(), gameModel.getYPosition());
		this.bottomLeftCorner.update(gameModel.getXPosition(),gameModel.getYPosition() + gameModel.getSpriteImage().getHeight());
		this.bottomRightCorner.update(gameModel.getXPosition() + gameModel.getSpriteImage().getWidth(), gameModel.getYPosition() + gameModel.getSpriteImage().getHeight());
	}

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

	public class Point {
		public int x;
		public int y;

		public String toString(){
			return "X: " + this.x + "\nY: " + this.y;
		}
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void update(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public boolean isAbove(Point otherPoint) {
			if (this.y <= otherPoint.y) {
				return true;
			}

			return false;
		}

		public boolean isToTheRightOf(Point otherPoint) {
			if (this.x >= otherPoint.x) {
				return true;
			}

			return false;
		}

	}

}
