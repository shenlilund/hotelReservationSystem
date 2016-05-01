
import java.sql.Date;
import java.util.ArrayList;

public class driver
{
  	public static void main(String[] args)
    {

      RoomTypes type = RoomTypes.doublebed;

      BusinessLogic b = new BusinessLogic();
      ArrayList<Room> rooms = b.findAvailableRooms(Date.valueOf("2016-4-2"), Date.valueOf("2016-4-21"), type);

      for (Room r : rooms)
      {
        System.out.println(r.RoomId());
      }

      //testing create reservation
      // b.createReservation(3, 5, 3, Date.valueOf("2016-7-10"), Date.valueOf("2016-7-12"));

      // editing a reservation (lets just extend the date to one more day)
      // b.editReservation(3, 3, 5, 3, Date.valueOf("2016-7-10"), Date.valueOf("2016-7-13"));

      //creating a room
      // b.createRoom(RoomTypes.queen);

      //editing a room
      b.editRoom(6, RoomTypes.doublebed);

      //creating a customer
      // b.createCustomer("Shenli", "Lund", "123 Test Drive", "TX", "12345");

      //editing a customer
      // b.editCustomer(4, "Shenli", "Lund", "123 Test Drive 2", "TX", "12345");
    }
}
