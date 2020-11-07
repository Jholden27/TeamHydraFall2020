package adventure;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Player {						//Controls where the player is currently
	private Scanner input = new Scanner(System.in);
	private String lookItem;

	private Room gameRoom;
	private Map gameMap;
	private Puzzle gamePuzzle;
	private ArrayList<String> items = new ArrayList<String>();
	private Item gameItem;
	
	public Player() throws InvalidMoveException, FileNotFoundException {
		gameMap = new Map();
		gameRoom = new Room();
		gameItem = new Item();
		gamePuzzle = new Puzzle();
		gameRoom = gameMap.getRoom("1");				//Starts at room 1
//		gamePuzzle = gameMap.getPuzzle("pizzapuzzle");
	}
	
	public String getRoomName() {
		return gameRoom.getName();
	}
	
	public String getRoomDescription() {
		return gameRoom.getDescription();
	}
	
	public String getRoomItem() {
		return gameRoom.getItem();
	}
	
	public String getItemName() {
		return gameItem.getItemName();
	}
	
	public String getItemDescription() {
		return gameItem.getDescription();
	}
	
	public String getRoomPuzzleID() {
		return gameRoom.getPuzzleID();
	}
	
	public String getPuzzleID() {
		return gamePuzzle.getPuzzleID();
	}
	
	public String getPuzzleQuestion() {
		return gamePuzzle.getQuestion();
	}
	
	
	
	//room item array
	
	
	public Room moveTo(String Room) throws InvalidMoveException {
		gameRoom.setVisited(true);						//Changes visited to true if the player enters the room
		return gameMap.getRoom(Room);
	}
	
	public void moveNorth() throws InvalidMoveException {
		gameRoom = moveTo(gameRoom.getNorthRoom());
	}
	
	public void moveEast() throws InvalidMoveException {
		gameRoom = moveTo(gameRoom.getEastRoom());
	}
	
	public void moveSouth() throws InvalidMoveException {
		gameRoom = moveTo(gameRoom.getSouthRoom());
	}
	
	public void moveWest() throws InvalidMoveException {
		gameRoom = moveTo(gameRoom.getWestRoom());
	}
	
	public boolean visited() {				//Returns if room is visited or not
		return gameRoom.visited();
	}
	
	//PICKUP ITEM
	public void pickUpItem(String item) {
		items.add(item);
	}
	
	//GET INVENTORY
	public void getInventory() {
		if (items.size() == 0) {
			System.out.println("You don't have anything.");
		}
		else {
			for (int i = 0; i < items.size(); i++) {
				System.out.println("You have: " + items.get(i) + " ");
			}
		}
	}
	
	//DROP ITEM
	public void dropItem(String item) {
		if (items.contains(item)) {	
			items.remove(item);
			System.out.println("You dropped: " + item);
		}
		else {
			System.out.println("You don't have one of those.");

		}
	}
	
	//INSPECT ITEM
	public void lookAtItem(String item) {									//WORKING
		if (items.size() == 0) {
			System.out.println("You don't have anything to look at.");
		}
		else {			
			System.out.println("What item would you like to look at? " + items);
			lookItem = input.next();
			gameItem = gameMap.getItem(lookItem);
			
			try {
				System.out.println(gameItem.getDescription());
			}
			catch (Exception e) {
				System.out.println("You don't have one of those.");
			}
		}
	}
	
	public void startPuzzle(String currentPuzzle) {
		gamePuzzle = gameMap.getPuzzle(currentPuzzle);
		System.out.println("Puzzle time!");		//holder
		System.out.println(gamePuzzle.getPuzzleID());
	}
	

}