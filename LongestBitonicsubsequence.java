import java.io.*;
import java.util.*;

public class Main {
     public static void solution(int []arr){


         int[]dp = new int[arr.length];
         int[]dp1 = new int[arr.length];

         for (int i = 0; i < dp.length; i++) {

             int max = 0;
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          if (dp[j] > max) {
            max = dp[j];
          }
        }
      }

      dp[i] = max + 1;
         }

         int ans = 0;

        for(int i=dp.length-1;i>=0;i--){
            int max =0;
            for(int j=i+1;j<dp.length;j++){
                if(arr[j]<arr[i]){
                    max = Math.max(dp1[j], max);

                }

            
            }
        dp1[i] = max+1;

        ans = Math.max(ans, dp1[i]+dp[i]-1);

        }

        System.out.println(ans);
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
