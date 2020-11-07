package grizzlyPunk;
import java.util.*;

public class Rooms {
	private String roomID;
	private String roomDesc;
	//This list will consist of the roomIDs that are connected to a room
	private ArrayList<String> roomConnections = new ArrayList<>();
	//This list will consist of the item inventory in the room
	private ArrayList<Item> inventory = new ArrayList<>();
	//This list will consist of the puzzles in a room
	private ArrayList<Puzzles> puzzles = new ArrayList<>();
	//This list will consist of the monsters in a room
	private ArrayList<Monster> monsters = new ArrayList<>();
	
	//Constructor
	public Rooms(String roomID, String roomDesc, ArrayList<String> roomConnections, ArrayList<Item> inventory,
			ArrayList<Puzzles> puzzles, ArrayList<Monster> monsters) {
		this.roomID = roomID;
		this.roomDesc = roomDesc;
		this.roomConnections = roomConnections;
		this.inventory = inventory;
		this.puzzles = puzzles;
		this.monsters = monsters;
	}
	
	//Getters and Setters
	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}

	public String getRoomDesc() {
		return roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

	public ArrayList<String> getRoomConnections() {
		return roomConnections;
	}

	public void setRoomConnections(ArrayList<String> roomConnections) {
		this.roomConnections = roomConnections;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}

	public ArrayList<Puzzles> getPuzzles() {
		return puzzles;
	}

	public void setPuzzles(ArrayList<Puzzles> puzzles) {
		this.puzzles = puzzles;
	}

	public ArrayList<Monster> getMonsters() {
		return monsters;
	}

	public void setMonsters(ArrayList<Monster> monsters) {
		this.monsters = monsters;
	}

	//toString
	@Override
	public String toString() {
		return "Rooms [roomID=" + roomID + ", roomDesc=" + roomDesc + ", roomConnections=" + roomConnections
				+ ", inventory=" + inventory + ", puzzles=" + puzzles + ", monsters=" + monsters + "]";
	}

}
