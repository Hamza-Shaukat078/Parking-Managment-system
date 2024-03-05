import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UtilitiesGui extends JFrame {
    JLabel titleLabel;
    JButton b1, b2, b3, b4, b5, b6,b7,b8;

    UtilitiesGui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Utilities");

       
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(8, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add some padding

        JPanel buttonPane2 = new JPanel();
        buttonPane2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        buttonPane2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Fonting
        titleLabel = new JLabel("Parking Monitoring System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Color buttonColor = new Color(70, 130, 180); 
        Color textColor = Color.WHITE;

        b1 = new JButton("Display Total Numbers of Cars");
        b2 = new JButton("Display Total Numbers of Bikes");
        b3 = new JButton("Display Total Numbers of Trucks");
        b4 = new JButton("Checking availability of spots");
        b5 = new JButton("Home");
        b6 = new JButton("Cancel");
        b7 = new JButton("Total Fess Of The Day");
        b8 = new JButton("Delete Total Fess file");
        JButton[] buttons = {b1, b2, b3,b4,b5,b6,b7,b8 };
       
      
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBackground(buttonColor);
             buttons[i].setFont(buttonFont);
             buttons[i].setForeground(textColor);
              buttons[i].setFocusPainted(false); 
        }

        b5.setBackground(Color.BLUE);
        b6.setBackground(Color.RED);
      b5.setForeground(Color.WHITE);
        b6.setForeground(Color.white);


        // Adding components to the frame
        add(titleLabel, BorderLayout.NORTH);
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);
        buttonPanel.add(b7);
        buttonPanel.add(b8);
        buttonPane2.add(b5);
        buttonPane2.add(b6);


        add(buttonPanel, BorderLayout.CENTER);
        add(buttonPane2, BorderLayout.SOUTH); 

        MyActionListener actionListener = new MyActionListener();
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(actionListener);
        }
       
        pack();
        setLocationRelativeTo(null); // Center frame
        setVisible(true);
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("Display Total Numbers of Cars")) {
               int TotalCars= ParkingSpot.numberOfCarsParked();
              
               JOptionPane.showMessageDialog(null,"Total numbers of Car Parked are :"+String.valueOf(TotalCars)+".");
            } else if (ae.getActionCommand().equalsIgnoreCase("Display Total Numbers of Bikes")) {
                int TotalBikes= ParkingSpot.numberOfBikesParked();
              
               JOptionPane.showMessageDialog(null,"Total numbers of Bikes Parked are :"+String.valueOf(TotalBikes)+".");
            } else if (ae.getActionCommand().equalsIgnoreCase("Display Total Numbers of Trucks")) {
               int TotalTrucks= ParkingSpot.numberOfTruckParked();
              
               JOptionPane.showMessageDialog(null,"Total numbers of Trucks Parked are :"+String.valueOf(TotalTrucks)+".");
            } else if (ae.getActionCommand().equalsIgnoreCase("Checking availability of spots")) {
                ParkingSpot.FillingSpots();
              int TotalSpots= ParkingSpot.isSpotEmpty();
              
               JOptionPane.showMessageDialog(null,"Number of spots available  :"+String.valueOf(TotalSpots)+".");
            } 
            else if (ae.getActionCommand().equalsIgnoreCase("Home")) {
                dispose();
                new HomeGui();
            } else if (ae.getActionCommand().equalsIgnoreCase("Cancel")) {
                System.exit(0);
            }
            else if (ae.getActionCommand().equalsIgnoreCase("Total Fess Of The Day")) {
                JOptionPane.showMessageDialog(null,"Total Fess of the day is :"+String.valueOf(ParkingSpot.calculateGrandTotal())+".");
            }
            else if (ae.getActionCommand().equalsIgnoreCase("Delete Total Fess file")) {
                ParkingSpot.deleteHistoryFile("totalbills.txt");
                JOptionPane.showMessageDialog(null,"File Deleted sucessfully .");
            }

        }
    }

    public static void main(String[] args) {
        new UtilitiesGui();
    }
}
