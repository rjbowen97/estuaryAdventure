# estuaryAdventure


intial planning:

	MVC:
		Model: Behavior - State
			Super: Page
				Collection of Buttons displayed on page
				
			Super: Player (Animal)
				Attributes:
					-health
					-score
					-position
					-speed
				-Crab
				-Bird
				-Fish
			
			Board (Arena):
				-dimensions
				-number_of_enemies


			Super: Interactables
				-Enemies
					- Pollution
					- Animal-Enemy
					
				-Food
					- X amount of food collected = Powerup
					- 25 food collected -> Tatical Nuke
			Main:
				
		
		Controller:
			Tic - x time has passed, update now
		
		View:
			user_sprite
				
				