package grizzlyPunk;
import java.util.*;

public class Rooms {
	private String roomID;
	private String roomName;
	private String roomDesc;
	//This list will consist of the roomIDs that are connected to a room
	ArrayList<String> roomConnections = new ArrayList<>();
	//This list will consist of the item inventory in the room
	private ArrayList<Item> inventory = new ArrayList<>();
	//This list will consist of the puzzles in a room
	private ArrayList<Puzzles> puzzles = new ArrayList<>();
	//This list will consist of the monsters in a room
	private ArrayList<Monster> monsters = new ArrayList<>();
	
	//Constructor
	public Rooms(String roomID, String roomName, String roomDesc, ArrayList<String> roomConnections,
			ArrayList<Item> inventory, ArrayList<Puzzles> puzzles, ArrayList<Monster> monsters) {
		super();
		this.roomID = roomID;
		this.roomName = roomName;
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

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	//toString
	@Override
	public String toString() {
		return "Rooms [roomID=" + roomID + ", roomName=" + roomName + ", roomDesc=" + roomDesc + ", roomConnections="
				+ roomConnections + ", inventory=" + inventory + ", puzzles=" + puzzles + ", monsters=" + monsters
				+ "]";
	}


}
