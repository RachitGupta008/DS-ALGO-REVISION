import java.io.*;
import java.util.*;

public class Main {

	static String max;
	public static void findMaximum(String str, int k) {
		//write your code here
		if(Integer.parseInt(str)>Integer.parseInt(max)){
			max = str;
			
		}

		if(k==0){
			return;
		}


		for(int i=0;i<str.length();i++){
			for(int j=i+1;j<str.length();j++){

				str = swap(str, i, j);
				//System.out.println(str);
				findMaximum(str, k-1);
				str = swap(str, i, j);

			}
		}


		
	}

	public static String swap(String str, int i, int j){
		String test ="";
		char[] arr= str.toCharArray();
		char temp='0';
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

		for(int id=0;id<arr.length;id++){
			test = test+arr[id];
		}

		return test;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = scn.nextInt();
		 max = str;
		findMaximum(str, k);
		System.out.println(max);
	}

}
