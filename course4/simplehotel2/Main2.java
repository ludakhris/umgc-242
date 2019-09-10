import java.util.*;

public class Main2 {
    
    public static void main(String args[]) {
        
        SimpleHotel2 holidayInn = new SimpleHotel2("Holiday Inn", 15);
        SimpleHotel2 marriott = new SimpleHotel2("Marriott", 90);

        HotelGui ga = new HotelGui ("Hotel Management System", holidayInn, marriott);
    
        System.out.printf("\nNumber of Holiday Inn Guests: %d \n", holidayInn.getNumberGuests());
        System.out.printf("Number of Marriott Guests: %d \n", marriott.getNumberGuests());
    }
}
