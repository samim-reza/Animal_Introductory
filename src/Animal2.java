import javax.swing.*;
import java.awt.*;

class Animal2 extends JFrame {
    protected Container c;
    protected JLabel eatLabel;
    protected ImageIcon eatImg;
    protected JPanel mainPanel;
    private String name;

    Animal2(String name, String eatImg) {
        this.name = name;
        c = getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);

        this.eatImg = new ImageIcon(eatImg);
        this.eatLabel = new JLabel(this.eatImg);
        this.eatLabel.setBounds(0, 0, 400, 350);

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void eat() {
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(eatLabel, BorderLayout.CENTER);

        c.add(mainPanel);
    }
}

class Walkable extends Animal2 {
    protected JLabel walkLabel;
    protected ImageIcon walkImg;

    Walkable(String name, String eatImg, String walkImg) {
        super(name, eatImg);

        this.walkImg = new ImageIcon(walkImg);
        this.walkLabel = new JLabel(this.walkImg);
        this.walkLabel.setBounds(0, 0, 400, 350);
    }

    public void walk() {
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(walkLabel, BorderLayout.CENTER);

        c.add(mainPanel);
    }
}

class Swimmable extends Animal2 {
    protected JLabel swimLabel;
    protected ImageIcon swimImg;

    Swimmable(String name, String eatImg, String swimImg) {
        super(name, eatImg);

        this.swimImg = new ImageIcon(swimImg);
        this.swimLabel = new JLabel(this.swimImg);
        this.swimLabel.setBounds(0, 0, 400, 350);
    }

    public void swim() {
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(swimLabel, BorderLayout.CENTER);

        c.add(mainPanel);
    }
}

class Flyable extends Animal2 {
    protected JLabel flyLabel;
    protected ImageIcon flyImg;

    Flyable(String name, String eatImg, String flyImg) {
        super(name, eatImg);

        this.flyImg = new ImageIcon(flyImg);
        this.flyLabel = new JLabel(this.flyImg);
        this.flyLabel.setBounds(0, 0, 400, 350);
    }

    public void fly() {
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(flyLabel, BorderLayout.CENTER);

        c.add(mainPanel);
    }
}

class Test2 {
    String[] animalEat = { "src/Animal/Ant/AntEat.gif", "src/Animal/Bear/BearEat.gif", "src/Animal/Cat/CatEat.gif",
            "src/Animal/Dog/DogEat.gif", "src/Animal/Elephant/ElephantEat.gif", "src/Animal/Fox/FoxEat.gif",
            "src/Animal/Giraffe/GiraffeEat.jpg", "src/Animal/Horse/HorseEat.gif", "src/Animal/Ibis/IbisEat.gif",
            "src/Animal/Jaguar/JaguarEat.gif", "src/Animal/Kangaroo/KangarooEat.gif", "src/Animal/Lion/LionEat.gif",
            "src/Animal/Monkey/MonkeyEat.gif", "src/Animal/Needlefish/NeedlefishEat.gif",
            "src/Animal/Ostrich/OstrichEat.gif", "src/Animal/Panda/PandaEat.gif", "src/Animal/Quail/QuailEat.gif",
            "src/Animal/Rabbit/RabbitEat.gif", "src/Animal/Shark/SharkEat.gif", "src/Animal/Tiger/TigerEat.gif",
            "src/Animal/Urial/UrialEat.gif", "src/Animal/Vulture/VultureEat.gif", "src/Animal/Wolf/WolfEat.gif",
            "src/Animal/Xerus/XerusEat.gif", "src/Animal/Yalk/YalkEat.gif", "src/Animal/Zebra/ZebraEat.gif",
            "src/Animal/Zebra/ZebraEat.gif", "src/Animal/Zebra/ZebraEat.gif" };
    String[] animalWalk = { "src/Animal/Ant/AntWalk.gif", "src/Animal/Bear/BearWalk.gif", "src/Animal/Cat/CatWalk.gif",
            "src/Animal/Dog/DogWalk.gif", "src/Animal/Elephant/ElephantWalk.gif", "src/Animal/Fox/FoxWalk.gif",
            "src/Animal/Giraffe/GiraffeWalk.jpg", "src/Animal/Horse/HorseWalk.gif", "src/Animal/Ibis/IbisFly.gif",
            "src/Animal/Jaguar/JaguarWalk.gif", "src/Animal/Kangaroo/KangarooWalk.gif", "src/Animal/Lion/LionWalk.gif",
            "src/Animal/Monkey/MonkeyWalk.gif", "src/Animal/Needlefish/NeedlefishWalk.gif",
            "src/Animal/Ostrich/OstrichWalk.gif", "src/Animal/Panda/PandaWalk.gif", "src/Animal/Quail/QuailWalk.gif",
            "src/Animal/Rabbit/RabbitWalk.gif", "src/Animal/Shark/SharkWalk.gif", "src/Animal/Tiger/TigerWalk.gif",
            "src/Animal/Urial/UrialWalk.gif", "src/Animal/Vulture/VultureWalk.gif", "src/Animal/Wolf/WolfWalk.gif",
            "src/Animal/Xerus/XerusWalk.gif", "src/Animal/Yalk/YalkWalk.gif", "src/Animal/Zebra/ZebraWalk.gif",
            "src/Animal/Zebra/ZebraEat.gif", "src/Animal/Zebra/ZebraEat.gif" };

    Walkable[] walkingAnimals = {
            new Walkable("Ant", animalEat[0], animalWalk[0]),
            new Walkable("Bear", animalEat[1], animalWalk[1]),
            new Walkable("Cat", animalEat[2], animalWalk[2]),
            new Walkable("Dog", animalEat[3], animalWalk[3]),
            new Walkable("Elephant", animalEat[4], animalWalk[4]),
            new Walkable("Fox", animalEat[5], animalWalk[5]),
            new Walkable("Giraffe", animalEat[6], animalWalk[6]),
            new Walkable("Horse", animalEat[7], animalWalk[7]),
            new Walkable("Jaguar", animalEat[9], animalWalk[9]),
            new Walkable("Kangaroo", animalEat[10], animalWalk[10]),
            new Walkable("Lion", animalEat[11], animalWalk[11]),
            new Walkable("Monkey", animalEat[12], animalWalk[12]),
            new Walkable("Ostrich", animalEat[14], animalWalk[14]),
            new Walkable("Panda", animalEat[15], animalWalk[15]),
            new Walkable("Rabbit", animalEat[17], animalWalk[17]),
            new Walkable("Tiger", animalEat[19], animalWalk[19]),
            new Walkable("Urial", animalEat[20], animalWalk[20]),
            new Walkable("Wolf", animalEat[22], animalWalk[22]),
            new Walkable("Xerus", animalEat[23], animalWalk[23]),
            new Walkable("Yalk", animalEat[24], animalWalk[24]),
            new Walkable("Zebra", animalEat[25], animalWalk[25])
    };
    Swimmable[] swimmingAnimals = {
            new Swimmable("Needlefish", animalEat[13], animalWalk[13]),
            new Swimmable("Shark", animalEat[18], animalWalk[18])
    };
    Flyable[] flyingingAnimals = {
            new Flyable("Ibis", animalEat[8], animalWalk[8]),
            new Flyable("Quail", animalEat[16], animalWalk[16]),
            new Flyable("Vulture", animalEat[21], animalWalk[21])

    };
}