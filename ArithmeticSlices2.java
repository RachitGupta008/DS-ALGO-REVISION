

import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        //write your code here


        Map<Integer, Integer> maps[] = new Map[arr.length];


        int ans = 0;

        for(int i=0;i<arr.length;i++){
            maps[i] = new HashMap<>();
            for(int j=i-1;j>=0;j--){

                long cd = (long)arr[i]-(long)arr[j];
                if(cd<=Integer.MIN_VALUE || cd>=Integer.MAX_VALUE){
                    continue;
                }

                int prev = maps[j].getOrDefault((int)cd, 0);
                int newL = maps[i].getOrDefault((int)cd, 0);
                ans+=prev;
                maps[i].put((int)cd, newL+ prev+1);

            }
        }





        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}
