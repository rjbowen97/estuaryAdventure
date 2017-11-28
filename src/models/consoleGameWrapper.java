package models;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Settings;

public class consoleGameWrapper {

	private final static int gameWidth = 300, gameHeight = 500;
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
	}

	private static void startGame(){
		while(player.getHealth() != 0){
			Scanner sc = new Scanner(System.in);
			System.out.println("Please Press W to go UP, S to go DOWN, A to go LEFT, and D to go Right");
		    String userChoice = sc.next();
//			while(userChoice != "W" && userChoice != "S" && userChoice != "A" && userChoice != "D")
//				sc.next();
			for(Interactable it: inters){
				if(it.isActive() == false) 
					continue;
				if(it.getXPosition() < 300) //if iter inside gameboard
					it.activate();
				System.out.println(it.toString());
				it.onTick();
			}
			System.out.println("Choice: " + userChoice);
			if((userChoice == "W" || userChoice == "w") & player.getYPosition() < gameHeight - player.getSpeed()){
				player.setyPosition(player.getYPosition()+ player.getSpeed());
			}else if((userChoice == "S" || userChoice == "S") & player.getYPosition() > player.getSpeed()){
				player.setyPosition(player.getYPosition()- player.getSpeed());
			}else if((userChoice == "A" || userChoice == "A")& player.getYPosition() > player.getSpeed()){
				player.setxPosition(player.getXPosition() - 10);;
			}else{
				if(player.getXPosition() < gameWidth - player.getSpeed()){
					player.setxPosition(player.getXPosition()+ player.getSpeed());
				}else{
					player.setxPosition(0);
					player.setyPosition(0);
				}
			}
			player.onTick();
			System.out.println(player.toString());
		}
	}
	
	private static ArrayList<Interactable> generateInteractable() {
		ArrayList<Interactable> interactables = new ArrayList<Interactable>();
		
    	for (int interactableIndex = 0; interactableIndex < 100; interactableIndex++) {
    		interactables.add(new Interactable(interactableIndex * 5));
    	}
    	
    	return interactables;
	}
}
