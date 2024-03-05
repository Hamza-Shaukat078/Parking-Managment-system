
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateVehicleGui extends JFrame {
    JLabel l1;
    JButton b1, b2, b3,b4 ;

   UpdateVehicleGui() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Updating vehicle");

        // Creating a panel for buttons and setting its layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add some padding

        // Fonting
        l1 = new JLabel("Parking Monitoring");
        l1.setFont(new Font("Arial", Font.BOLD, 24));
        l1.setHorizontalAlignment(SwingConstants.CENTER);

      
       
        b1 = new JButton("Update a Car Owner");
        b2 = new JButton("Update a Truck Owner");
        b3 = new JButton("Update a Bike Owner");
        b4 = new JButton("Home");
       

        // Styling the buttons
        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Color buttonColor = new Color(70, 130, 180); 
        Color textColor = Color.WHITE;

        JButton[] buttons = {b1, b2, b3,b4 };
       
      
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
        
        add(buttonPanel, BorderLayout.CENTER);

        // ActionListener
       MyActionListener a = new MyActionListener();
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(a);
        }
      

        pack();
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("Update a Car Owner")) {
                dispose();
              new UpdateCarOwnerGui();
            } else if (ae.getActionCommand().equalsIgnoreCase("Update a Bike Owner")) {
                dispose();
           new UpdateBikeOwnerGui();
            } else if (ae.getActionCommand().equalsIgnoreCase("Update a Truck Owner")) {
                dispose();
               new UpdateTruckOwnerGui();
            }
            else if (ae.getActionCommand().equalsIgnoreCase("Home")) {
                dispose();
               new HomeGui();
            }
          
        }
    }

    public static void main(String[] args) {
       new UpdateVehicleGui();
    }
}
