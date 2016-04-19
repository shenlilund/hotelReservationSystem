// CMSC 495
// Daniel Entzian
// April 19, 2016

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

// Class to handle the Customer database
public class CustomerDatabaseManager 
{
	private static String filename = "Customers.txt";
	private static String delimiter = ",";
	
	public int Create(Customer customer)
	{
		ArrayList<Customer> customers = GetAll();
		int newId = 1;
		if(customers.size() > 0)
		{
			newId = customers.get(customers.size() -1).CustomerId() + 1;
		}
		
		customer.SetCustomerId(newId);
		customers.add(customer);
		
		WriteToFile(customers);
		
		return newId;
	}
	
	public void Edit(Customer customerToEdit)
	{
		ArrayList<Customer> customers = GetAll();
		for(Customer customer: customers)
		{
			if(customer.CustomerId() == customerToEdit.CustomerId())
			{
				customer.SetLastName(customerToEdit.LastName());
				customer.SetFirstName(customerToEdit.FirstName());
				customer.SetStreetAddress(customerToEdit.StreetAddress());
				customer.SetState(customerToEdit.State());
				customer.SetZipcode(customerToEdit.Zipcode());
				
				break;
			}
		}
		
		WriteToFile(customers);
	}
	
	public Customer Get(int customerId)
	{
		ArrayList<Customer> customers = GetAll();
		
		for(Customer customer: customers)
		{
			if(customer.CustomerId() == customerId)
			{
				return customer;
			}
		}
		return null;
	}
	
	public ArrayList<Customer> GetAll()
	{
		ArrayList<Customer> customers = new ArrayList<Customer>();
		BufferedReader br;
		
		String line;
		try 
		{
			File file = new File(filename);
			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null)
			{
				//System.out.println(line);
				String[] lineParts = line.split(delimiter);
				Customer customer = new Customer(Integer.parseInt(lineParts[0]) ,
						lineParts[1],
						lineParts[2],
						lineParts[3],
						lineParts[4],
						lineParts[5]);
				
				customers.add(customer);
			}
			br.close();
		}
		catch (FileNotFoundException e)
		{
			
		}
		catch (IOException e) {
			
		}
		
		return customers;
	}
	
	public ArrayList<Customer> Find(String searchString)
	{
		ArrayList<Customer> customers = GetAll();
		ArrayList<Customer> foundCustomers = new ArrayList<Customer>();
		for(Customer customer: customers)
		{
			if(customer.LastName().toLowerCase().contains(searchString.toLowerCase()))
			{
				foundCustomers.add(customer);
			}
		}
		return foundCustomers;
	}
	
	public void WriteToFile(ArrayList<Customer> customers)
	{
		try 
		{
			//FileWriter output = new FileWriter(filename, true);
			FileOutputStream fostream = new FileOutputStream(filename);
			OutputStreamWriter oswriter = new OutputStreamWriter(fostream);
			BufferedWriter bwriter = new BufferedWriter(oswriter); 
			for(int cnt = 0; cnt < customers.size(); cnt++)
			{
				Customer customer = customers.get(cnt);
				
				String line = String.format("%s,%s,%s,%s,%s,%s", 
						customer.CustomerId(),
						customer.LastName(), 
						customer.FirstName(),
						customer.StreetAddress(),
						customer.State(),
						customer.Zipcode());
				bwriter.write(line);
				bwriter.newLine();
				//output.ne
			}
			
			bwriter.close();
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
}
