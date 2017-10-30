package models;

public class Bird extends Animal {

	public Bird() {
		super.setHealth(MAXHEALTH);
		super.setScore(0);
		super.setXPosition(0);
		super.setYPosition(0);
		super.setVelocity(0);
		super.setPoweredUp(false);
		super.setXAcceleration(0);
		super.setYAcceleration(0);
	}
	
	public void move(){
		
	}

	
}
