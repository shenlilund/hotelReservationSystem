// CMSC 495
// Shenli Lund
// April 23, 2016

import java.sql.Date;
import java.util.ArrayList;

//This class is used as a link between the UI and the rest of the project. To do anything to the databases, the UI will need to call methods in this class first.

public class BusinessLogic
{
  //class variables ------------------------------------------------------------

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



  //class methods --------------------------------------------------------------

  //Reservations

  public void createReservation(int customerId, int roomNumber, int numberOfOccupants, Date checkinDate, Date checkoutDate)
  {
    Reservation newRes = new Reservation(0, customerId, roomNumber, numberOfOccupants, checkinDate, checkoutDate);
    resManager.Create(newRes);
  }

  //pass in all items, and it will replace the existing reservation with this new one
  public void editReservation(int reservationId, int customerId, int roomNumber, int numberOfOccupants, Date checkinDate, Date checkoutDate)
  {
    Reservation tempRes = new Reservation(reservationId, customerId, roomNumber, numberOfOccupants, checkinDate, checkoutDate);
    resManager.Edit(tempRes);
  }

  //Rooms

  public ArrayList<Room> findAvailableRooms(Date checkin, Date checkout, RoomTypes roomType)
  {
    ArrayList<Reservation> listOfRes = resManager.GetAll();
    ArrayList<Room> listOfRooms = roomManager.GetAll();

    //new array for all reservations between checkin and checkout dates
    ArrayList<Reservation> resBetweenDates = new ArrayList<Reservation>();

    for (Reservation res : listOfRes)
    {
      if (!((checkin.before(res.CheckinDate()) && checkout.before(res.CheckinDate())) || (checkin.after(res.CheckoutDate()) && checkout.after(res.CheckoutDate()))))
      {
        resBetweenDates.add(res);
      }
    }

    ArrayList<Room> availRooms = new ArrayList<Room>();

    boolean avail = true;

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

  public int createRoom(RoomTypes type)
  {
    Room r = new Room();
    r.SetRoomType(type);
    return roomManager.Create(r);
  }

  public void editRoom(int roomNumber, RoomTypes type)
  {
    Room r = roomManager.Get(roomNumber);
    r.SetRoomType(type);
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
