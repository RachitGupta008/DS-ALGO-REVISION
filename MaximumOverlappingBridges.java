
import java.io.*;
import java.util.*;

public class Main {

    static class Bridge implements Comparable<Bridge>{
        public int n;
        public int s;

        public int getN(){
            return n;
        }

        Bridge(int n, int s){
            this.n = n;
            this.s = s;
        }
        Bridge(){

        }



        @Override
        public int compareTo(Bridge o) {
            if(this.n == o.n){
                return this.s - o.s;
            }
            return this.n - o.n;
        }
    }
    public static void solution(int [] arr){
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
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        Bridge arr[] = new Bridge[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = new Bridge(scn.nextInt(), scn.nextInt());


        }

        Arrays.sort(arr);

        int[] arr1 = new int[n];
        for(int i=0;i<n;i++){
            arr1[i] = arr[i].s;
        }

        solution(arr1);
    }

}
