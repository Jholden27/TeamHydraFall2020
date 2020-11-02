package grizzlyPunk;

public class Items {
	private String itemID;
	private String itemName;
	private String description;	
	
	public Item(String itemID, String itemName, String description) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.description = description;
	}
	
public Items() {
		super();
	}

	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}