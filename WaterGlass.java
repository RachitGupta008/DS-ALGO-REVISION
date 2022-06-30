

import java.io.*;
import java.util.*;

public class Main {

    public static double solution(int k, int r, int c) {
        // write your code here

        double amt = k;



        double[][] dp = new double[r+1][r+1];

        dp[0][0] = amt;


        for(int i=0;i<r;i++){
            for(int j=0;j<=i;j++){

                double spare = dp[i][j]-1.0;
                if(spare>0){
                    dp[i+1][j] += spare/2.0;
                    dp[i+1][j+1] += spare/2.0;
                    dp[i][j] = 1.0;

                }


            }
        }

        return dp[r][c]>1.0?1.0:dp[r][c];


    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();
        System.out.println(solution(k, r, c));
    }

}
