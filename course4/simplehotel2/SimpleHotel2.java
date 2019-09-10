import java.util.*;

public class SimpleHotel2 {
	private String hotelName;
	private int numOfGuests;
	private int maxCapacity;
	
	public SimpleHotel2(String name, int maxCapacity) {
		this.hotelName = name;
		this.maxCapacity = maxCapacity;
		this.numOfGuests = 0;
	}
	
	public void addGuest() throws HotelFullException {
		if (numOfGuests >= maxCapacity) {
			throw new HotelFullException(this.hotelName + " is full!");
		}
		++this.numOfGuests;
	}

	public int getMaxGuests() {
		return this.maxCapacity;
	}
	
	public int getNumberGuests() {
		return this.numOfGuests;
	}

	public String getHotelName() {
		return this.hotelName;
	}
}