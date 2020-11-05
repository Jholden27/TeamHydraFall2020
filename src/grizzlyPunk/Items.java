package grizzlyPunk;

public class Items {
	private String itemID;
	private String itemName;
	private String itemDescription;	
	private String itemType;
	private String itemNumericValue;
	
	public Item(String itemID, String itemName, String itemDescription, String itemType, String itemNumericaValue) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemType = itemType;
		this.itemNumericaValue = itemNumericaValue;
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
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	public String getItemNumericaValue() {
		return itemNumericaValue;
	}
	public void setItemNumericaValue(String itemNumericaValue) {
		this.itemNumericaValue = itemNumericaValue;
	}
}