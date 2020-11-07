package adventure;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {	
	private Scanner input = new Scanner(System.in);
	private Player character;
	private Room area;
	private Puzzle puzzle;
	private String none = "0";
	private String grabItem;
	private String dropItem;
	private String lookItem;
	private String currentPuz;
	//TEST
	private Map map;
	
	public static void main(String[] args) {
		System.out.println("Welcome to the game! You are next to your car outside of the school.");			//Game Introduction		
		Game play = new Game();
		try {
			play.gameRunning();
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void gameRunning() throws InvalidInputException {	//Main game run
		try {
			try {
				character = new Player();
			} catch (InvalidMoveException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e) {					//File checker message
			System.out.println(e.getMessage());
		}
		
		while(true) {
			try {
				activateNavigation(); 
			} 
			catch (InvalidMoveException e) {						//Informs player of not moving if the character did not move after the last input
				System.out.println("I haven't moved...");
			}
			catch (InvalidInputException e) {
				System.out.println("I haven't moved...");
			}
			
//			//START PUZZLE
//			if(puzzle.getId().contentEquals(none))
//			{
//				
//				System.out.println(character.getRoomDescription());
//			}
//			else
//			{
//				System.out.println("PUZZLE TIME");
//			}
			if (none.equals(character.getRoomPuzzleID())) {
				System.out.println(character.getRoomName());
			}
			else {
				//character.startPuzzle(character.getRoomPuzzleID());
//				puzzle.getQuestion();
				
				
				System.out.println("PUZZLE");

				
				
				System.out.println(character.getRoomName());
			}
			
			
			
			
//			//END PUZZLE
			//System.out.println(character.getRoomDescription());
		}	
	}
	
	private void activateNavigation() throws InvalidMoveException, InvalidInputException { 			//Character movement loop
		System.out.println("What should I do? (Enter 'H' for command list)");
		String direction = input.next();
		
		if (direction.equalsIgnoreCase("n")) {
			character.moveNorth();	
		} 
		else if (direction.equalsIgnoreCase("e")) {
			character.moveEast();
		} 
		else if (direction.equalsIgnoreCase("s")) {
			character.moveSouth();
		} 
		else if (direction.equalsIgnoreCase("w")) {
			character.moveWest();
		} 
		
		//ITEM SEARCH
		else if (direction.equalsIgnoreCase("x")) {			//Explore
			
			//ROOM DESCRIPTION HOLDER
			System.out.println("Looking around the room: " + character.getRoomDescription());
			
			if (none.equals(character.getRoomItem())) {
				System.out.println("No items here...");
			}
			else {
				System.out.println("You see: " + character.getRoomItem());	//Temp incorrect
			}
		}
		
		//PICKUP ITEM
		else if(direction.equalsIgnoreCase("p")) {
			//character.pickUpItem(direction.split(" ")[1]);
			if (none.equals(character.getRoomItem())) {
				System.out.println("There's nothing here to pick up.");
			}
			else {
				System.out.println("What would you like to pick up?");
				grabItem = input.next();
				
				if (grabItem.equals(character.getRoomItem())){
					System.out.println("You pick up: " + character.getRoomItem());	//Temp incorrect
					character.pickUpItem(grabItem);
				}
				else
				{
					System.out.println("There are none of those around.");
				}
			}
		}
		
		//check inventory
		else if (direction.equalsIgnoreCase("i")) {
			character.getInventory();
		}
		
		//drop item
		else if (direction.equalsIgnoreCase("d")) {
			System.out.println("What item would you like to drop?");
			dropItem = input.next();
			character.dropItem(dropItem);
		}
		
		//inspect item
		else if (direction.equalsIgnoreCase("l")) {		
//			System.out.println("What item would you like to look at?");
//			lookItem = input.next();
			character.lookAtItem(lookItem);
		}
		
		//Help - System commands
		
		else if (direction.equalsIgnoreCase("h")) {
			System.out.println("'N','E','S','W' for compass movement. 'I' to check inventory.");
			System.out.println("'X' to explore a room and look for items.");
			System.out.println("'P' to pickup items. 'D' to drop items.");
			System.out.println("'L' to look at items in your inventory.");
		} 
		
		
		
		//TESTER
		else if(direction.equalsIgnoreCase("qq"))
		{
			System.out.print(" == ");
			System.out.print(" ");
			System.out.print(" ");
//			System.out.print("Room desc: " + character.getRoomDescription());
			System.out.print(" == ");
			
			
		}
		
		
		
		
		
		
		
		
		else {
			throw new InvalidInputException();													//Invalid input message
		}
		
		if(character.visited() == true) {													//Character visited checker
			System.out.println("I've been here already.");
		}	
		else {
			System.out.println("This area is new to me.");
		}		
	}
}