import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int[] arr) {
    // write your code here
    int b = Integer.MIN_VALUE;
    int cb = 0;


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
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr));
  }
}
