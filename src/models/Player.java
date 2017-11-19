package models;
public abstract class Player {

	//limits
	
	//attributes
	protected int health;
	protected int score;

	protected int xPosition;
	protected int yPosition;

	protected String spriteFile = "./sprites/sprite.jpg";
	
	public abstract void move();
	public abstract void onViewClicked();
	
	
	public int getHealth() {
		return health;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getXPosition() {
		return xPosition;
	}
	
	public int getYPosition() {
		return yPosition;
	}
	
	public String getSpriteFile() {
		return spriteFile;
	}
	
}
