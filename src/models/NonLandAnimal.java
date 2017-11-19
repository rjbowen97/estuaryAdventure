package models;

public class NonLandAnimal extends Player {

	@Override
	public void move() {
		this.yPosition += 5;
	}

	@Override
	public void onViewClicked() {
		this.yPosition -= 15;
		
	}
	
}
