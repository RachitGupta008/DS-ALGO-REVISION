import java.io.*;
import java.util.*;

public class Main {

    public static int solve(String s){
        int len = s.length();
        int[][] dp = new int[len][len];
        boolean[][] mark = new boolean[len][len];
        int cnt = 0;
        for(int g=0;g<len;g++){
            for(int i=0,j=g;j<len;j++,i++){
                if(g==0){
                    dp[i][j] = 1;
                    mark[i][j] = true;
                }
                else if(g==1){

                    boolean cond = (s.charAt(i)==s.charAt(j));

                    mark[i][j]=cond;
                    dp[i][j] = cond?3:2;
                }
                else{

                    dp[i][j] = dp[i][j-1]+dp[i+1][j]-dp[i+1][j-1];

                    if((s.charAt(i)==s.charAt(j)) && mark[i+1][j-1]){
                        dp[i][j]+=+1;
                        mark[i][j] = true;
                    }

                }
                
                if(mark[i][j]){
                    cnt++;
                }
            }
            
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(solve(s));

    }

}
