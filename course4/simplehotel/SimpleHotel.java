import java.util.*;

public class SimpleHotel {
	private String hotelName;
	private int numOfGuests;
	private int maxCapacity;
	
	public SimpleHotel(String name, int maxCapacity) {
		this.hotelName = name;
		this.maxCapacity = maxCapacity;
	}
	
	public void addGuest() throws HotelFullException {
		if (numOfGuests >= maxCapacity) {
			throw new HotelFullException(this.hotelName + " is full!");
		}
		++this.numOfGuests;
	}
	
	public int getNumberGuests() {
		return this.numOfGuests;
	}
}