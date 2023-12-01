package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JTextField textFieldUser;
    JPasswordField passwordFieldPass;
    JButton login;

    Login() {
        // Set frame
        setTitle("Employee Management System");
        setSize(900, 550);
        setLayout(new BorderLayout()); // Use BorderLayout
        setLocation(450, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create two panels
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        // Set background colors for the panels
        leftPanel.setBackground(Color.WHITE);
        rightPanel.setBackground(Color.WHITE);

        // Set the layout for the panels
        leftPanel.setLayout(new BorderLayout());
        rightPanel.setLayout(new BorderLayout());

        // Set preferred sizes for the panels
        leftPanel.setPreferredSize(new Dimension(getWidth() / 2, getHeight()));
        rightPanel.setPreferredSize(new Dimension(getWidth() / 2, getHeight()));

        // Add Login logo
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("Images/login.png"));
        Image image2 = image.getImage().getScaledInstance(400,300, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel imageLabel = new JLabel(image3);
        leftPanel.add(imageLabel, BorderLayout.CENTER);

        // Add login panel to the right panel
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);

        // Add heading
        JLabel heading = new JLabel("LOGIN");
        heading.setBounds(170, 30, 140, 60);
        heading.setFont(new Font("serif", Font.BOLD, 40));
        heading.setForeground(Color.blue);
        loginPanel.add(heading);

        // Username label
        JLabel username = new JLabel("Username");
        username.setBounds(70,130,100,20);
        username.setFont(new Font("serif", Font.BOLD,23));
        loginPanel.add(username);

        // Username text field
        textFieldUser = new JTextField();
        textFieldUser.setBounds(70, 170, 320, 35);
        textFieldUser.setFont(new Font("serif", Font.PLAIN, 23));
        loginPanel.add(textFieldUser);

        // Password label
        JLabel password = new JLabel("Password");
        password.setBounds(70, 250, 100, 20);
        password.setFont(new Font("serif", Font.BOLD,23));
        loginPanel.add(password);

        // Password text field
        passwordFieldPass = new JPasswordField();
        passwordFieldPass.setBounds(70, 290, 320, 35);
        passwordFieldPass.setFont(new Font("serif", Font.PLAIN, 23));
        loginPanel.add(passwordFieldPass);

        // Login button
        login = new JButton("Log In");
        login.setBounds(70, 380, 320, 45);
        login.setForeground(Color.WHITE);
        login.setBackground(Color.BLUE);
        login.setFont(new Font("serif", Font.BOLD, 23));
        login.addActionListener(this);
        loginPanel.add(login);

        rightPanel.add(loginPanel, BorderLayout.CENTER);


        // Add the panels to the frame
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);

        // Set visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {

            try {

                String username = textFieldUser.getText();
                String password = passwordFieldPass.getText();

                if (username.equals("admin") && password.equals("admin")) {
                    setVisible(false);
                    new Main();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
            }
            catch (Exception E) {
                E.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        new Login();

    }
}


