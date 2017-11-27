package models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.Settings;

public class PlayerTest {
	
	private LandAnimal player;
	private LandAnimal comparePlayer;
	private Interactable inter, inter2;
	Settings set;

	@Before
	public void setUp() throws Exception {
		set = new Settings();
		player = new LandAnimal();
		comparePlayer = new LandAnimal();
		inter = new Interactable(0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPlayer() {
		assertTrue(player.getHealth() == comparePlayer.getHealth());
	}

	@Test
	public void testOnMiniGameEnd() {
		player.onMiniGameEnd(10);
		assertTrue(player.getScore() == 10);
		player.onMiniGameEnd(10);
		assertTrue(player.getScore() == 20);
	}

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

	@Test
	public void testOnCollisionWithInteractableModel() {
		while(inter.isFood())
			inter = new Interactable(0);
		player.onCollisionWithInteractableModel(inter);
		assertTrue(player.getScore() == 1);
		while(inter.isFood())
			inter = new Interactable(0);
		player.onCollisionWithInteractableModel(inter);
		assertTrue(player.getHealth() == 2);
	}

}
