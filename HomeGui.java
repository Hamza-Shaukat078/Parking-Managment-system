import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HomeGui extends JFrame {
    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6;
    JPanel backgroundPanel;

    HomeGui() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Parking Monitoring System");
      
        // Making a panel for buttons and setting its layout
        JPanel buttonPanel = new JPanel();
       
        buttonPanel.setLayout(new GridLayout(3, 2, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add some padding

        // fonting
        l1 = new JLabel("Parking Monitoring System");
        l1.setFont(new Font("Arial", Font.BOLD, 24));
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setBackground(Color.BLACK);
        l1.setForeground(Color.BLACK);

        b1 = new JButton("Add a Vehicle");
        b2 = new JButton("Display All Vehicles");
        b3 = new JButton("Delete a Vehicle");
        b4 = new JButton("Search a Vehicle");
        b5 = new JButton("Update a Vehicle");
        b6 = new JButton("Other Utility Options");

        // Styling the buttons
        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Color buttonColor = new Color(70, 130, 180);
        Color textColor = Color.WHITE;

      

        // button size
        Dimension buttonSize = new Dimension(250, 40);

        // styling 
        JButton[] buttons = { b1, b2, b3, b4, b5, b6 };
        for (int i = 0; i < buttons.length; i++) {
            JButton button = buttons[i];
            button.setFont(buttonFont);
            button.setBackground(buttonColor);
            button.setForeground(textColor);
            button.setPreferredSize(buttonSize);
        }

        // Adding
        add(l1, BorderLayout.NORTH);
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);
        buttonPanel.add(b5);
        buttonPanel.add(b6);
        add(buttonPanel, BorderLayout.CENTER);

        MyActionListener a = new MyActionListener();

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(a);
        }
        pack();
        setLocationRelativeTo(null); // center frame
        setVisible(true);
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("Add a Vehicle")) {
                dispose();
                new AddVehiclegui();

            } else if (ae.getActionCommand().equalsIgnoreCase("Display All Vehicles")) {
                JFrame f = new JFrame("Displaying Vehicles");
                f.setSize(600, 600); // it sets the frame size
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                String[] columns = { "License Plate", "Type", "Owner", "Vehicle Name", "Time" };
                ParkingSpot.FillingSpots();

                Object[][] data = new Object[ParkingSpot.vehicles.size()][5];

                for (int i = 0; i < ParkingSpot.vehicles.size(); i++) {
                    data[i][0] = ParkingSpot.vehicles.get(i).getLicensePlate();
                    data[i][1] = ParkingSpot.vehicles.get(i).getType();
                    data[i][2] = ParkingSpot.vehicles.get(i).getOwner();
                    data[i][3] = ParkingSpot.vehicles.get(i).getVehicleName();
                    data[i][4] = ParkingSpot.vehicles.get(i).getArrivaltime();

                }

                JTable jt = new JTable(data, columns);

                JScrollPane sp = new JScrollPane(jt);
                f.add(sp);

                f.setVisible(true);
            }

            else if (ae.getActionCommand().equalsIgnoreCase("Delete a Vehicle")) {
                dispose();
                new DeleteAVehicle1gui();

            } else if (ae.getActionCommand().equalsIgnoreCase("Search a Vehicle")) {
                dispose();
                new SearchVehicleGui();

            } else if (ae.getActionCommand().equalsIgnoreCase("Update a Vehicle")) {
                dispose();
                new UpdateVehicleGui();

            }
            else if (ae.getActionCommand().equalsIgnoreCase("Other Utility Options")) {
                dispose();
                new UtilitiesGui();

            }

        }

    }

    public static void main(String[] args) {
        new HomeGui();
    }

}