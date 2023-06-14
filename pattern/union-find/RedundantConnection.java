class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        Map<Integer, Integer> parent = new HashMap<>();
        
        for(int[] pair: edges){
            
        int a = pair[0];
        int b = pair[1];
        
        parent.put(a, a);
        parent.put(b, b);
            
        }
        
        int[] ans = new int[2];
        
        for(int[] pair: edges){
            
        int a = pair[0];
        int b = pair[1];
        
        if(!union(a, b, parent)){
            ans[0] = a;
            ans[1] = b;
        }
            
        }
        
        return ans;
        
    }
    
    int find( Map<Integer, Integer>  parent, int n){
        
        if(parent.get(n) == n){
            return n;
        }
        
        parent.put(n, find(parent, parent.get(n)));
        return parent.get(n);
    }
    
    
    boolean union(int a, int b,Map<Integer, Integer> parent ){
        
        int ap = find(parent, a);
        int bp = find(parent, b);
        
        if(ap==bp){
            return false;
        }
        
        parent.put(bp, ap);
        return true;
        
    }
    
}
