// This is tabulation take or not take 
static long countWaysToMakeChange(int[] arr, int n, int T){
    
    long dp[][]=new long[n][T+1];
    
    
    //Initializing base condition
    for(int i=0;i<=T;i++){
        if(i%arr[0]==0)
            dp[0][i]=1;
        // Else condition is automatically fulfilled,
        // as dp array is initialized to zero
    }
    
    for(int ind=1; ind<n;ind++){
        for(int target=0;target<=T;target++){
            long notTaken = dp[ind-1][target];
            
            long taken = 0;
            if(arr[ind]<=target)
                taken = dp[ind][target-arr[ind]];
                
            dp[ind][target] = notTaken + taken;
        }
    }
    
    return dp[n-1][T];
} 

// This is levels and choices method
// for each level we have all the choices 
    public int f(int[] coins, int amount, Integer[] dp){
        
     if(amount<0){
            return Integer.MAX_VALUE-1;
        }
        if(amount == 0){
            return 0;
        }
        if(dp[amount]!=null){
            return dp[amount];
        }
        
        
        int mcoins = Integer.MAX_VALUE-1;
        
        for(int i=0;i<coins.length;i++){
            
            mcoins = Math.min(mcoins, f(coins, amount-coins[i], dp));
        }
        
        if(mcoins!=Integer.MAX_VALUE-1)
            dp[amount] = mcoins+1;
        else
            dp[amount] = mcoins;
        return dp[amount];
        
        
    }
