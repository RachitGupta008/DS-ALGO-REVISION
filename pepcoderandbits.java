

import java.io.*;
import java.util.*;

public class Main {
    public static long ncr(long n, long r){
        if(n < r){
            return 0L;
        }

        long res = 1L;

        for(long i = 0L; i < r; i++){
            res = res * (n - i);
            res = res / (i + 1);
        }

        return res;
    }

    public static long solution(long n, int k, int i) {


        long lsbm = 1;
        while(i>=0){

            lsbm = ((long)1<<(i));
            if((n&lsbm) == lsbm){
                break;
            }
            i--;

        }

        int nZeroes = (i+1) - k;

        long cnt = 0;
        while(i>=0){

            if((n&((long)1<<i)) == ((long)1<<i)){
                cnt = cnt + nZeroes;
                int nOnes = k-1;
                for(int l =1;l<=nOnes;l++){
                    if((l+1)<=nZeroes){
                        cnt = cnt + ncr(nOnes, l) * ncr(nZeroes, l+1);
                    }

                }
                k--;

            }else{
                nZeroes--;
            }
            i--;
        }



        
        return cnt;

    }

    public static int csb(long n){
        int res = 0;

        while(n > 0){
            long rsb = n & -n;
            n -= rsb;
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long n = scn.nextLong();
        int k = csb(n);
        System.out.println(solution(n, k, 63));
    }


}
