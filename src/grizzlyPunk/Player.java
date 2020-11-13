package grizzlyPunk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	static Rooms currentRoom;
	static int maxHP;
	static int currentHP;
	static int sp; // shield points
	static int ap; // attack points / damage done
	static int memoryFragments;
	static ArrayList<Item> inventory = new ArrayList<Item>();
	static ArrayList<String> itemNames = new ArrayList<>();
	private static Map map;
	private static Rooms previousRoom;
	private static HashMap<String, MemoryPieces> memories = new HashMap<>();
	static boolean armor1 = false;
	static boolean armor2 = false;
	static String equippedWeapon = "un-armed";

	public Player(Rooms currentRoom, int maxHP, int currentHP, int sp, int ap, int memoryFragments,
			ArrayList<Item> inventory, Map map, Rooms previousRoom) {
		super();
		this.currentRoom = currentRoom;
		this.maxHP = maxHP;
		this.currentHP = currentHP;
		this.sp = sp;
		this.ap = ap;
		this.memoryFragments = memoryFragments;
		this.inventory = inventory;
		this.map = map;
		this.previousRoom = previousRoom;
	}

	public static Rooms getCurrentRoom() {
		return currentRoom;
	}

	public static void setCurrentRoom(String id) {
		currentRoom = map.getRoom(id);

	}

	public static int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public static int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	public static int getSp() {
		return sp;
	}

	public void setSp(int sp) {
		this.sp = sp;
	}

	public static int getAp() {
		return ap;
	}

	public static void setAp(int ap) {
		ap = ap;
	}

	public int getMemoryFragments() {
		return memoryFragments;
	}

	public void setMemoryFragments(int memoryFragments) {
		this.memoryFragments = memoryFragments;
	}

	public static ArrayList<Item> getInventory() {
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

	public Rooms getPreviousRoom() {
		return previousRoom;
	}

	public static void setPreviousRoom(String id) {
		previousRoom = map.getRoom(id);
	}

	@Override
	public String toString() {
		return "Player [currentRoom=" + currentRoom + ", maxHP=" + maxHP + ", currentHP=" + currentHP + ", sp=" + sp
				+ ", ap=" + ap + ", memoryFragments=" + memoryFragments + ", inventory=" + inventory + ", map=" + map
				+ ", previousRoom=" + previousRoom + "]";
	}

	// Moving rooms
	public static void move(String moveID) {
		// set previous room to current room
		 setPreviousRoom(currentRoom.getRoomID());

		// move using map class method
		map.enterRoom(moveID);

		// change current room
		setCurrentRoom(moveID);

		// if room has a puzzle, they need to choose to solve or ignore
		// if (map.getRoom(moveID).getPuzzles().isEmpty() ||
		// map.getRoom(moveID).getPuzzles().get(0).isSolved()) {

		// }
	}

	// Explore current room
	public static void explore() {
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
			for (int i = 0; i < itemNames.size(); i++) {
				System.out.println(itemNames.get(i));
			}
			System.out.println("You can choose to pick up these items or not pick them up.");
		}

	}

	// Pick up item
	public static void pickupItem(String itemName) {
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
					gainMemory(currentRoom.getRoomID());
					// remove memory frag from room
					currentRoom.getInventory().remove(i);
				}
				// adding item to inventory
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

	// Drop an item
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

	// Equipping weapon
	public static void equipWeapon(String itemName) {
		// loop through inventory to find item
		Item weapon;
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getItemName().equals(itemName)) {
				weapon = inventory.get(i);
				// for weapons
				if (weapon.getItemID().equalsIgnoreCase("Itm5")) {
					// unequip if necessary
					unequipWeapon();
					// equip item
					weapon.setEquipped(true);
					// add to ap
					ap = (weapon.getItemNumericValue());
					System.out.println(weapon.getItemName() + " is now equipped.");
					equippedWeapon = weapon.getItemName();
				}
				if (weapon.getItemID().equalsIgnoreCase("Itm6")) {
					// unequip if necessary
					unequipWeapon();
					// equip item
					weapon.setEquipped(true);
					// add to ap
					ap = (weapon.getItemNumericValue());
					System.out.println(weapon.getItemName() + " is now equipped.");
					equippedWeapon = weapon.getItemName();
				}
				if (weapon.getItemID().equalsIgnoreCase("Itm7")) {
					// unequip if necessary
					unequipWeapon();
					// equip item
					weapon.setEquipped(true);
					// add to ap
					ap = (weapon.getItemNumericValue());
					System.out.println(weapon.getItemName() + " is now equipped.");
					equippedWeapon = weapon.getItemName();
				} else {
					System.out.println("This item can't be equipped.");
				}
			}
		}
	}

	// Equipping item
	public static void equipItem(String itemName) {
		// loop through inventory to find item
		Item equipping;
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getItemName().equals(itemName)) {
				equipping = inventory.get(i);
				// for armor
				if (equipping.getItemID().equalsIgnoreCase("Itm3") && armor1 == false) {
					// set equipped
					equipping.setEquipped(true);
					armor1 = true;
					// change sp
					sp = (getSp() + equipping.getItemNumericValue());
					System.out.println(equipping.getItemName() + " is now equipped.");
				}
				if (equipping.getItemID().equalsIgnoreCase("Itm4") && armor2 == false) {
					// set equipped
					equipping.setEquipped(true);
					armor2 = true;
					// change sp
					sp = (getSp() + equipping.getItemNumericValue());
					System.out.println(equipping.getItemName() + " is now equipped.");
				}

				// for flashlight
				if (equipping.getItemID().equalsIgnoreCase("Itm8")) {
					// set equipped
					equipping.setEquipped(true);
					System.out.println(equipping.getItemName() + " is now equipped.");
				}
				// for grappling hook
				if (equipping.getItemID().equalsIgnoreCase("Itm9")) {
					// set equipped
					equipping.setEquipped(true);
					System.out.println(equipping.getItemName() + " is now equipped.");
				} else {
					System.out.println("This item can't be equipped.");
				}
			}
		}
	}

	// Using/consuming item
	public void useItem(String itemName) {
		// find the item in the inventory
		for (int i = 0; i < inventory.size(); i++) {
			// compare inventory with itemName player inputted
			if (inventory.get(i).getItemName().equalsIgnoreCase(itemName)) {
				// find out if it is itm1: health potion
				if (inventory.get(i).getItemID().equals("itm1")) {
					// check to see if hp is maxed (100hp)
					if (getCurrentHP() == getMaxHP()) {
						System.out.println("Your health is already maxed");
					}
					// if not maxed
					else {
						// if current health is 50 or above, then health becomes maxed
						if (getCurrentHP() >= 50) {
							setCurrentHP(getMaxHP());
							// item removed from inventory
							inventory.remove(i);
						}
						// if current health is <50, then item numeric value is added to current health
						else {
							setCurrentHP(getCurrentHP() + inventory.get(i).getItemNumericValue());
							// item removed from inventory
							inventory.remove(i);
						}

					}

				}
				// find out if it is itm2: shield potion
				else if (inventory.get(i).getItemID().equals("itm2")) {
					// check to see if sp is maxed (50 sp)
					if (getSp() == 50) {
						System.out.println("Your shield is already maxed.");
					}
					// if not maxed
					else {
						// if current sp is 25 or above, then sp becomes maxed (50sp)
						if (getSp() >= 25) {
							setSp(50);
							// item removed from inventory
							inventory.remove(i);
						}
						// if current sp is <25, then 25 is added to current sp
						else {
							setSp(getSp() + inventory.get(i).getItemNumericValue());
							// item removed from inventory
							inventory.remove(i);
						}

					}

				}

			}
			// item name wasn't found in inventory
			// else if (inventory.get(i).getItemName()
			// .equalsIgnoreCase((inventory.get(inventory.size() - 1).getItemName()))
			// && !(inventory.get(i).getItemName().equalsIgnoreCase(itemName))) {
			// System.out.println("There is no item with that name in your inventory.");
			// }

		}

	}

	// Check to see if a weapon is equipped already
	public static void unequipWeapon() {
		for (int i = 0; i < inventory.size(); i++) {
			// only 1 weapon can be equipped at a time
			if (inventory.get(i).getItemID().equals("itm5")) {
				// if equipped
				if (inventory.get(i).isEquipped()) {
					// unequip it
					inventory.get(i).setEquipped(false);
				}

			} else if (inventory.get(i).getItemID().equals("itm6")) {
				// if equipped
				if (inventory.get(i).isEquipped()) {
					// unequip it
					inventory.get(i).setEquipped(false);
				}

			} else if (inventory.get(i).getItemID().equals("itm7")) {
				// if equipped
				if (inventory.get(i).isEquipped()) {
					// unequip it
					inventory.get(i).setEquipped(false);
				}

			}

		}

	}

	// Check player stats
	public void checkStats() {
		System.out.println("Here are your stats:");
		System.out.println("Health: " + getCurrentHP());
		System.out.println("Shield: " + getSp());
		System.out.println("Attack points: " + getAp());
		System.out.println("Memory Fragments Collected: " + getMemoryFragments());

	}

	// Attacking monster

	public static void combatMonster(String bodypart) {
		// monster in room
		Monster monster = currentRoom.getMonsters().get(0);
		// monster hp
		int monsterHP = monster.getMonsterHP();
		// If player attacked weakness
		if (bodypart.equalsIgnoreCase(monster.getWeakness())) {
			// monster takes x3 damage
			int healthLeft = monsterHP - (getAp() * 3);
			System.out.println();
			System.out.println("You attack the " + monster.getMonsterName() + " dealing " + (getAp() * 3) + " damage!");
			if (healthLeft > 0) {
				System.out.println(monster.getMonsterName() + " has " + healthLeft + " health remaining.");
			}
			monster.setMonsterHP(healthLeft);
			// if monster has died
			if (healthLeft <= 0) {
				System.out.println("The monster has been defeated, you can now continue with your journey.");
				// if monster has inventory
				if (!(monster.getInventory().isEmpty())) {
					// monster drop added to inventory
					// inventory.add(monster.getInventory().get(0));
					System.out.println(monster.getInventory() + " added to your inventory.");
					// removed from monster inventory
					monster.getInventory().clear();
				}
				// monster is taken out of the room
				currentRoom.getMonsters().clear();
			} else
				// monster attacks after
				takeDamage();
		}
		// player didn't attack weakness
		else {
			int healthLeft = (monsterHP - (getAp()));
			monster.setMonsterHP(healthLeft);
			System.out.println();
			System.out.println("You attack the " + monster.getMonsterName() + " dealing " + (getAp()) + " damage!");
			System.out.println(monster.getMonsterName() + " has " + healthLeft + " health remaining.");
			// if monster has died
			if (healthLeft <= 0) {
				System.out.println("The monster has been defeated, you can now continue with your journey.");
				// if monster has inventory
				if (!(monster.getInventory().isEmpty())) {
					// monster drop added to inventory
					// inventory.add(monster.getInventory().get(0));
					System.out.println(monster.getInventory() + " added to your inventory.");
					// removed from monster inventory
					monster.getInventory().clear();
				}
				// monster is taken out of the room
				currentRoom.getMonsters().clear();
			} else
				// monster attacks after
				takeDamage();
			// System.out.println(monsterHP);
		}
	}

	// player taking monster damage
	public static void takeDamage() {
		// monster in room
		Monster monster = currentRoom.getMonsters().get(0);
		// monster attack
		int monsterDP = monster.getMonsterDP();
		int monsterMaxHP = monster.getMonsterHP();
		// if the sp isn't zero
		if (getSp() > 0) {
			if (monsterDP < getSp()) {
				sp = (getSp() - monsterDP);
				System.out.println("The " + monster.getMonsterName() + " attacks you, dealing " + monsterDP
						+ " damage to your shield!");
			} else {
				// hp = dp - sp
				currentHP = (getCurrentHP() - (monsterDP - getSp()));
				if (getSp() > 0) {
					System.out.println("The " + monster.getMonsterName() + " attacks you, dealing " + getSp()
							+ " damage to your shield!");
				}
				System.out.println("The " + monster.getMonsterName() + " attacks you, dealing " + (monsterDP - getSp())
						+ " damage to your health!");
				// set SP to 0
				sp = (0);
			}
		}
		// damage is take from hp until zero
		else {
			if (getCurrentHP() > 0) {
				currentHP = (getCurrentHP() - monsterDP);
				System.out.println("The " + monster.getMonsterName() + " attacks you, dealing " + monsterDP
						+ " damage to your health!");
			}
			// player dies
			if (getCurrentHP() <= 0) {
				System.out.println("");
				System.out.println(
						"You have passed out. Zap! A portal opens below you as you see the ground quickly approaching. You land with a thud in a pile of rocks and rusted metal...Again.");
				// monster health reset
				monster.setMonsterHP(monsterMaxHP);
				// player health set to 50
				currentHP = (50);
				// player sent back to previous room
				move(previousRoom.getRoomID());
			}

		}
	}

	// puzzle solving
	public void answerPuzzle(String answer) {
		// as long as there is a puzzle in the room and it hasn't been solved
		if (!(currentRoom.getPuzzles().isEmpty()) && !(currentRoom.getPuzzles().get(0).isSolved())) {
			// if the player answers correctly
			if (currentRoom.getPuzzles().get(0).getAnswer().equalsIgnoreCase(answer)) {
				System.out.println("That is correct!!");
				// set that the puzzle has been solved
				currentRoom.getPuzzles().get(0).setSolved(true);
				// room is removed from room
				currentRoom.getPuzzles().clear();
				// player is allowed to move to that room
				move(currentRoom.getRoomID());
			}
			// if the player answers wrong
			else {
				System.out.println("That is incorrect!!");
				// player looses health
				if (getCurrentHP() > 10) {
					// subtract 10 from health
					setCurrentHP(getCurrentHP() - 10);
				}
				// player dies
				else {
					System.out.println("You passed out.");
					// health set to 50
					setCurrentHP(50);
					// player sent back to previous room
					move(previousRoom.getRoomID());
				}
			}
		}

	}

	// create memory hashmap
	public void collectingMemory() {
		try {
			BufferedReader buffer = new BufferedReader(
					new InputStreamReader(Map.class.getResourceAsStream("MEMORYPIECES.txt")));

			String line;

			while ((line = buffer.readLine()) != null) {
				String[] text = line.split("~");
				// MemoryID
				String holdID = text[0];
				// Memory Description
				String holdName = text[1];
				// Memory Room
				String memRoom = text[2];

				MemoryPieces memo = new MemoryPieces(holdID, holdName, memRoom);
				// put into map
				memories.put(holdID, memo);

				// Test whether it is reading every line
				// System.out.println(line);
				// System.out.println(memories);

			}
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public MemoryPieces getMemory(String id) {
		return memories.get(id);
	}

	// Read frag memory pieces
	public static void gainMemory(String roomID) {
		if (roomID.equals("R1")) {
			System.out.println(memories.get("Itm10-1").getMemoryDesc());

		} else if (roomID.equals("R3")) {
			System.out.println(memories.get("Itm10-2").getMemoryDesc());

		} else if (roomID.equals("R8")) {
			System.out.println(memories.get("Itm10-3").getMemoryDesc());

		} else if (roomID.equals("R9")) {
			System.out.println(memories.get("Itm10-4").getMemoryDesc());

		} else if (roomID.equals("R12")) {
			System.out.println(memories.get("Itm10-5").getMemoryDesc());

		} else if (roomID.equals("R13")) {
			System.out.println(memories.get("Itm10-6").getMemoryDesc());

		} else if (roomID.equals("R15")) {
			System.out.println(memories.get("Itm10-7").getMemoryDesc());

		} else if (roomID.equals("R16")) {
			System.out.println(memories.get("Itm10-8").getMemoryDesc());

		} else if (roomID.equals("R19")) {
			System.out.println(memories.get("Itm10-9").getMemoryDesc());

		} else if (roomID.equals("R20")) {
			System.out.println(memories.get("Itm10-10").getMemoryDesc());

		}

	}

	// check inventory
	public static void checkInventory() {
		itemNames = new ArrayList<>();
		for (int i = 0; i < inventory.size(); i++) {
			itemNames.add(inventory.get(i).getItemName());
		}
		// System.out.println(itemNames);

	}

	public static void ignorePuzzle() {
		// player sent back to previous room
		move(previousRoom.getRoomID());
	}

	// solve puzzle: the puzzle description and answer choices are displayed
	public void solvePuzzle() {
		Puzzles puzzle = currentRoom.getPuzzles().get(0);
		System.out.println(puzzle.getDescription());
		for (int i = 0; i <= puzzle.getChoices().size() - 1; i++) {
			System.out.println((i + 1) + ". " + puzzle.getChoices().get(i));
		}

	}

}
