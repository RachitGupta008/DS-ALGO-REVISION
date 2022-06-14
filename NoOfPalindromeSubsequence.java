import java.io.*;
import java.util.*;

public class Main {

    public static int solve(String s){
        int len = s.length();
        int[][] dp = new int[len][len];

        for(int g=0;g<len;g++){
            for(int i=0,j=g;j<len;j++,i++){
                if(g==0){
                    dp[i][j] = 1;
                }else{

                    dp[i][j] = dp[i][j-1]+dp[i+1][j]-dp[i+1][j-1];

                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]+=dp[i+1][j-1]+1;
                    }

                }
            }
        }
        return dp[0][len-1];
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(solve(s));

    }

}
