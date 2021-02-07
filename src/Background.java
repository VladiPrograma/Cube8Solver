import javax.swing.*;
import java.awt.*;

public class Background extends JLabel {
    public Background(){
        ImageIcon imageIcon = new ImageIcon("src\\Images\\Fondo.jpg");
        this.setIcon(imageIcon);
        this.setOpaque(true);
    }
}
