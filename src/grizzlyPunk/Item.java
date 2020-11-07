package grizzlyPunk;

public class Item {
	private String itemID;
	private String itemName;
	private String itemDescription;	
	private String itemType;
	private String itemNumericValue;
	
	public Item(String itemID, String itemName, String itemDescription, String itemType, String itemNumericValue) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemType = itemType;
		this.itemNumericValue = itemNumericValue;
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
	public String getItemNumericValue() {
		return itemNumericValue;
	}
	public void setItemNumericValue(String itemNumericValue) {
		this.itemNumericValue = itemNumericValue;
	}
	 
	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", itemName=" + itemName + ", itemDescription=" + itemDescription
				+ ", itemType=" + itemType + ", itemNumericValue=" + itemNumericValue + "]";
	}
}
