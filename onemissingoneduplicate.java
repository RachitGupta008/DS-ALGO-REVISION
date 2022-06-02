import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    solution(arr);
  }

  public static void solution(int[] arr){
   //write your code here

   int xor = 0;
   for(int i=0;i<arr.length;i++){

     xor = xor ^ arr[i] ^ (i+1);
   }

   int rssb = xor & (-xor);
  int x =0;
  int y = 0;

   for(int i=0;i<arr.length;i++){
     if((arr[i]&rssb)==rssb){
       x = x ^ arr[i];
     }else{
       y = y ^ arr[i];
     }

    if(((i+1)&rssb)==rssb){
       x = x ^ (i+1);
     }else{
       y = y ^ (i+1);
     }


   }
    boolean missing=true;
    for(int i=0;i<arr.length;i++){
      if(arr[i]==x){
        missing = false;
        break;
      }
    }

   if(missing){
     System.out.println("Missing Number -> "+x);
     System.out.println("Repeating Number -> "+y);
   }else{
     System.out.println("Missing Number -> "+y);
     System.out.println("Repeating Number -> "+x);
   }
   
  }

}
