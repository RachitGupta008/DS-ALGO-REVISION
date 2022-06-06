import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    long[] dp = new long[n + 1];
    dp[0] = 1; //since 0th Catalan number is 1

    dp[1] = 1;
    for(int k=2;k<=n;k++){
    for(int i=k-1,j=0;i>=0;i--,j++){

        dp[k] = dp[k]+dp[i]*dp[j];
        

    }
    //System.out.print(dp[k]+" ");
    }
    // write your code here
    System.out.println(dp[n]);

 }

}
