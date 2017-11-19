package views;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import controller.Controller;
import controller.Settings;
import models.*;



@SuppressWarnings("serial")
public class View extends JFrame{

	private MainLayeredPane mainLayeredPane;
	private ArrayList<Component> allComponentsInView;

	private int mainFrameDimension;
	
	public View(Player playerModel, ArrayList<Background> backgroundModels) {
		
		this.mainFrameDimension = Integer.parseInt(Settings.globalSettings.getProperty("mainFrameDimension"));
		this.setSize(mainFrameDimension, mainFrameDimension);
		
		mainLayeredPane = new MainLayeredPane(playerModel, backgroundModels);
		mainLayeredPane.setBounds(0, 0, mainFrameDimension, mainFrameDimension);
		
		this.setLayeredPane(mainLayeredPane);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void paint(Graphics g) {
		mainLayeredPane.paint(g);
	}
	
	public void updateComponents() {
		
		this.allComponentsInView = getAllComponents(this);
		
		for (Component component : allComponentsInView ) {
			System.out.println(component.toString());
		}
		
	}
	
	public ArrayList<Component> getAllComponents(final Container c) {
	    Component[] comps = c.getComponents();
	    ArrayList<Component> compList = new ArrayList<Component>();
	    for (Component comp : comps) {
	        compList.add(comp);
	        if (comp instanceof Container)
	            compList.addAll(getAllComponents((Container) comp));
	    }
	    return compList;
	}
	
	
}
