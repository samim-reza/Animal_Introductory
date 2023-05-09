import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MyFrame extends JFrame {
    private JPanel mainPanel;
    private JPanel subPanel;
    private JLabel imgLabel1,imgLabel2;
    private ImageIcon img1,img2;
    MyFrame() {
        init();
    }

    private class BackgroundPanel extends JPanel {
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

    public void init() {
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

        img1 = new ImageIcon("src/Animal/Bear/Bear.jpg");
        imgLabel1 = new JLabel(img1);
        imgLabel1.setBounds(0, 0, img1.getIconWidth(), img1.getIconHeight());

        img2 = new ImageIcon("src/Animal/Cat/Cat.jpg");
        imgLabel2 = new JLabel(img2);
        imgLabel2.setBounds(0, 0, img2.getIconWidth(), img2.getIconHeight());


        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(350, 350));
        //panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK,10));
        panel1.add(imgLabel1);
        panel1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Component c = e.getComponent();
                if (c instanceof JPanel) {
                    JPanel panel = (JPanel) c;
                    int panelWidth = panel.getWidth();
                    int panelHeight = panel.getHeight();
                    //int index = Arrays.asList(subPanels).indexOf(panel);
                    ImageIcon resizedImg = new ImageIcon(img1.getImage().getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH));
                    imgLabel1.setIcon(resizedImg);
                }
            }
        });

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(350, 350));
        panel2.setBackground(Color.CYAN);
        panel2.add(imgLabel2);
        panel2.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Component c = e.getComponent();
                if (c instanceof JPanel) {
                    JPanel panel = (JPanel) c;
                    int panelWidth = panel.getWidth();
                    int panelHeight = panel.getHeight();
                    //int index = Arrays.asList(subPanels).indexOf(panel);
                    ImageIcon resizedImg = new ImageIcon(img2.getImage().getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH));
                    imgLabel2.setIcon(resizedImg);
                }
            }
        });
        subPanel.add(panel1, new GridBagConstraints());
        subPanel.add(panel2, new GridBagConstraints(){{
            gridx = 1;
            insets = new Insets(0, 30, 0, 0);
        }});

        mainPanel.add(subPanel,BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setPreferredSize(new Dimension(300, 50));
        JButton button1 = new JButton("Move");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");
        JButton button4 = new JButton("Button 4");
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        mainPanel.add(buttonPanel,BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
    }


    public static void main(String[] args) {
        new MyFrame();
    }
}
