package adventure;	

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Map {
	private ArrayList<Room> roomList;							
	private ArrayList<Item> itemList;
	private ArrayList<Puzzle> puzzleList;
	
	
	public Map() throws FileNotFoundException {					
		roomList = new ArrayList<Room>();						
		readRoomList("map.txt");							
		itemList = new ArrayList<Item>();			//new
		readItemList("item.txt");				//new
		puzzleList = new ArrayList<Puzzle>();		//new
		readPuzzleList("puzzle.txt");			//new
		
		
	}
	
//	public Map(ArrayList<Room> roomList) {
//		this.roomList = roomList;
//	}
	
//	public Map(ArrayList<Item> itemList) {
//		this.itemList = itemList;
//	}
	
	public Map(ArrayList<Puzzle> puzzleList) {
		this.puzzleList = puzzleList;
	}
	
	
	
	public Room getRoom(String Room) throws InvalidMoveException {		
		if (Room.equals("0")) {									
			throw new InvalidMoveException();
		}
		
		Room room = null;
		for (int i = 0; i < roomList.size(); i++) {				
			if (roomList.get(i).getRoom().equals(Room)) {
				room = roomList.get(i);							
			}
		}
		return room;	
	}
	
	public Item getItem(String Item) {		

		
		Item item = null;
		for (int i = 0; i < itemList.size(); i++) {				
			if (itemList.get(i).getItemName().equals(Item)) {
				item = itemList.get(i);							
			}
		}
		return item;	
	}
	
	
	public Puzzle getPuzzle(String Puzzle) {		

		
		Puzzle puzzle = null;
		for (int i = 0; i < puzzleList.size(); i++) {				
			if (puzzleList.get(i).getPuzzleID().equals(Puzzle)) {
				puzzle = puzzleList.get(i);							
			}
		}
		return puzzle;	
	}
	
	
	
	
	
	
	// read map TXT
	private void readRoomList(String mapTxt) throws FileNotFoundException {
		FileReader fileReader;
		try {
			fileReader = new FileReader(mapTxt);
			Scanner readFile = new Scanner(fileReader);
			while (readFile.hasNextLine()) {										
				String[] data = readFile.nextLine().split("::");
				String[] roomData = data[6].split("_");
				roomList.add(new Room(data[0], data[1], data[2], data[3], data[4], Boolean.parseBoolean(data[5]), roomData[0], roomData[1], roomData[2], roomData[3]) );	
			}
			readFile.close();
			fileReader.close();	
		} 
		catch (IOException e) {
			throw new FileNotFoundException("File 'map.txt' not found.");	
		}
	}
	
	//read item txt
	private void readItemList(String itemTxt) throws FileNotFoundException {
		FileReader fileReader;
		try {
			fileReader = new FileReader(itemTxt);
			Scanner readFile = new Scanner(fileReader);
			while (readFile.hasNextLine()) {											
				String[] data = readFile.nextLine().split("::");
				itemList.add(new Item(data[0], data[1], data[2]));		
			}
			readFile.close();
			fileReader.close();	
		} 
		catch (IOException e) {
			throw new FileNotFoundException("File 'item.txt' not found.");
		}
	}
	
	//read puzzle txt
	private void readPuzzleList(String puzzleTxt) throws FileNotFoundException {
		FileReader fileReader;
		try {
			fileReader = new FileReader(puzzleTxt);
			Scanner readFile = new Scanner(fileReader);
			while (readFile.hasNextLine()) {											
				String[] data = readFile.nextLine().split("::");
				puzzleList.add(new Puzzle(data[0], data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), Boolean.parseBoolean(data[6])));		
			}
			readFile.close();
			fileReader.close();	
		} 
		catch (IOException e) {
			throw new FileNotFoundException("File 'puzzle.txt' not found.");
		}
	}
}