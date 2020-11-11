package grizzlyPunk;
import java.util.ArrayList;

public class Monster {
	private String monsterID;
	private String monsterName;
	private String monsterDesc;
	private int monsterHP;
	private String monsterAttack;
	private int monsterDP;
	private String weakness;
	//monster drop items placed in an arraylist
	private ArrayList<Item> inventory = new ArrayList<>();
	
	//Constructor
	public Monster(String monsterID, String monsterName, String monsterDesc, int monsterHP, String monsterAttack,
			int monsterDP, String weakness, ArrayList<Item> inventory) {
		this.monsterID = monsterID;
		this.monsterName = monsterName;
		this.monsterDesc = monsterDesc;
		this.monsterHP = monsterHP;
		this.monsterAttack = monsterAttack;
		this.monsterDP = monsterDP;
		this.weakness = weakness;
		this.inventory = inventory;
	}

	//Getters and setters
	public String getMonsterID() {
		return monsterID;
	}

	public void setMonsterID(String monsterID) {
		this.monsterID = monsterID;
	}

	public String getMonsterName() {
		return monsterName;
	}

	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}

	public String getMonsterDesc() {
		return monsterDesc;
	}

	public void setMonsterDesc(String monsterDesc) {
		this.monsterDesc = monsterDesc;
	}

	public int getMonsterHP() {
		return monsterHP;
	}

	public void setMonsterHP(int monsterHP) {
		this.monsterHP = monsterHP;
	}

	public String getMonsterAttack() {
		return monsterAttack;
	}

	public void setMonsterAttack(String monsterAttack) {
		this.monsterAttack = monsterAttack;
	}

	public int getMonsterDP() {
		return monsterDP;
	}

	public void setMonsterDP(int monsterDP) {
		this.monsterDP = monsterDP;
	}

	public String getWeakness() {
		return weakness;
	}

	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}

	//toString
	@Override
	public String toString() {
		return "Monster [monsterID=" + monsterID + ", monsterName=" + monsterName + ", monsterDesc=" + monsterDesc
				+ ", monsterHP=" + monsterHP + ", monsterAttack=" + monsterAttack + ", monsterDP=" + monsterDP
				+ ", weakness=" + weakness + ", inventory=" + inventory + "]";
	}

}
