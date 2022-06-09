


import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int[] arr) {


        //write your code here

        int dp[][] = new int[arr.length][arr.length];

        for(int g=0;g<dp.length;g++){
            for(int i=0,j=g; j<dp.length;i++,j++){

                if(g == 0){

                    dp[i][j] = (j-1>=0?arr[j-1]:1)*arr[j]*(j+1<arr.length?arr[j+1]:1);
                }
                else{
                    int ans = Integer.MIN_VALUE;
                    for (int k=i;k<=j;k++){
                        int l =k-1>=0?dp[i][k-1]:0;
                        int r = k+1<dp.length?dp[k+1][j]:0;
                        int act = arr[k]*(i-1>=0?arr[i-1]:1)*(j+1<arr.length?arr[j+1]:1);
                        ans = Math.max(ans, l+r+act);
                    }
                    dp[i][j] = ans;
                }


            }
        }

        return dp[0][dp.length-1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}
