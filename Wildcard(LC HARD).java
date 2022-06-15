class Solution {
    public boolean isMatch(String str, String pattern) {
        boolean[][] dp = new boolean[pattern.length()+1][str.length()+1];

        dp[0][0] =true;

        for(int i=1;i<dp.length;i++){
            char ch = pattern.charAt(i-1);
            if(ch=='*' && dp[i-1][0]){
                dp[i][0] = true;
            }else{
                dp[i][0] = false;
            }

        }



        for(int i=1;i<dp.length;i++){
            for(int j=1;j<=str.length();j++){
                    char ch = pattern.charAt(i-1);

                    if(ch == '*'){
                        dp[i][j] = dp[i][j-1];
                    }
                    if(ch=='*' && dp[i-1][j]==true){

                        dp[i][j] = true;

                    }
                    else if(dp[i-1][j-1]==true) {

                        if (ch == '?') {
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
}
