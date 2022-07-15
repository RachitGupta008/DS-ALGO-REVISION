class Solution {
    
     class Pair{
        int r;
        int c;
        int cost;
        
        int getCost(){
            return cost;
        }
        
        Pair(int r, int c, int cost){
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
    public int swimInWater(int[][] grid) {
        PriorityQueue<Pair> q= new PriorityQueue(Comparator.comparing(Pair :: getCost));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        q.add(new Pair(0, 0, grid[0][0]));
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty()){
            
            Pair p = q.remove();
            
            if(p.r==grid.length-1 && p.c == grid[0].length-1){
                return p.getCost();
            }
            
            if(!visited[p.r][p.c]){
                visited[p.r][p.c] = true;
                
                for(int i=0;i<dirs.length;i++){
                    int rd = p.r + dirs[i][0];
                    int cd = p.c + dirs[i][1];
                    
                    if(rd<grid.length && rd>=0 && cd>=0 && cd<grid.length){
                        
                        q.add(new Pair(rd, cd, Math.max(p.getCost(), grid[rd][cd])));
                        
                        
                    }
                    
                    
                }
                
                
                
            }
            
            
            
        }
        return 0;
        
    }
    
   
}
