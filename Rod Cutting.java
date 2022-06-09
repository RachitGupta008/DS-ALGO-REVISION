import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int[] prices) {
    // write your code here
    int narr[] = new int[prices.length+1];
    
    for(int i=1;i<narr.length;i++){
        narr[i] = prices[i-1];
    }
    
    int dp[] = new int[prices.length+1];
    
    dp[1] = narr[1];
    for(int i=2;i<narr.length;i++){
        int j = i-1;
        int k=1;
        int ans = Integer.MIN_VALUE;
        while(j>=k){
            ans = Math.max(dp[k]+dp[j], ans);
            ans = Math.max(ans, narr[i]);
            k++;
            j--;
            
            
        }
        dp[i] = ans;
        
    }

    return dp[dp.length-1];
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] prices = new int[n];
    for (int i = 0; i < n; i++) {
      prices[i] = scn.nextInt();
    }
    System.out.println(solution(prices));
  }

}
