import java.util.*;

public abstract class Room {
	private int floor;
	private int roomNumber;
	private int maxGuests;
	private RoomType roomType;
	private ArrayList<Guest> guests = new ArrayList<>();
	
	public Room (int maxGuests, int floor, int roomNumber, RoomType roomType) {
		this.maxGuests = maxGuests;
		this.floor = floor;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
	}
	
	public void checkIn(List<Guest> guests) {
		this.guests.addAll(guests);
	}
	
	public void checkOut() {
		this.guests.clear();
	}
	
	public int getFloor() {
		return this.floor;
	}
	
	public int getRoomNumber() {
		return this.roomNumber;
	}
	
	public boolean isOccupied() {
		return !this.guests.isEmpty();
	}
	
	public String toString() {
		StringBuilder guestsStr = new StringBuilder();
		for (Guest g : guests) {
			guestsStr.append(g.toString() + ", ");
		}
		
		return String.format("Room: %d%d, Max Guests: %d, Guests: [%s]", this.floor, this.roomNumber, this.maxGuests, guestsStr);
	}
}