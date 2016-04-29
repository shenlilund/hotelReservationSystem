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

  ReservationDatabaseManager resManager;
  RoomDatabaseManager roomManager;
  CustomerDatabaseManager customerManager;

  //constructor
  public BusinessLogic()
  {
    resManager = new ReservationDatabaseManager();
    roomManager = new RoomDatabaseManager();
    customerManager = new CustomerDatabaseManager();
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

  //Reservations

  public Reservation createReservation(int customerId, int roomNumber, int numberOfOccupants, DateTime checkinDate, DateTime checkoutDate)
  {
    Reservation newRes = null;
    resManager.Create(newRes);
  }

  //pass in all items, and it will replace the existing reservation with this new one
  public void editReservation(int reservationId, int customerId, int roomNumber, int numberOfOccupants, DateTime checkinDate, DateTime checkoutDate)
  {
    Reservation tempRes = new Reservation(reservationId, customerId, roomNumber, numberOfOccupants, checkinDate, checkoutDate);
    resManager.Edit(tempRes);
  }

  //Rooms

  public Room[] findAvailableRooms(checkin, checkout, roomType)
  {
    ArrayList<Reservation> listOfRes = resManager.GetAll();
    ArrayList<Room> listOfRooms = roomManager.GetAll();

    //new array for all reservations between checkin and checkout dates
    ArrayList<Reservation> resBetweenDates = new ArrayList<Reservation>();

    for (Reservation res : listOfRes)
    {
      if ((checkin.before(res.CheckinDate()) && checkout.before(res.CheckinDate()) || (checkin.after(res.CheckoutDate()) && checkout.after(res.CheckoutDate()))
      {
        resBetweenDates.add(res);
      }
    }

    ArrayList<Room> availRooms = new ArrayList<Room>();

    bool avail = true;

    for (Room r : listOfRooms)
    {
      avail = true;
      for (Reservation res : resBetweenDates)
      {
        if (r.RoomId() == res.RoomId())
        {
          avail = false;
        }
      }
      if (avail == true)
      {
        availRooms.add(r);
      }
    }

    return availRooms;
  }

  public int createRoom()
  {
    Room r = new Room();
    // 2. RoomType = type;
    roomManager.Create(r);
  }

  public void editRoom(int roomNumber)
  {
    Room r = rooms.Get(roomNumber);
    // 2. RoomType = type;
    roomManager.Create(r);
  }

  //Customers

  public int createCustomer(String lastName, String firstName, String address)
  {
    Customer c = new Customer();
    c.SetLastName(lastName);
    c.SetFirstName(firstName);
    c.SetStreetAddress(address);
    return customerManager.Create(c);
  }

  public void editCustomer(int customerID, String lastName, String firstName, String address)
  {
    Customer c = customerManager.Get(customerID);
    c.SetLastName(lastName);
    c.SetFirstName(firstName);
    c.SetStreetAddress(address);
    customerManager.Edit(c);
  }

}
