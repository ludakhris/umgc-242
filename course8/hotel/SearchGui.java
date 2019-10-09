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

public class SearchGui extends JFrame {

    private Hotel hotel;
    private JTextField searchValue;
    private ArrayList<JTextField> guestNameFields = new ArrayList<>();

    public SearchGui(Hotel hotel) {
        super();

        setTitle ("Search " + hotel.getName());
        setSize (200,200);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
        this.hotel = hotel;

        searchValue = new JTextField("");
    
        // Form section
        final JPanel compsToExperiment = new JPanel();
        compsToExperiment.setLayout(new GridLayout(0, 2));
        compsToExperiment.add(new Label("Enter Guest Name"));
        compsToExperiment.add(searchValue);
        JButton submitButton = new JButton("Search ");
        compsToExperiment.add(submitButton);
    
        add(compsToExperiment, BorderLayout.CENTER);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String guestName = searchValue.getText();
                int roomNumber = hotel.findRoomNumber(guestName);
                if (roomNumber == -1) {
                    JOptionPane.showMessageDialog(null, "Guest Not Found: " + guestName);
                } else {
                    JOptionPane.showMessageDialog(null, "Guest Room Number: " + roomNumber); 
                }
            }
        });

        pack();
        setVisible(true);
    }
}