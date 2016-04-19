import java.sql.Date;
import java.util.ArrayList;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testCustomerrsWrite();
		testCustomersGetAll();
		//testCreateCustomer();
		//testGetCustomer();
		//testEditCustomer();
		//testFindCustomer();
		
		//testResWrite();
		//testResGetAndEdit();
		//testResCreate();
		//testResCancel();
		
		//testRoomCreate();
	}
	
	private static void testRoomCreate()
	{
		RoomDatabaseManager manager = new RoomDatabaseManager();
		Room room = new Room(0, RoomTypes.queen);

		System.out.println(manager.Create(room));

		ArrayList<Room> roomOutput = manager.GetAll();

		for(Room r: roomOutput)
		{
			System.out.println(r);
		}
	}
	
	private static void testResWrite()
	{
		Reservation res1 = new Reservation(1, 1, 1, 2, 
				Date.valueOf("2016-4-20"), 
				Date.valueOf("2016-4-27"));
		
		Reservation res2 = new Reservation(2, 3, 2, 1, 
				Date.valueOf("2016-5-1"), 
				Date.valueOf("2016-5-7"));
		
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		reservations.add(res1);
		reservations.add(res2);
		
		ReservationDatabaseManager manager = new ReservationDatabaseManager();
		manager.WriteToFile(reservations);
		
		ArrayList<Reservation> resOutput = manager.GetAll();

		for(Reservation res: resOutput)
		{
			System.out.println(res);
		}
	}

	private static void testResCreate()
	{
		ReservationDatabaseManager manager = new ReservationDatabaseManager();
		Reservation res1 = new Reservation(0, 2, 1, 6, 
				Date.valueOf("2016-5-20"), 
				Date.valueOf("2016-5-27"));
		
		System.out.println(manager.Create(res1));

		ArrayList<Reservation> resOutput = manager.GetAll();

		for(Reservation res: resOutput)
		{
			System.out.println(res);
		}
	}
	
	private static void testResGetAndEdit()
	{
		ReservationDatabaseManager manager = new ReservationDatabaseManager();
		Reservation res = manager.Get(3);
		System.out.println(res);
		
		res.SetCheckinDate(Date.valueOf("2016-5-24"));
		
		manager.Edit(res);
		
		ArrayList<Reservation> resOutput = manager.GetAll();

		for(Reservation res1: resOutput)
		{
			System.out.println(res1);
		}
	}
	
	private static void testResCancel()
	{
		ReservationDatabaseManager manager = new ReservationDatabaseManager();
		manager.Cancel(3);
		
		ArrayList<Reservation> resOutput = manager.GetAll();

		for(Reservation res1: resOutput)
		{
			System.out.println(res1);
		}
	}
	
	private static void testCustomerrsWrite()
	{
		Customer cust1 = new Customer(1, "Entzian", "Daniel", "123 main st", "MD", "12345");
		Customer cust2 = new Customer(2, "Entzian", "Tina", "456 main st", "MD", "12345");
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(cust1);
		customers.add(cust2);
		
		CustomerDatabaseManager manager = new CustomerDatabaseManager();
		manager.WriteToFile(customers);
	}
	
	private static void testCustomersGetAll()
	{
		CustomerDatabaseManager manager = new CustomerDatabaseManager();
		ArrayList<Customer> customers = manager.GetAll();
		
		for(Customer customer: customers)
		{
			System.out.println(customer.toString());
		}
	}
	
	private static void testCreateCustomer()
	{
		CustomerDatabaseManager manager = new CustomerDatabaseManager();
		Customer newCust = new Customer(0, "Polo", "Marco", "123 silk rd", "MO", "23409");
		
		int newId = manager.Create(newCust);
		
		System.out.println(newId);
		testCustomersGetAll();
	}

	private static void testGetCustomer()
	{
		CustomerDatabaseManager manager = new CustomerDatabaseManager();
		Customer customer = manager.Get(3); 
		System.out.println(customer.toString());
	}
	
	private static void testEditCustomer()
	{
		CustomerDatabaseManager manager = new CustomerDatabaseManager();
		Customer customer = manager.Get(3); 
		System.out.println(customer.toString());
		
		customer.SetStreetAddress("666 Somewhere Else");
		
		manager.Edit(customer);
		
		Customer editedcustomer = manager.Get(3); 
		System.out.println(editedcustomer.toString());
	}
	
	private static void testFindCustomer()
	{
		CustomerDatabaseManager manager = new CustomerDatabaseManager();
		ArrayList<Customer> customers = manager.Find("pol");
		
		for(Customer customer: customers)
		{
			System.out.println(customer.toString());
		}
	}
	
}
