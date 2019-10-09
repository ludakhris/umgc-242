package hotel;

public class Main {

    public static void main(String[] args) {
        Hotel a = new Hotel("Marriott", 1, 99);
        Hotel b = new Hotel("Hampton Inn", 50, 50);
        
        new HotelGui(a, b);
    }
}