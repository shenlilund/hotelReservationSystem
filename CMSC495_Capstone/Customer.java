// CMSC 495
// Daniel Entzian
// April 19, 2016

// Class to handle the Customer object
public class Customer 
{
	// member variables
	private int customerId;
	private String firstName;
	private String lastName;
	private String streetAddress;
	private String state;
	private String zipcode;
	
	// default constructor
	public Customer()
	{
		customerId = 0;
		firstName= "";
		lastName = "";
		streetAddress = "";
		state = "";
		zipcode = "";
	}
	
	// constructor
	public Customer(int id, String last, String first, String address, String state, String zip)
	{
		this.customerId = id;
		this.firstName = first;
		this.lastName = last;
		this.streetAddress = address;
		this.state = state;
		this.zipcode = zip;
	}
	
	// Getter/Setters
	
	public int CustomerId()
	{
		return customerId;
	}
	
	public void SetCustomerId(int value)
	{
		this.customerId = value;
	}
	
	public String FirstName()
	{
		return firstName;
	}
	
	public void SetFirstName(String value)
	{
		this.firstName = value;
	}
	 
	public String LastName()
	{
		return lastName;
	}
	
	public void SetLastName(String value)
	{
		this.lastName = value;
	}
	
	public String StreetAddress()
	{
		return streetAddress;
	}
	
	public void SetStreetAddress(String value)
	{
		this.streetAddress = value;
	}
	
	public String State()
	{
		return state;
	}
	
	public void SetState(String value)
	{
		this.state = value;
	}
	
	public String Zipcode()
	{
		return zipcode;
	}
	
	public void SetZipcode(String value)
	{
		this.zipcode = value;
	}
	
	// Override to print out party info
	public String toString()
	{
		return String.format("%s,%s,%s,%s,%s,%s", 
				this.customerId,
				this.lastName, 
				this.firstName,
				this.streetAddress,
				this.state,
				this.zipcode);
	}
}
