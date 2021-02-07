import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Puzzle8 {
    int[] table;
    int pos;
    int last;
    int score;
    ArrayList<Integer> moves;

    public Puzzle8() {
        table=new int[]{1,2,3,4,0,8,5,6,7};
        pos=4;
        last=-1;
        score=0;
        moves= new ArrayList<>();
        suffle();
    }
    public void suffle(){
        int dif = (int)(Math.random()*24)+10;
        while (true){
            int[]p = this.posibleMoves();
            int n= (int)(Math.random()*p.length);
            if (n==last){
                if (n!=0){n--; }
                else{n++;}
            }
            this.moveThis(p[n]);
            if (score>dif){break;}
        }
    }
    public void moveThis(int curr){
        last=pos;
        this.table[pos]=this.table[curr];
        this.table[curr] = 0;
        pos=curr;
        this.score=scoreTable();
    }

    public Puzzle8(int[] curr, int pos, int last, ArrayList moves){
        this.table= curr;
        this.pos=pos;
        this.last=last;
        this.moves=moves;
        score =scoreTable();
    }
    public int scoreTable(){
        return getG()+getH();
   }
    public int getG(){
        int res=0;
        for (int i=0; i<9; i++) {
            if (i<4&&table[i]!=i+1){ res++;}
            if (i>5&&table[i]!=i-1){res++;}
        }
        if (table[4]!=0){res++;}
        if (table[5]!=8){res++;}
       return res;
   }
    public int getH(){
        int res=0;
        int curr=table[0];
        if (curr!=1){
            if (curr==2||curr==4){res++;}
            else if(curr==3||curr==0||curr==5){res+=2;}
            else if(curr==7){res+=4;}
            else{res+=3;}

        }
       curr=table[1];
       if (curr!=2){
           if (curr==1||curr==3||curr==0){res++;}
           else if(curr==4||curr==6||curr==8){res+=2;}
           else{res+=3;}

       }
       curr=table[2];
       if (curr!=3){
           if (curr==2||curr==8){res++;}
           else if(curr==1||curr==0||curr==7){res+=2;}
           else if(curr==5){res+=4;}
           else{res+=3;}

       }
       curr=table[3];
       if (curr!=4){
           if (curr==1||curr==5||curr==0){res++;}
           else if(curr==2||curr==6){res+=2;}
           else{res+=3;}

       }
       curr=table[4];
       if (curr!=0){
           if (curr==2||curr==4||curr==6||curr==8){res++;}
           else{res+=2;}

       }
       curr=table[5];
       if (curr!=8){
           if (curr==3||curr==7||curr==0){res++;}
           else if(curr==2||curr==4||curr==6){res+=2;}
           else{res+=3;}

       }
       curr=table[6];
       if (curr!=5){
           if (curr==6||curr==4){res++;}
           else if(curr==1||curr==0||curr==7){res+=2;}
           else if(curr==3){res+=4;}
           else{res+=3;}

       }
       curr=table[7];
       if (curr!=6){
           if (curr==5||curr==7||curr==0){res++;}
           else if(curr==4||curr==8||curr==2){res+=2;}
           else{res+=3;}

       }
       curr=table[8];
       if (curr!=7){
           if (curr==8||curr==6){res++;}
           else if(curr==3||curr==0||curr==5){res+=2;}
           else if(curr==1){res+=4;}
           else{res+=3;}

       }

       return res;
   }



   public Puzzle8 move(int curr) {
       int[] arr = this.table.clone();
       arr[pos] = table[curr];
       arr[curr] = 0;
       ArrayList mov = (ArrayList) moves.clone();
       mov.add(curr);
       return new Puzzle8(arr, curr, pos, mov);
   }

    public int[] posibleMoves(){
        int res[];
        switch (pos){
            case 0:    res = new int[]{1,3}; return res;
            case 1:    res = new int[]{0,2,4}; return res;
            case 2:    res = new int[]{1,5}; return res;
            case 3:    res = new int[]{0,4,6}; return res;
            case 4:    res = new int[]{1,3,5,7}; return res;
            case 5:    res = new int[]{2,4,8}; return res;
            case 6:    res = new int[]{3,7}; return res;
            case 7:    res = new int[]{4,6,8}; return res;
            case 8:    res = new int[]{5,7}; return res;
        }
        return null;

    }


    public String toString(){
        String res= "|| ";
        for (int i=0; i<this.table.length; i++){
            res+=this.table[i]+" || ";
            if ((i+1)%3==0&&i!=8){
                res+="\n|| ";
            }
        }
        res+="\n";
        return res;
    }

    public static void main(String[] args) {
        Puzzle8 p = new Puzzle8();
        System.out.println(p.moves);
        Puzzle8 a =p.move(2);
        System.out.println(p.moves);
        System.out.println(a.moves);
    }

}
