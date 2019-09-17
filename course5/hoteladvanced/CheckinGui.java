
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CheckinGui extends JFrame {

  private static final long serialVersionUID = 1L;
  private ArrayList<JTextField> guestNameFields = new ArrayList<>();
  private JTextField roomNumberField;
  private JButton checkinButton;
  private JButton addGuestButton;

  private AdvancedHotel hotel;
  private Window windowRef = this;

  public CheckinGui(AdvancedHotel hotel) {
    setTitle("Check-in form for " + hotel.getHotelName());
    setSize(400, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    this.hotel = hotel;

    roomNumberField = new JTextField("");

    // Form section
    final JPanel compsToExperiment = new JPanel();
    compsToExperiment.setLayout(new GridLayout(0, 2));
    compsToExperiment.add(new Label("Room Number:"));
    compsToExperiment.add(roomNumberField);
    constructGuestField(compsToExperiment);

    // Add controls
    JPanel controls = new JPanel();
    controls.setLayout(new GridLayout(1, 2));
    this.checkinButton = new JButton("Process check-in for: " + hotel.getHotelName());
    this.addGuestButton = new JButton("Add Additional Guest");
    controls.add(addGuestButton);
    controls.add(checkinButton);

    add(compsToExperiment, BorderLayout.NORTH);
    add(new JSeparator(), BorderLayout.CENTER);
    add(controls, BorderLayout.SOUTH);

    // Action for add guest button
    addGuestButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        constructGuestField(compsToExperiment);
        validate();
        pack();
      }
    });

    // Action for check-in buttons
    checkinButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          ArrayList<String> guestList = new ArrayList<>();
          for (JTextField field : guestNameFields) {
            guestList.add(field.getText());
          }
          hotel.addGuest(guestList, Integer.parseInt(roomNumberField.getText()));
          setVisible(false);
        } catch (HotelFullException ex) {
          System.err.println(ex.getMessage());
          JOptionPane.showMessageDialog(null, ex.getMessage());
        }
      }
    });

    validate();
    pack();
    setVisible(true);
  } // end String constructor

  private void constructGuestField(JPanel panel) {
    int guestNum = guestNameFields.size() + 1;
    panel.add(new Label("Guest " + guestNum + " Name:"));
    JTextField guestNameField = new JTextField("");
    guestNameFields.add(guestNameField);
    panel.add(guestNameField);
  }
} // end class