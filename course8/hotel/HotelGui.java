import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class HotelGui extends JFrame {

    HotelGui(Hotel a, Hotel b){
        super();

        setTitle ("Hotel Management System");
        setSize (500,500);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        // Create panel for the north
        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(3,2));
        JButton hotelACheckinButton = new JButton("Check-In for " + a.getName());
        controls.add(hotelACheckinButton);
        JButton hotelBCheckinButton = new JButton("Check-In for " + b.getName());
        controls.add(hotelBCheckinButton);
        JButton hotelACheckoutButton = new JButton("Check-Out for " + a.getName());
        controls.add(hotelACheckoutButton);
        JButton hotelBCheckoutButton = new JButton("Check-Out for " + b.getName());
        controls.add(hotelBCheckoutButton);

        JButton hotelAGuests = new JButton("Get All Guest Info " + a.getName());
        controls.add(hotelAGuests);
        JButton hotelBGuests = new JButton("Get All Guest Info " + b.getName());
        controls.add(hotelBGuests);

        hotelAGuests.addActionListener(new GuestInfoActionListener(a));
        hotelBGuests.addActionListener(new GuestInfoActionListener(b));

        // Second panel for output
        JPanel output = new JPanel();
        output.setLayout(new GridLayout(1,2));
        JTextArea hotelAResults = new JTextArea("");
        output.add(hotelAResults);
        hotelAResults.setEditable(false);
        JTextArea hotelBResults = new JTextArea("");
        output.add(hotelBResults);
        hotelBResults.setEditable(false);

        // Define action listeners

        hotelACheckinButton.addActionListener(
            new CheckInActionListener(a, hotelAResults));
        hotelBCheckinButton.addActionListener(
            new CheckInActionListener(b, hotelBResults));
        hotelACheckoutButton.addActionListener(
            new CheckOutActionListener(a, hotelAResults));
        hotelBCheckoutButton.addActionListener(
            new CheckOutActionListener(b, hotelBResults));

        // Add content to JFRAME
        add(controls, BorderLayout.NORTH);
        add(new JSeparator(), BorderLayout.CENTER);
        add(output, BorderLayout.SOUTH);

        createOutput(a, hotelAResults);
        createOutput(b, hotelBResults);
        
        pack();
        setVisible(true);
    }

    public static void createOutput(Hotel hotel, JTextArea output) {

        output.setText(
            String.format("The %s hotel, room capacity %d out of %d", 
            hotel.getName(), hotel.getNumberRoomsOccupied(), hotel.getMaxRooms()));
    }
}