package models;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.Settings;

public class BackgroundTest {
	
	private BufferedImage testImage;
	private int xPos, yPos;
	private static int layerPos;
	static Background bckGrnd;
	Settings settings;
	
	@Before
	public void setUp(){
		settings = new Settings();
		xPos = 40;
		yPos = 30;
		layerPos = 0;
		try {
			testImage = ImageIO.read(new File("./Graphics/Backgrounds/AirBackground/b" + layerPos + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBackground0Layer() {
		
		//test starting from Player Start Settings on Layer 0
		bckGrnd = new Background(xPos, yPos, layerPos);
		assertEquals(bckGrnd.getSpeed(), Settings.getBackgroundBaseSpeed(0));
		assertTrue(bckGrnd.getXPosition() == 40);
		assertTrue(bckGrnd.getYPosition() == 30);
	}
	
	@Test
	public void testBackground1Layer() {
		
		//test starting from Player Start Settings on Layer 1
		layerPos = 1;
		bckGrnd = new Background(xPos, yPos, layerPos);
		assertEquals(bckGrnd.getSpeed(), Settings.getBackgroundBaseSpeed(1));
		assertTrue(bckGrnd.getXPosition() == 40);
		assertTrue(bckGrnd.getYPosition() == 30);
	}
	
	@Test
	public void testBackground2Layer() {
		
		//test starting from Player Start Settings on Layer 2
		layerPos = 2;
		bckGrnd = new Background(xPos, yPos, layerPos);
		assertEquals(bckGrnd.getSpeed(), Settings.getBackgroundBaseSpeed(2));
		assertTrue(bckGrnd.getXPosition() == 40);
		assertTrue(bckGrnd.getYPosition() == 30);
	}
	
	@Test
	public void testBackground3Layer() {
		
		//test starting from Player Start Settings on Layer 3
		layerPos = 3;
		bckGrnd = new Background(xPos, yPos, layerPos);
		assertEquals(bckGrnd.getSpeed(), Settings.getBackgroundBaseSpeed(3));
		assertTrue(bckGrnd.getXPosition() == 40);
		assertTrue(bckGrnd.getYPosition() == 30);
	}
	
	@Test
	public void testBackground4Layer() {
		
		//test starting from Player Start Settings on Layer 4
		layerPos = 4;
		bckGrnd = new Background(xPos, yPos, layerPos);
		assertEquals(bckGrnd.getSpeed(), Settings.getBackgroundBaseSpeed(4));
		assertTrue(bckGrnd.getXPosition() == 40);
		assertTrue(bckGrnd.getYPosition() == 30);
	}
	
	@Test
	public void testTick(){
		bckGrnd = new Background(xPos, yPos, 0);
		int newX = bckGrnd.getXPosition() - bckGrnd.getSpeed();
		bckGrnd.onTick();
		assertTrue(bckGrnd.getXPosition() == newX);
	}

	@Test
	public void testHitBox(){
		Hitbox testHitB = new Hitbox(new Background(40,30,0));
		bckGrnd = new Background(xPos, yPos, layerPos);
		bckGrnd.setHitbox();
		bckGrnd.updateHitbox();
		assertTrue(bckGrnd.getHitbox().isOverlapping(testHitB));
	}
	
	//currently does nothing
	@Test
	public void testReset() {
		bckGrnd = new Background(xPos, yPos, layerPos);
		bckGrnd.reset();
	}

	

}
