import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
        // write your code here
        if(qpsf == tq){
            for(int i=0;i<chess.length;i++){
                for(int j=0;j<chess[0].length;j++){
                    if(chess[i][j]){
                        System.out.print("q\t");
                    }else{
                        System.out.print("-\t");
                    }
                    
                    
                }
                System.out.println();
            }
            System.out.println();
        }


        for(int i=lcno+1;i<(tq*tq);i++){
            int r = i/(tq);
            int c = i%(tq);
            chess[r][c] = true;
            queensCombinations(qpsf+1, tq, chess, i);
            chess[r][c] = false;

        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
}
