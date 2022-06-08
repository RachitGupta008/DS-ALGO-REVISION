


import java.io.*;
import java.util.*;

public class Main {

    //This solution might work but for large input due to stack space it might fail

    public static Map<String, Integer> map = new HashMap<>();
    public static int mcm(int[] arr, int s, int e ){
        //write your code here
        if(s+1==e || s==e){
            return 0;
        }
        if(map.containsKey(s+" "+e)){
            return map.get(s+" "+e);
        }


        int ans = Integer.MAX_VALUE;

        for(int i=s+1;i<e ;i++){

            int ans1 =  mcm(arr, i, e);
            int ans2 = mcm(arr, s, i);

            int ans3 = arr[s] * arr[i] * arr[e];

            ans = Math.min(ans, ans3+ans2+ans1);




        }
        map.put(s+" "+e, ans);


        return ans;
    }

    //Gap approach

    public static int mcm(int[] arr){

        int dp[][] = new int[arr.length-1][arr.length-1];

        for(int g=0;g<dp.length;g++){
            for(int i=0,j=g;j<dp.length;i++,j++){
                if(g==0){
                    dp[i][j] = 0;
                }
                else if(g==1){
                    dp[i][j] = arr[i] *arr[j] *arr[j+1];
                }else{
                    int ans = Integer.MAX_VALUE;
                    for(int k=i;k<j;k++){
                        int lv = dp[i][k];
                        int rv = dp[k+1][j];

                        int mv = arr[i] * arr[k+1] * arr[j+1];

                        ans = Math.min(ans, lv+rv+mv);
                    }
                    dp[i][j] = ans;

                }



            }
        }




        return dp[0][dp.length-1];


    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(mcm(arr));
        //   System.out.println(mcm(arr, 0, arr.length-1));
    }


}
