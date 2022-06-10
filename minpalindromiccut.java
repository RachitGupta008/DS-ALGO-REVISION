import java.io.*;
import java.util.*;

public class Main {

  
  //This is a o n^3 solution can be reduced to o n^2 by using 1d array also for checking the palindrome we can first create a 2d palindrome array dp.
  
	public static int minPalindromicCut(String s) {
		//write your code here
		int dp[][] = new int[s.length()][s.length()];

		for(int g=0;g<dp.length;g++){
			for(int i=0,j=g;j<dp.length;i++, j++){

				if(g==0){
					dp[i][j] = 0;
				}

				else if(isPalindrome(s.substring(i, j+1))){
					dp[i][j] = 0;

				}else{
					int ans = Integer.MAX_VALUE;
					for(int k=i;k<j;k++){
						int l = dp[i][k];
						int r = dp[k+1][j];

						ans = Math.min(ans, l+r+1);


					}
					dp[i][j] = ans;

				}

			}
		}




		return dp[0][dp.length-1];
	}

	public static boolean isPalindrome(String s){

		int i=0;
		int j=s.length()-1;
		while(i<=j){
			if(s.charAt(i)!=s.charAt(j)){
				return false;
			}
		i++;
		j--;

		}
	return true;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(minPalindromicCut(str));
	}
}
