import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import java.awt.Cursor;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Image;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class Book extends JFrame implements ActionListener {
    static JPanel[] pages = new JPanel[7];
    static JPanel[] animals = new JPanel[28];
    static JPanel buttonPanel = new JPanel();
    private JLabel[] animalsImages=new JLabel[28];
    private ImageIcon[] img=new ImageIcon[28];
    private ImageIcon icon;
    private JButton prevButton;
    private JButton nextButton;
    private int animalsIndex = 0;
    static int currentPageIndex = 0;
    private String[] animalName={"src/Animal/Ant/Ant.jpg","src/Animal/Bear/Bear.jpg","src/Animal/Cat/Cat.jpg","src/Animal/Dog/Dog.jpg",
            "src/Animal/Elephant/Elephant.jpg","src/Animal/Fox/Fox.jpg","src/Animal/Giraffe/Giraffe.jpg","src/Animal/Horse/Horse.jpg",
            "src/Animal/Ibis/Ibis.jpg","src/Animal/Jaguar/Jaguar.jpg","src/Animal/Kangaroo/Kangaroo.jpg","src/Animal/Lion/Lion.jpg",
            "src/Animal/Monkey/Monkey.jpg","src/Animal/Needlefish/Needlefish.png","src/Animal/Ostrich/Ostrich.jpg","src/Animal/Panda/Panda.jpg",
            "src/Animal/Quail/Quail.jpg","src/Animal/Rabbit/Rabbit.jpg","src/Animal/Shark/Shark.jpg","src/Animal/Tiger/Tiger.jpg",
            "src/Animal/Urial/Urial.jpg","src/Animal/Vulture/Vulture.jpg","src/Animal/Wolf/Wolf.jpg","src/Animal/Xerus/Xerus.jpg",
            "src/Animal/Yalk/Yalk.jpg","src/Animal/Zebra/Zebra.jpg","src/Animal/Account.jpg","src/Animal/Logout.jpg"};

    Book(int width, int height){
        setTitle("Animal Introductory");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(900,600));
        setVisible(true);
        icon =new ImageIcon("src/Icon.jpg");
        this.setIconImage(icon.getImage());

        prevButton = new JButton("Previous");
        prevButton.setToolTipText("Previous page");
        prevButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        prevButton.addActionListener(this);
        buttonPanel.add(prevButton);

        nextButton = new JButton("Next");
        nextButton.setToolTipText("Next page");
        nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        nextButton.addActionListener(this);
        buttonPanel.add(nextButton);

        getContentPane().setLayout(new BorderLayout());

        for (int i = 0; i < pages.length; i++) {
            pages[i] = new JPanel(new GridLayout(2, 2));
            for (int j = 0; j < 4; j++) {
                animals[animalsIndex] = new JPanel();
                animals[animalsIndex].setBackground(Color.white);
                animals[animalsIndex].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                animals[animalsIndex].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                animals[animalsIndex].setToolTipText("Click to expand");
                animals[animalsIndex].addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        Component c = e.getComponent();
                        if (c instanceof JPanel) {
                            JPanel panel = (JPanel) c;
                            int panelWidth = panel.getWidth();
                            int panelHeight = panel.getHeight();
                            int index = Arrays.asList(animals).indexOf(panel);
                            ImageIcon resizedImg = new ImageIcon(img[index].getImage().getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH));
                            animalsImages[index].setIcon(resizedImg);
                        }
                    }
                });
                animals[animalsIndex].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        for(int subPanel=0; subPanel<28; subPanel++){
                            if(e.getSource()==animals[26]) {
                                getContentPane().removeAll();
                                getContentPane().add(new UserProfile(getContentPane().getWidth(),getContentPane().getHeight()).getContentPane());
                                getContentPane().revalidate();
                                getContentPane().repaint();
                                break;
                            }
                            else if(e.getSource()==animals[27]) {
                                getContentPane().removeAll();
                                getContentPane().add(new WelcomePage(getContentPane().getWidth(),getContentPane().getHeight()).getContentPane());
                                getContentPane().revalidate();
                                getContentPane().repaint();
                                break;
                            }
                            else if(e.getSource()==animals[subPanel]) {
                                getContentPane().removeAll();
                                getContentPane().add(new DetailsPage(subPanel).getContentPane());
                                getContentPane().revalidate();
                                getContentPane().repaint();
                                break;
                            }
                        }
                    }
                });
                img[animalsIndex] = new ImageIcon(animalName[animalsIndex]);
                animalsImages[animalsIndex] = new JLabel(img[animalsIndex]);
                animals[animalsIndex].add(animalsImages[animalsIndex]);
                pages[i].add(animals[animalsIndex]);
                animalsIndex++;
            }
        }
        getContentPane().add(pages[currentPageIndex], BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        pages[currentPageIndex].setVisible(true);
        JOptionPane.showMessageDialog(null,"Log in Successful");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == prevButton) {
            currentPageIndex--;
            if (currentPageIndex < 0) {
                currentPageIndex = pages.length - 1;
            }
            getContentPane().removeAll();
            getContentPane().add(pages[currentPageIndex], BorderLayout.CENTER);
            getContentPane().add(buttonPanel, BorderLayout.SOUTH);
            getContentPane().revalidate();
            getContentPane().repaint();
        }
        else if (e.getSource() == nextButton) {
            currentPageIndex++;
            if (currentPageIndex >= pages.length) {
                currentPageIndex = 0;
            }
                getContentPane().removeAll();
                getContentPane().add(pages[currentPageIndex], BorderLayout.CENTER);
                getContentPane().add(buttonPanel, BorderLayout.SOUTH);
                getContentPane().revalidate();
                getContentPane().repaint();
        }
    }
}
