import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPane extends JFrame implements ActionListener{
    private Container c;
    private JLabel usernameLabel;
    private JTextField usernameTextField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton logButton,clearButton;
    LoginPane() {
        c=getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50,50,900,600);
        setMinimumSize(new Dimension(900,600));
        setTitle("Login Form");
        setVisible(true);

        JPanel panel = new JPanel(new GridBagLayout());

        usernameLabel = new JLabel("Username:");
        usernameTextField = new JTextField(20);
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        passwordField.setEchoChar('*');
        logButton =new JButton("Login");
        logButton.addActionListener(this);
        clearButton =new JButton("Clear");
        clearButton.addActionListener(this);

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

        c.add(panel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==logButton){
            String username = usernameTextField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("admin") && password.equals("1234")) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    setVisible(false);
                    new Pages(c.getWidth(),c.getHeight());
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
        }
        else if(e.getSource()==clearButton){
            usernameTextField.setText("");
            passwordField.setText("");
        }
    }
    public static void main(String[] args) {
        new LoginPane();
    }

}