import java.io.*;
import java.util.*;

public class Main {
	//solution using recursion and memoization
	//Can also be done using tabulation
	//It can be optimized furthar by going thru binary search, always check the middle floor.

	public static int eggDrop(int n, int k, Map<String, Integer> map){
		//write your code here

		
		if(n==1){
			return k;
		}
		if(k==0){
			return 0;
		}
		if(k==1){
			return 1;
		}

		if(map.containsKey(n+" "+k)){
			return map.get(n+" "+k);
		}


		int ans = Integer.MAX_VALUE;

		for(int i=1;i<=k;i++){

			int a = eggDrop(n-1, i-1, map);
			int b = eggDrop(n, k-i, map);
			ans = Math.min(ans, Math.max(a, b));
		}

		map.put(n+" "+k, ans+1);
		return ans+1;
	} 

	// By Tabulation
	  public static int eggDropTable(int n, int k) {
    int[][]dp = new int[n + 1][k + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= k; j++) {
        if (i == 1) {
          dp[i][j] = j;
        } else if (j == 1) {
          dp[i][j] = 1;
        } else {
          int min = Integer.MAX_VALUE;
          for (int mj = j - 1, pj = 0; mj >= 0; mj--, pj++) {
            int v1 = dp[i][mj]; //egg survives
            int v2 = dp[i - 1][pj]; //egg breaks
            int val = Math.max(v1, v2);
            min = Math.min(val, min);
          }
          dp[i][j] = min + 1;
        }
      }
    }
    return dp[n][k];
  }

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//n -> number of eggs and k -> number of floors
		int n = scn.nextInt();
		int k = scn.nextInt();
		Map<String, Integer> map = new HashMap<>();
		System.out.println(eggDropTable(n,k));
	}
	
}
