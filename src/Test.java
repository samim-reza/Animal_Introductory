import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Test extends JFrame{
    private JPanel mainPanel;
    private JPanel subPanel, panel1, panel2;
    private JLabel imgLabel1,actionLabel;
    private ImageIcon img1,actionImage;
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
    Test(int i) {
        setTitle("Panel Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setMinimumSize(new Dimension(900,400));
        setLocationRelativeTo(null);
        // setVisible(true);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        subPanel = new BackgroundPanel(new ImageIcon("src/Icon.jpg").getImage());
        subPanel.setLayout(new GridBagLayout());
        //subPanel.setPreferredSize(new Dimension(300, 200));

        img1 = new ImageIcon(animalName[i]);
        imgLabel1 = new JLabel(img1);
        imgLabel1.setBounds(0, 0, img1.getIconWidth(), img1.getIconHeight());

        actionImage = new ImageIcon("src/Animal/Fox/CatEat.gif");
        actionLabel = new JLabel(actionImage);
        actionLabel.setBounds(0, 0, actionImage.getIconWidth(), actionImage.getIconHeight());

        panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(400, 350));
        panel1.setBackground(Color.white);
        panel1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Component c = e.getComponent();
                if (c instanceof JPanel) {
                    JPanel panel = (JPanel) c;
                    int panelWidth = panel.getWidth();
                    int panelHeight = panel.getHeight();
                    ImageIcon resizedImg = new ImageIcon(img1.getImage().getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH));
                    imgLabel1.setIcon(resizedImg);
                }
            }
        });
        panel1.add(imgLabel1);

        panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(400, 350));
        panel2.setBackground(Color.white);
        panel2.add(actionLabel);
        subPanel.add(panel1, new GridBagConstraints());
        subPanel.add(panel2, new GridBagConstraints(){{
            gridx = 1;
            insets = new Insets(0, 30, 0, 0);
        }});

        mainPanel.add(subPanel,BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setPreferredSize(new Dimension(300, 50));
        eatButton = new JButton("Eat");
        walkButton = new JButton("Walk");
        backButton = new JButton("Back");
        buttonPanel.add(eatButton);
        buttonPanel.add(walkButton);
        buttonPanel.add(backButton);
        mainPanel.add(buttonPanel,BorderLayout.SOUTH);

        getContentPane().add(mainPanel);

        walkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.removeAll();
                if(i==13 || i==18){
                    int x=0;
                    if(i==13){x=0;}
                    if(i==18){x=1;}
                    Test2 to=new Test2();
                    Swimmable animal = to.swimmingAnimals[x];
                    animal.swim();
                    panel2.add(animal.getContentPane());
                    panel2.revalidate();
                    panel2.repaint();
                }
                else if(i==8 || i==16 || i==21){
                    int x=0;
                    if(i==8){x=0;}
                    if(i==16){x=1;}
                    if(i==21){x=2;}
                    Test2 to=new Test2();
                    Flyable animal = to.flyingingAnimals[x];
                    animal.fly();
                    panel2.add(animal.getContentPane());
                    panel2.revalidate();
                    panel2.repaint();
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
                    Test2 to=new Test2();
                    Walkable animal = to.walkingAnimals[x];
                    animal.walk();
                    panel2.add(animal.getContentPane());
                    panel2.revalidate();
                    panel2.repaint();
                }
            }
        });
        eatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.removeAll();
                if(i==13 || i==18){
                    int x=0;
                    if(i==13){x=0;}
                    if(i==18){x=1;}
                    Test2 to=new Test2();
                    Swimmable animal = to.swimmingAnimals[x];
                    animal.eat();
                    panel2.add(animal.getContentPane());
                    panel2.revalidate();
                    panel2.repaint();
                }
                else if(i==8 || i==16 || i==21){
                    int x=0;
                    if(i==8){x=0;}
                    if(i==16){x=1;}
                    if(i==21){x=2;}
                    Test2 to=new Test2();
                    Flyable animal = to.flyingingAnimals[x];
                    animal.eat();
                    panel2.add(animal.getContentPane());
                    panel2.revalidate();
                    panel2.repaint();
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
                    Test2 to=new Test2();
                    Walkable animal = to.walkingAnimals[x];
                    animal.eat();
                    panel2.add(animal.getContentPane());
                    panel2.revalidate();
                    panel2.repaint();
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
