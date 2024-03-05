import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteAVehicle1gui extends JFrame {
    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6,b7;

    DeleteAVehicle1gui() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Deleting a vehicle");

        // Creating a panel for buttons and setting its layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(7, 2, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Fonting
        l1 = new JLabel("Parking Monitoring System");
        l1.setFont(new Font("Arial", Font.BOLD, 24));
        l1.setHorizontalAlignment(SwingConstants.CENTER);

        b1 = new JButton("Delete a Car");
        b2 = new JButton("Delete a Truck");
        b3 = new JButton("Delete a Bike");
        b4 = new JButton("Delete all Bikes");
        b5 = new JButton("Delete all Cars");
        b6 = new JButton("Delete all Trucks");
        b7 = new JButton("Home");

        // Styling the buttons
        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Color buttonColor = new Color(70, 130, 180);
        Color textColor = Color.WHITE;

        JButton[] buttons = { b1, b2, b3, b4, b5, b6 ,b7};

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBackground(buttonColor);
            buttons[i].setFont(buttonFont);
            buttons[i].setForeground(textColor);
            buttons[i].setFocusPainted(false);
        }

        // Adding components to the frame
        add(l1, BorderLayout.NORTH);
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);
        buttonPanel.add(b5);
        buttonPanel.add(b6);
        buttonPanel.add(b7);
        b7.setBackground(Color.DARK_GRAY);

        add(buttonPanel, BorderLayout.CENTER);

        // ActionListener
        MyActionListener a = new MyActionListener();
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(a);
        }

        pack();
        setLocationRelativeTo(null); // Center frame
        setVisible(true);
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("Delete a Car")) {
                dispose();
                new DeleteCarGui();
            } else if (ae.getActionCommand().equalsIgnoreCase("Delete a Bike")) {
                dispose();
                new DeleteBikeGui();
            } else if (ae.getActionCommand().equalsIgnoreCase("Delete a Truck")) {
                dispose();
                new DeleteTruckGui();
               
            }
            else if (ae.getActionCommand().equalsIgnoreCase("Delete all Trucks")) {
                Truck.deleteFile("Trucks.ser");
                ParkingSpot.FillingSpots();
                JOptionPane.showMessageDialog(rootPane, "All trucks are deleted" );
            }
             else if (ae.getActionCommand().equalsIgnoreCase("Delete all Bikes")) {
                Truck.deleteFile("Bikes.ser");
                ParkingSpot.FillingSpots();
                JOptionPane.showMessageDialog(rootPane, "All Bikes are deleted" );
            }
             else if (ae.getActionCommand().equalsIgnoreCase("Delete all Cars")) {
                Truck.deleteFile("Cars.ser");
                ParkingSpot.FillingSpots();
                JOptionPane.showMessageDialog(rootPane, "All Cars are deleted" );
            }
            else if (ae.getActionCommand().equalsIgnoreCase("Home")) {
               dispose();
               new HomeGui();
            }

        }
    }

    public static void main(String[] args) {
        new DeleteAVehicle1gui();
    }
}
