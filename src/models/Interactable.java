package models;

public class Interactable implements GameModel {
	private int xPosition;
	private int yPosition;
	private boolean isFood;
	
	public int getxPosition() {
		return xPosition;
	}
	public int getyPosition() {
		return yPosition;
	}
	public boolean isFood() {
		return isFood;
	}
	
	@Override
	public void onTick() {
		// TODO Auto-generated method stub
	}
	
}