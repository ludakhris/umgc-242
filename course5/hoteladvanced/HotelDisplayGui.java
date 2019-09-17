
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelDisplayGui extends JFrame {

  private static final long serialVersionUID = 1L;

  private AdvancedHotel hotel;

  public HotelDisplayGui (AdvancedHotel hotel) {
    setTitle ("Room Display for " + hotel.getHotelName());
    setSize (600,600);
    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo (null);

    this.hotel = hotel;

    final JPanel compsToExperiment = new JPanel();
    compsToExperiment.setLayout(new GridLayout(hotel.getNumFloor(), hotel.getNumRooms()));
    Room[][] rooms = hotel.getRooms();
    for (int i = 0; i < hotel.getNumFloor(); i++) {
      for (int j = 0; j < hotel.getNumRooms(); j++) {
        JButton button = constructDetailsButton(i, j, rooms);
        compsToExperiment.add(
          button);
      }
    }

    add(compsToExperiment, BorderLayout.NORTH);
    setVisible(true);
  }

  private JButton constructDetailsButton(int i, int j, Room[][] rooms) {
    String desc;
    String roomDesc = null;
    try {
      Room r = rooms[i][j];
      if (r.getGuests().isEmpty()) {
        desc = Integer.toString(r.getRoomNumber());
      } else {
        desc = "X";
        roomDesc = String.format("Room: %d\n Guests: %s", r.getRoomNumber(), r.getGuests());
      }
    } catch (NullPointerException | java.lang.ArrayIndexOutOfBoundsException e) {
      desc = "Error";
     // roomDesc = null;
    }

    JButton button = new JButton(desc);
    if (roomDesc != null) {
      final String d = roomDesc;
      button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

          JOptionPane.showMessageDialog(null, d);
        }
      });
    }

    return button;
  }
} // end class