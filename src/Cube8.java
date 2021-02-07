import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cube8 extends JPanel implements MouseListener{
    static Puzzle8 p = new Puzzle8();
    static JLabel[] arr = new JLabel[9];
    JButton shuffle;
    JButton minMoves;
    JButton solve;
    public Cube8(){
        int y=30;
        int x=87;
        for (int i=0; i<9; i++){
            arr[i]=new CubeLabel(i);
            arr[i].addMouseListener(this);
            if (p.table[i]==0){
                arr[i].setOpaque(false);
            }
            else {
                arr[i].setText(Integer.toString(p.table[i]));
            }
            arr[i].setBounds(x,y,175,175);
            this.add(arr[i]);
            x+=175;
            if ((i+1)%3==0){y+=175; x=87;}
        }

        this.setLayout(null);
        this.setOpaque(false);
        this.setBounds(0,0,700,700);
    }


    static void paintTable(){
        for (int i=0; i<9; i++){
            if (arr[i].isOpaque()&&p.table[i]==0){
                arr[i].setOpaque(false);
                arr[i].setText("");
            }
            else if (!arr[i].isOpaque()&&p.table[i]!=0){
                arr[i].setOpaque(true);
                arr[i].setText(Integer.toString(p.table[i]));
            }
        }
    }



    public void mousePressed(MouseEvent e) {
        try {
            CubeLabel one = (CubeLabel) e.getSource();
            int[] moves = p.posibleMoves();
            for (int i = 0; i < moves.length; i++) {
                if (one.pos == moves[i]) {
                    p.moveThis(moves[i]);
                    paintTable();
                    break;
                }
            }
            Options.solved=false;
        }catch (Exception E){
            System.out.println("Not valid");
        }
    }

    public void mouseClicked(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
}

