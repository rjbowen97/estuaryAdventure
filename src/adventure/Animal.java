package adventure;

public class Animal {

	//limits
	protected final int MAX_HEALTH = 100;
	
	//attributes
	private int health;
	private int score;
	private int position_x, position_y;
	private int x_acceleration;
	private int y_acceleration;
	private int velocity;
	
	private boolean powered_up;
	private boolean animal_type; //for the two different estuaries
	
	//getters and setters
	public double getHealth() {
		return health;
	}
	public void setHealth(int health) {
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
	public int getVelocity() {
		return velocity;
	}
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	public boolean isPowered_up() {
		return powered_up;
	}
	public void setPowered_up(boolean powered_up) {
		this.powered_up = powered_up;
	}
	public int getX_acceleration() {
		return x_acceleration;
	}
	public void setX_acceleration(int x_acceleration) {
		this.x_acceleration = x_acceleration;
	}
	public int getY_acceleration() {
		return y_acceleration;
	}
	public void setY_acceleration(int y_acceleration) {
		this.y_acceleration = y_acceleration;
	}


}
