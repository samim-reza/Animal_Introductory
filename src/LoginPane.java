import javax.swing.*;
import java.awt.*;

public class LoginPane extends JFrame {
    private Container c;
    private JLabel usernameLabel;
    private JTextField usernameTextField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton logButton,clearButton;
    LoginPane() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50,50,500,350);
        //setSize(300, 150);
        setTitle("Login Form");

        // Create a panel with a GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());

        // Create username and password labels and text fields
        usernameLabel = new JLabel("Username:");
        usernameTextField = new JTextField(20);
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        passwordField.setEchoChar('*');
        logButton =new JButton("Login");
        clearButton =new JButton("Clear");

        // Add the components to the panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(usernameLabel, gbc);
        gbc.gridx = 1;
        panel.add(usernameTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        panel.add(logButton, gbc);
        gbc.gridx=1;
        panel.add(clearButton, gbc);

        // Center the panel and add it to the frame
        getContentPane().add(panel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        LoginPane example = new LoginPane();
        example.setVisible(true);
    }
}