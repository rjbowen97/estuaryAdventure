package testing;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.Settings;
import models.Interactable;
import models.LandAnimal;
import models.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class InteractableTest.
 */
public class InteractableTest {
	
	/** The player. */
	private Player player;
	
	/** The test interactable. */
	private Interactable testInteractable;
	
	/** The y pos. */
	private int activationTick, yPos;
	
	/** The set. */
	private Settings set;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		set = new Settings();
		activationTick = 0;
		testInteractable = new Interactable(activationTick);
		player = new LandAnimal();
		yPos = testInteractable.getYPosition();
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
	 * Test interactable.
	 */
	@Test
	public void testInteractable() {
		assertTrue(testInteractable.getSpeed() == Settings.getInteractableSpeed());
		assertTrue(testInteractable.getActivationTick() == activationTick);
		assertTrue(testInteractable.getXPosition() == Settings.getInteractableStartXPosition());
		assertTrue(testInteractable.getYPosition() == yPos);
		assert(testInteractable.isActive() == false);
		testInteractable.activate();
		assertTrue(testInteractable.isActive());
	}

	/**
	 * Test on tick.
	 */
	@Test
	public void testOnTick() {
		int newX = Settings.getInteractableStartXPosition() - testInteractable.getSpeed();
		testInteractable.onTick();
		assertTrue(testInteractable.getXPosition() == newX);
	}
//
//	@Test
//	public void testReset() {
//		fail("Not yet implemented");
//	}
//
/**
 * Test on collision with player model.
 */
//
	@Test
	public void testOnCollisionWithPlayerModel() {
		testInteractable.onCollisionWithPlayerModel(player);
		assertTrue(testInteractable.isActive() == false);
	}
//

//	@Test
//	public void testIsFood() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testIsActive() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetActivationTick() {
//		fail("Not yet implemented");
//	}

}
