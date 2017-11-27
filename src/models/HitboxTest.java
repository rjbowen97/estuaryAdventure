package models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.Settings;
import models.Hitbox.Point;

public class HitboxTest{

	private Hitbox hitbox, offHb, overLapHb;
	private GameModel model, offModel, overLappingModel;
	private Settings set;
	private int orig_x =10, orig_y =10;
	@Before
	public void setUp() throws Exception {
		set = new Settings();
		model = new Background(orig_x, orig_y,0);
		overLappingModel = new Background(9,9,1);
		
		hitbox = new Hitbox(model);
		overLapHb = new Hitbox(overLappingModel);
	}

	//demonstrates hitboxes only change positions if the model updates its position, cant update on own
	@Test
	public void testUpdate(){
		assertTrue(hitbox.topLeftCorner.x == orig_x);
		assertTrue(hitbox.bottomLeftCorner.x == orig_x);
		assertTrue(hitbox.topRightCorner.x == orig_x + model.getSpriteImage().getWidth());
		assertTrue(hitbox.bottomRightCorner.x == orig_x + model.getSpriteImage().getWidth());
		assertTrue(hitbox.topLeftCorner.y == orig_y);
		assertTrue(hitbox.bottomLeftCorner.y == orig_y + model.getSpriteImage().getHeight());
		assertTrue(hitbox.topRightCorner.y == orig_y);
		assertTrue(hitbox.bottomRightCorner.y == orig_y + model.getSpriteImage().getHeight());
		hitbox.update();
		
		//assert values havent changed
		assertTrue(hitbox.topLeftCorner.x == orig_x);
		assertTrue(hitbox.bottomLeftCorner.x == orig_x);
		assertTrue(hitbox.topRightCorner.x == orig_x + model.getSpriteImage().getWidth());
		assertTrue(hitbox.bottomRightCorner.x == orig_x + model.getSpriteImage().getWidth());
		assertTrue(hitbox.topLeftCorner.y == orig_y);
		assertTrue(hitbox.bottomLeftCorner.y == orig_y + model.getSpriteImage().getHeight());
		assertTrue(hitbox.topRightCorner.y == orig_y);
		assertTrue(hitbox.bottomRightCorner.y == orig_y + model.getSpriteImage().getHeight());
	}
	
	
	@After
	public void tearDown() throws Exception {
	}
	
	
	//helper func for cleaner code
	private void setNewModelCoords(int x, int y, GameModel mod){
		mod = new Background(x,y, 1);
		overLapHb = new Hitbox(mod);
	}

	@Test
	public void testOverlapping() {
		//tests first case
		assertTrue(hitbox.isOverlapping(overLapHb));
		setNewModelCoords(hitbox.topLeftCorner.x,model.getYPosition()-1,overLappingModel);
		assertTrue(hitbox.isOverlapping(overLapHb));	
		//2nd
		setNewModelCoords(hitbox.topRightCorner.x,model.getYPosition()-1,overLappingModel);
		assertTrue(hitbox.isOverlapping(overLapHb));
		//3rd
		setNewModelCoords(hitbox.bottomLeftCorner.x,model.getYPosition()+1,overLappingModel);
		assertTrue(hitbox.isOverlapping(overLapHb));
		//4th
		setNewModelCoords(hitbox.bottomRightCorner.x,model.getYPosition()+1,overLappingModel);
		assertTrue(hitbox.isOverlapping(overLapHb));
		//rest cant be tested
		setNewModelCoords(hitbox.bottomRightCorner.x,hitbox.bottomRightCorner.y+1,overLappingModel);
		assertTrue(hitbox.isOverlapping(overLapHb)==false);
		
	}

	
	

}
