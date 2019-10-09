package hotel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Hotel {

    private int numberRoomsOccupied;
    private int maxSingles;
    private int maxDouble;
    private String name;
    private int occupiedSingles = 0;
    private int occupiedDoubles = 0;
    private HashMap<Integer, Room> rooms = new HashMap<>();
    private HashMap<String, Room> guestNameToRoom = new HashMap<>();
    private RoomDisplayUI display;

    public Hotel(String name, int maxSingles, int maxDouble) {
        if (maxSingles < 0 || maxDouble < 0) {
            throw new IllegalArgumentException();
        }
        this.maxSingles = maxSingles;
        this.maxDouble = maxDouble;
        this.name = name;
        for (int i = 0; i < (maxSingles + maxDouble); i++) {
            if (i < this.maxSingles) {
                this.rooms.put(i, new Room(i, new ArrayList<>(), RoomType.SINGLE));
            } else {
                this.rooms.put(i, new Room(i, new ArrayList<>(), RoomType.DOUBLE));
            }
        }

        display = new RoomDisplayUI(this);
    }

    public void checkIn(int roomNumber, ArrayList<String> guestNames) throws HotelFullException {
        if (numberRoomsOccupied >= (this.maxDouble + this.maxSingles)) {
            throw new HotelFullException("Hotel: " + name + " is full");
        }

        // Find room and add guest
        boolean foundRoom = false;
        Room room = this.rooms.get(roomNumber);
        if (room != null) {
            foundRoom = true;
            room.getGuests().addAll(guestNames);
            switch (room.getRoomType()) {
                case SINGLE:
                    ++this.occupiedSingles;
                    break;
                case DOUBLE:
                    ++this.occupiedDoubles;
                    break;
            }

            // Also update map of guest names
            for (String guest : guestNames) {
                this.guestNameToRoom.put(guest, room);
            }
        }

        // If no room found throw exception
        if (!foundRoom) {
            JOptionPane.showMessageDialog(null, "Room number invalid, dummy");
        } else {
            ++numberRoomsOccupied;
            display.setVisible(false);
            display = new RoomDisplayUI(this);
        }
    }

    public void checkOut(int roomNumber) throws HotelEmptyException {
        if (numberRoomsOccupied <= 0) {
            throw new HotelEmptyException("Hotel: " + name + " is empty");
        }

        boolean foundRoom = false;
        Room room = this.rooms.get(roomNumber);
        if (room != null) {
            foundRoom = true;
            switch (room.getRoomType()) {
                case SINGLE:
                    --this.occupiedSingles;
                    break;
                case DOUBLE:
                    --this.occupiedDoubles;
                    break;
            }

            // Update our room map
            for (String guest : room.getGuests()) {
                this.guestNameToRoom.remove(guest);
            }
            room.getGuests().clear();
        }

        // If no room found throw exception
        if (!foundRoom) {
            JOptionPane.showMessageDialog(null, "Room number invalid, dummy");
        } else {
            JOptionPane.showMessageDialog(null, "Checkout complete!");
            --numberRoomsOccupied;
            display.setVisible(false);
            display = new RoomDisplayUI(this);
        }
    }

    public int getVacantDoubles() {
        return this.maxDouble - this.occupiedDoubles;
    }

    public int getVacantSingles() {
        return this.maxSingles - this.occupiedSingles;
    }

    public int getMaxRooms() {
        return this.maxDouble + this.maxSingles;
    }

    public String getName() {
        return this.name;
    }

    public Collection<Room> getRoomInfo() {
        return this.rooms.values();
    }

    public int findRoomNumber(String guestName) {

        // Search impl #2
        Room room = this.guestNameToRoom.get(guestName);
        if (room != null) {
            return room.getRoomNumber();
        }

        // Search all the rooms for a matching guest name
        // for (Map.Entry<Integer, Room> entry: this.rooms.entrySet()) {
        //     if (entry.getValue().getGuests().contains(guestName)) {
        //         return entry.getKey();
        //     }
        // }

        return -1;
    }
}