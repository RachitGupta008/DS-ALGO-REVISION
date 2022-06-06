import java.io.*;
import java.util.*;

public class Main {
  
  //Written both recursive and tabulation but recursive will not work on big nums due to stack overflow since each time a new stack will be formed new space has to be created for dp array which can resulti in low memory.
  

	public static int solution(int n, Integer[] dp){
		//write your code here
		if(n<=3){
			return n;
		}

		if(dp[n]!=null){
			return dp[n];
		}



		int x = (int)Math.sqrt(n);

		int ans = Integer.MAX_VALUE;
		for(int i=1;i<=x;i++){

			ans = Math.min(ans, 1+solution(n-i*i, dp));

		}

		dp[n] = ans;

		return ans;
	}

	public static int solution(int n){
		int[] dp = new int[n+1];
		dp[0] = 0;
		for(int j=1;j<=n;j++){
			int max = Integer.MAX_VALUE;
			for(int i=1;j-i*i>=0;i++){
				max = Math.min(dp[j-i*i], max);

			}
			dp[j] = max+1;
			//System.out.print(dp[j]+" " );
		}
		
		return dp[n];

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		Integer[] dp = new Integer[n+1];
		System.out.println(solution(n));
	}


	
}
