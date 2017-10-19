package Model;

public class Animal {

	//limits
	protected final double MAX_HEALTH = 100;
	
	//attributes
	private double health;
	private int score;
	private int position_x, position_y;
	private double velocity;
	private boolean powered_up;
	
	
	//getters and setters
	public double getHealth() {
		return health;
	}
	public void setHealth(double health) {
		this.health = health;
	}
	public int getPosition_x() {
		return position_x;
	}
	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}
	public int getPosition_y() {
		return position_y;
	}
	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public double getVelocity() {
		return velocity;
	}
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
	public boolean isPowered_up() {
		return powered_up;
	}
	public void setPowered_up(boolean powered_up) {
		this.powered_up = powered_up;
	}


}
