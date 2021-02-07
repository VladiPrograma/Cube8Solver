import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CubeLabel extends JLabel {
    int pos=0;
    public CubeLabel(int pos){
        this.pos=pos;
        this.setBackground(new Color(0x5C286F));
        this.setOpaque(true);
        this.setVerticalAlignment(SwingConstants.CENTER);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setFont(new Font("Sans serif", 2, 50));
        this.setForeground(new Color(0xE7E7E7));
        Border border = BorderFactory.createLineBorder(new Color(0x4C0A4B), 3);
        this.setBorder(border);
    }
}
