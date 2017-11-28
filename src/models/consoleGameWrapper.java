package models;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Settings;

public class consoleGameWrapper {

	private final static int gameWidth = 300, gameHeight = 200;
	private static Player player;
	private ScoreBoard scoreBoard;
	private static ArrayList<Interactable> inters;
	
	
	private static Settings settings;
	
	
	public static void main(String[] args) {
		System.out.println("Estuary Adventure!");
		setUpGame();
		startGame();
	}
	
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
