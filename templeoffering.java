import java.io.*;
import java.util.*;

public class Main {
	
	public static int totaloffering(int[] height) {
		// write your code here
		int dp1[] = new int[height.length];
		

		for(int i=0;i<height.length;i++){
			if(i==0){
				dp1[i] = 1;
			}else if(height[i-1]<height[i]){
				dp1[i] = dp1[i-1]+1;
			}else{
				dp1[i] = 1;
			}

		}
		int dp2[] = new int[height.length];
		int ans = 0;
		for(int i=height.length-1;i>=0;i--){
			if(i==height.length-1){
				dp2[i] = 1;
			}else if(height[i]>height[i+1]){
				dp2[i] = dp2[i+1]+1;
			}else{
				dp2[i] = 1;
			}

			dp1[i] = Math.max(dp1[i], dp2[i]);
			ans+=dp1[i];

		}
		
		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int height[] = new int[n];
		for (int i = 0; i < n; i++) {
			height[i] = scn.nextInt();
		}
		System.out.println(totaloffering(height));
	}

}
