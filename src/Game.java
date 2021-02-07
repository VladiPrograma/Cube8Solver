import javax.swing.*;

public class Game extends JLayeredPane {
    Background background = new Background();
    Cube8 cube8 = new Cube8();
    Options options = new Options();
    public Game(){
        this.add(background, Integer.valueOf(0));
        background.setBounds(0,0,700,700);

        this.add(cube8, Integer.valueOf(1));
        cube8.setBounds(0,0,700,700);
        this.addMouseListener(cube8);


        options.setBounds(0,0,700,700);
        this.add(options, Integer.valueOf(2));
    }
}
