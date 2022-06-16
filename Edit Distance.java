import java.io.*;
import java.util.*;

public class Main {
	
	public static int solution(String str1, String str2) {
		//write your code here

		int[][] dp = new int[str2.length()+1][str1.length()+1];


		for(int i=str2.length();i>=0;i--){
			for(int j=str1.length();j>=0;j--){
				if(i==str2.length()){

					dp[i][j] = str1.length()-j;
				}
				else if(j==str1.length()){
					dp[i][j] = str2.length()-i;
				}else{
					if(str2.charAt(i) == str1.charAt(j)){
						dp[i][j] = dp[i+1][j+1];
					}else{

						int b = dp[i+1][j];
						int l = dp[i][j+1];
						int d = dp[i+1][j+1];


						dp[i][j] =1+ Math.min(Math.min(b, l), d);


					}


				}

			}
		}




		return dp[0][0];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}
