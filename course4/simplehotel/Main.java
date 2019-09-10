import java.util.*;

public class Main {
    
    public static void main(String args[]) {
        
        SimpleHotel holidayInn = new SimpleHotel("Holiday Inn", 15);
        SimpleHotel marriott = new SimpleHotel("Marriott", 90);

        try {
            for (int i = 0; i < 20; i++) {
                holidayInn.addGuest();
            }
        } catch (HotelFullException e) {
            System.err.println(e.getMessage());
        }

        System.out.printf("\nNumber of Holiday Inn Guests: %d \n", holidayInn.getNumberGuests());
        System.out.printf("Number of Marriott Guests: %d \n", marriott.getNumberGuests());
    }
}
