import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Arrays;

abstract class Animal extends JFrame{
    protected Container c;
    protected JLabel imgLabel;
    protected ImageIcon img;
    protected JPanel mainPanel;
    protected String[] animalEat = {"src/Animal/Ant/AntEat.gif","src/Animal/Bear/BearEat.gif","src/Animal/Cat/CatEat.gif","src/Animal/Dog/DogEat.gif","src/Animal/Elephant/ElephantEat.gif","src/Animal/Fox/FoxEat.gif","src/Animal/Giraffe/GiraffeEat.jpg","src/Animal/Horse/HorseEat.gif","src/Animal/Ibis/IbisEat.gif","src/Animal/Jaguar/JaguarEat.gif","src/Animal/Kangaroo/KangarooEat.gif","src/Animal/Lion/LionEat.gif","src/Animal/Monkey/MonkeyEat.gif","src/Animal/Needlefish/NeedlefishEat.gif","src/Animal/Ostrich/OstrichEat.gif","src/Animal/Panda/PandaEat.gif","src/Animal/Quail/QuailEat.gif","src/Animal/Rabbit/RabbitEat.gif","src/Animal/Shark/SharkEat.gif","src/Animal/Tiger/TigerEat.gif","src/Animal/Urial/UrialEat.gif","src/Animal/Vulture/VultureEat.gif","src/Animal/Wolf/WolfEat.gif","src/Animal/Xerus/XerusEat.gif","src/Animal/Yalk/YalkEat.gif","src/Animal/Zebra/ZebraEat.gif","src/Animal/Zebra/ZebraEat.gif","src/Animal/Zebra/ZebraEat.gif"};
    protected String[] animalWalk = {"src/Animal/Ant/AntWalk.gif","src/Animal/Bear/BearWalk.gif","src/Animal/Cat/CatWalk.gif","src/Animal/Dog/DogWalk.gif","src/Animal/Elephant/ElephantWalk.gif","src/Animal/Fox/FoxWalk.gif","src/Animal/Giraffe/GiraffeWalk.jpg","src/Animal/Horse/HorseWalk.gif","src/Animal/Ibis/IbisWalk.gif","src/Animal/Jaguar/JaguarWalk.gif","src/Animal/Kangaroo/KangarooWalk.gif","src/Animal/Lion/LionWalk.gif","src/Animal/Monkey/MonkeyWalk.gif","src/Animal/Needlefish/NeedlefishWalk.gif","src/Animal/Ostrich/OstrichWalk.gif","src/Animal/Panda/PandaWalk.gif","src/Animal/Quail/QuailWalk.gif","src/Animal/Rabbit/RabbitWalk.gif","src/Animal/Shark/SharkWalk.gif","src/Animal/Tiger/TigerWalk.gif","src/Animal/Urial/UrialWalk.gif","src/Animal/Vulture/VultureWalk.gif","src/Animal/Wolf/WolfWalk.gif","src/Animal/Xerus/XerusWalk.gif","src/Animal/Yalk/YalkWalk.gif","src/Animal/Zebra/ZebraWalk.gif","src/Animal/Zebra/ZebraEat.gif","src/Animal/Zebra/ZebraEat.gif"};
    static Object[] animal = {new Ant()};

    abstract void eat();
    abstract void walk();
}
class Ant extends Animal{
    Ant(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);

        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[0]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[0]);
        imgLabel.setIcon(img);
    }
}
class Bear extends Animal{
    Bear(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);

        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[1]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[1]);
        imgLabel.setIcon(img);
    }
}
class Cat extends Animal{
    Cat(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);

        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[2]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[2]);
        imgLabel.setIcon(img);
    }
}
class Dog extends Animal{
    Dog(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[3]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[3]);
        imgLabel.setIcon(img);
    }
}
class Elephant extends Animal{
    Elephant(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[4]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[4]);
        imgLabel.setIcon(img);
    }
}
class Fox extends Animal{
    Fox(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[5]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[5]);
        imgLabel.setIcon(img);
    }
}
class Giraffe extends Animal{
    Giraffe(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[6]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[6]);
        imgLabel.setIcon(img);
    }
}
class Horse extends Animal{
    Horse(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[7]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[7]);
        imgLabel.setIcon(img);
    }
}
class Ibis extends Animal{
    Ibis(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[8]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[8]);
        imgLabel.setIcon(img);
    }
}
class Jaguar extends Animal{
    Jaguar(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[9]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[9]);
        imgLabel.setIcon(img);
    }
}
class Kangaroo extends Animal{
    Kangaroo(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[10]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[10]);
        imgLabel.setIcon(img);
    }
}
class Lion extends Animal{
    Lion(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[11]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[11]);
        imgLabel.setIcon(img);
    }
}
class Monkey extends Animal{
    Monkey(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[12]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[12]);
        imgLabel.setIcon(img);
    }
}
class NeedleFish extends Animal{
    NeedleFish(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[13]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[13]);
        imgLabel.setIcon(img);
    }
}
class Ostrich extends Animal{
    Ostrich(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[14]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[14]);
        imgLabel.setIcon(img);
    }
}
class Panda extends Animal{
    Panda(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[15]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[15]);
        imgLabel.setIcon(img);
    }
}
class Quail extends Animal{
    Quail(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[16]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[16]);
        imgLabel.setIcon(img);
    }
}
class Rabbit extends Animal{
    Rabbit(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[17]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[17]);
        imgLabel.setIcon(img);
    }
}
class Shark extends Animal{
    Shark(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[18]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[18]);
        imgLabel.setIcon(img);
    }
}
class Tiger extends Animal{
    Tiger(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[19]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[19]);
        imgLabel.setIcon(img);
    }
}
class Urial extends Animal{
    Urial(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[20]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[20]);
        imgLabel.setIcon(img);
    }
}
class Vulture extends Animal{
    Vulture(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[21]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[21]);
        imgLabel.setIcon(img);
    }
}
class Wolf extends Animal{
    Wolf(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[22]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[22]);
        imgLabel.setIcon(img);
    }
}
class Xerus extends Animal{
    Xerus(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[23]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[23]);
        imgLabel.setIcon(img);
    }
}
class Yalk extends Animal{
    Yalk(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[24]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[24]);
        imgLabel.setIcon(img);
    }
}
class Zebra extends Animal{
    Zebra(){
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);


        mainPanel = new JPanel(new BorderLayout());
        img = new ImageIcon("src/Animal/Ant/AntEat.gif");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        mainPanel.add(imgLabel,BorderLayout.CENTER);

        c.add(mainPanel);
    }
    @Override
    void eat() {
        img = new ImageIcon(animalEat[25]);
        imgLabel.setIcon(img);
    }
    @Override
    public void walk() {
        img = new ImageIcon(animalWalk[25]);
        imgLabel.setIcon(img);
    }
}