package grizzlyPunk;

public class Monster {
	private String monsterID;
	private String monsterName;
	private String monsterHP;
	private String monsterAttack;
	private String monsterDamage;
	private String monsterWeakPoint;
	private String monsterItem;
	private String monsterDescription;
	
	public Monster(String monsterID, String monsterName, String monsterHP, String monsterAttack, String monsterDamage, 
			String monsterWeakPoint, String monsterItem, String monsterDescription) {
		this.monsterID = monsterID;
		this.monsterName = monsterName;
		this.monsterHP = monsterHP;
		this.monsterAttack = monsterAttack;
		this.monsterDamage = monsterDamage;
		this.monsterWeakPoint =  monsterWeakPoint;
		this.monsterItem = monsterItem;
		this.monsterDescription = monsterDescription;
	}
	
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
	public String getMonsterHP() {
		return monsterHP;
	}
	public void setMonsterHP(String monsterHP) {
		this.monsterHP = monsterHP;
	}
	public String getMonsterAttack() {
		return monsterAttack;
	}
	public void setMonsterAttack(String monsterAttack) {
		this.monsterAttack = monsterAttack;
	}
	public String getMonsterDamage() {
		return monsterDamage;
	}
	public void setMonsterDamage(String monsterDamage) {
		this.monsterDamage = monsterDamage;
	}
	public String getMonsterWeakPoint() {
		return monsterWeakPoint;
	}
	public void setMonsterWeakPoint(String monsterWeakPoint) {
		this.monsterWeakPoint = monsterWeakPoint;
	}
	public String getMonsterItem() {
		return monsterItem;
	}
	public void setMonsterItem(String monsterItem) {
		this.monsterItem = monsterItem;
	}
	public String getMonsterDescription() {
		return monsterDescription;
	}
	public void setMonsterDescription(String monsterDescription) {
		this.monsterDescription = monsterDescription;
	}
	
	
}
