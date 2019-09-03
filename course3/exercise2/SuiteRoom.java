public class SuiteRoom extends Room {
	public SuiteRoom (int maxGuests, int floor, int roomNumber) {
		super(maxGuests, floor, roomNumber, RoomType.SUITE);
	}
	
	public void checkIn(List<Guest> guests) {
		super.checkIn(guests);
		
		System.out.println("Roll out the red carpet......");
		for (Guest g : guests) {
			System.out.println("Welcome VIP guest: " + g);
		}
	}
}