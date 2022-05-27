import java.io.*;
import java.util.*;

public class Main {


	public static void solution(int[] arr, int vidx,int n , 
	int k,int[] subsetSum,int ssssf, ArrayList<ArrayList<Integer>> ans) {
		//write your code here

		if(vidx == n){
			if(ssssf == k){
				int sum = subsetSum[0];

				for(int i=1;i<k;i++){
					if(sum!=subsetSum[i]){
						return;
					}

				}
			
			for(ArrayList<Integer> list : ans){
				System.out.print("[");
				for(int i=0;i<list.size();i++){
					if(i==0){
						System.out.print(list.get(i));
					}else{
						System.out.print(", "+list.get(i));
					}
					

					
				}
				System.out.print("] ");

			}
			System.out.println();
			}
			return;

		}


		for(int i = 0;i<k;i++){
			ArrayList<Integer> list = ans.get(i);

			list.add(arr[vidx]);
			subsetSum[i] = subsetSum[i]+arr[vidx];
			if(list.size()==1){
				
				solution(arr, vidx+1, n, k, subsetSum, ssssf+1, ans);
				list.remove(list.size()-1);
				subsetSum[i] = subsetSum[i]-arr[vidx];
				break;

			}else{

				solution(arr, vidx+1, n, k, subsetSum, ssssf, ans);
			}
			list.remove(list.size()-1);
			subsetSum[i] = subsetSum[i]-arr[vidx];
		}



	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for(int i =  0 ; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			sum += arr[i];
		}
		int k = scn.nextInt();
		// if k is equal to 1, then whole array is your answer 
		if(k == 1) {
			System.out.print("[");
			for(int i = 0 ; i  < arr.length; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.println("]");
			return;
		}
		//if there are more subsets than no. of elements in array or sum of all elements is not divisible by k
		if(k > n || sum % k != 0) {
			System.out.println("-1");
			return;
		}
		int[] subsetSum = new int[k];
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(arr,0,n,k,subsetSum,0,ans);
	}
	
	

}
