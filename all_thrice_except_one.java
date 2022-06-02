//Tricky quesition
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
   int tn = -1;
   int tnp1=0;
   int tnp2=0;

   for(int i=0;i<arr.length;i++){


     int mtn = tn & arr[i];
     int mtnp1 = tnp1 & arr[i];
     int mtnp2 = tnp2 & arr[i];

      tn = tn & (~mtn);
      tnp1 = tnp1 | mtn;


      tnp1 = tnp1 &(~mtnp1);
      tnp2 = tnp2 | mtnp1;

      tnp2 = tnp2 &(~mtnp2);
      tn = tn | mtnp2;


   }

   System.out.println(tnp1);
   
  }

}
