
public class HotelAdvancedMain {
    
    public static void main(String args[]) {
        
        AdvancedHotel holidayInn = new AdvancedHotel("Holiday Inn", 3, 5);
        AdvancedHotel marriott = new AdvancedHotel("Marriott", 5, 10);

        new HotelGui ("Hotel Management System", holidayInn, marriott);
    
        System.out.printf("\nNumber of Holiday Inn Guests: %d \n", holidayInn.getNumRoomsOccupied());
        System.out.printf("Number of Marriott Guests: %d \n", marriott.getNumRoomsOccupied());
    }
}
