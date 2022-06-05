import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    
    public static class Pair {
        int l;
        int i;
        int v;
        String psf;
        
        Pair(int l, int i, int v, String psf){
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }
        
    public static void solution(int []arr){
// write your code here

     int omax = 0;
     int oidx = -1;
    int[]dp = new int[arr.length];
    for (int i = 0; i < dp.length; i++) {
      int max = 0;
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          if (dp[j] > max) {
            max = dp[j];
          }
        }
      }
      dp[i] = max + 1;
      if (dp[i] > omax) {
        omax = dp[i];
        oidx = i;
      }
    }
    System.out.println(omax);


    Queue<Pair> q = new ArrayDeque<Pair>();

    for(int k = 0;k<arr.length;k++){
        if(dp[k] == omax){
            q.add(new Pair(k, omax, 0, arr[k]+""));
        }

    }

    //System.out.println(q.size());
    

    while(!q.isEmpty()){

    Pair p = q.remove();

    int v = p.i;

    if(v == 1){
        System.out.println(p.psf);
        continue;
    }
    if(p.l == -1){
        continue;
    }

    for(int i=p.l-1;i>=0;i--){
        if(dp[i]==v-1 && arr[i]<=arr[p.l]){
            q.add(new Pair(i, v-1, 0, arr[i]+" -> "+p.psf));
        }
    }


    }


    }
    
    
    
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        solution(arr);

        scn.close();
    }
}
