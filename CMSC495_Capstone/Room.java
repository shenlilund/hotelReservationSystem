// CMSC 495
// Daniel Entzian
// April 19, 2016


// Class to handle the Room object
public class Room 
{
	// member variables
	private int roomId;
	private RoomTypes roomType;
	
	// default constructor
	public Room()
	{
		roomId = 0;
		roomType = RoomTypes.doublebed;
	}
	
	// constructor
	public Room(int roomId, RoomTypes roomType)
	{
		this.roomId = roomId;
		this.roomType = roomType;
	}
	
	// Getter/Setters
	
	public int RoomId()
	{
		return roomId;
	}
	
	public void SetRoomId(int value)
	{
		this.roomId = value;
	}
	
	public RoomTypes RoomType()
	{
		return roomType;
	}
	
	public void SetRoomType(RoomTypes value)
	{
		this.roomType = value;
	}
	
	// Override to print out party info
	public String toString()
	{
		return String.format("%s,%s", 
				this.roomId,
				this.roomType);
	}
}
