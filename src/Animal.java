import javax.swing.*;
import java.awt.*;

abstract public class Animal extends JFrame{
    private String name="null";
    public void setName(String name)
    {
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    abstract void walk();
    abstract void eat();
    abstract void sleep();
}
class Ant extends Animal{
    private Container c;
    private JLabel imgLabel;
    private ImageIcon img;
    private JPanel jp;
    Ant(){
        init();
    }
    public void init(){
        c = getContentPane();
        c.setLayout(null);
        setLayout(new GridLayout(2, 2));
        setTitle("My Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
        img = new ImageIcon("src/Animal/Ant/Ant.jpg");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        c.add(imgLabel);
    }
    @Override
    public void walk() {
        img = new ImageIcon("src/Animal/Ant/AntWalk.gif");
        imgLabel.setIcon(img);
    }
  
    @Override
    void eat() {

    }

    @Override
    void sleep() {

    }

    public static void main(String[] args) {
        Ant ant=new Ant();
        ant.walk();
    }
}
