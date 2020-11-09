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

		// move using map class method
		map.enterRoom(moveID);

		// Change current room location to where player moved (only if there is no puzzle to solve)
		if (map.getRoom(moveID).getPuzzles().isEmpty() || map.getRoom(moveID).getPuzzles().get(0).isSolved()) {
			setCurrentRoom(moveID);
		}
	}

	// Explore current room
	public void explore() {
		ArrayList<String> itemNames = new ArrayList<>();
		for (int i = 0; i < currentRoom.getInventory().size(); i++) {
			itemNames.add(currentRoom.getInventory().get(i).getItemName());
		}
		// if there are no items in the room or in R19 and grappling hook not equipped
		if (itemNames.isEmpty() || (getCurrentRoom() == map.getRoom("R19") && !isGrapplingEquipped())) {
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

	// Equipping item
	public void equipItem(String itemName) {
		// find item in the inventory
		for (int i = 0; i < inventory.size(); i++) {
			// compare inventory with itemName player inputted
			if (inventory.get(i).getItemName().equalsIgnoreCase(itemName)) {
				// make sure the item is an equippable type
				if (inventory.get(i).getItemType().equals("Equip")) {
					// if the item is already equipped
					if (inventory.get(i).isEquipped()) {
						System.out.println("This item is equipped already.");
					}
					// item isn't equipped yet
					else {
						// if the item is armor
						if (inventory.get(i).getItemID().equals("itm3")
								|| inventory.get(i).getItemID().equals("itm4")) {
							// add it sp
							setSp(getSp() + inventory.get(i).getItemNumericValue());
							// make item isEquipped equal true
							inventory.get(i).setEquipped(true);
						}
						// if the item is a weapon
						else if (inventory.get(i).getItemID().equals("itm5")
								|| inventory.get(i).getItemID().equals("itm6")
								|| inventory.get(i).getItemID().equals("itm7")) {
							// if itm5
							if (inventory.get(i).getItemID().equals("itm5")) {
								// unequip already equipped item if necessary
								unequipWeapon();
								// set ap to weapon value
								setAp(inventory.get(i).getItemNumericValue());
								// make item isEquipped true
								inventory.get(i).setEquipped(true);

							}
							// if itm6
							else if (inventory.get(i).getItemID().equals("itm6")) {
								// unequip already equipped item if necessary
								unequipWeapon();
								// set ap to weapon value
								setAp(inventory.get(i).getItemNumericValue());
								// make item isEquipped true
								inventory.get(i).setEquipped(true);
							}
							// if itm7
							else {
								// unequip already equipped item if necessary
								unequipWeapon();
								// set ap to weapon value
								setAp(inventory.get(i).getItemNumericValue());
								// make item isEquipped true
								inventory.get(i).setEquipped(true);
							}

						}
						// if the item is a flashlight
						else if (inventory.get(i).getItemID().equals("itm8")) {
							// if the player isn't in room R17
							if (getCurrentRoom() != map.getRoom("R17")) {
								System.out.println("This item is not useful in this room might want to try later.");
							}
							// the player is in room R17
							else {
								// item is set to equipped
								inventory.get(i).setEquipped(true);
								System.out.println("I can see now and get through the room.");

							}

						}
						// if the item is a grappling hook
						else if (inventory.get(i).getItemID().equals("itm9")) {
							// if the player isn't in room R19
							if (getCurrentRoom() != map.getRoom("R19")) {
								System.out.println("This item is not useful in this room might want to try later.");

							}
							// the player is in room R19
							else {
								// item is set to equipped
								inventory.get(i).setEquipped(true);
								System.out.println(
										"I will use this grapping hook to get to the other side of the hallway.");

							}

						}
					}

				}
				// can't equip this item
				else {
					System.out.println("This item can not be used this way.");
				}

			}
			// not in inventory
			else if (inventory.get(i).getItemName()
					.equalsIgnoreCase((inventory.get(inventory.size() - 1).getItemName()))
					&& !(inventory.get(i).getItemName().equalsIgnoreCase(itemName))) {
				System.out.println("There is no item with that name in your inventory.");
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
						}
						// if current health is <50, then item numeric value is added to current health
						else {
							setCurrentHP(getCurrentHP() + inventory.get(i).getItemNumericValue());
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
						}
						// if current sp is <25, then 25 is added to current sp
						else {
							setSp(getSp() + inventory.get(i).getItemNumericValue());
						}

					}

				}
				// if neither, then they can't consume this item
				else {
					System.out.println("This item can not be used this way.");
				}

			}
			// item name wasn't found in inventory
			else if (inventory.get(i).getItemName()
					.equalsIgnoreCase((inventory.get(inventory.size() - 1).getItemName()))
					&& !(inventory.get(i).getItemName().equalsIgnoreCase(itemName))) {
				System.out.println("There is no item with that name in your inventory.");
			}

		}

	}

	// Check if grappling hook is equipped
	public boolean isGrapplingEquipped() {
		for (int i = 0; i < inventory.size(); i++) {
			// compare inventory with grappling hook
			if (inventory.get(i).getItemID().equals("itm9")) {
				if (inventory.get(i).isEquipped()) {
					return true;
				} else {
					return false;
				}
			}
			// item wasn't found in inventory
			else if (inventory.get(i).getItemID().equalsIgnoreCase((inventory.get(inventory.size() - 1).getItemID()))
					&& !(inventory.get(i).getItemID().equalsIgnoreCase("itm9"))) {
				return false;
			}
		}
		return false;// need to fix
	}

	// Check to see if a weapon is equipped already
	public void unequipWeapon() {
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
	// Read frag memory description
}
