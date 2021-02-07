import javax.swing.*;

public class MyFrame extends JFrame {
    Game game = new Game();
    MyFrame(){
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(700,700);


        game.setBounds(0,0,700,700);
        this.add(game);


        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
