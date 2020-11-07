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
				BufferedReader buffer = new BufferedReader(new InputStreamReader(Map.class.getResourceAsStream("ROOMS.txt")));

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
					//Room connections will be placed in an arraylist
					ArrayList<String> holdConn = new ArrayList<>();
					//Rooms will have a different number of connections
					for(int i = 0; i<c.length;i++) {
						holdConn.add(c[i]);
					}
					// Room monsters
					String holdMon = text[4];
					ArrayList<Monster> monsters = roomMonster(holdMon);

					// Room items
					String items = text[5];
					String[] itm = items.split(",");
					//There can be more than item in the room
					for(int i = 0; i<c.length;i++) {
						String holdItem = itm[i];
					}
					//keep working on this
					ArrayList<Item> inventory = createInventory(holdInv);
					
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
}
