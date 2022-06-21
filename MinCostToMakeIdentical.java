import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String s1, String s2, int c1, int c2) {
		// write your code here


		int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];

		for(int i=len1;i>=0;i--){
            for(int j=len2;j>=0;j--){
				if(i==len1 && j == len2){
					dp[i][j] = 0;
				}else if (i==len1) {
					dp[i][j] = dp[i][j+1]+c2;
					
				} else if(j==len2) {
					dp[i][j] = dp[i+1][j]+c1;
				}else{

					int r = c2+dp[i][j+1];
					int b = c1+dp[i+1][j];
					int m = dp[i+1][j+1];

					if(s1.charAt(i) != s2.charAt(j)){
						m  = m+ c1+c2;
					}

					dp[i][j] = Math.min(Math.min(r, b), m);




				}


			}
			}

		return dp[0][0];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		int x = scn.nextInt();
		int y = scn.nextInt();
		System.out.println(solution(s1, s2,x, y));
	}

}
