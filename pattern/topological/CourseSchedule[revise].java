// This algo works based upon the fact that, it can involve topological sort, but it can also involve cycle detection since ans is true or false
// this problem is reduced to cycle detection algo

class Solution {
    
    
    
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
    LinkedList<Integer>[] l = new LinkedList[numCourses];
        
    for(int i=0;i<numCourses;i++){
        l[i] = new LinkedList<>();
    }
    
    for(int i=0;i<prerequisites.length;i++){
        
        
        l[prerequisites[i][1]].add(prerequisites[i][0]);
    }
        
    boolean visited[] = new boolean[numCourses];
        
    Map<Integer, Boolean> mem = new HashMap<Integer, Boolean>();
        
    for(int i=0;i<numCourses;i++){
        
        if(!visited[i]){
            if(dfs(l, i, visited, mem) == false){
                return false;
            }
            
        }
        
        
    }    
    
    return true;    
    
    }
    
    boolean dfs(LinkedList<Integer>[] l, int i, boolean visited[], Map<Integer, Boolean> mem){
        
        if(mem.containsKey(i)){
            return mem.get(i);
        }
        
        visited[i] = true;
        
        for(Integer j : l[i]){
            if(!visited[j]){
                System.out.println(j);
                if(!dfs(l, j, visited, mem)){
                    mem.put(i, false);
                    return false;
                }
            }else{
                mem.put(i, false);
                return false;
            }
            
        }
        visited[i] = false;
        mem.put(i, true);
      return true;  
    }
    
}
