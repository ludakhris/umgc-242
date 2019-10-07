public class Main {

    public static void main(String[] args) {
        Hotel a = new Hotel("Marriott", 10);
        Hotel b = new Hotel("Hampton Inn", 5);
        
        new HotelGui(a, b);
    }
}