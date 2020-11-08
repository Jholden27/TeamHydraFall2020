package grizzlyPunk;

public class Item {
	private String itemID;
	private String itemName;
	private String itemDescription;	
	private String itemType;
	private int itemNumericValue;
	private boolean isEquipped;
	
	public Item(String itemID, String itemName, String itemDescription, String itemType, int itemNumericValue,
			boolean isEquipped) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemType = itemType;
		this.itemNumericValue = itemNumericValue;
		this.isEquipped = isEquipped;
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
	
	public int getItemNumericValue() {
		return itemNumericValue;
	}
	public void setItemNumericValue(int itemNumericValue) {
		this.itemNumericValue = itemNumericValue;
	}
	public boolean isEquipped() {
		return isEquipped;
	}
	public void setEquipped(boolean isEquipped) {
		this.isEquipped = isEquipped;
	}
	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", itemName=" + itemName + ", itemDescription=" + itemDescription
				+ ", itemType=" + itemType + ", itemNumericValue=" + itemNumericValue + ", isEquipped=" + isEquipped
				+ "]";
	}

}
