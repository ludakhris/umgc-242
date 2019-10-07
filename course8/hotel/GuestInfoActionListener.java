import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class GuestInfoActionListener implements ActionListener {

    private Hotel hotel;
    public GuestInfoActionListener(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StringBuilder buffer = new StringBuilder();
        for (Room r : hotel.getRoomInfo()) {
            String detailMsg = String.format("Room Num: %d - Guests: %s\n", 
                r.getRoomNumber(), r.getGuests());
                buffer.append(detailMsg);
        }
        
        JOptionPane.showMessageDialog(null, buffer.toString());
    }

}