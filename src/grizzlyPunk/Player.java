package grizzlyPunk;

import java.util.ArrayList;

public class Player {
	private String currentRoom;
	private int maxHP;
	private int currentHP;
	private int sp;		//shield points
	private int ap;		//attack points / damage done
	private int memoryFragments;
	private ArrayList<String> items = new ArrayList<String>();	

	public Player() {
		currentRoom = "R1";
		maxHP = 100;
		currentHP = 100;
		sp = 0;
		ap = 0;
		memoryFragments = 0;
	}

	public Player(String currentRoom, int maxHP, int currentHP, int sp, int ap, int memoryFragments,
			ArrayList<String> items) {
		super();
		this.currentRoom = currentRoom;
		this.maxHP = maxHP;
		this.currentHP = currentHP;
		this.sp = sp;
		this.ap = ap;
		this.memoryFragments = memoryFragments;
		this.items = items;
	}

	public String getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(String currentRoom) {
		this.currentRoom = currentRoom;
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

	public ArrayList<String> getItems() {
		return items;
	}

	public void setItems(ArrayList<String> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Player [currentRoom=" + currentRoom + ", maxHP=" + maxHP + ", currentHP=" + currentHP + ", sp=" + sp
				+ ", ap=" + ap + ", memoryFragments=" + memoryFragments + ", items=" + items + "]";
	}
}
