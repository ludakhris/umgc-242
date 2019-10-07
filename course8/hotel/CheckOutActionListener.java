import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class CheckOutActionListener implements ActionListener {

    private Hotel hotel;
    private JTextArea textArea;
    public CheckOutActionListener(Hotel hotel, JTextArea textArea) {
        this.hotel = hotel;
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new CheckOutGui(hotel, textArea);
    }

}