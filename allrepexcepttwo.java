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

  int xor =0;
  for(int i=0;i<arr.length;i++){
    xor = xor ^ arr[i];
  }

  int rsbm = xor & (-xor);
  int x= 0;
  int y =0;

  for(int i=0;i<arr.length;i++){
    if((arr[i]&rsbm) == rsbm){
      x = x^arr[i];

    }else{
      y=y^arr[i];
    }

  }
  if(x>y){
   System.out.println(y);
   System.out.println(x);
  }else{
    System.out.println(x);
   System.out.println(y);
  }





   
  }

}
