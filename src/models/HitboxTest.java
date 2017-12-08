package models;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.Settings;

// TODO: Auto-generated Javadoc
/**
 * The Class HitboxTest.
 */
public class HitboxTest{

	/** The over lap hb. */
	private Hitbox hitbox, offHb, overLapHb;
	
	/** The over lapping model. */
	private GameModel model, offModel, overLappingModel;
	
	/** The set. */
	private Settings set;
	
	/** The orig y. */
	private int orig_x =10, orig_y =10;
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		set = new Settings();
		model = new Background(orig_x, orig_y,0);
		overLappingModel = new Background(9,9,1);
		
		hitbox = new Hitbox(model);
		overLapHb = new Hitbox(overLappingModel);
	}

	/**
	 * Test update.
	 */
	//demonstrates hitboxes only change positions if the model updates its position, cant update on own
	@Test
	public void testUpdate(){
		assertTrue(hitbox.topLeftCorner.x == orig_x);
		assertTrue(hitbox.bottomLeftCorner.x == orig_x);
		assertTrue(hitbox.topRightCorner.x == orig_x + model.getWidth());
		assertTrue(hitbox.bottomRightCorner.x == orig_x + model.getWidth());
		assertTrue(hitbox.topLeftCorner.y == orig_y);
		assertTrue(hitbox.bottomLeftCorner.y == orig_y + model.getHeight());
		assertTrue(hitbox.topRightCorner.y == orig_y);
		assertTrue(hitbox.bottomRightCorner.y == orig_y + model.getHeight());
		hitbox.update();
		assertTrue(hitbox.topLeftCorner.x == orig_x);
		assertTrue(hitbox.bottomLeftCorner.x == orig_x);
		assertTrue(hitbox.topRightCorner.x == orig_x + model.getWidth());
		assertTrue(hitbox.bottomRightCorner.x == orig_x + model.getWidth());
		assertTrue(hitbox.topLeftCorner.y == orig_y);
		assertTrue(hitbox.bottomLeftCorner.y == orig_y + model.getHeight());
		assertTrue(hitbox.topRightCorner.y == orig_y);
		assertTrue(hitbox.bottomRightCorner.y == orig_y + model.getHeight());
	}
	
	
	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Sets the new model coords.
	 *
	 * @param x the x
	 * @param y the y
	 * @param mod the mod
	 */
	private void setNewModelCoords(int x, int y, GameModel mod){
		mod = new Background(x,y, 1);
		overLapHb = new Hitbox(mod);
	}

	/**
	 * Test overlapping.
	 */
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
