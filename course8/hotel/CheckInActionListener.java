import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class CheckInActionListener implements ActionListener {

    private Hotel hotel;
    private JTextArea textArea;
    public CheckInActionListener(Hotel hotel, JTextArea textArea) {
        this.hotel = hotel;
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            new CheckInGui(hotel, textArea);   
    }

}