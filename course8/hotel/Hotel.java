import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Hotel {

    private int numberRoomsOccupied;
    private int maxRooms;
    private String name;
    private Room[] rooms;
    private RoomDisplayUI display;

    public Hotel(String name, int maxRooms) {
        if (maxRooms < 0) {
            throw new IllegalArgumentException();
        }
        this.maxRooms = maxRooms;
        this.name = name;
        this.rooms = new Room[maxRooms];
        for (int i = 0; i < maxRooms; i++) {
            this.rooms[i] = new Room(i, new ArrayList<>());
        }

        display = new RoomDisplayUI(this);
    }

    public void checkIn(int roomNumber, ArrayList<String> guestNames) throws HotelFullException{
        if (numberRoomsOccupied >= maxRooms) {
            throw new HotelFullException("Hotel: " + name + " is full");
        }

        // Find room and add guest
        boolean foundRoom = false;
        for (Room r : this.rooms) {
            if (r.getRoomNumber() == roomNumber) {
                r.getGuests().addAll(guestNames);
                foundRoom = true;
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
        if (numberRoomsOccupied <=0) {
            throw new HotelEmptyException("Hotel: " + name + " is empty");
        }

        boolean foundRoom = false;
        for (Room r : this.rooms) {
            if (r.getRoomNumber() == roomNumber) {
                r.getGuests().clear();
                foundRoom = true;
            }
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

    public int getNumberRoomsOccupied() {
        return this.numberRoomsOccupied;
    }

    public int getMaxRooms() {
        return this.maxRooms;
    }

    public String getName() {
        return this.name;
    }

    public Room[] getRoomInfo() {
        return this.rooms;
    }
}