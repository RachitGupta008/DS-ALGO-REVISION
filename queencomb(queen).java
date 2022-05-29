import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j){
        // write your code here

        if(qpsf == tq){
            
            for(int k=0;k<chess.length;k++){
            for(int l = 0;l<chess[k].length;l++){
                if(chess[k][l]){
                    System.out.print("q\t");
                }
                
                else{
                    System.out.print("-\t");
                }
            
            }
            System.out.println();
            }
            System.out.println();
            return;

        }

        for(int k=i;k<chess.length;k++){
            if(k==i){
            for(int l = j+1;l<chess[k].length;l++){
                if(chess[k][l]==false){
                    chess[k][l] = true;
                    queensCombinations(qpsf+1, tq, chess, k, l);
                    chess[k][l] = false;

                }

            }

            }else{
                for(int l = 0;l<chess[k].length;l++){
                if(chess[k][l]==false){
                    chess[k][l] = true;
                    queensCombinations(qpsf+1, tq, chess, k, l);
                    chess[k][l] = false;

                }

            }

            }

            
        }


    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations(0, n, chess, 0, -1);
    }
}
