package hotel;

import java.util.ArrayList;

public class Room {

    private int roomNumber;
    private ArrayList<String> guests;
    private RoomType roomType;

    public Room(int room, ArrayList<String> guests, RoomType type) {
        this.roomNumber = room;
        this.guests = guests;
        this.roomType = type;
    }

    public int getRoomNumber() {
        return this.roomNumber;
    }

    public ArrayList<String> getGuests() {
        return this.guests;
    }

    public RoomType getRoomType() {
        return this.roomType;
    }
}