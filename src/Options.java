import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.undo.CannotUndoException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Options extends JPanel implements ActionListener {
    JButton shuffle;
    JButton minMoves;
    JButton manhattan;
    Puzzle8 winner;
    static boolean solved=false;
    Timer timer = new Timer(500, this);
    int cont;
    public Options(){
        this.setLayout(null);
        this.setOpaque(false);
        Border border = BorderFactory.createLineBorder(new Color(0x340A33), 3);


        timer.start();
        shuffle = new JButton("Shuffle");
        shuffle.setBounds(50,585,100,50);
        shuffle.setBackground(new Color(0x7B0060));
        shuffle.setBorder(null);
        shuffle.setForeground(new Color(0xFFFFFF));
        shuffle.setFocusable(false);
        shuffle.addActionListener(this);
        shuffle.setBorder(border);
        this.add(shuffle);



        minMoves = new JButton("Solve Min");
        minMoves.setBounds(200,585,100,50);
        minMoves.setBackground(new Color(0x7B0060));
        minMoves.setBorder(null);
        minMoves.setForeground(new Color(0xFFFFFF));
        minMoves.setFocusable(false);
        minMoves.addActionListener(this);
        minMoves.setBorder(border);
        this.add(minMoves);



        manhattan = new JButton("Solve Manhattan");
        manhattan.setBounds(400,585,120,50);
        manhattan.setBackground(new Color(0x7B0060));
        manhattan.setBorder(null);
        manhattan.setForeground(new Color(0xFFFFFF));
        manhattan.setFocusable(false);
        manhattan.addActionListener(this);
        manhattan.setBorder(border);
        this.add(manhattan);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==timer&&solved){
            if (cont<winner.moves.size()) {
                Cube8.p = Cube8.p.move(winner.moves.get(cont));
                cont++;
                Cube8.paintTable();
            }

        }
        if (e.getSource()==timer&&!solved){
            manhattan.setEnabled(true);
            minMoves.setEnabled(true);
        }
        if (e.getSource()==shuffle){
            solved=false;
            Cube8.p =new Puzzle8();
            for (int i=0; i<9; i++){
                if (Cube8.p.table[i]!=0){
                    Cube8.arr[i].setText(Integer.toString(Cube8.p.table[i]));
                    Cube8.arr[i].setOpaque(true);
                }
                else{
                    Cube8.arr[i].setText("");
                    Cube8.arr[i].setOpaque(false);
                }
            }
            minMoves.setEnabled(true);
            manhattan.setEnabled(true);
            winner=null;
            cont=0;
        }

        if (e.getSource()==minMoves){
            minMoves.setEnabled(false);
            manhattan.setEnabled(false);
            Solver s = new Solver(Cube8.p);
            s.ThickSearch();
            winner = s.winner;
            solved=true;
        }

        if (e.getSource()==manhattan){
            minMoves.setEnabled(false);
            manhattan.setEnabled(false);
            Solver s = new Solver(Cube8.p);
            s.manhattanSearch();
            winner = s.winner;
            solved=true;
        }

    }



}
