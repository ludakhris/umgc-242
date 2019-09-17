
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelGui extends JFrame {

  private static final long serialVersionUID = 1L;
  private JTextField resultTxt;
  private JButton hotelAButton;
  private JButton hotelBButton;
  private JButton balanceButton;

  private AdvancedHotel a;
  private AdvancedHotel b;

  private JFrame hotelADisplay;
  private JFrame hotelBDisplay;

  public HotelGui (String t, AdvancedHotel hotelA, AdvancedHotel hotelB) {
    setTitle (t);
    setSize (200,200);
    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo (null);

    this.a = hotelA;
    this.b = hotelB;

    hotelAButton = new JButton ("Do check-in for: " + hotelA.getHotelName());
    add (hotelAButton, BorderLayout.WEST);
    hotelBButton = new JButton ("Do check-in for: " + hotelB.getHotelName());
    add (hotelBButton, BorderLayout.EAST);
    balanceButton = new JButton ("Get Hotel Capacities");
    add (balanceButton, BorderLayout.NORTH);
    resultTxt = new JTextField("");
    resultTxt.setEditable(false);
    add (resultTxt, BorderLayout.CENTER);

    // Action for balance button
    balanceButton.addActionListener(
      new ActionListener(){ 
        public void actionPerformed(ActionEvent e){
          createOutput(resultTxt, a, b);
        }
      }
    );

    // Action for check-in buttons
    hotelAButton.addActionListener(
      new ActionListener(){ 
        public void actionPerformed(ActionEvent e){
          new CheckinGui(a);
        }
      }
    );
    hotelBButton.addActionListener(
      new ActionListener(){ 
        public void actionPerformed(ActionEvent e){
          new CheckinGui(b);
        }
      }
    );

    createOutput(resultTxt, hotelA, hotelB);
   
    validate ();
    pack ();
    setVisible (true);
  } // end String constructor

  private void createOutput(JTextField resultTxt, AdvancedHotel hotelA, AdvancedHotel hotelB) {
    String newOutput = String.format("The %s hotel, room capacity %d out of %d\n The %s hotel, room capacity %d out of %d\n", 
      hotelA.getHotelName(), hotelA.getNumRoomsOccupied(), hotelA.getMaxRooms(),
      hotelB.getHotelName(), hotelB.getNumRoomsOccupied(), hotelB.getMaxRooms()
    );

    resultTxt.setText(newOutput);

    if (hotelADisplay != null) {
      hotelADisplay.setVisible(false);
    }
    hotelADisplay = new HotelDisplayGui(hotelA);

    if (hotelBDisplay != null) {
      hotelBDisplay.setVisible(false);
    }
    hotelBDisplay = new HotelDisplayGui(hotelB);
  }
} // end class