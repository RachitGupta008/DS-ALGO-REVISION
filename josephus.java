# tricky question, the trick is to map the result into desired result
import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int n, int k){
    if(n==1){
      return (n+k)%n;
    }
    //write your code here
    int x = solution(n-1, k);
    return (x+k)%n;
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();
    System.out.println(solution(n,k));
  }
  

}
