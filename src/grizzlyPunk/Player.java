package grizzlyPunk;

import java.util.ArrayList;

public class Player {
	private Rooms currentRoom;
	private int maxHP;
	private int currentHP;
	private int sp; // shield points
	private int ap; // attack points / damage done
	private int memoryFragments;
	private ArrayList<Item> inventory = new ArrayList<Item>();
	private Map map;

	public Player(Rooms currentRoom, int maxHP, int currentHP, int sp, int ap, int memoryFragments,
			ArrayList<Item> inventory, Map map) {
		super();
		this.currentRoom = currentRoom;
		this.maxHP = maxHP;
		this.currentHP = currentHP;
		this.sp = sp;
		this.ap = ap;
		this.memoryFragments = memoryFragments;
		this.inventory = inventory;
		this.map = map;
	}

	public Rooms getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(String id) {
		currentRoom = map.getRoom(id);

	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	public int getSp() {
		return sp;
	}

	public void setSp(int sp) {
		this.sp = sp;
	}

	public int getAp() {
		return ap;
	}

	public void setAp(int ap) {
		this.ap = ap;
	}

	public int getMemoryFragments() {
		return memoryFragments;
	}

	public void setMemoryFragments(int memoryFragments) {
		this.memoryFragments = memoryFragments;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "Player [currentRoom=" + currentRoom + ", maxHP=" + maxHP + ", currentHP=" + currentHP + ", sp=" + sp
				+ ", ap=" + ap + ", memoryFragments=" + memoryFragments + ", inventory=" + inventory + ", map=" + map
				+ "]";
	}

	// Moving rooms
	public void move(String moveID) {

		// Change current room location to where player moved
		setCurrentRoom(moveID);

		// move using map class method
		map.enterRoom(moveID);
	}

	// Explore room current room
	public void explore() {
		ArrayList<String> itemNames = new ArrayList<>();
		for (int i = 0; i < currentRoom.getInventory().size(); i++) {
			itemNames.add(currentRoom.getInventory().get(i).getItemName());
		}
		// if there are no items in the room
		if (itemNames.isEmpty()) {
			System.out.println(
					"You search the room for anything that could help you in your journey, but there is nothing.");
		}
		// there are items in the room
		else {
			System.out.println(itemNames);
			System.out.println("You can choose to pick up these items or not pick them up.");
		}

	}

	// Pick up item
	public void pickupItem(String itemName) {
		// get room inventory
		ArrayList<Item> holdRoomInv = currentRoom.getInventory();
		for (int i = 0; i < holdRoomInv.size(); i++) {
			// compare room inventory with itemName player inputted
			if (holdRoomInv.get(i).getItemName().equalsIgnoreCase(itemName)) {
				// if the item is a memory fragment
				if (holdRoomInv.get(i).getItemType().equals("Collect")) {
					// memory fragments is increased
					memoryFragments++;
					// read memory frag description
				} 
				//adding item to inventory
				else {
					// Item description is outputted
					System.out.println(holdRoomInv.get(i).getItemDescription());

					// add to player inventory
					inventory.add(holdRoomInv.get(i));

					// Remove from room inventory
					currentRoom.getInventory().remove(i);

					// tell user that item was added to inventory
					System.out.println(itemName + " was successfully added to your inventory.");
				}
			}
		}
		if (inventory.isEmpty()) {
			System.out.println("That item is not in this room.");
		}
	}
	
	// drop an item
		public void dropItem(String itemName) {
			for (int i = 0; i < inventory.size(); i++) {
				// compare inventory with itemName player inputted
				if (inventory.get(i).getItemName().equalsIgnoreCase(itemName)) {
					// add to room inventory
					currentRoom.getInventory().add(inventory.get(i));

					// Remove from player inventory
					inventory.remove(i);

					// tell user that item was added to inventory
					System.out.println(itemName + " was successfully dropped from your inventory.");
				}
				// We are at the end of the list and there are still no matches
				else if (inventory.get(i).getItemName()
						.equalsIgnoreCase((inventory.get(inventory.size() - 1).getItemName()))
						&& !(inventory.get(i).getItemName().equalsIgnoreCase(itemName))) {
					System.out.println("There is no item with that name in your inventory");
				}
			}
		}
		
	//Equipping item
	public void equipItem(String itemName) {
		
	}
	
	//Using/consuming item
	public void useItem(String itemName) {
		
	}

	// Attacking monster
	// Check stats
	// Open inventory
	// Close inventory
	// Read frag memory description
}
