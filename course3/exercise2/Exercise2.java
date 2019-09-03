import java.util.*;

public class Exercise2 {
    
    public static void main(String args[]) {
        
        Hotel holidayInn = new Hotel("Holiday Inn");
        Hotel marriott = new Hotel("Marriott");
      
        // Create hotel floor plans
        createHotelFloorPlan(holidayInn, 3, 4, 5, 1);
        createHotelFloorPlan(marriott, 7, 5, 8, 2);
        
        // Wait for checkins
        promptForHotels(holidayInn, marriott);
        Scanner input = new Scanner(System.in);
        int userChoice = 0;
        while (userChoice != 4) {
            userChoice = input.nextInt();
            if (userChoice >= 1 || userChoice <= 4) {
                if (userChoice == 1) {
                    processCheckins(holidayInn);
                } else if (userChoice == 2) {
                    processCheckins(marriott);
                } else if (userChoice == 3) {
                    holidayInn.displayHotelInfo();
                    marriott.displayHotelInfo();
                } else {
                    System.out.println("System quitting");
                    return;
                }
            }
            promptForHotels(holidayInn, marriott);
        }
    }
    
    private static void processCheckins(Hotel h) {
        Scanner input = new Scanner(System.in);
        ArrayList<Guest> guests = new ArrayList<>();
        
        // Prompt
        System.out.print("\nCheck in for " + h.getName());
        System.out.print("\nEnter Room Number: ");
        int roomNumber = input.nextInt();
        System.out.print("Enter Number of Guests: ");
        int numGuests = input.nextInt();
        for (int gNum = 1; gNum <= numGuests; gNum++) {
            System.out.println("Enter guests " + gNum + " name and age...");
            System.out.print("Guest Name: ");
            String name = input.next();
            System.out.print("Guest Age: ");
            int age = input.nextInt();
        
            guests.add(new Guest(name, age));
        }
        h.checkin(roomNumber, guests);
    }
    
    private static void promptForHotels(Hotel h1, Hotel h2) {
        System.out.println("\nSelect the hotel you wish to manage:");
        System.out.println("[1] " + h1.getName());
        System.out.println("[2] " + h2.getName());
        System.out.println("[3] Show Hotel Status");
        System.out.println("[4] Quit the System");
    }
    
    private static void createHotelFloorPlan(Hotel h, int numFloors, 
        int singlesPerFloor, int doublesPerFloor, int suitesPerFloor) {
        if (h == null) {
            throw new IllegalArgumentException("Invalid Hotel");
        }
        
        // For each floor of the hotel
        for (int floor = 1; floor <= numFloors; ++floor) {
            
            int roomId = 0;
            // Create requested number of singles
            createRoom(h, floor, singlesPerFloor, RoomType.SINGLE, roomId);
            
            // Create requested number of 
            roomId += singlesPerFloor;
            createRoom(h, floor, doublesPerFloor, RoomType.DOUBLE, roomId);
            
            // Create requested number of 
            roomId += doublesPerFloor;
            createRoom(h, floor, suitesPerFloor, RoomType.SUITE, roomId);
        }
    }
    
    private static void createRoom(Hotel h, int floor, int roomsPerFloor, RoomType roomType, int roomId) {
        for (int roomNum = 1; roomNum <= roomsPerFloor; ++roomNum) {
            int roomNumberId = roomId + roomNum;
            if (roomType == RoomType.SUITE) {
                Room newRoom = new SuiteRoom(2, floor, roomNumberId);
                h.addRoom(newRoom);
            } else {
                Room newRoom = new StdRoom(2, floor, roomNumberId, roomType);
                h.addRoom(newRoom);
            }
            
        }
    }
}
