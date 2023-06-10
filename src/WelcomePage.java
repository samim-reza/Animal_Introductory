import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

class WelcomePage extends JFrame {

    private JLabel welcomeLabel, background;
    private JButton signIn, signUp;
    private ImageIcon icon;

    WelcomePage() {

        setTitle("Welcome");
        setSize(900, 600);
        setVisible(true);
        init();
    }

    WelcomePage(int width, int height) {

        setTitle("Welcome");
        setSize(width, height);
        init();
    }

    public void init() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        icon = new ImageIcon("src/Icon.jpg");
        this.setIconImage(icon.getImage());

        background = new JLabel(new ImageIcon("src/BackGroundImage/Cat.gif"));
        background.setLayout(new GridBagLayout());
        setContentPane(background);

        GridBagConstraints positions = new GridBagConstraints();
        positions.fill = GridBagConstraints.HORIZONTAL;
        positions.insets = new Insets(10, 10, 10, 10);

        welcomeLabel = new JLabel("Welcome to the Introductory");
        welcomeLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        positions.gridx = 0;
        positions.gridy = 0;
        positions.gridwidth = 2;
        positions.anchor = GridBagConstraints.CENTER;
        add(welcomeLabel, positions);

        signIn = new JButton("Sign In");
        signIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signIn.setBackground(new Color(0x2FD7C9));
        positions.gridx = 0;
        positions.gridy = 1;
        add(signIn, positions);

        signUp = new JButton("Sign Up");
        signUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        positions.gridy = 2;
        add(signUp, positions);

        setLocationRelativeTo(null);

        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginPane(getContentPane().getWidth(), getContentPane().getHeight());
            }
        });
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CreateAccountPage(getContentPane().getWidth(), getContentPane().getHeight());
            }
        });
    }
}

class LoginPane extends JFrame implements ActionListener {

    private JLabel usernameLabel, loginJLabel;
    private JTextField usernameTextField;
    private JLabel passwordLabel, background;
    private JPasswordField passwordField;
    private JButton logButton, clearButton, backButton;
    private ImageIcon icon;
    private Database db;
    public static String checkMail;

    LoginPane(int width, int height) {

        db = new Database();

        background = new JLabel(new ImageIcon("src/BackGroundImage/Cat.gif"));
        background.setLayout(new GridBagLayout());
        setContentPane(background);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setMinimumSize(new Dimension(900, 600));
        setTitle("Login Form");
        setLayout(new GridBagLayout());
        setVisible(true);
        icon = new ImageIcon("src/Icon.jpg");
        this.setIconImage(icon.getImage());

        loginJLabel = new JLabel("Login Form");
        loginJLabel.setFont(loginJLabel.getFont().deriveFont(Font.BOLD, 22));

        usernameLabel = new JLabel("Email:");
        usernameTextField = new JTextField(20);
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        passwordField.setEchoChar('*');

        logButton = new JButton("Login");
        logButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logButton.setBackground(new Color(0xFD7F00));
        logButton.addActionListener(this);

        clearButton = new JButton("Clear");
        clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        clearButton.setBackground(new Color(0xFC9125));
        clearButton.addActionListener(this);

        backButton = new JButton("Back");
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setBackground(new Color(0xFDA852));
        backButton.addActionListener(this);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginJLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(usernameLabel, gbc);
        gbc.gridx = 1;
        add(usernameTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(passwordLabel, gbc);
        gbc.gridx = 1;
        add(passwordField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(logButton, gbc);
        gbc.gridy = 4;
        add(clearButton, gbc);
        gbc.gridy = 5;
        add(backButton, gbc);

        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logButton) {

            String username = usernameTextField.getText();
            String password = new String(passwordField.getPassword());

            boolean isValidCredential = false;

            try {
                var response = db.getConnection().createStatement().executeQuery(
                        "SELECT true as isValid FROM Userinfo WHERE Email = '" + username + "' AND Password = '"
                                + password + "'");

                var hasResult = response.next();

                if (hasResult)
                    isValidCredential = response.getBoolean("isValid");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            if (isValidCredential) {
                checkMail = username;
                dispose();
                new Book(getContentPane().getWidth(), getContentPane().getHeight());
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.", "Login Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == clearButton) {
            usernameTextField.setText("");
            passwordField.setText("");
        } else if (e.getSource() == backButton) {
            getContentPane().removeAll();
            getContentPane()
                    .add(new WelcomePage(getContentPane().getWidth(), getContentPane().getHeight()).getContentPane());
            getContentPane().revalidate();
            getContentPane().repaint();
        }
    }
}

class CreateAccountPage extends JFrame {

    private JPanel pane;
    private JLabel name, pass, emailLabel, ageLabel, createAccountLabel, confirmPass;
    private JTextField username, emailField;
    private JPasswordField password, confirmPassword;
    private JSlider ageSlider;
    private JButton signup, exsistAccount;
    private ImageIcon icon;
    private Database db;

    CreateAccountPage(int width, int height) {

        db = new Database();

        setTitle("Create New Account");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        icon = new ImageIcon("src/Icon.jpg");
        this.setIconImage(icon.getImage());

        pane = new JPanel(new GridBagLayout());
        GridBagConstraints positions = new GridBagConstraints();
        positions.fill = GridBagConstraints.HORIZONTAL;
        positions.insets = new Insets(5, 5, 5, 5);

        createAccountLabel = new JLabel("Create Account");
        createAccountLabel.setFont(createAccountLabel.getFont().deriveFont(Font.BOLD, 22));

        name = new JLabel("Full Name: ");
        username = new JTextField(15);

        pass = new JLabel("Password: ");
        password = new JPasswordField(15);

        confirmPass = new JLabel("Confirm Password: ");
        confirmPassword = new JPasswordField(15);

        emailLabel = new JLabel("Email: ");
        emailField = new JTextField(25);

        ageLabel = new JLabel("Age: ");
        ageSlider = new JSlider(5, 40);
        ageSlider.setMajorTickSpacing(5);
        ageSlider.setMinorTickSpacing(1);
        ageSlider.setPaintTicks(true);
        ageSlider.setPaintLabels(true);

        signup = new JButton("Sign up");
        signup.setBackground(new Color(0x2FD7C9));
        signup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        exsistAccount = new JButton("Already have an account?");
        exsistAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        positions.gridx = 0;
        positions.gridy = 0;
        positions.gridwidth = 2;
        positions.anchor = GridBagConstraints.CENTER;
        pane.add(createAccountLabel, positions);

        positions.gridx = 0;
        positions.gridy = 1;
        positions.gridwidth = 1;
        pane.add(name, positions);

        positions.gridx = 1;
        pane.add(username, positions);

        positions.gridx = 0;
        positions.gridy = 2;
        pane.add(pass, positions);

        positions.gridx = 1;
        pane.add(password, positions);

        positions.gridx = 0;
        positions.gridy = 3;
        pane.add(confirmPass, positions);

        positions.gridx = 1;
        pane.add(confirmPassword, positions);

        positions.gridx = 0;
        positions.gridy = 4;
        pane.add(emailLabel, positions);

        positions.gridx = 1;
        pane.add(emailField, positions);

        positions.gridx = 0;
        positions.gridy = 5;
        pane.add(ageLabel, positions);

        positions.gridx = 1;
        pane.add(ageSlider, positions);

        positions.gridx = 0;
        positions.gridy = 6;
        positions.gridwidth = 2;
        positions.anchor = GridBagConstraints.CENTER;
        pane.add(signup, positions);

        positions.gridy = 7;
        pane.add(exsistAccount, positions);

        setContentPane(pane);
        setLocationRelativeTo(null);
        setVisible(true);

        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = username.getText();
                String email = emailField.getText();
                String password = new String(CreateAccountPage.this.password.getPassword());
                String confirmPassword = new String(CreateAccountPage.this.confirmPassword.getPassword());
                int age = ageSlider.getValue();

                if (!isValidName(name)) {
                    JOptionPane.showMessageDialog(null, "Invalid name", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!isValidPassword(password)) {
                    JOptionPane.showMessageDialog(null, "Use minimun 8 characters, with uppercase,\nlowercase number and special character", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(null, "Invalid email address", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill up all the fields", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Password and Confirm Password don't match", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        db.getConnection().createStatement().executeUpdate("INSERT INTO Userinfo VALUES ('" + email
                                + "','" + password + "','" + name + "'," + age + ")");
                        JOptionPane.showMessageDialog(null, "Account Created Successfully", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        new LoginPane(getContentPane().getWidth(), getContentPane().getHeight());
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, "Email already exists", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });


        exsistAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginPane(getContentPane().getWidth(), getContentPane().getHeight());
            }
        });
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    private boolean isValidName(String name) {
        return name.matches("^[a-zA-Z\\s]+$");
    }

    private boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,32}$";
        return password.matches(passwordRegex);
    }
}
