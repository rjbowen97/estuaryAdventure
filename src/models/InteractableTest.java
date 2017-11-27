package models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.Settings;

public class InteractableTest {
	
	private Player player;
	private Interactable testInteractable;
	private int activationTick, yPos;
	private Settings set;

	@Before
	public void setUp() throws Exception {
		set = new Settings();
		activationTick = 0;
		testInteractable = new Interactable(activationTick);
		player = new LandAnimal();
		yPos = testInteractable.getYPosition();
	}

	@After
	public void tearDown() throws Exception {
	}

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
