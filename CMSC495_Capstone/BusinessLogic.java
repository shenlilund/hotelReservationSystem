// CMSC 495
// Shenli Lund
// April 23, 2016

public class BusinessLogic
{
  //class variables ------------------------------------------------------------
  private int customer; //TODO Why are these ints? Shouldn't they be objects? like private Customer customer;
  private int room;
  private int customerID;
  private int roomNumber;
  private int numberOfOccupants;
  private Date checkInDate;
  private Date checkOutDate;
  private int reservationID;
  private int roomNumber;
  private Type roomType;   //TODO we don't have a Type class?
  private String firstName; //TODO if we have a customer object, we could get the names from that
  private String lastName;
  private String address;

  //getters and setters --------------------------------------------------------
  public Date getCheckIn()
  {
    return checkInDate;
  }
  public void setCheckin(Date d)
  {
    checkInDate = d;
  }

  public Date getCheckOut()
  {
    return checkOutDate;
  }
  public void setCheckOut(Date d)
  {
      checkOutDate = d;
  }


  //class methods --------------------------------------------------------------
  public Reservation createReservation(int customerId, int roomNumber, int numberOfOccupants, DateTime checkinDate, DateTime checkoutDate)
  {
    Reservation newRes = new Reservation()


    // Create Reservation Object;
  	// CustomerId = customerId;
  	// RoomNumber = roomNumber;
  	// NumberOfOccupants = numberOfOccupants;
  	// CheckinDate = checkinDate;
  	// CheckoutDate = checkoutDate;
  	// Call ReservationDatabaseManager.Create(Reservation);
  }

  public void editReservation()
  {

  }

  public String findAvailableRooms()
  {

  }

  public int createRoom()
  {

  }

  public void editRoom()
  {

  }

  public int createCustomer()
  {

  }

  public void editCustomer()
  {

  }

}
