import java.util.*;

public class Hotel {
	private String hotelName;
	public ArrayList<Room> hotelRooms = new ArrayList<>();
	
	public Hotel(String name) {
		this.hotelName = name;
	}
	
	public void addRoom(Room r) {
		this.hotelRooms.add(r);
	}
	
	public String getName() {
		return this.hotelName;
	}
	
	public void checkin(int roomNumber, List<Guest> guests) {
		for (Room r : hotelRooms) {
			String roomId = Integer.toString(r.getFloor()) + Integer.toString(r.getRoomNumber());
			if (roomId.equals(Integer.toString(roomNumber))) {
				r.checkIn(guests);
				return;
			}
		}
		System.err.println("Was unable to find room number: " + roomNumber);
	}
	
	public void displayHotelInfo() {
		Comparator<Room> comparator = Comparator.comparing(Room::getFloor).thenComparingInt(Room::getRoomNumber);
		Collections.sort(hotelRooms, comparator);

		int currFloor = 1;
		System.out.printf("Hotel Status for %s: \n", this.hotelName);
		System.out.print("|");
		for (Room r : hotelRooms) {
			if (r.getFloor() != currFloor) {
				currFloor = r.getFloor();
				System.out.print(" |\n|");
			}
			
			if (r.isOccupied()) {
				System.out.printf("%5s", "XXX");
			} else {
				String roomId = Integer.toString(r.getFloor()) + Integer.toString(r.getRoomNumber());
				System.out.printf("%5s", roomId);
			}
			
		}
		System.out.println(" |");
	}
}