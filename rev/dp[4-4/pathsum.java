Intuition is to move either left or down and see where do we find the min path and in that way we can build from bottom up
Time Complexity: O(N*M)

Reason: At max, there will be N*M calls of recursion.

Space Complexity: O((M-1)+(N-1)) + O(N*M)

Reason: We are using a recursion stack space:O((M-1)+(N-1)), here (M-1)+(N-1) is the path length and an external DP Array of size ‘N*M’.

without memoization: O(2^(m+n)).


class Solution {
    public int minPathSum(int[][] grid) {
        
        //Integer[][] dp = new Integer[grid.length][grid[0].length];
        //return rf(grid, 0, 0, grid.length-1, grid[0].length-1, dp);
        return rf1(grid, grid.length, grid[0].length);
    
    }
    
    public int rf(int[][] grid, int r, int c, int m, int n, Integer[][] dp){
        
        if(r>m || c>n){
            return Integer.MAX_VALUE;
        }
        
        if(r==m && c ==n ){
            
            return grid[r][c];
            
        }
        
        if(dp[r][c]!=null){
            return dp[r][c];
        }
        
        
        dp[r][c] = grid[r][c] + Math.min(rf(grid, r+1, c, m, n, dp), rf(grid, r, c+1, m, n, dp));
        
        return dp[r][c];
        
    }
    
     public int rf1(int[][] grid, int m, int n){
         Integer[][] dp = new Integer[m][n];
        
       for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                if(i==0 && j==0){
                    
                    dp[i][j] = grid[i][j];
                }else if(i==0){
                    
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                }else if(j==0){
                    dp[i][j] =  grid[i][j] + dp[i-1][j];
                }else{
                    
                    dp[i][j] =  grid[i][j] + Math.min(dp[i][j-1], dp[i-1][j]);
                }
                
                
            }
       }
        return dp[m-1][n-1];
    }
    
    
    
    
}
