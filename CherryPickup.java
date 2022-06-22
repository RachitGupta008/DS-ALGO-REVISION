

import java.io.*;
import java.util.*;

public class Main {

    public static int Solution(int r1, int c1, int r2, int[][] arr, int[][][] dp) {
        //write your code here

        return 0;
    }
    public static int ans1 = Integer.MIN_VALUE;
    //This is the solution using  backtracking
    public static int Solution(int r1, int c1, int[][] arr, boolean visited){
        if((visited && r1 ==0 && c1 == 0) || (r1==arr.length || c1 == arr[0].length || r1<0 || c1<0
                || arr[r1][c1] == -1
        )){
            return 0;
        }

        if(!visited && (r1 == arr.length-1 && c1 == arr[0].length-1)){
            return Solution(r1, c1, arr, true);
        }
        int ansb = 0;
        int ansr = 0;
        int ans = 0;
        if(!visited){

            int temp = arr[r1][c1];


            arr[r1][c1] = 0;
            ansb = temp+ Solution(r1+1, c1, arr, visited);
            arr[r1][c1] = temp;

            arr[r1][c1] = 0;
            ansr = temp+ Solution(r1, c1+1, arr, visited);
            arr[r1][c1] = temp;



        }



        if(visited){

            int temp = arr[r1][c1];

            arr[r1][c1] = 0;
            ansb = temp+ Solution(r1-1, c1, arr, visited);
            arr[r1][c1] = temp;

            arr[r1][c1] = 0;
            ansr = temp+ Solution(r1, c1-1, arr, visited);
            arr[r1][c1] = temp;


        }

        return Math.max(ansb, ansr);



    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        //Solution(0, 0, 0, arr, new int[n][n][n])
        int ans = Math.max(0,Solution(0, 0, arr, false));
        System.out.println(ans);
    }

}
