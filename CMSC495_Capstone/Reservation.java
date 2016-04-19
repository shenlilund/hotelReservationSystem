// CMSC 495
// Daniel Entzian
// April 19, 2016

import java.util.Date;

// Class to handle the Reservation object
public class Reservation
{
	// member variables
	private int reservationId;
	private int customerId;
	private int roomId;
	private int numberOfOccupants;
	private Date checkinDate;
	private Date checkoutDate;
	
	// default constructor
	public Reservation()
	{
		reservationId = 0;
		customerId = 0;
		roomId = 0;
		numberOfOccupants = 0;
		checkinDate = null;
		checkoutDate = null;
	}
	
	// constructor
	public Reservation(int reservationId, int customerId, int roomId, int numberOfOccupants, Date checkinDate, Date checkoutDate)
	{
		this.reservationId = reservationId;
		this.customerId = customerId;
		this.roomId = roomId;
		this.numberOfOccupants = numberOfOccupants;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
	}
	
	// Getter/Setters
	
	public int ReservationId()
	{
		return reservationId;
	}
	
	public void SetReservationId(int value)
	{
		this.reservationId = value;
	}
		
	public int CustomerId()
	{
		return customerId;
	}
	
	public void SetCustomerId(int value)
	{
		this.customerId = value;
	}
	
	public int RoomId()
	{
		return roomId;
	}
	
	public void SetRoomId(int value)
	{
		this.roomId = value;
	}
	
	public int NumberOfOccupants()
	{
		return numberOfOccupants;
	}
	
	public void SetNumberOfOccupants(int value)
	{
		this.numberOfOccupants = value;
	}
	
	public Date CheckinDate()
	{
		return checkinDate;
	}
	
	public void SetCheckinDate(Date value)
	{
		this.checkinDate = value;
	}
	
	public Date CheckoutDate()
	{
		return checkoutDate;
	}
	
	public void SetCheckoutDate(Date value)
	{
		this.checkoutDate = value;
	}
	
	// Override to print out party info
		public String toString()
		{
			return String.format("%s,%s,%s,%s,%s,%s", 
					this.reservationId,
					this.customerId,
					this.roomId, 
					this.numberOfOccupants,
					this.checkinDate,
					this.checkoutDate);

		}
}
