package adventure;

/*
 Food : An interactable with positive effect on player
 Pollution: an interactable with negative effect on player
 Enemy: an interactable with negative effect on player 
 */

public class Interactable {
	private int x_position;
	private int y_position;
	private int effect_on_player; //can be positive or negative depending on categor
	enum category{FOOD, POLLUTION, ENEMY};
}
