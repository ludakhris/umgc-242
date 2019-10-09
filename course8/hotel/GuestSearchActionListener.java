package hotel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class GuestSearchActionListener implements ActionListener {

    private Hotel hotel;
    public GuestSearchActionListener(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new SearchGui(hotel);   
    }

}