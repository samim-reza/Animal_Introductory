import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;

class UserProfile extends JFrame{

    private JPanel pane;
    private JLabel name, emailLabel, ageLabel, yourInformationLabel;
    private JButton changepassword, back, logoutbutton;
    private ImageIcon icon;
    private Database db;
    private String userName,userAge;
    private ResultSet userAgeResult,userNameResult;
    private String userEmail;

    UserProfile(int width, int height) {

        db = new Database();

        userEmail = LoginPane.checkMail;

        try {
            userNameResult = db.getConnection().createStatement().executeQuery("Select Name from Userinfo where Email='"+userEmail+"'");
            while(userNameResult.next()){
                userName = userNameResult.getString("Name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            userAgeResult = db.getConnection().createStatement().executeQuery("Select Age from Userinfo where Email='"+userEmail+"'");
            while(userAgeResult.next()){
                userAge = userAgeResult.getString("Age");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        setTitle("User Information");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        icon =new ImageIcon("src/Icon.jpg");
        this.setIconImage(icon.getImage());

        pane = new JPanel(new GridBagLayout());
        GridBagConstraints positions = new GridBagConstraints();
        positions.fill = GridBagConstraints.HORIZONTAL;
        positions.insets = new Insets(5, 5, 5, 5);

        yourInformationLabel = new JLabel("Account Information");
        yourInformationLabel.setFont(yourInformationLabel.getFont().deriveFont(Font.BOLD, 22));

        name = new JLabel("Name: "+userName);
        emailLabel = new JLabel("Email: "+userEmail);
        ageLabel = new JLabel("Age: "+userAge);

        changepassword = new JButton("Change Password");
        changepassword.setBackground(new Color(0x2FD7C9));
        changepassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        back = new JButton("Back");
        back.setBackground(new Color(0x2FD7C9));
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        logoutbutton = new JButton("Logout");
        logoutbutton.setBackground(new Color(0x2FD7C9));
        logoutbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        positions.gridx = 0;
        positions.gridy = 0;
        positions.gridwidth = 2;
        positions.anchor = GridBagConstraints.CENTER;
        pane.add(yourInformationLabel, positions);

        positions.gridx = 0;
        positions.gridy = 1;
        positions.gridwidth = 1;
        pane.add(name, positions);

        positions.gridx = 0;
        positions.gridy = 4;
        pane.add(emailLabel, positions);

        positions.gridx = 0;
        positions.gridy = 5;
        pane.add(ageLabel, positions);
        
        positions.gridx = 0;
        positions.gridy = 6;
        positions.gridwidth = 2;
        positions.anchor = GridBagConstraints.CENTER;
        pane.add(changepassword, positions);

        positions.gridy = 7;
        pane.add(back, positions);

        positions.gridy = 8;
        pane.add(logoutbutton, positions);
        

        setContentPane(pane);
        setLocationRelativeTo(null);
        logoutbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(new WelcomePage(getContentPane().getWidth(),getContentPane().getHeight()).getContentPane());
                getContentPane().revalidate();
                getContentPane().repaint();
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().setLayout(new BorderLayout());
                getContentPane().add(Book.pages[Book.currentPageIndex], BorderLayout.CENTER);
                getContentPane().add(Book.buttonPanel, BorderLayout.SOUTH);
                getContentPane().revalidate();
                getContentPane().repaint();
            }
        });
        changepassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(new changepassword(getContentPane().getWidth(),getContentPane().getHeight()).getContentPane());
                getContentPane().revalidate();
                getContentPane().repaint();
            }
        });
    }
}
class changepassword extends JFrame{

    private JPanel pane;
    private JLabel prevPass, newPass, confirmPass, yourInformationLabel;
    private JTextField prevPassField, newPassField, confirmPassField;
    private JButton confirm, back;
    private ImageIcon icon;
    private Database db;
    private ResultSet passResult;
    private String userpassResultName;

    changepassword(int width, int height) {

        db = new Database();

        try {
            passResult = db.getConnection().createStatement().executeQuery("Select Password from Userinfo where Email='"+LoginPane.checkMail+"'");
            while(passResult.next()){
                userpassResultName = passResult.getString("Password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        setTitle("Password Change");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        icon =new ImageIcon("src/Icon.jpg");
        this.setIconImage(icon.getImage());

        pane = new JPanel(new GridBagLayout());
        GridBagConstraints positions = new GridBagConstraints();
        positions.fill = GridBagConstraints.HORIZONTAL;
        positions.insets = new Insets(5, 5, 5, 5);

        yourInformationLabel = new JLabel("Change Password");
        yourInformationLabel.setFont(yourInformationLabel.getFont().deriveFont(Font.BOLD, 22));

        prevPass = new JLabel("Old password: ");
        prevPassField = new JTextField(15);

        newPass = new JLabel("New Password: ");
        newPassField = new JPasswordField(15);

        confirmPass = new JLabel("Confirm Password: ");
        confirmPassField = new JPasswordField(15);

        confirm = new JButton("Confirm");
        confirm.setBackground(new Color(0x2FD7C9));
        confirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        back = new JButton("Back");
        back.setBackground(new Color(0x2FD7C9));
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        positions.gridx = 0;
        positions.gridy = 0;
        positions.gridwidth = 2;
        positions.anchor = GridBagConstraints.CENTER;
        pane.add(yourInformationLabel, positions);

        positions.gridx = 0;
        positions.gridy = 1;
        positions.gridwidth = 1;
        pane.add(prevPass, positions);

        positions.gridx = 1;
        pane.add(prevPassField, positions);

        positions.gridx = 0;
        positions.gridy = 2;
        pane.add(newPass, positions);

        positions.gridx = 1;
        pane.add(newPassField, positions);

        positions.gridx = 0;
        positions.gridy = 3;
        pane.add(confirmPass, positions);

        positions.gridx = 1;
        pane.add(confirmPassField, positions);

        positions.gridx = 0;
        positions.gridy = 6;
        positions.gridwidth = 2;
        positions.anchor = GridBagConstraints.CENTER;
        pane.add(confirm, positions);

        positions.gridy = 7;
        pane.add(back, positions);

        setContentPane(pane);
        setLocationRelativeTo(null);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(new UserProfile(getContentPane().getWidth(),getContentPane().getHeight()).getContentPane());
                getContentPane().revalidate();
                getContentPane().repaint();
            }
        });

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prevPass = prevPassField.getText();
                String newPass = newPassField.getText();
                String confirmPass = confirmPassField.getText();

                if(!prevPass.equals(userpassResultName)){
                    JOptionPane.showMessageDialog(null, "Old password doesn't match");
                }
                else
                if(prevPass.equals("") || newPass.equals("") || confirmPass.equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill up all the fields");
                }
                else if(!newPass.equals(confirmPass)){
                    JOptionPane.showMessageDialog(null, "New password and confirm password doesn't match");
                }
                else{
                    try {
                        db.getConnection().createStatement().executeUpdate("update Userinfo set Password='"+newPass+"' where Email='"+LoginPane.checkMail+"'");
                        JOptionPane.showMessageDialog(null, "Password changed successfully");
                        getContentPane().removeAll();
                        getContentPane().add(new UserProfile(getContentPane().getWidth(),getContentPane().getHeight()).getContentPane());
                        getContentPane().revalidate();
                        getContentPane().repaint();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

    }
}