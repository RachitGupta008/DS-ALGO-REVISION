import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		solve(arr, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
		System.out.println(ans);
	}

	static int mindiff = Integer.MAX_VALUE;
	static String ans = "";

	public static void solve(int[] arr, int vidx, 
	ArrayList<Integer> set1, ArrayList<Integer> set2, int soset1,
			int soset2) {
		//write your code here

		if(vidx==arr.length){
			
			if(Math.abs(set1.size()-set2.size())<=1){
				int mval = Math.abs(soset1-soset2);
				if(mval<mindiff){
					mindiff = mval;
					ans =  set1.toString()+" "+set2.toString() ;
				}

			}
			return;

		}



		int val = arr[vidx];

		set1.add(val);
		soset1+=val;
		solve(arr, vidx+1, set1, set2, soset1, soset2);
		set1.remove(set1.size()-1);
		soset1-=val;

		set2.add(val);
		soset2+=val;
		solve(arr, vidx+1, set1, set2, soset1, soset2);
		set2.remove(set2.size()-1);
		soset2-=val;



	}

}
