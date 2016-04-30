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

//Class to handle the Room database
public class RoomDatabaseManager 
{
	private static String filename = "Rooms.txt";
	private static String delimiter = ",";
	
	public int Create(Room room)
	{
		ArrayList<Room> rooms = GetAll();
		int newId = 1;
		if(rooms.size() > 0)
		{
			newId = rooms.get(rooms.size() -1).RoomId() + 1;
		}

		room.SetRoomId(newId);
		rooms.add(room);
		
		WriteToFile(rooms);
		
		return newId;
	}
	
	public void Edit(Room roomToEdit)
	{
		ArrayList<Room> rooms = GetAll();
		for(Room room: rooms)
		{
			if(room.RoomId() == roomToEdit.RoomId())
			{
				room.SetRoomType(roomToEdit.RoomType());
				break;
			}
		}
		
		WriteToFile(rooms);
	}
	
	public Room Get(int roomId)
	{
		ArrayList<Room> rooms = GetAll();
		
		for(Room room: rooms)
		{
			if(room.RoomId() == roomId)
			{
				return room;
			}
		}
		return null;
	}
	
	public ArrayList<Room> GetAll()
	{
		ArrayList<Room> rooms = new ArrayList<Room>();
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
				
				RoomTypes roomType;

				if(lineParts[1].equals(RoomTypes.queen.toString()))
				{
					roomType = RoomTypes.queen;
				}
				else
				{
					roomType = RoomTypes.doublebed;
				}
				
				Room room = new Room(Integer.parseInt(lineParts[0]),
						roomType);
				
				rooms.add(room);
			}
			br.close();
		}
		catch (FileNotFoundException e)
		{
			
		}
		catch (IOException e) {
			
		}
		
		return rooms;
	}
	
	public void WriteToFile(ArrayList<Room> rooms)
	{
		try 
		{
			//FileWriter output = new FileWriter(filename, true);
			FileOutputStream fostream = new FileOutputStream(filename);
			OutputStreamWriter oswriter = new OutputStreamWriter(fostream);
			BufferedWriter bwriter = new BufferedWriter(oswriter); 
			for(int cnt = 0; cnt < rooms.size(); cnt++)
			{
				Room room = rooms.get(cnt);
				bwriter.write(room.toString());
				bwriter.newLine();
			}
			
			bwriter.close();
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
