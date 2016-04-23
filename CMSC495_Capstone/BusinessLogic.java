// CMSC 495
// Shenli Lund
// April 23, 2016

//This class is used as a link between the UI and the rest of the project. To do anything to the databases, the UI will need to call methods in this class first.

public class BusinessLogic
{
  //class variables ------------------------------------------------------------

  //TODO Don't think we need any of these variables actually
  // private int customer; //TODO Why are these ints? Shouldn't they be objects? like private Customer customer;
  // private int room;
  // private int customerID;
  // private int roomNumber;
  // private int numberOfOccupants;
  // private Date checkInDate;
  // private Date checkOutDate;
  // private int reservationID;
  // private int roomNumber;
  // private Type roomType;   //TODO we don't have a Type class?
  // private String firstName; //TODO if we have a customer object, we could get the names from that
  // private String lastName;
  // private String address;

  ReservationDatabaseManager reservations;
  RoomDatabaseManager rooms;
  CustomerDatabaseManager customers;

  //constructor
  public BusinessLogic()
  {
    reservations = new ReservationDatabaseManager();
    rooms = new RoomDatabaseManager();
    customers = new CustomerDatabaseManager();
  }

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
    Reservation newRes = null;
    reservations.Create(newRes);
  }

  //pass in all items, and it will replace the existing reservation with this new one
  public void editReservation(int reservationId, int customerId, int roomNumber, int numberOfOccupants, DateTime checkinDate, DateTime checkoutDate)
  {
    Reservation tempRes = new Reservation(reservationId, customerId, roomNumber, numberOfOccupants, checkinDate, checkoutDate);
    reservations.Edit(tempRes);
  }

  //TODO Not complete, will come back later
  public Room[] findAvailableRooms(checkin, checkout, roomType)
  {
    ArrayList<Reservation> listOfRes = reservations.GetAll();
    ArrayList<Room> listOfRooms = rooms.GetAll();

    ArrayList<Room> availRooms = null;

    // 1. Call ReservationDatabaseManager.GetAll();
		// 2. Call RoomDatabaseManager.GetAll();
		// 3. Find taken rooms based on dates and types;
		// 4. return list of all not taken rooms;
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
