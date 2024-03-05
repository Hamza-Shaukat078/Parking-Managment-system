import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGui extends JFrame {
    JButton loginButton, cancelButton;
    JLabel l3, l2, l1;
    JTextField t1, t2;
    JPanel p1, p2, p3, backgroundPanel;
    String password = "123";

    LoginGui() {
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("User Login");

        // Create a new JPanel for the background
        backgroundPanel = new BackgroundPanel("back.jpg");
        setContentPane(backgroundPanel);

        setLayout(new BorderLayout());

        l1 = new JLabel("USER LOGIN");
        l1.setFont(new Font("Arial", Font.BOLD, 30));
        l1.setForeground(Color.WHITE);
        l1.setHorizontalAlignment(SwingConstants.CENTER);

        t1 = new JTextField();
        t2 = new JPasswordField(); // Using JPasswordField 
        l2 = new JLabel("Name");
        l2.setForeground(Color.white);
        l3 = new JLabel("Password");
         l3.setForeground(Color.white);

        loginButton = new JButton("Login");
        cancelButton = new JButton("Cancel");

        p1 = new JPanel();
        p1.setOpaque(false); // this make panel transparent
        p1.setLayout(new FlowLayout());
        p1.add(l1);

        p2 = new JPanel();
        p2.setOpaque(false); // Make panel transparent
        p2.setLayout(new GridLayout(2, 2, 10, 10));
        p2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        p2.add(l2);
        p2.add(t1);
        p2.add(l3);
        p2.add(t2);

        p3 = new JPanel();
        p3.setOpaque(false); 
        p3.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        p3.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        p3.add(loginButton);
        p3.add(cancelButton);

        // Styling the buttons
        Font buttonFont = new Font("Arial", Font.PLAIN, 18);
        Color buttonColor = new Color(70, 130, 180);
        Color textColor = Color.WHITE;

        // button size
        Dimension buttonSize = new Dimension(150, 40);

        // adding style to burrons
        JButton[] buttons = { loginButton, cancelButton };
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBackground(buttonColor);
             buttons[i].setFont(buttonFont);
             buttons[i].setForeground(textColor);
              buttons[i].setFocusPainted(false); 
              buttons[i].setSize(buttonSize);
        }

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);

        MyActionListener actionListener = new MyActionListener();
        loginButton.addActionListener(actionListener);
        cancelButton.addActionListener(actionListener);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equalsIgnoreCase("Login")) {
                if (String.valueOf(t2.getText()).equals(password)) {
                    JOptionPane.showMessageDialog(null, "Login successful. Welcome " + t1.getText());
                    dispose();
                    new HomeGui();
                } else {
                    JOptionPane.showMessageDialog(null, "Your password is incorrect");
                }
            } else if (ae.getActionCommand().equalsIgnoreCase("Cancel")) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new LoginGui();
    }
}
