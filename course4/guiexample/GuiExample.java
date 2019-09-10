import javax.swing.*;
import java.awt.*;

public class GuiExample extends JFrame {
  public GuiExample () {
    this ("one");
  } // end no parameter constructor

  public GuiExample (String t) {
    setTitle (t);
    setSize (200,200);
    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo (null);
    add (new JButton ("North " + t), BorderLayout.NORTH);
    add (new JButton ("East " + t), BorderLayout.EAST);
    add (new JButton ("West " + t), BorderLayout.WEST);
   
    validate ();
    pack ();
    setVisible (true);
  } // end String constructor

  public static void main (String args []) {
    GuiExample ga = new GuiExample ();
    GuiExample gb = new GuiExample ("two");
  } // end main

} // end class GuiExample