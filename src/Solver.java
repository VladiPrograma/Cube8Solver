import java.util.ArrayList;
import java.util.Arrays;

public class Solver {
   ArrayList<Puzzle8> arr = new ArrayList<>();
   ArrayList<Puzzle8> notGood = new ArrayList<>();
   Puzzle8 winner = null;
    public Solver(Puzzle8 puzzle8){
        arr.add(puzzle8);
    }

    public void Iterate(){
        ArrayList<Puzzle8> curr = new ArrayList<>();
        for (int i=0; i<arr.size(); i++){
            int[]moves = arr.get(i).posibleMoves();
            for (int j=0; j<moves.length; j++){
                if (arr.get(i).last!=moves[j]) {
                    curr.add(arr.get(i).move(moves[j]));
                    if (curr.get(curr.size()-1).score==0){
                        winner=curr.get(curr.size()-1);
                        break;
                    }
                }
            }
            if (winner!=null){break;}
        }
        arr=curr;
    }

    public Puzzle8 bestOne(){
        int cont=500;
        int pos=-1;
        for (int i=0; i<arr.size(); i++){
            int score =arr.get(i).score;
            if (score<cont&&isBestOne(arr.get((i)))){
                cont=score;
                pos=i;
                arr.get(i).last=-1;
                notGood.add(arr.get(i));
            }
        }

        return arr.get(pos);
    }

    public boolean isBestOne(Puzzle8 p){
        for (int i=0; i<notGood.size(); i++){
            if (Arrays.equals(notGood.get(i).table, p.table)){
                return false;
            }
        }
        return true;

    }

    public void clean(){
        ArrayList<Puzzle8> curr = new ArrayList<>();
        for (int i=0; i<arr.size(); i++){
            boolean repeated=false;
            for (int j=i+1; j<arr.size(); j++){
                if (Arrays.equals(arr.get(i).table, arr.get(j).table)){
                    repeated=true;
                    break;
                }
            }
            if (!repeated){
                curr.add(arr.get(i));
            }

        }
        arr=curr;
    }

    public Puzzle8 ThickSearch(){
        int cont=0;
        while(winner==null){
                Iterate();
                cont++;
                if (winner!=null){break;}

        }
        return arr.get(arr.size()-1);
    }

    public Puzzle8 manhattanSearch(){
        while (winner==null){
            for (int i=0; i<=12; i++){
                Iterate();
                if (winner!=null){break;}
            }
            ArrayList<Puzzle8> curr = new ArrayList<>();
            curr.add(bestOne());
            arr=curr;


        }
        return winner;
    }

    public void unHilo(){
        while (true) {
            int x=0;
            int[] curr = arr.get(0).posibleMoves();
            if (arr.get(0).last==curr[x]){x++;}
            arr.set(0, arr.get(0).move(curr[x]));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {7,6,4,8,5,2,3,0,1};
        int[] pito = {1,0,3,4,2,8,6,5,7};


            Puzzle8 p = new Puzzle8();
            Solver s = new Solver(p);
            s.manhattanSearch();
        System.out.println(s.winner);
        System.out.println(s.winner.moves);


    }
}
