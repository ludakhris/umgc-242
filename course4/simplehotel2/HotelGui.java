
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelGui extends JFrame {

  private JTextField resultTxt;
  private JButton hotelAButton;
  private JButton hotelBButton;
  private JButton balanceButton;

  private SimpleHotel2 a;
  private SimpleHotel2 b;

  public HotelGui (String t, SimpleHotel2 hotelA, SimpleHotel2 hotelB) {
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
    add (resultTxt, BorderLayout.SOUTH);

    // Action for balance button
    balanceButton.addActionListener(
      new ActionListener(){ 
        public void actionPerformed(ActionEvent e){
          createOutput(resultTxt, a, b);
        }
      }
    );

    // Action for checkin buttons
    hotelAButton.addActionListener(
      new ActionListener(){ 
        public void actionPerformed(ActionEvent e){
          try {
            a.addGuest();
          } catch (HotelFullException ex) {
              System.err.println(ex.getMessage());
          }
        }
      }
    );
    hotelBButton.addActionListener(
      new ActionListener(){ 
        public void actionPerformed(ActionEvent e){
          try {
            b.addGuest();
          } catch (HotelFullException ex) {
              System.err.println(ex.getMessage());
          }
        }
      }
    );

    createOutput(resultTxt, hotelA, hotelB);
   
    validate ();
    pack ();
    setVisible (true);
  } // end String constructor

  private static void createOutput(JTextField resultTxt, SimpleHotel2 hotelA, SimpleHotel2 hotelB) {
    String newOutput = String.format("The %s hotel, room capacity %d out of %d\n The %s hotel, room capacity %d out of %d\n", 
      hotelA.getHotelName(), hotelA.getNumberGuests(), hotelA.getMaxGuests(),
      hotelB.getHotelName(), hotelB.getNumberGuests(), hotelB.getMaxGuests()
    );

    resultTxt.setText(newOutput);
  }
} // end class