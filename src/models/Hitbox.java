package models;

public class Hitbox {
	
	private GameModel gameModel;
	
	private Point topLeftCorner;
	private Point topRightCorner;
	private Point bottomLeftCorner;
	private Point bottomRightCorner;
	
	
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
		
		return false;
		
	}
	
	private class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public void update(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public boolean isAbove(Point otherPoint) {
			if (this.y < otherPoint.y) {
				return true;
			}
			
			return false;
		}
		
		public boolean isToTheRightOf(Point otherPoint) {
			if (this.x > otherPoint.x) {
				return true;
			}
			
			return false;
		}
		
	}
	
}
