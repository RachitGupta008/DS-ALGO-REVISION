import java.util.*;
 
 class Main {
 	 public static void main (String[] args) {
 	 Scanner sc=new Scanner(System.in);
 	     String s=sc.next();
 	     String t=sc.next();
 	     function(s, t);
 	 }
 	 	 // -----------------------------------------------------
 	 // This is a functional problem. Only this function has to be written.
 	 // This function takes as input 2 strings 
 	 // It should return the required output
 
 	 public static void function(String S, String T){
 	 	 //Write your code here
		int l = S.length();
		int t = T.length();
		int prev[] = new int[l+1];
		int curr[] = new int[l+1];



		for(int i=0;i<l;i++){
			prev[i] = 1;
		}
		prev[l] = 1;


		for(int i=t-1;i>=0;i--){
			for(int j=l;j>=0;j--){
					if(j==l){

						curr[j] = 0;
					}else {
						if(T.charAt(i) == S.charAt(j)){

							curr[j] += prev[j+1];
						}
						curr[j] += curr[j+1];



					}

				

			}
			prev = curr;
				curr = new int[l+1];
		}
		System.out.println(prev[0]);

 	 }
 }
