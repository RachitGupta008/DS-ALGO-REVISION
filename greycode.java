import java.util.*;
 
 public class Main {
 
     public static List<Integer> grayCode(int n) {
 	 //Write your code here
    if(n==1){
        ArrayList<Integer> bres = new ArrayList<>();
        bres.add(0);
        bres.add(1);
        return bres;
    }
    if(n==0){
        ArrayList<Integer> bres = new ArrayList<>();
        bres.add(0);
       
        return bres;
    }
    
   
    List<Integer> ans = grayCode(n-1);
    int mask = 1<<n-1;
    
    for(int i=ans.size()-1;i>=0;i--){
        int num = ans.get(i);
        ans.add(num^mask);
    }
 	 return ans;
 	 
 	 
     }
 
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         List<Integer> ans=grayCode(scn.nextInt());
         Collections.sort(ans);
         System.out.println(ans);
     }
 }
