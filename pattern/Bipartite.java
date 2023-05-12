class Solution {
    public boolean isBipartite(int[][] graph) {
        
        boolean[] visited = new boolean[graph.length];
    
        for(int i=0;i<graph.length;i++){
            
            if(!visited[i]){
                if(!dfs(graph, visited, i, -1, new int[graph.length], 1)){
                    return false;
                }
            }
            
        }
        
        return true;
    }
    
    class Pair {
        int p;
        int clr;
    }
    
   boolean dfs(int[][] graph, boolean[] visited, int n,int p, int[] col, int clr){
        
        visited[n] = true;
        col[n] = clr;
        
        
        for(int i=0;i<graph[n].length;i++){
            if(!visited[graph[n][i]]){
                    boolean res =  dfs(graph, visited, graph[n][i], n, col, clr==2?1:2);
                    if(res == false){
                        return false;
                    }
                }else if(col[graph[n][i]]==clr){
                    
                    
                        
                    return false;
                }
            
            
        }
        
        return true;
    }
    
    
    
    
}
