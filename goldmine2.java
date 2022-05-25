import java.io.*;
import java.util.*;

public class Main {
	static int max = 0;
	public static void getMaxGold(int[][] arr){
		//write your code here

		boolean[][] visited = new boolean[arr.length][arr[0].length];

		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				if(!visited[i][j]){
					max = Math.max(max, fetchGold(arr, i, j, visited));
				}
			}
		}
	}

	public static int fetchGold(int[][] arr, int r, int c, boolean[][] visited){

		if( r>=arr.length||r<0|| c<0|| c>=arr[0].length|| arr[r][c]==0 ||visited[r][c]){
			return 0;
		}

		visited[r][c] = true;
		int gold = arr[r][c];

		gold = gold 
		+fetchGold(arr, r+1, c, visited)
		+fetchGold(arr, r, c+1, visited)
		+fetchGold(arr, r-1, c, visited)
		+fetchGold(arr, r, c-1, visited);

		return gold;

	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0 ; j  < arr[0].length; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		getMaxGold(arr);
		System.out.println(max);
	}
		
}
