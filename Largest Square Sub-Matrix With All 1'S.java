import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int[][] arr) {
		//write your code here

		int m = arr.length;
		int n = arr[0].length;
		int[][] dp = new int[m][n];
		int ans = Integer.MIN_VALUE;

		for(int i=m-1;i>=0;i--){
			for(int j=n-1;j>=0;j--){
				if(i==m-1 || j==n-1 || arr[i][j]==0){
					dp[i][j] = arr[i][j];
				}else{

					dp[i][j] = Math.min(Math.min(dp[i][j+1], dp[i+1][j]), dp[i+1][j+1])+1;

				}
				

			ans = Math.max(dp[i][j], ans);

			}

		}
		return ans;

	}
	public static int max = Integer.MIN_VALUE;

	public static int memSolution(int[][] arr, int[][] memo, int i, int j){

		if(i==arr.length-1 || j==arr[0].length-1 ){
			memo[i][j] = arr[i][j];
			if(arr[i][j]>max){
				max = arr[i][j];
			}
			return memo[i][j];
		}

		if(memo[i][j]!=-1){
			return memo[i][j];
		}

		


		int m1 = memSolution(arr, memo, i, j+1);
		int m2 = memSolution(arr, memo, i+1, j);
		int m3 = memSolution(arr, memo, i+1, j+1);

		

		if(arr[i][j]==0){
			memo[i][j] = 0;
		}else{
			memo[i][j] = Math.min(Math.min(m1, m2), m3)+1;
		}


		if(memo[i][j]>max){
			max = memo[i][j];
		}

		return memo[i][j];


	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m =scn.nextInt();
		int[][] arr = new int[n][m];
		for(int i = 0 ; i < n; i++){
			for(int j = 0 ; j < m; j++){
				arr[i][j] = scn.nextInt();
			}
		}

		int[][] memo = new int[n][m];

		for(int i = 0 ; i < n; i++){
			for(int j = 0 ; j < m; j++){
				memo[i][j] = -1;
			}
		}

		memSolution(arr, memo, 0, 0);
		//System.out.println(max);
		System.out.println(solution(arr));
	}

}
