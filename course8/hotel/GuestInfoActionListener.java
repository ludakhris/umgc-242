package hotel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GuestInfoActionListener implements ActionListener {

    private Hotel hotel;

    public GuestInfoActionListener(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StringBuilder buffer = new StringBuilder();
        for (Room r : hotel.getRoomInfo()) {
            String detailMsg = String.format("Room Num: %d - Guests: %s\n", r.getRoomNumber(), r.getGuests());
            buffer.append(detailMsg);
        }

        JTextArea textArea = new JTextArea(buffer.toString());
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setPreferredSize(new Dimension(500, 500));

        JOptionPane.showMessageDialog(null, scrollPane, 
            "Hotel Details", JOptionPane.QUESTION_MESSAGE);

    }

}