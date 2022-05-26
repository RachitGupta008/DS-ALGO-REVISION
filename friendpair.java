import java.io.*;
import java.util.*;

public class Main {
  static int counter = 1;

  public static void solution(int i, int n, boolean[] used, String asf) {
    // write your code here
  if(i>n){
    System.out.println(counter+"."+asf);
    counter++;
    return;
    
  }

  if(i==n && used[i]){
    System.out.println(counter+"."+asf);
    counter++;
    return;
    
    
  }
   

   if(!used[i]){
    used[i] = true;
    solution(i+1, n, used, asf+"("+i+") ");
    used[i] = false;
   }
   else{
     solution(i+1, n, used, asf);
   }


  for(int k=i+1;k<=n;k++){
    if(!used[k] && !used[i]){
      used[i] = true;
      used[k] = true;
      solution(i+1, n, used, asf + "("+i+","+k+") ");
      used[k] = false;
      used[i] = false;
    }

  }

 

  


  }

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean[] used = new boolean[n + 1];
    solution(1, n, used, "");
  }
}

