import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddVehiclegui extends JFrame {
    JButton button1, button2, button3, button4, button5;
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3, t4, t5;
    JPanel p1, p2, p3;

    AddVehiclegui() {
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Add Vehicle");

        setLayout(new BorderLayout());

        l1 = new JLabel("License Plate:");
        l2 = new JLabel("Owner Name:");
        l3 = new JLabel("Type:");
        l4 = new JLabel("Vehicle Name:");
        l5 = new JLabel("Arrival Time:");
        l6 = new JLabel("Vehicle Information");
        l6.setFont(new Font("Arial", Font.BOLD, 20));
        l6.setHorizontalAlignment(SwingConstants.CENTER);

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();

        button1 = new JButton("Add to car");
        button2 = new JButton("Add to bike");
        button3 = new JButton("Add to truck");
        button4 = new JButton("Cancel");
        button5 = new JButton("Home");

        p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(l6);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(5, 2, 10, 10));
        p1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(l3);
        p1.add(t3);
        p1.add(l4);
        p1.add(t4);
        p1.add(l5);
        p1.add(t5);

        p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
       
        p3.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // adjusting
        p3.add(button1);
        p3.add(button2);
        p3.add(button3);
        p3.add(button4);
        p3.add(button5);

          // Styling the buttons
          Font buttonFont = new Font("Arial", Font.PLAIN, 16);
          Color buttonColor = new Color(70, 130, 180); // Custom color (Steel Blue)
          Color textColor = Color.WHITE;
          
          //button size
          Dimension buttonSize = new Dimension(150, 40);  
         
  
          // styling
          JButton[] buttons = {button1,button2,button3,button4,button5};
          for (int i = 0; i < buttons.length; i++) {
              JButton button = buttons[i];
              button.setFont(buttonFont);
              button.setBackground(buttonColor);
              button.setForeground(textColor);
              button.setPreferredSize(buttonSize);

          }

        add(p2, BorderLayout.NORTH);
        add(p1, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
        MyActionListener a = new MyActionListener();
        button1.addActionListener(a);
        button2.addActionListener(a);
        button3.addActionListener(a);
        button4.addActionListener(a);
        button5.addActionListener(a);
        button1.setBackground(Color.DARK_GRAY );
        button2.setBackground(Color.DARK_GRAY );
        button3.setBackground(Color.DARK_GRAY );
       
       
        
          pack();
        setVisible(true);
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("Add to car")) {
                double arrivalTime = Double.parseDouble(t5.getText());
                Car c1 = new Car(t1.getText(), t2.getText(), t3.getText(), t4.getText(), arrivalTime);
                Car.writeToFile(c1);
               
                 
                  
                
                JOptionPane.showMessageDialog(null, "Car Added");
            } else if (ae.getActionCommand().equalsIgnoreCase("Add to Bike")) {
                double arrivalTime = Double.parseDouble(t5.getText());
                Bike bi1 = new Bike(t1.getText(), t2.getText(), t3.getText(), t4.getText(), arrivalTime);
                Bike.writeToFile(bi1);
                JOptionPane.showMessageDialog(null, "Bike Added");
            } else if (ae.getActionCommand().equalsIgnoreCase("Add to Truck")) {
                double arrivalTime = Double.parseDouble(t5.getText());
                Truck tr1 = new Truck(t1.getText(), t2.getText(), t3.getText(), t4.getText(), arrivalTime);
                Truck.writeToFile(tr1);
                JOptionPane.showMessageDialog(null, "Truck Added");
            }

            else if (ae.getActionCommand().equalsIgnoreCase("Home")) {
                dispose();
                new HomeGui();
            } else if (ae.getActionCommand().equalsIgnoreCase("Cancel")) {
                System.exit(0);
            }

        }

    }

    public static void main(String[] args) {
        new AddVehiclegui();
       
    }

}
