import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		for(int i=1;i<=9;i++){
			lexicographical(n, i);
		}
		



		//write your code here
	}


	public static void lexicographical(int n, int s){

		if(s>n){
			return;
		}
		if(s!=0){
			System.out.println(s);
		}
		
		
		for(int i=0;i<=9;i++){
			lexicographical(n, ((s)*10)+i);

		}

	}
}
