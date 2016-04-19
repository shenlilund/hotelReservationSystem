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
import java.sql.Date;
import java.util.ArrayList;

//Class to handle the Reservation database
public class ReservationDatabaseManager 
{
	private static String filename = "Reservations.txt";
	private static String delimiter = ",";
	
	public int Create(Reservation reservation)
	{
		ArrayList<Reservation> reservations = GetAll();
		int newId = 1;
		
		if(reservations.size() > 0)
		{
			newId = reservations.get(reservations.size() -1).ReservationId() + 1;
		}
		
		reservation.SetReservationId(newId);
		reservations.add(reservation);
		
		WriteToFile(reservations);
		
		return newId;
	}
	
	public void Edit(Reservation reservationToEdit)
	{
		ArrayList<Reservation> reservations = GetAll();
		for(Reservation reservation: reservations)
		{
			if(reservation.ReservationId() == reservationToEdit.ReservationId())
			{
				reservation.SetCustomerId(reservationToEdit.CustomerId());
				reservation.SetRoomId(reservationToEdit.RoomId());
				reservation.SetNumberOfOccupants(reservationToEdit.NumberOfOccupants());;
				reservation.SetCheckinDate(reservationToEdit.CheckinDate());
				reservation.SetCheckoutDate(reservationToEdit.CheckoutDate());
				
				break;
			}
		}
		
		WriteToFile(reservations);
	}
	
	public Reservation Get(int reservationId)
	{
		ArrayList<Reservation> reservations = GetAll();
		
		for(Reservation reservation: reservations)
		{
			if(reservation.ReservationId() == reservationId)
			{
				return reservation;
			}
		}
		return null;
	}
	
	public ArrayList<Reservation> GetAll()
	{
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
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
				
				Reservation reservation = new Reservation(Integer.parseInt(lineParts[0]),
						Integer.parseInt(lineParts[1]),
						Integer.parseInt(lineParts[2]),
						Integer.parseInt(lineParts[3]),
						Date.valueOf(lineParts[4]),
						Date.valueOf(lineParts[5]));
				
				reservations.add(reservation);
			}
			br.close();
		}
		catch (FileNotFoundException e)
		{
			
		}
		catch (IOException e) {
			
		}
		
		return reservations;
	}
	
	public void Cancel(int reservationId)
	{
		ArrayList<Reservation> reservations = GetAll();
		Reservation reservationToCancel = null;
		
		for(Reservation reservation: reservations)
		{
			if(reservation.ReservationId() == reservationId)
			{
				reservationToCancel = reservation;
				break;
			}
		}

		if(reservationToCancel != null)
		{
			reservations.remove(reservationToCancel);
			WriteToFile(reservations);
		}
	}
	
	public void WriteToFile(ArrayList<Reservation> reservations)
	{
		try 
		{
			//FileWriter output = new FileWriter(filename, true);
			FileOutputStream fostream = new FileOutputStream(filename);
			OutputStreamWriter oswriter = new OutputStreamWriter(fostream);
			BufferedWriter bwriter = new BufferedWriter(oswriter); 
			for(int cnt = 0; cnt < reservations.size(); cnt++)
			{
				Reservation reservation = reservations.get(cnt);
				
				String line = String.format("%s,%s,%s,%s,%s,%s", 
						reservation.ReservationId(),
						reservation.CustomerId(), 
						reservation.RoomId(),
						reservation.NumberOfOccupants(),
						reservation.CheckinDate(),
						reservation.CheckoutDate());
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
