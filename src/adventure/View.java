package adventure;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class View extends JFrame{
	
	
	public JFrame frame;
	private BufferedImage playerSprite, backgroundImage, interactable_sprites[];
	
	private Animal mainModel;
	
	@Override
	public void paint(Graphics g){

	}
	
	
	public View(Animal model) {
		mainModel = model;
		frame = new JFrame();
		frame.setBackground(Color.cyan);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(Controller.getFramewidth(), Controller.getFrameheight());
		frame.setVisible(true);
		//frame.getContentPane().add(m_model);		
	}

}
