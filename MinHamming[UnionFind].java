class Solution {
    
     int[] parent;
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
     
        int[] parent1 = new int[source.length];
        int[] parent2 = new int[source.length];
        
        for(int i=0;i<parent1.length;i++){
            parent1[i] = i;
        }
        
        parent = new int[source.length];
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }
        
        for(int i=0;i<allowedSwaps.length;i++){
            
            int a = allowedSwaps[i][0];
            int b = allowedSwaps[i][1];
            
            union( a, b);
            
            
        }
        
        for(int i=0;i<parent.length;i++){
            System.out.print(parent[i]+" ");
        }
        int cnt = 0;
        
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        
        for(int i=0;i<parent.length;i++){
            int key = find(i);
            Map<Integer, Integer> m = new HashMap<Integer, Integer>();
            if(map.containsKey(key)){
                
              m =  map.get(key);
                
            
            }else{
                map.put(key, m);
            }
            m.put(source[i], m.getOrDefault(source[i],0)+1);
            
            
            
        }
        for(int i=0;i<parent.length;i++){
            int key  = find(i);
            Map<Integer, Integer> m = map.get(key);
            
            if(m.containsKey(target[i])){
                if(m.get(target[i])==1){
                    m.remove(target[i]);
                }else{
                    m.put(target[i], m.get(target[i])-1);
                }
            }else{
                cnt++;
            }
            
        }
        
         
        return cnt;
        
        
        
    }
    
   
    public int find(int n){
        
        if(parent[n] == n){
            return parent[n];
        }
        
        parent[n] = find(parent[n]);
        return parent[n];
        
    }
    
    public void union(int n1, int n2){
        
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1!=p2){
           parent[p2] = p1; 
        }
        
        
        
        
    }
    
    
}
