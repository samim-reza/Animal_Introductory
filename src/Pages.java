import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class Pages extends JFrame implements MouseListener, ActionListener {
    private Container c;
    private JPanel[] subPanels = new JPanel[28];
    private JPanel[] mainPanel = new JPanel[7];
    private JPanel buttonPanel = new JPanel();
    private JLabel[] imgLabel=new JLabel[28];
    private ImageIcon[] img=new ImageIcon[28];
    private ImageIcon icon;
    private JButton prevButton;
    private JButton nextButton;
    private int subPanelIndex = 0, currentPanelIndex = 0;
    private String[] animalName={"src/Animal/Ant/Ant.jpg","src/Animal/Bear/Bear.jpg","src/Animal/Cat/Cat.jpg","src/Animal/Dog/Dog.jpg","src/Animal/Elephant/Elephant.jpg","src/Animal/Fox/Fox.jpg","src/Animal/Giraffe/Giraffe.jpg","src/Animal/Horse/Horse.jpg","src/Animal/Ibis/Ibis.jpg","src/Animal/Jaguar/Jaguar.jpg","src/Animal/Kangaroo/Kangaroo.jpg","src/Animal/Lion/Lion.jpg","src/Animal/Monkey/Monkey.jpg","src/Animal/Needlefish/Needlefish.png","src/Animal/Ostrich/Ostrich.jpg","src/Animal/Panda/Panda.jpg","src/Animal/Quail/Quail.jpg","src/Animal/Rabbit/Rabbit.jpg","src/Animal/Shark/Shark.jpg","src/Animal/Tiger/Tiger.jpg","src/Animal/Urial/Urial.jpg","src/Animal/Vulture/Vulture.jpg","src/Animal/Wolf/Wolf.jpg","src/Animal/Xerus/Xerus.jpg","src/Animal/Yalk/Yalk.jpg","src/Animal/Zebra/Zebra.jpg","src/Animal/Zebra/Zebra.jpg","src/Animal/Zebra/Zebra.jpg"};

    Pages(){
        c = getContentPane();
        setTitle("Animal Introductory");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
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

        c.setLayout(new BorderLayout());

        for (int i = 0; i < mainPanel.length; i++) {
            mainPanel[i] = new JPanel(new GridLayout(2, 2));
            for (int j = 0; j < 4; j++) {
                subPanels[subPanelIndex] = new JPanel();
                subPanels[subPanelIndex].setBackground(Color.white);
                subPanels[subPanelIndex].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                subPanels[subPanelIndex].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                subPanels[subPanelIndex].addMouseListener(this);
                subPanels[subPanelIndex].addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        Component c = e.getComponent();
                        if (c instanceof JPanel) {
                            JPanel panel = (JPanel) c;
                            int panelWidth = panel.getWidth();
                            int panelHeight = panel.getHeight();
                            int index = Arrays.asList(subPanels).indexOf(panel);
                            ImageIcon resizedImg = new ImageIcon(img[index].getImage().getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH));
                            imgLabel[index].setIcon(resizedImg);
                        }
                    }
                });
                img[subPanelIndex] = new ImageIcon(animalName[subPanelIndex]);
                imgLabel[subPanelIndex] = new JLabel(img[subPanelIndex]);
                subPanels[subPanelIndex].add(imgLabel[subPanelIndex]);
                mainPanel[i].add(subPanels[subPanelIndex]);
                subPanelIndex++;
            }
        }
        c.add(mainPanel[currentPanelIndex], BorderLayout.CENTER);
        c.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel[currentPanelIndex].setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == prevButton) {
            mainPanel[currentPanelIndex].setVisible(false);
            currentPanelIndex--;
            if (currentPanelIndex < 0) {
                currentPanelIndex = mainPanel.length - 1;
            }
            mainPanel[currentPanelIndex].setVisible(true);
            c.add(mainPanel[currentPanelIndex], BorderLayout.CENTER);
        }
        else if (e.getSource() == nextButton) {
            mainPanel[currentPanelIndex].setVisible(false);
            currentPanelIndex++;
            if (currentPanelIndex >= mainPanel.length) {
                currentPanelIndex = 0;
            }
            mainPanel[currentPanelIndex].setVisible(true);
            c.add(mainPanel[currentPanelIndex], BorderLayout.CENTER);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for(int subPanel=0; subPanel<subPanels.length; subPanel++){
            if(e.getSource()==subPanels[subPanel]) {
                mainPanel[currentPanelIndex].setVisible(false);
                c.removeAll();
                Test ant = new Test(subPanel);
                c.add(ant.getContentPane());
                c.revalidate();
                c.repaint();
                break;
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
