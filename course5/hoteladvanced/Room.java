import java.util.ArrayList;

public class Room {

    private int roomNumber;
    private ArrayList<String> guests;

    public Room(int room, ArrayList<String> guests) {
        this.roomNumber = room;
        this.guests = guests;
    }

    public int getRoomNumber() {
        return this.roomNumber;
    }

    public ArrayList<String> getGuests() {
        return this.guests;
    }
}