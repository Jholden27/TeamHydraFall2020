package grizzlyPunk;

public class MemoryPieces {
	private String memoryID;
	private String memoryDesc;
	private String memoryRoom;
	public MemoryPieces(String memoryID, String memoryDesc, String memoryRoom) {
		super();
		this.memoryID = memoryID;
		this.memoryDesc = memoryDesc;
		this.memoryRoom = memoryRoom;
	}
	public String getMemoryID() {
		return memoryID;
	}
	public void setMemoryID(String memoryID) {
		this.memoryID = memoryID;
	}
	public String getMemoryDesc() {
		return memoryDesc;
	}
	public void setMemoryDesc(String memoryDesc) {
		this.memoryDesc = memoryDesc;
	}
	public String getMemoryRoom() {
		return memoryRoom;
	}
	public void setMemoryRoom(String memoryRoom) {
		this.memoryRoom = memoryRoom;
	}
	@Override
	public String toString() {
		return "MemoryPieces [memoryID=" + memoryID + ", memoryDesc=" + memoryDesc + ", memoryRoom=" + memoryRoom + "]";
	}

}
