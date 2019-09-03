import java.util.*;

public class Exercise2 {
    
    public static enum RoomType {
        SINGLE("Single King"),
        DOUBLE("Double Beds"),
        SUITE("Suite");
        
        private String desc;
        private RoomType(String d) {
            this.desc = d;
        }
    }
    
    public static abstract class Room {
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
        
        public String toString() {
            StringBuilder guestsStr = new StringBuilder();
            for (Guest g : guests) {
                guestsStr.append(g.toString() + ", ");
            }
            
            return String.format("Room: %d, Floor: %d, Max Guests: %d, Guests: [%s]", this.roomNumber, this.floor, this.maxGuests, guestsStr);
        }
    }
    
    public static class DoubleRoom extends Room {
        public DoubleRoom (int maxGuests, int floor, int roomNumber) {
            super(maxGuests, floor, roomNumber, RoomType.DOUBLE);
        }
    }
    
    public static class Guest {
        private String name;
        private int age;
        
        public Guest(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        public String toString() {
            return String.format("Guest: %s, Age: %d", this.name, this.age);
        }
    }
    
    public static class Hotel {
        private String hotelName;
        private ArrayList<Room> hotelRooms = new ArrayList<>();
        
        public Hotel(String name) {
            this.hotelName = name;
        }
        
        public void addRoom(Room r) {
            this.hotelRooms.add(r);
        }
    }
    
    public static void main(String args[]) {
      int x=10;
      int y=25;
      int z=x+y;

      System.out.println("Sum of x+y = " + z);
    }
}
