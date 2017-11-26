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
		layerPos += 1;
	}
//	
//	@Test
//	public void testSetSpriteImage() {
//		try {
//			testImage = ImageIO.read(new File("./Graphics/Backgrounds/AirBackground/b" + layerPos + ".png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		assertTrue(testImage != bckGrnd.getSpriteImage());
//	}
//
//	@Test
//	public void testSetHitbox() {
//		
//	}
//
//	@Test
//	public void testUpdateHitbox() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testOnTick() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testReset() {
//	}
//
//	

}
