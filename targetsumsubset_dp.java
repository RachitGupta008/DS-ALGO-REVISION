import java.io.*;
import java.util.*;

public class Main {

    public static class Pair{
        int i;
        int rem;
        String psf;

        public Pair(int i, int rem, String psf){
            this.i = i;
            this.rem = rem;
            this.psf = psf;
        }
    }

    public static void targetSum(int[] arr, int k){

    boolean dp[][] = new boolean[arr.length][k+1];

    for(int i=0;i<dp.length;i++){
        for(int j=0;j<dp[i].length;j++){
            if(j==0 || j==arr[i]){
                dp[i][j] = true;
            }else if(i==0){
                dp[i][j] = false;
            }else{

                if(j<arr[i]){
                    dp[i][j] = dp[i-1][j];

                }else{
                    int rem = j-arr[i];
                    if(dp[i-1][rem]){
                        dp[i][j] = true;
                    }else if(dp[i-1][j]){
                        dp[i][j] = true;

                    }


                }
                


            }

        

        }
        
    }

    System.out.println(dp[dp.length-1][dp[0].length-1]);
    Queue<Pair> q = new ArrayDeque<>();
    q.add(new Pair(arr.length-1, k, ""));

    while(!q.isEmpty()){

        Pair pair = q.remove();

        if(pair.i<0){
            continue;
        }
        int rem = pair.rem;
        int idx = pair.i;
       // System.out.println(idx);
        int num = arr[idx];

       

        if( rem==0){
            System.out.println(pair.psf);
            continue;
        }
        
         if(idx == 0){
            if(rem-arr[idx]==0){
                System.out.println(idx+" "+pair.psf);
            }
            continue;

        }
        if(idx-1>=0 && dp[idx-1][rem]){
            q.add(new Pair(idx-1,rem, pair.psf));
        }

         if(idx-1>=0 && rem-arr[idx]>=0 && dp[idx-1][rem-arr[idx]]){
            q.add(new Pair( idx-1,rem-arr[idx], idx+" "+pair.psf));
        }


        


       


    }


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());
        targetSum(arr, tar);
        //write your code here

    }
}


                        


                        
