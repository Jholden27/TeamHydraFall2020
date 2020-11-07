package grizzlyPunk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Map {
	private HashMap<String, Rooms> map = new HashMap<>(); // String = roomID

	// Read from ROOMS.txt to create the map
	public void createMap() {
		try {
			BufferedReader buffer = new BufferedReader(
					new InputStreamReader(Map.class.getResourceAsStream("ROOMS.txt")));

			String line;

			while ((line = buffer.readLine()) != null) {
				String[] text = line.split("~");
				// Room id
				String holdID = text[0];
				// Room description
				String holdDesc = text[1];
				// Room connections
				String connections = text[2];
				String[] c = connections.split(",");
				// Room connections will be placed in an arraylist
				ArrayList<String> holdConn = new ArrayList<>();
				// Rooms will have a different number of connections
				for (int i = 0; i < c.length; i++) {
					holdConn.add(c[i]);
				}
				// Room monsters
				String holdMon = text[4];
				ArrayList<Monster> monsters = roomMonster(holdMon);

				// Room items
				String items = text[5];
				String[] itm = items.split(",");
				// There can be more than item in the room, so send array to create inventory
				ArrayList<Item> inventory = createInventory(itm);

				// Room puzzles
				String holdPuzz = text[6];
				ArrayList<Puzzles> puzzles = roomPuzzles(holdPuzz);

				Rooms r = new Rooms(holdID, holdDesc, holdConn, inventory, puzzles, monsters);
				// put into map
				map.put(holdID, r);

				// Test whether it is reading every line
				// System.out.println(line);
				// System.out.println(r);

			}
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Read from MONSTERS.txt to create an arraylist of monsters for each room
		public ArrayList<Monster> roomMonsters(String monsterID) {
			ArrayList<Monster> monsters = new ArrayList<>();

			try {
				BufferedReader buffer = new BufferedReader(
						new InputStreamReader(Map.class.getResourceAsStream("MONSTERS.txt")));

				String line;

				while ((line = buffer.readLine()) != null) {
					String[] text = line.split("~");
					if ((monsterID.equals(text[0]))) {
						// monster id
						String holdID = text[0];
						// Puzzle Question
						String holdQuestion = text[1];
						// Puzzle Answer
						String holdAnswer = text[2];
						// Puzzle choices = answer + text[3]
						choices.add(holdAnswer);
						String wrong = text[3];
						String[] w = wrong.split(",");
						// add the 2 wrong choices to arraylist
						choices.add(w[0]);
						choices.add(w[1]);

						// Create puzzle
						Puzzles puzzle = new Puzzles(holdID, holdQuestion, holdAnswer, choices);

						// Add item to inventory
						puzzles.add(puzzle);

						break;

						// Check if puzzles are being read correctly
						// System.out.println(puzzles);
					}

				}
				buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return puzzles;
		}

	// Read from ITEMS.txt to create an arraylist of items for each room
	public ArrayList<Item> createInventory(String[] items) {
		ArrayList<Item> inventory = new ArrayList<>();

		try {
			BufferedReader buffer = new BufferedReader(
					new InputStreamReader(Map.class.getResourceAsStream("ITEMS.txt")));

			String line;

			while ((line = buffer.readLine()) != null) {
				String[] text = line.split("~");
				for (int i = 0; i < items.length; i++) {
					if ((items[i].equals(text[0]))) {
						// Item id
						String holdID = text[0];
						// Item name
						String holdName = text[1];
						// Item description
						String holdDesc = text[2];
						// Item type
						String holdType = text[3];
						// Item numeric value
						String holdValue = text[4];
						// Create item
						Item item = new Item(holdID, holdName, holdDesc, holdType, holdValue);

						// Add item to inventory
						inventory.add(item);
					}
					// break;
					// check to see if the inventory is being read properly
					// System.out.println(inventory);
				}

			}
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inventory;
	}

	// Read from PUZZLES.txt to create an arraylist of puzzles for each room
	public ArrayList<Puzzles> roomPuzzles(String puzzleID) {
		ArrayList<Puzzles> puzzles = new ArrayList<>();
		ArrayList<String> choices = new ArrayList<>();

		try {
			BufferedReader buffer = new BufferedReader(
					new InputStreamReader(Map.class.getResourceAsStream("PUZZLES.txt")));

			String line;

			while ((line = buffer.readLine()) != null) {
				String[] text = line.split("~");
				if ((puzzleID.equals(text[0]))) {
					// Puzzle id
					String holdID = text[0];
					// Puzzle Question
					String holdQuestion = text[1];
					// Puzzle Answer
					String holdAnswer = text[2];
					// Puzzle choices = answer + text[3]
					choices.add(holdAnswer);
					String wrong = text[3];
					String[] w = wrong.split(",");
					// add the 2 wrong choices to arraylist
					choices.add(w[0]);
					choices.add(w[1]);

					// Create puzzle
					Puzzles puzzle = new Puzzles(holdID, holdQuestion, holdAnswer, choices);

					// Add item to inventory
					puzzles.add(puzzle);

					break;

					// Check if puzzles are being read correctly
					// System.out.println(puzzles);
				}

			}
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return puzzles;
	}
}
