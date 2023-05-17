import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class WelcomePage extends JFrame{
    private JLabel label;
    private JButton signIn, signUp;
    WelcomePage() {
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints positions = new GridBagConstraints();
        positions.fill = GridBagConstraints.HORIZONTAL;
        positions.insets = new Insets(10, 10, 10, 10);

        label = new JLabel("Welcome to the Introductory");
        label.setFont(new Font("Serif", Font.PLAIN, 30));
        positions.gridx = 0;
        positions.gridy = 0;
        positions.gridwidth = 2;
        positions.anchor = GridBagConstraints.CENTER;
        add(label, positions);

        signIn = new JButton("Sign In");
        positions.gridx = 0;
        positions.gridy = 1;
        add(signIn, positions);

        signUp = new JButton("Sign Up");
        positions.gridy = 2;
        add(signUp, positions);

        setLocationRelativeTo(null);
        setVisible(true);

        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginPane(getContentPane().getWidth(),getContentPane().getHeight());

            }
        });
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CreateAccountPage(getContentPane().getWidth(),getContentPane().getHeight());
            }
        });
    }
}
class LoginPane extends JFrame implements ActionListener{
    private Container c;
    private JLabel usernameLabel;
    private JTextField usernameTextField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton logButton,clearButton;
    LoginPane(int width, int height) {
        c=getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width,height);
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

            if (username.equals("") && password.equals("")) {
                new Book(getContentPane().getWidth(), getContentPane().getHeight());
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource()==clearButton){
            usernameTextField.setText("");
            passwordField.setText("");
        }
    }
}
class CreateAccountPage extends JFrame{

    private JPanel pane;
    private JLabel name, pass, emailLabel, ageLabel, createAccountLabel, confirmPass ;
    private JTextField username, emailField;
    private JPasswordField password, confirmPassword;
    private JSlider ageSlider;
    private JButton signup, exsistAccount;

    CreateAccountPage(int width, int height) {
        super("Create New Account");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        exsistAccount = new JButton("Already have an account?");

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
                dispose();
                new LoginPane(getContentPane().getWidth(),getContentPane().getHeight());
            }
        });
        exsistAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginPane(getContentPane().getWidth(),getContentPane().getHeight());
            }
        });
    }

}
