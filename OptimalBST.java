

import java.io.*;
import java.util.*;

public class Main {

    private static void optimalbst(int[] keys, int[] frequency, int n) {
        //write your code here

        int freqPre[] = new int[frequency.length];

        int sum  =0;
        for(int i=0;i<frequency.length;i++){
            sum+=frequency[i];
            freqPre[i] = sum;
        }
        int dp[][] = new int[keys.length][keys.length];


        for(int g=0;g<keys.length;g++){
            for(int i=0,j=g;j<keys.length;i++,j++){
                if(g==0){
                    dp[i][j] = frequency[i];
                }else{
                    int ans = Integer.MAX_VALUE;

                    for(int k=i;k<=j;k++){
                        int left = 0;
                        int right = 0;

                        int li = k-1;

                        if(li>=i){
                            left = left+dp[i][li];
                            if(i==0){
                                left = left+freqPre[li];
                            }else{

                                left = left + freqPre[li]-freqPre[i-1];
                            }

                        }

                        int ri = k+1;
                        if(ri<=j){
                            right+=dp[ri][j];
                            right+=(freqPre[j]-freqPre[ri-1]);

                        }

                        ans = Math.min(ans, left+right+frequency[k]);

                    }

                    dp[i][j] = ans;



                }

            }



        }

        System.out.println(dp[0][dp.length-1]);


    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] keys = new int[n];
        int[] frequency = new int[n];
        for(int i= 0 ;i < n ; i++) {
            keys[i] = scn.nextInt();
        }
        for(int i = 0 ; i < n; i++){
            frequency[i] = scn.nextInt();
        }
        optimalbst(keys,frequency,n);
    }

}
