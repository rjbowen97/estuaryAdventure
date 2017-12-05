package models;

import static org.junit.Assert.assertTrue;

import java.io.Serializable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.Settings;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerTest.
 */
public class PlayerTest implements Serializable {
	
	/** The player. */
	private LandAnimal player;
	
	/** The compare player. */
	private LandAnimal comparePlayer;
	
	/** The inter 2. */
	private Interactable inter, inter2;
	
	/** The set. */
	Settings set;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		set = new Settings();
		player = new LandAnimal();
		comparePlayer = new LandAnimal();
		inter = new Interactable(0);
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
	 * Test player.
	 */
	@Test
	public void testPlayer() {
		assertTrue(player.getHealth() == comparePlayer.getHealth());
	}

	/**
	 * Test on mini game end.
	 */
	@Test
	public void testOnMiniGameEnd() {
		player.onMiniGameEnd(10);
		assertTrue(player.getScore() == 10);
		player.onMiniGameEnd(10);
		assertTrue(player.getScore() == 20);
	}

	/**
	 * Test reset score streak.
	 */
	@Test
	public void testResetScoreStreak() {
		assertTrue(comparePlayer.getScoreStreak() == 0);
		while(!inter.isFood())
			inter = new Interactable(0);
		comparePlayer.onCollisionWithInteractableModel(inter);
		assertTrue(comparePlayer.getScoreStreak() == 1);
		comparePlayer.resetScoreStreak();
		assertTrue(comparePlayer.getScoreStreak() == 0);
		
		//assertTrue(comparePlayer.getScoreStreak() == 1);
	}

	/**
	 * Test on collision with interactable model.
	 */
	@Test
	public void testOnCollisionWithInteractableModel() {
		while(!inter.isFood())
			inter = new Interactable(0);
		player.onCollisionWithInteractableModel(inter);
		assertTrue(player.getScore() == 1);
		while(inter.isFood())
			inter = new Interactable(0);
		player.onCollisionWithInteractableModel(inter);
		assertTrue(player.getHealth() == 2);
	}

}
