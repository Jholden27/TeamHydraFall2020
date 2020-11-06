package adventure;

import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Room {
	private String room;
	private String description;
	private String item;
	private boolean visited;
	private String northRoom;
	private String eastRoom;
	private String southRoom;
	private String westRoom;
	private String puzzleID;	//NEW
	private ArrayList<String> items = new ArrayList<String>();	//NEW

	public Room(String room, String description, String item, String puzzleID, boolean visited, String northRoom, String eastRoom, String southRoom, String westRoom) {		//pulls data from Map class
		this.room = room;
		this.description = description;
		this.setItem(item);
		this.puzzleID = puzzleID;
		this.visited = visited;
		this.northRoom = northRoom;
		this.eastRoom = eastRoom;
		this.southRoom = southRoom;
		this.westRoom = westRoom;
	}
	
	public Room() {
		super();
	}


	public boolean visited() {
		return visited;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getRoom() {
		return room;
	}
	
	public String getNorthRoom() {
		return northRoom;
	}
	
	public String getEastRoom() {
		return eastRoom;
	}
	
	public String getSouthRoom() {
		return southRoom;
	}
	
	public String getWestRoom() {
		return westRoom;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public ArrayList<String> getItems() {
		return items;
	}

	public void setItems(ArrayList<String> items) {
		this.items = items;
	}
	
	public void pickUpItem(String thisitem) {
		items.remove(thisitem);
	}
	
	public String getPuzzleID() {
		return puzzleID;
	}

	public void setPuzzleID(String puzzleID) {
		this.puzzleID = puzzleID;
	}
}