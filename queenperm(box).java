import java.io.*;
import java.util.*;

public class Main {

    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        // write your code here
        if(row == tq){
            if(qpsf == tq){
                System.out.println(asf);
                System.out.println();

            }
            return;
        }

        boolean cond = (col == (tq-1));
        if(col == (tq-1)){
            row = row+1;
            col = 0;

        }else{
            row = row;
            col = col+1;

        }

       

        for(int i=0;i<queens.length;i++){
            if(!queens[i]){
                queens[i] = true;
                queensPermutations(qpsf+1,tq, row, col, cond?asf+"q"+(i+1)+"\n":asf+"q"+(i+1)+"\t"
                ,queens
                 );
                 queens[i] = false;
            }
        }

        queensPermutations(qpsf,tq, row, col, cond?asf+"-"+"\n":asf+"-\t"
                ,queens
                 );


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}
