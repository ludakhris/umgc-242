package hotel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class RoomDetailsListener implements ActionListener {

    private Room r;
    public RoomDetailsListener(Room r) {
        this.r = r;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String detailMsg = String.format("Room Num: %d\n Guests: %s", r.getRoomNumber(), r.getGuests());
        JOptionPane.showMessageDialog(null, detailMsg);
        return;  
    }

}