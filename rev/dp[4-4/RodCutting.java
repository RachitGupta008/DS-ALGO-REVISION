class Solution {
    public int minCost(int n, int[] cuts) {
        //Integer[][] dp = new Integer[n+1][n+1];
        Map<String, Integer> dp = new HashMap<>();
        return f1(cuts,n);
    }
    

    int f(int[] cuts,int s,int e, Map<String, Integer> dp){
        
        if(e==s+1){
            return 0;
        }
        String key = s+"@"+e;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<cuts.length;i++){
            
            if(cuts[i]>s && cuts[i]<e){
                 ans = Math.min(ans, (e-s) + f(cuts, cuts[i], e, dp) + f(cuts, s, cuts[i], dp));
            }
            
           
        }
        dp.put(key, ((ans == Integer.MAX_VALUE)? 0: ans));
        
        return dp.get(key);
        
        
    }
    
  
  // For gap dp table if of form i represent start and j represent end 
  // each value is the min cost of cutting a rod starting at i and ending at j it would involve cutting i and j with multiple k's and finding the min
    int f1(int[] cuts, int n){
        Arrays.sort(cuts);
        
        int[][] dp = new int[cuts.length+2][cuts.length+2];
        
        for(int g=0;g<dp.length;g++){
            
            for(int i=0,j=g ;j<dp.length;i++,j++){
                
                if(g==0 ){
                    dp[i][j] = 0;
                }else{
                    int lval = i==0?0:cuts[i-1];
                    int rval = j==dp.length-1?n:cuts[j-1];
                    
                    int val = Integer.MAX_VALUE;
                    for(int k=i+1;k<j;k++){
                        
                        val = Math.min(val, rval-lval+dp[i][k]+dp[k][j]);
                        
                        
                    }
                    if(val == Integer.MAX_VALUE){
                        val = 0;
                    }
                    dp[i][j] = val;
                    
                }
            }
        }
        
        return dp[0][dp.length-1];
        
        
        
    }
    
    
    
}
