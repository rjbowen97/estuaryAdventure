package views;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import models.Player;

public class View extends JFrame {
	
	public JFrame frame = new JFrame();
	public Player playerModel;
	
	public View(Player playerModel) { //Maybe change this so it accepts an array of models
		
		this.playerModel = playerModel;
	}
}
