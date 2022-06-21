import java.io.*;
import java.util.*;

public class Main {

  public static long solution(int[] arr, int k, long sum) {
    // write your code here

  if(k==1){
    return kdane(arr);

  }else{
    int len = arr.length/k;
    long ans = kdane(arr);

    if(sum>0){
     // System.out.println(ans);
     return(ans + (k-2)*sum);
    }else{
      return ans;
    }
  }
  }


  public static long kdane(int[] arr){
     long b = Long.MIN_VALUE;
    long cb = 0;


    for(int i=0;i<arr.length;i++){
      if(arr[i]+cb<=arr[i]){
        cb = arr[i];
      }else{
        cb = cb+arr[i];
      }
      b = Math.max(cb, b);


    }

    return b;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    long sum = 0;
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
      sum += arr[i];
    }
    int k = scn.nextInt();

  int l=0;
  int narr[] = new int[2*arr.length];
  
    for(int i=0;i<2&&i<k ;i++){
      for(int j=0;j<arr.length;j++){
        narr[l] = arr[j];
        l++;
      }
    }
    System.out.println(solution(narr, k, sum));
  }

}
