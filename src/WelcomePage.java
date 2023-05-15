import javax.swing.*;

public class WelcomePage extends JFrame {

    private JLabel welcomeLabel;

    public WelcomePage() {
        setTitle("Welcome");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a welcome label
        welcomeLabel = new JLabel("Welcome to the Application!");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(welcomeLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        // Run the welcome page
        SwingUtilities.invokeLater(() -> new WelcomePage());
    }
}
