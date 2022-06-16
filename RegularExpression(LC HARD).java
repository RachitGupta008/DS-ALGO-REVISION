


import java.io.*;
import java.util.*;

public class Main {

    public static boolean solution(String str, String pattern) {
        //write your code here

        boolean[][] dp = new boolean[pattern.length()+1][str.length()+1];

        dp[0][0] =true;


        for(int i=1;i<dp.length;i++){
            char ch = pattern.charAt(i-1);
            if(ch=='*' && dp[i-2][0]){
                dp[i][0] = true;
            }else{
                dp[i][0] = false;
            }

        }



        for(int i=1;i<dp.length;i++){
            for(int j=1;j<=str.length();j++){
                char ch = pattern.charAt(i-1);


                if(ch == '*' && dp[i-1][j-1]==true ){
                    char prev = pattern.charAt(i-2);
                    while(j<dp[i].length && (str.charAt(j-1)==prev || (prev=='.'))){
                        dp[i][j] = true;
                        j++;
                    }
                    continue;

                }
                if(ch=='*' && (dp[i-1][j]==true || dp[i-2][j]==true)){
                    dp[i][j] = true;

                }
                else if(dp[i-1][j-1]==true) {

                    if (ch == '.') {
                        dp[i][j] = true;
                    }
                    if (ch == str.charAt(j-1)) {
                        dp[i][j] = true;
                    }

                }
            }
        }




        return dp[dp.length-1][str.length()];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1,s2));
    }

}
