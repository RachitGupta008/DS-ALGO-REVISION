import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        
        //write your code here
        int len = str.length();
        long[] dp = new long[len];

        Map<Character, Integer> map = new HashMap<>();
        map.put(str.charAt(0), 0);
        dp[0] = 2;

        for(int i=1;i<len;i++){
            dp[i] = 2*dp[i-1];
            if(map.containsKey(str.charAt(i))){
                int idx = map.get(str.charAt(i));
                if(idx!=0){
                    dp[i] = dp[i]-dp[idx-1];
                }else{
                    dp[i] = dp[i]-1;
                }
            }
            map.put(str.charAt(i), i);
        }

        System.out.println(dp[len-1]-1);


    }
}
