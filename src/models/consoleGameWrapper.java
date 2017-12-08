package models;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Settings;

// TODO: Auto-generated Javadoc
/**
 * The Class consoleGameWrapper.
 */
public class consoleGameWrapper {

	/** The Constant gameHeight. */
	private final static int gameWidth = 300, gameHeight = 200;
	
	/** The player. */
	private static Player player;
	
	/** The score board. */
	private ScoreBoard scoreBoard;
	
	/** The inters. */
	private static ArrayList<Interactable> inters;
	
	
	/** The settings. */
	private static Settings settings;
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		System.out.println("Estuary Adventure!");
		setUpGame();
		startGame();
	}
	
	/**
	 * Sets the up game.
	 */
	private static void setUpGame(){
		settings = new Settings();
		player = new LandAnimal();
		inters = new ArrayList<Interactable>(generateInteractable());
		System.out.println("What is your name: ");
		Scanner scan = new Scanner(System.in);
		String name = scan.next();
		player.setPlayerName(name);
		player.setSpeed(10);
		System.out.println("Board Max Height: "+ gameHeight +"\nBoard Max Width: " + gameWidth);
		
		System.out.println(player.toString());
	}

	/**
	 * Start game.
	 */
	private static void startGame(){
		Scanner sc = new Scanner(System.in);
		String userChoice;
		int numberActive = 0;
		while(player.getHealth() > 0){
			userChoice = "";
			System.out.println("Please Press W to go UP, S to go DOWN, A to go LEFT, and D to go Right");
		    userChoice = sc.next();
		    
			for(Interactable it: inters){
				if(it.isActive() && it.getXPosition() > 0 && it.getXPosition() < gameWidth){
					if(it.isFood()){
						System.out.println("Food Target at X: "+ it.getXPosition() + " Y: " + it.getYPosition());
					}else{
						System.out.println("Enemy Target at X: "+ it.getXPosition() + " Y: " + it.getYPosition());
					}
					it.onTick();
					if(it.getHitbox().isOverlapping(player.getHitbox())){
						player.onCollisionWithInteractableModel(it);
						it.onCollisionWithPlayerModel(player);
					}
				}else if(it.getXPosition() <= 0){
					it.setxPosition(gameWidth);
				}else{
					it.activate();
				}
				it.onTick();
			}
			
			
			System.out.println("Choice: " + userChoice);
			if((userChoice.equals("W") || userChoice.equals("w")) && player.getYPosition() < gameHeight - player.getSpeed()){
				player.setyPosition(player.getYPosition() +  player.getSpeed());
			}else if((userChoice.equals("S") || userChoice.equals("s")) && player.getYPosition() > 0){
				player.setyPosition(player.getYPosition() -  player.getSpeed());
			}else if((userChoice.equals("D") || userChoice.equals("d")) && player.getXPosition() < gameWidth - player.getSpeed()){
				player.setxPosition(player.getXPosition() + player.getSpeed());
			}else if((userChoice.equals("A") || userChoice.equals("a")) && player.getXPosition() > 0){
				if(player.getXPosition() < gameWidth - player.getSpeed()){
					player.setxPosition(player.getXPosition() - player.getSpeed());
				}
			}else{
				System.out.println("Error: Choice Incorrect");
			}
			player.onTick();
			System.out.println(player.toString());
		}
	}
	
	/**
	 * Generate interactable.
	 *
	 * @return the array list
	 */
	private static ArrayList<Interactable> generateInteractable() {
		ArrayList<Interactable> interactables = new ArrayList<Interactable>();
		
    	for (int interactableIndex = 0; interactableIndex < 10; interactableIndex++) {
    		interactables.add(new Interactable(interactableIndex * 5));
    		interactables.get(interactableIndex).setxPosition(300);
    		interactables.get(interactableIndex).setyPosition(interactables.get(interactableIndex).getYPosition() % 200);
    	}
    	
    	return interactables;
	}
}
