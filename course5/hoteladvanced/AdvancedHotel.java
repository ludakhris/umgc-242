import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AdvancedHotel {
	private String hotelName;
	private int roomsOccupied;
	private Room[][] hotelRooms;
	private int maxRooms;
	private int numFloors;
	private int numRooms;

	private static final int MIN_ROOM_NUM = 100;

	public AdvancedHotel(String name, int numFloors, int numRooms) {
		this.hotelName = name;
		this.numFloors = numFloors;
		this.numRooms = numRooms;
		this.roomsOccupied = 0;
		this.hotelRooms = new Room[numFloors][numRooms];
		for (int i = 0; i < numFloors; i++) {
			for (int j = 0; j < numRooms; j++) {
				this.hotelRooms[i][j] = new Room((((i+1)*MIN_ROOM_NUM) + j + 1), new ArrayList<>());
			}
		}
		this.maxRooms = numRooms * numFloors;
	}
	
	public void addGuest(ArrayList<String> guestNames, int roomNumber) throws HotelFullException {
		// Check 1 -- no more rooms
		if (roomsOccupied >= maxRooms) {
			throw new HotelFullException(this.hotelName + " is full!");
		}

		// Check 2 -- Invalid guest name
		for (String name : guestNames) {
			if (name == null || name.length() == 0) {
				JOptionPane.showMessageDialog(null, "Invalid guest name -- cannot be empty");
				return;
			}
		}

		// Check 3 -- Invalid room number
		if (roomNumber <= MIN_ROOM_NUM) {
			JOptionPane.showMessageDialog(null, "Invalid room number -- must be greater than " + MIN_ROOM_NUM);
			return;
		}

		// Compute floor and room 
		// Check 4 -- verify floor and room
		int floor = roomNumber / MIN_ROOM_NUM;
		int room = roomNumber % MIN_ROOM_NUM;
		if (floor < 1 || floor > this.numFloors || room < 1 || room > this.numRooms) {
			JOptionPane.showMessageDialog(null, "Invalid room number");
			return;
		}

		System.out.println("Check-in, floor:" + floor + ", room:" + room);
		this.hotelRooms[floor-1][room-1] = new Room(roomNumber, guestNames);

		++this.roomsOccupied;
	}

	public int getMaxRooms() {
		return this.maxRooms;
	}
	
	public int getNumRoomsOccupied() {
		return this.roomsOccupied;
	}

	public String getHotelName() {
		return this.hotelName;
	}

	public int getNumFloor() {
		return this.numFloors;
	}

	public int getNumRooms() {
		return this.numRooms;
	}

	public Room[][] getRooms() {
		return this.hotelRooms;
	}
}