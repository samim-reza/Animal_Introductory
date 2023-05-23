import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Graphics;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class DetailsPage extends JFrame{
    private JPanel fullPage;
    private JPanel backgroundPanel, leftImagePanel, rightImagePanel;
    private JLabel leftImgLabel,actionLabel;
    private ImageIcon leftImg,actionImage;
    private JButton eatButton,walkButton,backButton;
    private String[] animalName = {"src/Animal/Ant/Ant.jpg","src/Animal/Bear/Bear.jpg","src/Animal/Cat/Cat.jpg","src/Animal/Dog/Dog.jpg","src/Animal/Elephant/Elephant.jpg","src/Animal/Fox/Fox.jpg","src/Animal/Giraffe/Giraffe.jpg","src/Animal/Horse/Horse.jpg","src/Animal/Ibis/Ibis.jpg","src/Animal/Jaguar/Jaguar.jpg","src/Animal/Kangaroo/Kangaroo.jpg","src/Animal/Lion/Lion.jpg","src/Animal/Monkey/Monkey.jpg","src/Animal/Needlefish/Needlefish.png","src/Animal/Ostrich/Ostrich.jpg","src/Animal/Panda/Panda.jpg","src/Animal/Quail/Quail.jpg","src/Animal/Rabbit/Rabbit.jpg","src/Animal/Shark/Shark.jpg","src/Animal/Tiger/Tiger.jpg","src/Animal/Urial/Urial.jpg","src/Animal/Vulture/Vulture.jpg","src/Animal/Wolf/Wolf.jpg","src/Animal/Xerus/Xerus.jpg","src/Animal/Yalk/Yalk.jpg","src/Animal/Zebra/Zebra.jpg","src/Animal/Zebra/Zebra.jpg","src/Animal/Zebra/Zebra.jpg"};
    private class BackgroundPanel extends JPanel{
        private Image backgroundImage;

        public BackgroundPanel(Image backgroundImage) {
            this.backgroundImage = backgroundImage;
            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    repaint();
                }
            });
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
        }
    }
    DetailsPage(int i) {

        setTitle("Action Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setMinimumSize(new Dimension(900,400));
        setLocationRelativeTo(null);

        fullPage = new JPanel();
        fullPage.setLayout(new BorderLayout());

        backgroundPanel = new BackgroundPanel(new ImageIcon("src/Icon.jpg").getImage());
        backgroundPanel.setLayout(new GridBagLayout());

        leftImg = new ImageIcon(animalName[i]);
        leftImgLabel = new JLabel(leftImg);
        leftImgLabel.setBounds(0, 0, leftImg.getIconWidth(), leftImg.getIconHeight());

        actionImage = new ImageIcon("src/Animal/Fox/CatEat.gif");
        actionLabel = new JLabel(actionImage);
        actionLabel.setBounds(0, 0, actionImage.getIconWidth(), actionImage.getIconHeight());

        leftImagePanel = new JPanel();
        leftImagePanel.setPreferredSize(new Dimension(400, 350));
        leftImagePanel.setBackground(Color.white);
        leftImagePanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Component c = e.getComponent();
                if (c instanceof JPanel) {
                    JPanel panel = (JPanel) c;
                    int panelWidth = panel.getWidth();
                    int panelHeight = panel.getHeight();
                    ImageIcon resizedImg = new ImageIcon(leftImg.getImage().getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH));
                    leftImgLabel.setIcon(resizedImg);
                }
            }
        });

        leftImagePanel.add(leftImgLabel);

        rightImagePanel = new JPanel();
        rightImagePanel.setPreferredSize(new Dimension(400, 350));
        rightImagePanel.setBackground(Color.white);
        rightImagePanel.add(actionLabel);
        backgroundPanel.add(leftImagePanel, new GridBagConstraints());
        backgroundPanel.add(rightImagePanel, new GridBagConstraints(){{
            gridx = 1;
            insets = new Insets(0, 30, 0, 0);
        }});

        fullPage.add(backgroundPanel,BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setPreferredSize(new Dimension(300, 50));
        eatButton = new JButton("Eat");
        eatButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        walkButton = new JButton("Move");
        walkButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton = new JButton("Back");
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        buttonPanel.add(eatButton);
        buttonPanel.add(walkButton);
        buttonPanel.add(backButton);
        fullPage.add(buttonPanel,BorderLayout.SOUTH);

        getContentPane().add(fullPage);

        walkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rightImagePanel.removeAll();
                if(i==13 || i==18){
                    int x=0;
                    if(i==13){x=0;}
                    if(i==18){x=1;}
                    MakeAction action=new MakeAction();
                    Swimmable animal = action.swimmingAnimals[x];
                    animal.swim();
                    rightImagePanel.add(animal.getContentPane());
                    rightImagePanel.revalidate();
                    rightImagePanel.repaint();
                }
                else if(i==8 || i==16 || i==21){
                    int x=0;
                    if(i==8){x=0;}
                    if(i==16){x=1;}
                    if(i==21){x=2;}
                    MakeAction to=new MakeAction();
                    Flyable animal = to.flyingingAnimals[x];
                    animal.fly();
                    rightImagePanel.add(animal.getContentPane());
                    rightImagePanel.revalidate();
                    rightImagePanel.repaint();
                }
                else{
                    int x=i;
                    if(i>8 && i<13){
                        x=i-1;
                    }
                    else if(i>13 && i<16){
                        x=i-2;
                    }
                    else if(i==17){
                        x=i-3;
                    }
                    else if(i>18 && i<21){
                        x=i-4;
                    }
                    else if(i>21){
                        x=i-5;
                    }
                    MakeAction action=new MakeAction();
                    Walkable animal = action.walkingAnimals[x];
                    animal.walk();
                    rightImagePanel.add(animal.getContentPane());
                    rightImagePanel.revalidate();
                    rightImagePanel.repaint();
                }
            }
        });
        eatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rightImagePanel.removeAll();
                if(i==13 || i==18){
                    int x=0;
                    if(i==13){x=0;}
                    if(i==18){x=1;}
                    MakeAction action=new MakeAction();
                    Swimmable animal = action.swimmingAnimals[x];
                    animal.eat();
                    rightImagePanel.add(animal.getContentPane());
                    rightImagePanel.revalidate();
                    rightImagePanel.repaint();
                }
                else if(i==8 || i==16 || i==21){
                    int x=0;
                    if(i==8){x=0;}
                    if(i==16){x=1;}
                    if(i==21){x=2;}
                    MakeAction to=new MakeAction();
                    Flyable animal = to.flyingingAnimals[x];
                    animal.eat();
                    rightImagePanel.add(animal.getContentPane());
                    rightImagePanel.revalidate();
                    rightImagePanel.repaint();
                }
                else{
                    int x=i;
                    if(i>8 && i<13){
                        x=i-1;
                    }
                    else if(i>13 && i<16){
                        x=i-2;
                    }
                    else if(i==17){
                        x=i-3;
                    }
                    else if(i>18 && i<21){
                        x=i-4;
                    }
                    else if(i>21){
                        x=i-5;
                    }
                    MakeAction action=new MakeAction();
                    Walkable animal = action.walkingAnimals[x];
                    animal.eat();
                    rightImagePanel.add(animal.getContentPane());
                    rightImagePanel.revalidate();
                    rightImagePanel.repaint();
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(Book.pages[Book.currentPageIndex], BorderLayout.CENTER);
                getContentPane().add(Book.buttonPanel, BorderLayout.SOUTH);
                getContentPane().revalidate();
                getContentPane().repaint();
            }
        });
    }
}
