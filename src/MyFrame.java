import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MyFrame extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JPanel subPanel, panel1, panel2;
    private JLabel imgLabel1,actionLabel;
    private ImageIcon img1,actionImage;
    private JButton eatButton,walkButton,backButton;
    private String[] animalEat = {"src/Animal/Ant/AntEat.gif","src/Animal/Bear/BearEat.gif","src/Animal/Cat/CatEat.gif","src/Animal/Dog/DogEat.gif","src/Animal/Elephant/ElephantEat.gif","src/Animal/Fox/FoxEat.gif","src/Animal/Giraffe/GiraffeEat.jpg","src/Animal/Horse/HorseEat.gif","src/Animal/Ibis/IbisEat.gif","src/Animal/Jaguar/JaguarEat.gif","src/Animal/Kangaroo/KangarooEat.gif","src/Animal/Lion/LionEat.gif","src/Animal/Monkey/MonkeyEat.gif","src/Animal/Needlefish/NeedlefishEat.gif","src/Animal/Ostrich/OstrichEat.gif","src/Animal/Panda/PandaEat.gif","src/Animal/Quail/QuailEat.gif","src/Animal/Rabbit/RabbitEat.gif","src/Animal/Shark/SharkEat.gif","src/Animal/Tiger/TigerEat.gif","src/Animal/Urial/UrialEat.gif","src/Animal/Vulture/VultureEat.gif","src/Animal/Wolf/WolfEat.gif","src/Animal/Xerus/XerusEat.gif","src/Animal/Yalk/YalkEat.gif","src/Animal/Zebra/ZebraEat.gif","src/Animal/Zebra/ZebraEat.gif","src/Animal/Zebra/ZebraEat.gif"};

    private String[] animalWalk = {"src/Animal/Ant/AntWalk.gif","src/Animal/Bear/BearWalk.gif","src/Animal/Cat/CatWalk.gif","src/Animal/Dog/DogWalk.gif","src/Animal/Elephant/ElephantWalk.gif","src/Animal/Fox/FoxWalk.gif","src/Animal/Giraffe/GiraffeWalk.jpg","src/Animal/Horse/HorseWalk.gif","src/Animal/Ibis/IbisWalk.gif","src/Animal/Jaguar/JaguarWalk.gif","src/Animal/Kangaroo/KangarooWalk.gif","src/Animal/Lion/LionWalk.gif","src/Animal/Monkey/MonkeyWalk.gif","src/Animal/Needlefish/NeedlefishWalk.gif","src/Animal/Ostrich/OstrichWalk.gif","src/Animal/Panda/PandaWalk.gif","src/Animal/Quail/QuailWalk.gif","src/Animal/Rabbit/RabbitWalk.gif","src/Animal/Shark/SharkWalk.gif","src/Animal/Tiger/TigerWalk.gif","src/Animal/Urial/UrialWalk.gif","src/Animal/Vulture/VultureWalk.gif","src/Animal/Wolf/WolfWalk.gif","src/Animal/Xerus/XerusWalk.gif","src/Animal/Yalk/YalkWalk.gif","src/Animal/Zebra/ZebraWalk.gif","src/Animal/Zebra/ZebraEat.gif","src/Animal/Zebra/ZebraEat.gif"};

    MyFrame(int i) {
        init(i);
    }

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
    public void init(int i) {
        i=1;
        setTitle("Panel Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setMinimumSize(new Dimension(750,400));
        setLocationRelativeTo(null);
        setVisible(true);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        subPanel = new BackgroundPanel(new ImageIcon("src/Icon.jpg").getImage());
        subPanel.setLayout(new GridBagLayout());
        //subPanel.setPreferredSize(new Dimension(300, 200));

        img1 = new ImageIcon("/home/samim101/Code/Animal_Introductory/src/Animal/Fox/FoxEat.gif");
        imgLabel1 = new JLabel(img1);
        imgLabel1.setBounds(0, 0, img1.getIconWidth(), img1.getIconHeight());

        actionImage = new ImageIcon(animalWalk[i]);
        actionLabel = new JLabel(actionImage);
        actionLabel.setBounds(0, 0, actionImage.getIconWidth(), actionImage.getIconHeight());

        panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(400, 350));
        panel1.setBackground(Color.BLACK);
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
        eatButton.addActionListener(this);
        walkButton.addActionListener(this);
        backButton.addActionListener(this);
        //JButton button4 = new JButton("Button 4");
        buttonPanel.add(eatButton);
        buttonPanel.add(walkButton);
        buttonPanel.add(backButton);
        //buttonPanel.add(button4);
        mainPanel.add(buttonPanel,BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==eatButton){
            panel2.removeAll();
            Ant ant = new Ant();
            ant.walk();
            panel2.add(ant.getContentPane());
            panel2.revalidate();
            panel2.repaint();
        }
    }
    public static void main(String[] args) {
        //new Test(0);
    }
}
