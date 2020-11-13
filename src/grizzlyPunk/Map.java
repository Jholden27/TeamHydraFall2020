package grizzlyPunk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Map {
	private static HashMap<String, Rooms> map = new HashMap<>(); // String = roomID

	// Read from ROOMS.txt to create the map
	public static void createMap() {
		try {
			BufferedReader buffer = new BufferedReader(
					new InputStreamReader(Map.class.getResourceAsStream("ROOMS.txt")));

			String line;

			while ((line = buffer.readLine()) != null) {
				String[] text = line.split("~");
				// Room id
				String holdID = text[0];
				// Room name
				String holdName = text[1];
				// Room description
				String holdDesc = text[2];
				// Room connections
				String connections = text[3];
				String[] c = connections.split(",");
				// Room connections will be placed in an arraylist
				ArrayList<String> holdConn = new ArrayList<>();
				// Rooms will have a different number of connections
				for (int i = 0; i < c.length; i++) {
					holdConn.add(c[i]);
				}
				// Room monsters
				String holdMon = text[4];
				ArrayList<Monster> monsters = roomMonsters(holdMon);

				// Room items
				String items = text[5];
				String[] itm = items.split(",");
				ArrayList<Item> inventory = createInventory(itm);

				// There can be more than item in the room, so send array to create inventory
				// ArrayList<Item> inventory = createInventory(itm);

				// Room puzzles
				String holdPuzz = text[6];
				ArrayList<Puzzles> puzzles = roomPuzzles(holdPuzz);

				Rooms r = new Rooms(holdID, holdName, holdDesc, holdConn, inventory, puzzles, monsters);
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
	public static ArrayList<Monster> roomMonsters(String monsterID) {
		ArrayList<Monster> monsters = new ArrayList<>();

		try {
			BufferedReader buffer = new BufferedReader(
					new InputStreamReader(Map.class.getResourceAsStream("MONSTER.txt")));

			String line;

			while ((line = buffer.readLine()) != null) {
				String[] text = line.split("~");
				if ((monsterID.equals(text[0]))) {
					// Monster id
					String holdID = text[0];
					// Monster name
					String holdName = text[1];
					// Monster description
					String holdDesc = text[2];
					// Monster hp
					int holdHP = Integer.parseInt(text[3]);
					// Monster attack type
					String holdAttack = text[4];
					// Monster dp
					int holdDP = Integer.parseInt(text[5]);
					// Monster Weakness
					String holdWeak = text[6];
					// Monster inventory
					String[] monInv = line.split(",");
					ArrayList<Item> inventory = createInventory(monInv);

					// Create monster
					Monster monster = new Monster(holdID, holdName, holdDesc, holdHP, holdAttack, holdDP, holdWeak,
							inventory);

					// Add monster to arraylist
					monsters.add(monster);

					// Check if monsters are being read correctly
					 //System.out.println(monsters);

					break;

				}

			}
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return monsters;
	}

	// Read from ITEMS.txt to create an arraylist of items for each room
	public static ArrayList<Item> createInventory(String[] items) {
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
						// Item description
						String holdType = text[3];
						// Item description
						int holdValue = Integer.parseInt(text[4]);

						// Create item
						Item item = new Item(holdID, holdName, holdDesc, holdType, holdValue, false);

						// Add item to inventory
						inventory.add(item);

						// break;
					}

				}

			}
			// System.out.println(inventory);
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inventory;
	}

	// Read from PUZZLES.txt to create an arraylist of puzzles for each room
	public static ArrayList<Puzzles> roomPuzzles(String puzzleID) {
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
					// Puzzle name
					String holdName = text[1];
					// Puzzle Question
					String holdQuestion = text[2];
					// Puzzle Answer
					String holdAnswer = text[3];
					// Puzzle choices = answer + text[3]
					choices.add(holdAnswer);
					String wrong = text[4];
					String[] w = wrong.split(",");
					// add the 2 wrong choices to arraylist
					choices.add(w[0]);
					choices.add(w[1]);

					// Create puzzle
					Puzzles puzzle = new Puzzles(holdID, holdName, holdQuestion, holdAnswer, choices, false);

					// Add item to inventory
					puzzles.add(puzzle);

					// Check if puzzles are being read correctly
					// System.out.println(puzzles);

					break;

				}

			}
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return puzzles;
	}

	// entering a room
	public void enterRoom(String id) {
		// for certain rooms, the player has to solve a puzzle to enter
		// the room has a puzzle they have to solve before entering
		if (!(map.get(id).getPuzzles().isEmpty()) && !(map.get(id).getPuzzles().get(0).isSolved())) {
			// tell player there is a puzzle they need to solve
			System.out.println("There seems to be a riddle or something, that's preventing the door from opening.");
			System.out.println("You may choose to solve or ignore.");
		}
		// a normal room or puzzle is solved
		else {
			// Room name is displayed
			System.out.println(map.get(id).getRoomName());
			System.out.println();
			// Room description is displayed
			System.out.println(map.get(id).getRoomDesc());
			System.out.println();
			// If there is a monster alive in the room
			if (!(map.get(id).getMonsters().isEmpty()) && (map.get(id).getMonsters().get(0).getMonsterHP() != 0)) {
				// Monster description is displayed
				System.out.println(map.get(id).getMonsters().get(0).getMonsterDesc());
			}
		}
	}

	public Rooms getRoom(String id) {
		return map.get(id);
	}

}
