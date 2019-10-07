import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import javafx.scene.paint.Color;

public class RoomDisplayUI extends JFrame {

    RoomDisplayUI(Hotel a){
        super();

        setTitle (a.getName() + " Layout");
        setSize (500,500);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        // Second panel for output
        JPanel output = new JPanel();
        output.setLayout(new GridLayout(0,5));

        // Add rooms to panel
        for (Room r : a.getRoomInfo()) {
            JButton roomButton = new JButton(Integer.toString(r.getRoomNumber()));
            if (!r.getGuests().isEmpty()) {
                roomButton.setText("X");
                roomButton.addActionListener(new RoomDetailsListener(r));
            }
            output.add(roomButton);
        }

        // Add content to JFRAME
        add(output, BorderLayout.CENTER);
        
        pack();
        setVisible(true);
    }
}