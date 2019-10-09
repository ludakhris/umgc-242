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

public class CheckOutGui extends JFrame {

    private Hotel hotel;
    private JTextField roomNumberField;

    public CheckOutGui(Hotel hotel, JTextArea textArea) {
        super();

        setTitle ("Check Out for " + hotel.getName());
        setSize (500,500);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
        this.hotel = hotel;

        roomNumberField = new JTextField("");
    
        // Form section
        final JPanel compsToExperiment = new JPanel();
        compsToExperiment.setLayout(new GridLayout(0, 1));
        compsToExperiment.add(new Label("Room Number:"));
        compsToExperiment.add(roomNumberField);

    
        // Add controls
        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(1, 2));
        JButton checkoutButton = new JButton("Process check-out for: " + hotel.getName());
        controls.add(checkoutButton);

        checkoutButton.addActionListener(
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

                    // If all of the above are valid 
                    try {
                        hotel.checkOut(roomNumber);
                        HotelGui.createOutput(hotel, textArea);

                        // Close the new check in UI
                        JOptionPane.showMessageDialog(null, "Check out of room complete:" + roomNumber);
                        setVisible(false);

                    } catch (HotelEmptyException ex) {
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