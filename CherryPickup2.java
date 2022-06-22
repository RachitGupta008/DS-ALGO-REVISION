class Solution {
    public int cherryPickup(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        
        int [][][] dp = new int[nr][nc][nc];
        
        
        return cherryPick(grid, dp, 0, 0,nc-1);
    }
    
    public int cherryPick(int[][] grid, int [][][] dp, int r1, int c1, int c2){
        
        int r2 = r1;
        
        
        if(r1<0 || r1>=grid.length || c1<0 || c1>=grid[0].length || c2<0 || c2>=grid[0].length){
            return 0;
        }
           
        if(dp[r1][c1][c2]!=0){
            return dp[r1][c1][c2];
        }
        
        int ans = 0;
        
        if(r1 == r2 && c1 == c2){
            ans+=grid[r1][c1];
            
        }else{
            
            ans += grid[r1][c1] + grid[r2][c2];
            
            
        }
        
        int temp = 0;
        
        for(int i=-1;i<2;i++){
            for(int j=-1;j<2;j++){
                
                temp = Math.max(temp, cherryPick(grid, dp, r1+1, c1+i, c2+j));
            }
        }
        
        ans = ans + temp;
           
        dp[r1][c1][c2] = ans;
        return ans;
        
    }
    
    
    
}
