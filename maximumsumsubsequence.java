import java.io.*;
import java.util.*;

public class Main {

    public static void solution(int[] arr){
        int dp[] = new int[arr.length];

        int omax = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int val = arr[i];
            int min = 0;
            for(int j=0;j<i;j++){
                if(arr[j]<=arr[i]){
                    min = Math.max(min, dp[j]);
                }

            }
            dp[i] = min+arr[i];
            //System.out.print(dp[i]+ " ");

            omax = Math.max(omax, dp[i]);

        }

        System.out.println(omax);

    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        solution(arr);
         scn.close();
    }

}
