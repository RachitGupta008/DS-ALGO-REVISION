import java.io.*;
import java.util.*;

public class Main {

    public static class Pair {
    int i;
    int val;
    int wt;
    String psf;

    public Pair(int i, int val,int wt, String psf) {
      this.i = i;
      this.val = val;
      this.wt = wt;
      this.psf = psf;
    }
  }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        int [][] dp = new int[n+1][cap+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }else{
                    if(wts[i-1]>j){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        int rem = j-wts[i-1];
                         dp[i][j] = Math.max(dp[i-1][rem]+values[i-1], dp[i-1][j]);
                    }

                   


                }
               // System.out.print(dp[i][j]+" ");
            }
           // System.out.println();
        }

        System.out.println(dp[n][cap]);
        Queue< Pair> q = new ArrayDeque< >();
        q.add(new Pair(n, dp[n][cap],cap, ""));

        while(!q.isEmpty()){
            Pair pair = q.remove();

            if(pair.i==0 || pair.val==0 || pair.wt==0){
                System.out.println(pair.psf);
                continue;
            }

            int inc = pair.wt>=wts[pair.i-1]?values[pair.i-1]+dp[pair.i-1][pair.wt-wts[pair.i-1]]:Integer.MIN_VALUE;
            int exc = dp[pair.i-1][pair.wt];

            if(dp[pair.i][pair.wt] == exc){
                q.add(new Pair(pair.i-1, pair.val, pair.wt, pair.psf));
            }

            if(dp[pair.i][pair.wt] == inc){
                q.add(new Pair(pair.i-1, pair.val-values[pair.i-1], 
                pair.wt-wts[pair.i-1], pair.i-1 + " "+pair.psf));
            }




        }



        //write your code here
        
    }
}


                        


                        


                        
