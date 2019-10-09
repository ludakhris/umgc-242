package hotel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CheckInGui extends JFrame {

    private Hotel hotel;
    private JTextField roomNumberField;
    private ArrayList<JTextField> guestNameFields = new ArrayList<>();

    public CheckInGui(Hotel hotel, JTextArea textArea) {
        super();

        setTitle ("Check for " + hotel.getName());
        setSize (500,500);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
        this.hotel = hotel;

        roomNumberField = new JTextField("");
    
        // Form section
        final JPanel compsToExperiment = new JPanel();
        compsToExperiment.setLayout(new GridLayout(0, 2));
        compsToExperiment.add(new Label("Room Number:"));
        compsToExperiment.add(roomNumberField);

        compsToExperiment.add(new Label("Guest 1:"));
        JTextField guestNameField = new JTextField("");
        compsToExperiment.add(guestNameField);
        guestNameFields.add(guestNameField);
    
        // Add controls
        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(1, 2));
        JButton checkinButton = new JButton("Process check-in for: " + hotel.getName());
        JButton addGuestButton = new JButton("Add Additional Guest");
        controls.add(addGuestButton);
        controls.add(checkinButton);

        addGuestButton.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    // generate new text field
                    int guestNum = guestNameFields.size() + 1;
                    compsToExperiment.add(new Label("Guest " + guestNum + ":"));
                    JTextField guestNameField = new JTextField("");
                    compsToExperiment.add(guestNameField);
                    guestNameFields.add(guestNameField);
                    pack();
                }
            }
        );

        checkinButton.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Check 1 - Validate the room number
                    int roomNumber;
                    try {
                        roomNumber = Integer.parseInt(roomNumberField.getText());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Enter a number dummy");
                        return;
                    }

                    // Check 2 - Check that all the guest names are not empty
                    ArrayList<String> guestNames = new ArrayList<>();
                    for (JTextField field : guestNameFields) {
                        String value = field.getText();
                        if (value == null || value.length() == 0) {
                            JOptionPane.showMessageDialog(null, "Enter guest name dummy");
                            return;
                        }
                        guestNames.add(value);
                    }

                    // If all of the above are valid 
                    try {
                        hotel.checkIn(roomNumber, guestNames);
                        HotelGui.createOutput(hotel, textArea);

                        // Close the new check in UI
                        JOptionPane.showMessageDialog(null, "Guests added to room: " + roomNumber);
                        setVisible(false);

                    } catch (HotelFullException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        return;
                    }
                }
            }
        );
    
        add(compsToExperiment, BorderLayout.NORTH);
        add(new JSeparator(), BorderLayout.CENTER);
        add(controls, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }
}