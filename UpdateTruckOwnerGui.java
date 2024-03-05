import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateTruckOwnerGui extends JFrame {
    JButton b1, b2, b3;
    JLabel l1, l2, l3; 
    JTextField t1, t2; 
    JPanel mainPanel, topPanel, centerPanel, bottomPanel;

UpdateTruckOwnerGui() {
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Upadating Owner Name");
        setLayout(new BorderLayout());

        l1 = new JLabel("Enter License Plate Number:");
        l2 = new JLabel("Upadating Owner Name");
        l3 = new JLabel("Enter Name to Update"); 
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l2.setHorizontalAlignment(SwingConstants.CENTER);

        t1 = new JTextField();
        t2 = new JTextField(); 

        b1 = new JButton("Submit");
        b2 = new JButton("Cancel");
        b3 = new JButton("Home");

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Color textColor = Color.WHITE;

        JButton[] buttons = {b1, b2, b3};
        for (int i =0;i<buttons.length;i++) {
            buttons[i].setFont(buttonFont);
            buttons[i].setForeground(textColor);
        }

        mainPanel = new JPanel(new BorderLayout());
        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel = new JPanel(new GridLayout(3, 1, 10, 10)); 
        bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        topPanel.add(l2);

        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPanel.add(l1);
        centerPanel.add(t1);
        centerPanel.add(l3); 
        centerPanel.add(t2); 

        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        bottomPanel.add(b1);
        bottomPanel.add(b2);
        bottomPanel.add(b3);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        b1.setBackground(Color.DARK_GRAY);
        b2.setBackground(Color.RED);
        b3.setBackground(Color.blue);

        MyActionListener a = new MyActionListener();
          for (int i =0;i<buttons.length;i++) {
            buttons[i].addActionListener(a);
          }

        add(mainPanel);
        setLocationRelativeTo(null); // center frame
        setVisible(true);
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("Submit")) {
                    Truck.updateOwnerName(t2.getText(), t1.getText());
            
                    JOptionPane.showMessageDialog(null, "Car Owner updated");
               
            } 
            else if (ae.getActionCommand().equalsIgnoreCase("Home")) {
                dispose();
                new HomeGui();
            }
             else if (ae.getActionCommand().equalsIgnoreCase("Cancel")) {
                System.exit(0);
            }
        }
    

    public static void main(String[] args) {
        new DeleteTruckGui();
    }
}
}
